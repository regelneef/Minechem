package ljdp.minechem.common;

import ljdp.minechem.utils.MinechemHelper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class MinechemBlocks {
	public static Block decomposer;
	public static Block microscope;
	public static Block synthesis;
	public static Block ghostBlock;
	public static Material materialGas = new MaterialGas();
	private static int microscopeID;
	private static int decomposerID;
	private static int synthesisID;
	private static int ghostBlockID;
	
	public static void loadConfig(Configuration config) {
		microscopeID = config.get(config.CATEGORY_BLOCK, "Microscope", 4012).getInt(4012);
	 	decomposerID = config.get(config.CATEGORY_BLOCK, "Decomposer", 4011).getInt(4011);
	 	synthesisID  = config.get(config.CATEGORY_BLOCK, "Synthesis",  4013).getInt(4013);
	 	ghostBlockID = config.get(config.CATEGORY_BLOCK, "GhostBlock", 4014).getInt(4014);
	}
	
	public static void registerBlocks() {
		decomposer = new BlockDecomposer(decomposerID);
		microscope = new BlockMicroscope(microscopeID);
		synthesis  = new BlockSynthesis(synthesisID);
		ghostBlock = new BlockGhostBlock(ghostBlockID);
		
		GameRegistry.registerBlock(decomposer);
		GameRegistry.registerTileEntity(TileEntityDecomposer.class, "minechem.tileEntityDecomposer");
		LanguageRegistry.addName(decomposer, "Chemical Decomposer");
		
		GameRegistry.registerBlock(microscope);
		GameRegistry.registerTileEntity(TileEntityMicroscope.class, "minechem.tileEntityMicroscope");
		LanguageRegistry.addName(microscope, MinechemHelper.getLocalString("block.name.microscope"));
		
		GameRegistry.registerBlock(synthesis);
		GameRegistry.registerTileEntity(TileEntitySynthesis.class, "minechem.tileEntitySynthesis");
		LanguageRegistry.addName(synthesis, MinechemHelper.getLocalString("block.name.synthesis"));
		
		GameRegistry.registerBlock(ghostBlock, ItemGhostBlock.class);
		LanguageRegistry.addName(ghostBlock, "ghost block");
	}

}
