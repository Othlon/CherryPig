package othlon.cherrypig.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import othlon.cherrypig.CherryPig;

/**
 * Created by Jen on 29/11/2014.
 */
public class CPFlintBlock extends Block {

    IIcon face;

    public CPFlintBlock(){
        super(Material.iron);

        this.setHardness(5.0F);
        this.setResistance(10.0F);
        this.setStepSound(soundTypeMetal);
        this.setBlockName("flintblock");
        this.setCreativeTab(CherryPig.tabCherryPig);
    }
    @Override
    public void registerBlockIcons(IIconRegister flintblock) {
        face = flintblock.registerIcon("cherrypig:flint_block");
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        return face;
    }
}
