package othlon.cherrypig.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

/**
 * Created by Jen on 30/05/14.
 */

public class CPBlocks {

    public static CPCherryLeaf    cherryLeaf     = new CPCherryLeaf();
    public static CPCherryLog     cherryLog      = new CPCherryLog();
    public static CPCherrySapling cherrySapling  = new CPCherrySapling();
    public static CPCherryPlank   cherryPlanks   = new CPCherryPlank();
    public static CPNest          nest           = new CPNest();
    public static CPFirtileEgg    egg            = new CPFirtileEgg();
    public static CPBushStem      bushStem       = new CPBushStem();

    public static void doTheBlockThing(){


     GameRegistry.registerBlock(cherryLog,         "cherrylog");
     OreDictionary.registerOre("treeWood", cherryLog);

     GameRegistry.registerBlock(cherryLeaf,       "cherryleaf");
     OreDictionary.registerOre("treeLeaves", cherryLeaf);

     GameRegistry.registerBlock(cherrySapling, "cherrysapling");
     OreDictionary.registerOre("treeSapling", cherrySapling);

     GameRegistry.registerBlock(cherryPlanks,    "cherryplank");
     OreDictionary.registerOre("plankWood", cherryPlanks);

     GameRegistry.registerBlock(nest,"nest");
     GameRegistry.registerBlock(egg, "egg");
     GameRegistry.registerBlock(bushStem, "bushStem");


    }
}
