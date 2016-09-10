package othlon.cherrypig.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import othlon.cherrypig.helpers.CPItemBlockSlab;

/**
 * Created by Jen on 30/05/14.
 */

public class CPBlocks {

    public static Block    cherryLeaf       = new CPCherryLeaf().setRegistryName("cherryleaf");
    public static Block     cherryLog        = new CPCherryLog().setRegistryName("cherrylog");
    public static Block cherrySapling    = new CPCherrySapling().setRegistryName("cherrysapling");
    public static Block cherryPlanks     = new CPCherryPlank().setRegistryName("cherrywoodplank");

    public static Block cherrySingleSlab = new CPCherrySlab.Half().setRegistryName("cherrywoodslab");
    public static Block    cherryDoubleSlab = new CPCherrySlab.Double().setRegistryName("cherryDoubleSlab");

    public static Block cherryStairs;//declaired below just before registration

    public static Block charchoalBlack  = new CPCharcoalBlock().setRegistryName("charcoalblock");
    public static Block flintBlock = new CPFlintBlock().setRegistryName("flintblock");



    public static void doTheBlockThing(){


        registerBlockAndItem(cherryLog);
        OreDictionary.registerOre("treeWood",   cherryLog);

        registerBlockAndItem(cherryLeaf);
        OreDictionary.registerOre("treeLeaves",   cherryLeaf);

        registerBlockAndItem(cherrySapling);
        OreDictionary.registerOre("treeSapling" ,  cherrySapling);

        registerBlockAndItem(cherryPlanks);
        OreDictionary.registerOre("plankWood"  ,  cherryPlanks);

        GameRegistry.register(cherrySingleSlab);
        GameRegistry.register(cherryDoubleSlab);
        GameRegistry.register(new CPItemBlockSlab(cherrySingleSlab, (CPCherrySlab) cherrySingleSlab, (CPCherrySlab) cherryDoubleSlab).setRegistryName("cherrywoodslab"));
        //GameRegistry.register(new CPItemBlockSlab(cherryDoubleSlab, (CPCherrySlab) cherrySingleSlab, (CPCherrySlab) cherryDoubleSlab).setRegistryName(cherryDoubleSlab.getRegistryName()));

        //GameRegistry.registerBlock(cherrySingleSlab, CPItemBlockSlab.class, "cherrypig:cherrySingleSlab", cherrySingleSlab, cherryDoubleSlab);
        //GameRegistry.registerBlock(cherryDoubleSlab, CPItemBlockSlab.class, "cherrypig:cherryDoubleSlab", cherrySingleSlab, cherryDoubleSlab);
        OreDictionary.registerOre("slabWood", cherrySingleSlab);
        OreDictionary.registerOre("slabWood", cherryDoubleSlab);

        cherryStairs = new CPCherryStairs(CPBlocks.cherryPlanks.getDefaultState()).setRegistryName("cherrywoodstairs");
        registerBlockAndItem(cherryStairs);
        OreDictionary.registerOre ("stairWood",   cherryStairs);

        registerBlockAndItem(charchoalBlack);
        OreDictionary.registerOre ("blockCharcoal", charchoalBlack);

        registerBlockAndItem(flintBlock);
        OreDictionary.registerOre ("blockFlint", flintBlock);


    }

    private static void registerBlockAndItem(Block block)
    {
        GameRegistry.register(block);
        GameRegistry.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
    }
}
