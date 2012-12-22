package ljdp.minechem.client;

import ljdp.minechem.common.ModMinechem;
import ljdp.minechem.common.tileentity.TileEntityBlueprintProjector;
import ljdp.minechem.common.tileentity.TileEntityDecomposer;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.ForgeHooksClient;

public class TileEntityBlueprintProjectorRenderer extends TileEntitySpecialRenderer {
	
	ModelProjector model;
	
	public TileEntityBlueprintProjectorRenderer() {
		this.model = new ModelProjector();
	}
	
	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float scale) {
		if(tileEntity instanceof TileEntityBlueprintProjector) {
			TileEntityBlueprintProjector blueprintProjector = (TileEntityBlueprintProjector)tileEntity;
			GL11.glPushMatrix();
			GL11.glTranslated(x + 0.5D, y + 1.5D, z + 0.5D);
			GL11.glRotatef(180f, 0f, 0f, 1f);
			GL11.glEnable(GL11.GL_LIGHTING);
			if(blueprintProjector.isPowered()) {
				ForgeHooksClient.bindTexture(ModMinechem.proxy.PROJECTOR_MODEL_ON, 0);
			} else {
				ForgeHooksClient.bindTexture(ModMinechem.proxy.PROJECTOR_MODEL_OFF, 0);
			}
			model.render(0.0625F);
			GL11.glDisable(GL11.GL_LIGHTING);
			GL11.glPopMatrix();
		}
	}

}
