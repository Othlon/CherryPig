package othlon.cherrypig.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import othlon.cherrypig.CherryPig;

/**
 * Created by Jen on 14/12/2014.
 */
public class CPCherryStairs extends BlockStairs {

    public CPCherryStairs(Block block, int num){
        super(block, num);
        this.setHardness(1.5F);
        this.setBlockName("cherrywoodstairs");
        this.setCreativeTab(CherryPig.tabCherryPig);
        this.useNeighborBrightness = true;

    }
}
