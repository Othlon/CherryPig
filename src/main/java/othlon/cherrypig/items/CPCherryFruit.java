package othlon.cherrypig.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import othlon.cherrypig.CherryPig;

/**
 * Created by Jen on 7/09/2014.
 */
public class CPCherryFruit extends ItemFood {

    IIcon texture;
    public CPCherryFruit(int food, float saturation)
    {
        this.setHasSubtypes(true);
        this.setUnlocalizedName("CherryFruit");
        this.setCreativeTab(CherryPig.tabCherryPig);
        this.setTextureName("cherrypig:cherryfruit");
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack){
        return "CherrypigFruit";
    }

}
