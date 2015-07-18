package othlon.cherrypig.tileentities;

import cpw.mods.fml.common.registry.GameRegistry;


public class CPTileEntites {


    public static void doTheTileEntityThings(){
        GameRegistry.registerTileEntity(CPNestTileEntity.class, "cherrypig:Nest");
        GameRegistry.registerTileEntity(CPFertileEggTileEntity.class, "cherrypig:FirtileEgg");
        GameRegistry.registerTileEntity(CPIncubatorTileEntity.class, "cherrypig:Incubator");
    }

}
