package othlon.cherrypig;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import othlon.cherrypig.blocks.CPCherryLeaf;
import othlon.cherrypig.blocks.CPCherryLog;

/**
 * Created by Jen on 25/05/14.
 */
@Mod(modid = "cherrypig")
public class CherryPig {

    @Mod.EventHandler
    public static void preInit( FMLPreInitializationEvent event)
    {

        final Block cherryLog  = new CPCherryLog();
        final Block cherryLeaf = new CPCherryLeaf();


        GameRegistry.registerBlock(cherryLog, "CPCherryLog");
        GameRegistry.registerBlock(cherryLeaf, "CPCherryLeaf");
    }//end pre init
}
