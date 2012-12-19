package ljdp.minechem.common;

import ljdp.minechem.common.tileentity.TileEntityDecomposer;
import ljdp.minechem.common.tileentity.TileEntityMicroscope;
import ljdp.minechem.common.tileentity.TileEntitySynthesis;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.world.World;

public class CommonProxy {
	
	public static String TEXTURE_DIR		= "/ljdp/minechem/textures/";
	public static String TAB_LEFT_PNG 		= TEXTURE_DIR + "tab_left.png";
	public static String TAB_RIGHT_PNG 		= TEXTURE_DIR + "tab_right.png";
	public static String ELEMENTBOTTLES_PNG = TEXTURE_DIR + "elementbottles.png";
	public static String DECOMPOSER_GUI_PNG = TEXTURE_DIR + "ChemicalDecomposerGUI.png";
	public static String MICROSCOPE_GUI_PNG = TEXTURE_DIR + "MicroscopeGUI.png";
	public static String SYNTHESIS_GUI_PNG  = TEXTURE_DIR + "SynthesisGUI.png";
	public static String BLOCKS_PNG			= TEXTURE_DIR + "blocktextures.png";
	public static String ICONS_PNG			= TEXTURE_DIR + "icons.png";
	public static String TERRAIN_ALPHA_PNG  = TEXTURE_DIR + "terrainWithAlpha.png";
	public static String MICROSCOPE_MODEL   = TEXTURE_DIR + "MicroscopeModel.png";
	
	public static int RENDER_MICROSCOPE;
	
	public void registerRenderers() {
		
	}
	
	public void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntityMicroscope.class, "minechem.tileEntityMicroscope");
		GameRegistry.registerTileEntity(TileEntitySynthesis.class,  "minechem.tileEntitySynthesis");
		GameRegistry.registerTileEntity(TileEntityDecomposer.class, "minechem.tileEntityDecomposer");
	}
	
	public World getClientWorld() {
		return null;
	}

}
