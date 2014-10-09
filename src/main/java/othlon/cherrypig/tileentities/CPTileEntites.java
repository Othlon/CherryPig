package othlon.cherrypig.tileentities;

import cpw.mods.fml.common.registry.GameRegistry;
import othlon.cherrypig.blocks.CPNest;


public class CPTileEntites {


    public static void doTheTileEntityThings(){
        GameRegistry.registerTileEntity(CPNestTileEntity.class, "Nest");
        GameRegistry.registerTileEntity(CPFirtileEggTileEntity.class, "FirtileEgg");
    }

}
