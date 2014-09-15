package othlon.cherrypig;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import othlon.cherrypig.blocks.CPBlocks;
import othlon.cherrypig.items.CPItem;


public class CPCookBook {
    //item stacks



    public static void cookfood(){
        ItemStack stackFruit = new ItemStack(CPItem.cherryFruit, 1, 0);
        ItemStack stackPips  = new ItemStack(CPItem.cherryPip, 1, 0);

        GameRegistry.addShapelessRecipe(stackPips, stackFruit);
    }

    public static void cookblocks(){
        ItemStack stackCPSapling = new ItemStack(CPBlocks.cherrySapling,1,0);
       ItemStack stackPork       = new ItemStack(Items.porkchop,1,0);

        GameRegistry.addRecipe(new ShapedOreRecipe(stackCPSapling,
                "xxx",
                "xyx",
                "xxx",
                'x', stackPork,
                'y', "treeSapling"
        ));

        ItemStack stackLog       = new ItemStack(CPBlocks.cherryLog,1,0);
        ItemStack stackSpruce    = new ItemStack(Blocks.planks, 1, 4);

        GameRegistry.addShapelessRecipe(stackSpruce, stackLog);
    }
}
