package othlon.cherrypig.tileentities;

import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Created by Jen on 17/09/2014.
 */
public class CPTileEntites {

    public static void doTheEntityThings(){
        GameRegistry.registerTileEntity(CPTileEntityNest.class, "tileEntityNest");
    }
}
