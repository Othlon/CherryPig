package othlon.cherrypig.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import othlon.cherrypig.CherryPig;

/**
 * Created by Jen on 7/09/2014.
 */
public class CPFood extends ItemFood {

    private String text;
    IIcon icon;

    public CPFood(int food, boolean canWolf, float saturation, String texture)
    {
        super(food, saturation, canWolf);
        text = texture;
        this.setCreativeTab(CherryPig.tabCherryPig);

    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister ir){
        this.icon = ir.registerIcon("cherrypig:"+ text);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage( int iPar){
        return this.icon;
    }

}
