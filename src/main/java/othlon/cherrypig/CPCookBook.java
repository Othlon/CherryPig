package othlon.cherrypig;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import othlon.cherrypig.items.CPItem;


public class CPCookBook {
    //item stacks



    public static void cookfood(){
        ItemStack stackFruit = new ItemStack(CPItem.cherryFruit, 1, 0);
        ItemStack stackPips  = new ItemStack(CPItem.cherryPip, 1, 0);

        GameRegistry.addShapelessRecipe(stackPips, stackFruit);
    }
}
