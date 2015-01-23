package othlon.cherrypig.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import othlon.cherrypig.CherryPig;


/**
 * Created by Jen on 21/01/2015.
 */
public class CPChickenFeed extends Item {

    public CPChickenFeed()
    {
         this.setHasSubtypes(true);
         this.setUnlocalizedName("chickenfeed");
         this.setCreativeTab(CherryPig.tabCherryPig);
         this.setTextureName("cherrypig:chickenfeed");
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack){
        return "Chicken Feed";
    }

}
