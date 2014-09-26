package othlon.cherrypig.tileentities;

import cpw.mods.fml.common.registry.GameRegistry;
import othlon.cherrypig.blocks.CPNest;


public class CPTileEntites {

    public static void doTheEntityThings(){
        GameRegistry.registerTileEntity(CPNestTileEntity.class, "Nest");
    }
}
