package othlon.cherrypig.helpers;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Created by Jen on 9/06/14.
 */
public class CPCreativeTab extends CreativeTabs {

    public CPCreativeTab(int position, String tabID) {
        super(position, tabID);
    }

    @Override
    public ItemStack getIconItemStack() {
        return new ItemStack(Items.apple);
    }

    @Override
    public Item getTabIconItem() {
        return null;
    }

}
