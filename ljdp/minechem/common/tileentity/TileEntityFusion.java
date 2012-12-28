package ljdp.minechem.common.tileentity;

import ljdp.minechem.api.core.EnumElement;
import ljdp.minechem.api.util.Constants;
import ljdp.minechem.common.MinechemItems;
import ljdp.minechem.common.blueprint.BlueprintFusion;
import ljdp.minechem.common.network.PacketFusionUpdate;
import ljdp.minechem.common.network.PacketHandler;
import ljdp.minechem.common.utils.MinechemHelper;
import buildcraft.api.core.SafeTimeTracker;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;

public class TileEntityFusion extends TileEntityMultiBlock implements IInventory {
	
	public static int kStartFusionStar = 0;
	public static int kStartInput1 = 1;
	public static int kStartInput2 = 2;
	public static int kStartOutput = 3;
	
	ItemStack[] inventory;
	int energyStored = 0;
	int maxEnergy = 9;
	int targetEnergy = 0;
	boolean isRecharging = false;
	SafeTimeTracker energyUpdateTracker = new SafeTimeTracker();
	boolean shouldSendUpdatePacket;
	
	public TileEntityFusion() {
		this.inventory = new ItemStack[this.getSizeInventory()];
		setBlueprint(new BlueprintFusion());
	}
	
	@Override
	public void updateEntity() {
		super.updateEntity();
		if(!completeStructure)
			return;
		
		shouldSendUpdatePacket = false;
		if(!worldObj.isRemote && inventory[kStartFusionStar] != null 
				&& energyUpdateTracker.markTimeIfDelay(worldObj, Constants.TICKS_PER_SECOND * 2))
		{
			if(!isRecharging)
				targetEnergy = takeEnergyFromStar(inventory[kStartFusionStar], true);
			if(targetEnergy > 0)
				isRecharging = true;
			if(isRecharging) {
				recharge();
			} else {
				ItemStack fusionResult = getFusionOutput();
				while(fusionResult != null && canFuse(fusionResult)) {
					if(!worldObj.isRemote) {
						addToOutput(fusionResult);
						removeInputs();
					}
					energyStored -= getEnergyCost(fusionResult);
					fusionResult = getFusionOutput();
					shouldSendUpdatePacket = true;
				}
			}
		}
		if(shouldSendUpdatePacket && !worldObj.isRemote)
			sendUpdatePacket();
	}
	
	private void addToOutput(ItemStack fusionResult) {
		if(inventory[kStartOutput] == null) {
			ItemStack output = fusionResult.copy();
			MinechemItems.element.initiateRadioactivity(output, worldObj);
			inventory[kStartOutput] = output;
		} else {
			inventory[kStartOutput].stackSize++;
		}
	}
	
	private void removeInputs() {
		decrStackSize(kStartInput1, 1);
		decrStackSize(kStartInput2, 1);
	}

	private boolean canFuse(ItemStack fusionResult) {
		ItemStack itemInOutput = inventory[kStartOutput];
		if(itemInOutput != null)
			return itemInOutput.stackSize < getInventoryStackLimit() 
					&& itemInOutput.isItemEqual(fusionResult) && energyStored >= getEnergyCost(fusionResult);
		else
			return energyStored >= getEnergyCost(fusionResult);
	}

