package othlon.cherrypig;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import othlon.cherrypig.blocks.CPBlocks;
import othlon.cherrypig.blocks.CPCharcoalBlock;
import othlon.cherrypig.items.CPItem;


public class CPCookBook {

    public static void cookfood(){

        //animal food
        ItemStack stackChickenFeed = new ItemStack(CPItem.chickenfeed, 1, 0);
        //spawn items
        ItemStack stackPips  = new ItemStack(CPItem.cherryPip, 1, 0);
        //people foood
        ItemStack stackFruit = new ItemStack(CPItem.cherryFruit, 1, 0);
        ItemStack stackPie   = new ItemStack(CPItem.cherryPie, 1, 0);
        //vanilla stacks
        ItemStack stackSugar = new ItemStack(Items.sugar, 1, 0);
        ItemStack stackEgg   = new ItemStack(Items.egg,   1, 0);
        ItemStack stackWheat = new ItemStack(Items.wheat, 1, 0);
        ItemStack stackSeeds      = new ItemStack(Items.wheat_seeds,   1, 0);
        ItemStack stackSeedsPump  = new ItemStack(Items.pumpkin_seeds, 1, 0);
        ItemStack stackSeedsMelon = new ItemStack(Items.melon_seeds,   1, 0);


        //making chicken feed
        GameRegistry.addShapelessRecipe(stackChickenFeed,
                stackSeeds,stackSeedsPump, stackSeedsMelon);

        //making pips
        GameRegistry.addShapelessRecipe(stackPips,
                stackFruit);

        //making cherry pies
        GameRegistry.addShapelessRecipe(stackPie,
                stackEgg, stackFruit, stackSugar, stackWheat);


    }

    public static void cookblocks(){
        /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
        ItemStack stackCPSapling  = new ItemStack(CPBlocks.cherrySapling,1,0);
        ItemStack stackPork       = new ItemStack(Items.porkchop,1,0);


        GameRegistry.addRecipe(new ShapedOreRecipe(stackCPSapling,
                "xxx",
                "xyx",
                "xxx",
                'x', stackPork,
                'y', "treeSapling"
        ));
        /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
        ItemStack stackLog       = new ItemStack(CPBlocks.cherryLog,1,0);
        ItemStack stackSpruce    = new ItemStack(Blocks.planks, 1, 4);

        GameRegistry.addShapelessRecipe(stackSpruce, stackLog);
        /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
        ItemStack stackHay      = new ItemStack(Blocks.hay_block, 1, 0);
        ItemStack stackNest     = new ItemStack(CPBlocks.nest, 1, 0);

        GameRegistry.addShapedRecipe(stackNest,
                "x x",
                "xxx",
                'x', stackHay);

        /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
        ItemStack stackCharcoalBlock = new ItemStack(CPBlocks.charchoalBlack, 1, 0);
        ItemStack stackCharcoal      = new ItemStack(Items.coal, 1, 1);

        GameRegistry.addShapedRecipe(stackCharcoalBlock,
                "xxx",
                "xxx",
                "xxx",
                'x', stackCharcoal);


    }
}
