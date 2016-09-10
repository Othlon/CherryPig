package othlon.cherrypig;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
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
        ItemStack stackSugar      = new ItemStack(Items.SUGAR, 1, 0);
        ItemStack stackEgg        = new ItemStack(Items.EGG,   1, 0);
        ItemStack stackWheat      = new ItemStack(Items.WHEAT, 1, 0);


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
        ItemStack stackPork       = new ItemStack(Items.PORKCHOP,1,0);


        GameRegistry.addRecipe(new ShapedOreRecipe(stackCPSapling,
                "xxx",
                "xyx",
                "xxx",
                'x', stackPork,
                'y', "treeSapling"
        ));
        /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
        ItemStack stackLog       = new ItemStack(CPBlocks.cherryLog,1,0);
        ItemStack stackPlanks    = new ItemStack(CPBlocks.cherryPlanks, 4,0);

        GameRegistry.addShapelessRecipe(stackPlanks, stackLog);


        /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
        ItemStack stackCharcoalBlock = new ItemStack(CPBlocks.charchoalBlack, 1, 0);
        ItemStack stackCharcoal      = new ItemStack(Items.COAL, 1, 1);

        GameRegistry.addShapedRecipe(stackCharcoalBlock,
                "xxx",
                "xxx",
                "xxx",
                'x', stackCharcoal);


    }
}
