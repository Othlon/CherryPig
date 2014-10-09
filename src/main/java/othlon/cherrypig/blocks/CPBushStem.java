package othlon.cherrypig.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import othlon.cherrypig.CherryPig;

import java.util.List;

public class CPBushStem extends Block{


    @SideOnly(Side.CLIENT)
    IIcon logIcon;
    IIcon logIconTopBtm;


    public CPBushStem(){
       super(Material.wood);
        this.setHardness(2.0F);
        this.setHarvestLevel("axe", 0);
        this.setResistance(5.0F);
        this.setStepSound(soundTypeWood);
        this.setBlockName("cherrylog");
        this.setCreativeTab(CherryPig.tabCherryPig);
    }

    @Override
    public void getSubBlocks(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_) {
        //noinspection unchecked
        p_149666_3_.add(new ItemStack(p_149666_1_, 1, 0));
    } //nope

    @Override
    public void registerBlockIcons(IIconRegister thisdude) {
        logIcon       = thisdude.registerIcon("cherrypig:cherrypig_treebark");
        logIconTopBtm = thisdude.registerIcon("cherrypig:cherrypig_treelog");
    }



    @SideOnly(Side.CLIENT)
    protected IIcon getSideIcon(int meta)
    {
        return this.logIcon;
    }


    @SideOnly(Side.CLIENT)
    protected IIcon getTopIcon(int meta)
    {
        return this.logIconTopBtm;
    }

}
