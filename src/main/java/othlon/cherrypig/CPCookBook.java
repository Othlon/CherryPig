package othlon.cherrypig;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;
import othlon.cherrypig.blocks.CPBlocks;
import othlon.cherrypig.items.CPItem;


public class CPCookBook {

    public static void cookfood(){

        //animal food

        //spawn items
        ItemStack stackPips  = new ItemStack(CPItem.cherryPip,   1, 0);

        //people foood
        ItemStack stackFruit = new ItemStack(CPItem.cherryFruit, 1, 0);
        ItemStack stackPie   = new ItemStack(CPItem.cherryPie,   1, 0);

        //vanilla stacks
        ItemStack stackSugar = new ItemStack(Items.SUGAR, 1, 0);
        ItemStack stackEgg   = new ItemStack(Items.EGG,   1, 0);
        ItemStack stackWheat = new ItemStack(Items.WHEAT, 1, 0);


        //making pips
        GameRegistry.addShapelessRecipe(stackPips,     //result
                                        stackFruit);   //input

        //making cherry pies
        GameRegistry.addShapelessRecipe(stackPie,              //result
                stackEgg, stackFruit, stackSugar, stackWheat); //input
    }

    public static void cookblocks()
    {
        /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~SAPLING~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
            ItemStack stackCPSapling = new ItemStack(CPBlocks.cherrySapling, 1, 0);
            ItemStack stackPork      = new ItemStack(Items.PORKCHOP, 1, 0);

             GameRegistry.addRecipe(new ShapedOreRecipe(stackCPSapling,
                "xxx",
                "xyx",
                "xxx",
                'x', stackPork,
                'y', "treeSapling"
             ));
        /*~~~~~~~~~~~~~~~~~~~~~~~~WOODEN PLANKS~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
            ItemStack aLog         = new ItemStack(CPBlocks.cherryLog,    1, 0);
            ItemStack stackPlanks  = new ItemStack(CPBlocks.cherryPlanks, 4, 0);

            GameRegistry.addShapelessRecipe(stackPlanks, aLog);
        /*~~~~~~~~~~~~~~~~~~~~~~~WOODEN STAIRS~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
            ItemStack aCherryPlank  = new ItemStack(CPBlocks.cherryPlanks, 1, 0);
            ItemStack stackStairs   = new ItemStack(CPBlocks.cherryStairs, 6, 0);

            GameRegistry.addRecipe(new ShapedOreRecipe( stackStairs,
                    "x  ",
                    "xx ",
                    "xxx",
                    'x', aCherryPlank
            ));
        /*~~~~~~~~~~~~~~~~~~~~~~~WOODEN SLABS~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
            /* use from above aCherryPlank */
            ItemStack stackSlab  = new ItemStack(CPBlocks.cherrySingleSlab, 6,  0);
            ItemStack aSlab      = new ItemStack(CPBlocks.cherrySingleSlab, 1 , 0);

            GameRegistry.addRecipe(new ShapedOreRecipe( stackSlab,
                "xxx",
                'x', aCherryPlank
             ));

        //reverse

            GameRegistry.addShapelessRecipe(aCherryPlank, aSlab, aSlab );

        /*~~~~~~~~~~~~~~~~~~~~~~~CHARCOAL BLOCK AND REVERSE ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
            ItemStack stackCharcoalBlock = new ItemStack(CPBlocks.charchoalBlack, 1, 0);
            ItemStack aCharcoal          = new ItemStack(Items.COAL, 1, 1);
            ItemStack stackCharcoal      = new ItemStack(Items.COAL, 9, 1);

            GameRegistry.addShapedRecipe(stackCharcoalBlock,
                    "xxx",
                    "xxx",
                    "xxx",
                    'x', aCharcoal);

            //reverse
            GameRegistry.addShapelessRecipe(stackCharcoal, stackCharcoalBlock);

        /*~~~~~~~~~~~~~~~~~~~~~~~~FLINT BLOCK AND REVERSE~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
            ItemStack stackFlintBlock = new ItemStack(CPBlocks.flintBlock, 1, 0);
            ItemStack aFlint          = new ItemStack(Items.FLINT, 1, 0);
            ItemStack stackFlint      = new ItemStack(Items.FLINT, 9, 0);
            GameRegistry.addShapedRecipe(stackFlintBlock,
                    "fff",
                    "fff",
                    "fff",
                    'f', aFlint);

             //reverse
             GameRegistry.addShapelessRecipe(stackFlint, stackFlintBlock);

    }//end cookbook function
}
