package othlon.cherrypig.helpers;

import net.minecraft.block.Block;
import net.minecraft.item.ItemSlab;
import net.minecraft.item.ItemStack;
import othlon.cherrypig.blocks.CPCherrySlab;

/**
 * Created by Jen on 29/11/2014.
 */
public class CPItemBlockSlab extends ItemSlab {


    public CPItemBlockSlab(Block block, CPCherrySlab singleSlab, CPCherrySlab doubleSlab, Boolean bool) {
        super(block, singleSlab, doubleSlab, bool);
        this.setHasSubtypes(true);
    }

    @Override
    public int getMetadata(int meta)
    {
        return meta & 7;
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack)
    {
        //TODO:									getBlockFromItem
        CPCherrySlab slab = (CPCherrySlab)Block.getBlockFromItem(itemStack.getItem());

        //TODO:																		getFullSlabName()
        return super.getUnlocalizedName() + "." + (new StringBuilder()).append(slab.func_150002_b(itemStack.getItemDamage())).toString();
    }
}
