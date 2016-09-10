package othlon.cherrypig.helpers;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import othlon.cherrypig.items.CPItem;

/**
 * Created by Jen on 9/06/14.
 */
public class CPCreativeTab extends CreativeTabs {

    public CPCreativeTab(int position, String tabID) {
        super(position, tabID);
    }

    @Override
    public ItemStack getIconItemStack() {
        return new ItemStack(CPItem.cherryFruit);
    }

    @Override
    public Item getTabIconItem() {
        return null;
    }

}
