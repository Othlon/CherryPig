package othlon.cherrypig.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import othlon.cherrypig.CherryPig;

/**
 * Created by Jen on 29/11/2014.
 */
public class CPCharcoalBlock extends Block {

    IIcon face;

    public CPCharcoalBlock(){

        super(Material.rock);
        this.setHardness(5.0F);
        this.setResistance(10.0F);
        this.setStepSound(soundTypePiston);
        this.setBlockName("charcoalblock");
        this.setCreativeTab(CherryPig.tabCherryPig);
    }
    @Override
    public void registerBlockIcons(IIconRegister charcoalblock) {
        face = charcoalblock.registerIcon("cherrypig:charcoal_block");

    }

    @Override
    public IIcon getIcon(int side, int meta) {
        return face;
    }
}