	private ItemStack getFusionOutput() {
		if(hasInputs()) {
			int mass1 = inventory[kStartInput1].getItemDamage() + 1;
			int mass2 = inventory[kStartInput2].getItemDamage() + 1;
			int massSum = mass1 + mass2;
			if(massSum <= EnumElement.heaviestMass) {
				return new ItemStack(MinechemItems.element, 1, massSum - 1);
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
	
	private int getEnergyCost(ItemStack itemstack) {
		int mass = itemstack.getItemDamage();
		int cost = (int) MinechemHelper.translateValue(mass + 1, 1, EnumElement.heaviestMass, 1, this.maxEnergy);
		return cost;
	}

	private boolean hasInputs() {
		return inventory[kStartInput1] != null && inventory[kStartInput2] != null;
	}

	private void recharge() {
		if(energyStored < targetEnergy) {
			energyStored++;
			shouldSendUpdatePacket = true;
		} else {
			isRecharging = false;
			targetEnergy = 0;
		}
	}
	
	private void sendUpdatePacket() {
		PacketFusionUpdate fustionUpdate = new PacketFusionUpdate(this);
		PacketHandler.sendPacket(fustionUpdate);
	}
	
	private int takeEnergyFromStar(ItemStack fusionStar, boolean doTake) {
		int energyCapacityAvailable = maxEnergy - energyStored;
		int fusionStarDamage = fusionStar.getItemDamage();
		int energyInStar = fusionStar.getMaxDamage() - fusionStarDamage;
		if(energyCapacityAvailable == 0) {
			return 0;
		} else if(energyInStar > energyCapacityAvailable) {
			if(doTake) {
				fusionStarDamage += energyCapacityAvailable;
				fusionStar.setItemDamage(fusionStarDamage);
			}
			return maxEnergy;
		} else {
			if(doTake) {
				destroyFusionStar(fusionStar);
			}
			return energyStored + energyInStar;
		}
	}
	
	private void destroyFusionStar(ItemStack fusionStar) {
		this.inventory[kStartFusionStar] = null;
	}
	
	@Override
	public int getSizeInventory() {
		return 4;
	}
	@Override
	public ItemStack getStackInSlot(int slot) {
		return this.inventory[slot];
	}
	@Override
	public ItemStack decrStackSize(int slot, int amount) {
		if(this.inventory[slot] != null) {
			ItemStack itemstack;
			if(this.inventory[slot].stackSize <= amount) {
				itemstack = this.inventory[slot];
				this.inventory[slot] = null;
				return itemstack;
			} else {
				itemstack = this.inventory[slot].splitStack(amount);
				if(this.inventory[slot].stackSize == 0)
					this.inventory[slot] = null;
				return itemstack;
			}
		} else {
			return null;
		}
	}
	@Override
	public ItemStack getStackInSlotOnClosing(int var1) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setInventorySlotContents(int slot, ItemStack itemstack) {
		if(itemstack != null && itemstack.itemID == Item.netherStar.shiftedIndex) {
			this.inventory[slot] = new ItemStack(MinechemItems.fusionStar);
		} else {
			this.inventory[slot] = itemstack;
		}
	}
	@Override
	public String getInvName() {
		return "container.minechemFusion";
	}
	@Override
	public int getInventoryStackLimit() {
		return 64;
	}
	@Override
	public boolean isUseableByPlayer(EntityPlayer entityPlayer) {
		if(!completeStructure)
			return false;
		double dist = entityPlayer.getDistanceSq(xCoord + 0.5D, yCoord + 0.5D, zCoord + 0.5D);
		return worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) != this ? false :  dist <= 64.0D;
	}
	@Override
	public void openChest() {}
	@Override
	public void closeChest() {}
	
	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound tagCompound = new NBTTagCompound();
        this.writeToNBT(tagCompound);
        return new Packet132TileEntityData(this.xCoord, this.yCoord, this.zCoord, 0, tagCompound);
	}
	
	@Override
	public void onDataPacket(INetworkManager net, Packet132TileEntityData pkt) {
		this.readFromNBT(pkt.customParam1);
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbtTagCompound) {
		super.writeToNBT(nbtTagCompound);
		nbtTagCompound.setInteger("energyStored", energyStored);
		nbtTagCompound.setInteger("targetEnergy", targetEnergy);
		nbtTagCompound.setBoolean("isRecharging", isRecharging);
		NBTTagList inventoryTagList = MinechemHelper.writeItemStackArrayToTagList(inventory);
		nbtTagCompound.setTag("inventory", inventoryTagList);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbtTagCompound) {
		super.readFromNBT(nbtTagCompound);
		energyStored = nbtTagCompound.getInteger("energyStored");
		targetEnergy = nbtTagCompound.getInteger("targetEnergy");
		isRecharging = nbtTagCompound.getBoolean("isRecharging");
		inventory = new ItemStack[getSizeInventory()];
		MinechemHelper.readTagListToItemStackArray(nbtTagCompound.getTagList("inventory"), inventory);
	}

	public int getEnergyStored() {
		return this.energyStored;
	}
	
	public void setEnergyStored(int amount) {
		this.energyStored = amount;
	}
	
	public int getMaxEnergy() {
		return this.maxEnergy;
	}

}