package othlon.cherrypig.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.material.Material;
import net.minecraftforge.oredict.OreDictionary;

/**
 * Created by Jen on 30/05/14.
 */

public class CPBlocks {

    public static CPCherryLeaf    cherryLeaf       = new CPCherryLeaf();
    public static CPCherryLog     cherryLog        = new CPCherryLog();
    public static CPCherrySapling cherrySapling    = new CPCherrySapling();
    public static CPCherryPlank   cherryPlanks     = new CPCherryPlank();
    public static CPCherrySlab    cherrySingleSlab = new CPCherrySlab(false, Material.wood);
   // public static CPCherrySlab    cherryDoubleSlab = new CPCherrySlab(true, Material.wood);

    public static CPNest          nest            = new CPNest();
    public static CPFertileEgg    egg             = new CPFertileEgg();
    public static CPBushStem      bushStem        = new CPBushStem();
    public static CPCharcoalBlock charchoalBlack  = new CPCharcoalBlock();
    public static CPFlintBlock flintBlack         = new CPFlintBlock();
    public static void doTheBlockThing(){


     GameRegistry.registerBlock(cherryLog,         "cherrylog");
     OreDictionary.registerOre("treeWood", cherryLog);

     GameRegistry.registerBlock(cherryLeaf,       "cherryleaf");
     OreDictionary.registerOre("treeLeaves", cherryLeaf);

     GameRegistry.registerBlock(cherrySapling, "cherrysapling");
     OreDictionary.registerOre("treeSapling", cherrySapling);

     GameRegistry.registerBlock(cherryPlanks,    "cherryplank");
     OreDictionary.registerOre("plankWood", cherryPlanks);

    GameRegistry.registerBlock(cherrySingleSlab, "cherryslab");
      //??????????????????
    //GameRegistry.registerBlock(cherrySingleSlab, ItemBlockSlab.class, cherrySingleSlab, doubleSlab);
    OreDictionary.registerOre("slabWood", cherrySingleSlab);


       // GameRegistry.registerBlock(cherryDoubleSlab,    "cherryslab");
       // OreDictionary.registerOre("slabWood", cherryDoubleSlab);

     GameRegistry.registerBlock(nest,"nest");

     GameRegistry.registerBlock(egg, "egg");

     GameRegistry.registerBlock(bushStem, "bushStem");

     GameRegistry.registerBlock(charchoalBlack, "Charcoal Block");
     OreDictionary.registerOre("blockCharcoal", charchoalBlack);

     GameRegistry.registerBlock(flintBlack, "Flint Block");
     OreDictionary.registerOre("blockFlint", flintBlack);


    }
}
