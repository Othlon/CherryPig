package othlon.cherrypig.tileentities;

import cpw.mods.fml.common.registry.GameRegistry;


public class CPTileEntites {


    public static void doTheTileEntityThings(){
//<<<<<<< HEAD
        GameRegistry.registerTileEntity(CPNestTileEntity.class, "CPNest");
        GameRegistry.registerTileEntity(CPFertileEggTileEntity.class, "CPFirtileEgg");
        GameRegistry.registerTileEntity(CPIncubatorTileEntity.class, "CPIncubator");
//=======
        GameRegistry.registerTileEntity(CPNestTileEntity.class, "cherrypig:Nest");
        GameRegistry.registerTileEntity(CPFertileEggTileEntity.class, "cherrypig:FirtileEgg");
        GameRegistry.registerTileEntity(CPIncubatorTileEntity.class, "cherrypig:Incubator");
//>>>>>>> 6ac178f3cca2ab5e329ae1c0545f9240bbc51369
    }

}
