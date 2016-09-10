package othlon.cherrypig.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;
import othlon.cherrypig.CherryPig;

/**
 * Created by Jen on 14/12/2014.
 */
public class CPCherryStairs extends BlockStairs {

    public CPCherryStairs(IBlockState block){
        super(block);
        this.setHardness(1.5F);
        this.setCreativeTab(CherryPig.tabCherryPig);
        this.useNeighborBrightness = true;

    }

    @Override
    public String getUnlocalizedName()
    {
        return "tile." + getRegistryName();
    }
}
