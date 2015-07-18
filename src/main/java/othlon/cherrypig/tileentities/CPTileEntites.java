package othlon.cherrypig.tileentities;

import cpw.mods.fml.common.registry.GameRegistry;


public class CPTileEntites {


    public static void doTheTileEntityThings(){
        GameRegistry.registerTileEntity(CPNestTileEntity.class, "CPNest");
        GameRegistry.registerTileEntity(CPFertileEggTileEntity.class, "CPFirtileEgg");
        GameRegistry.registerTileEntity(CPIncubatorTileEntity.class, "CPIncubator");
    }

}
