package othlon.cherrypig.items;

import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import othlon.cherrypig.CherryPig;

/**
 * Created by Jen on 7/09/2014.
 */
public class CPFood extends ItemFood {

    private String text;

    public CPFood(int food, boolean canWolf, float saturation)
    {
        super(food, saturation, canWolf);
        this.setCreativeTab(CherryPig.tabCherryPig);

    }

    @Override
    public String getUnlocalizedName()
    {
        return "item." + getRegistryName();
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack)
    {
        return getUnlocalizedName();
    }
}
