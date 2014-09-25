package othlon.cherrypig.blocks;

import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Created by Jen on 30/05/14.
 */

public class CPBlocks {

    public static CPCherryLeaf    cherryLeaf     = new CPCherryLeaf();
    public static CPCherryLog     cherryLog      = new CPCherryLog();
    public static CPCherrySapling cherrySapling  = new CPCherrySapling();

        public static void doTheBlockThing(){


            GameRegistry.registerBlock(cherryLog,         "cherrylog");
            GameRegistry.registerBlock(cherryLeaf,       "cherryleaf");
            GameRegistry.registerBlock(cherrySapling, "cherrysapling");
        }
}
