package othlon.cherrypig;

import cpw.mods.fml.common.IFuelHandler;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import othlon.cherrypig.blocks.CPBlocks;

/**
 * Created by Candice on 7/18/2015.
 */
public class CPFuelHandler implements IFuelHandler {
    @Override
    public int getBurnTime(ItemStack fuel) {
        if( fuel.getItem() == Item.getItemFromBlock( CPBlocks.charchoalBlack ) ) {
            return 14400;
        }
        return 0;
    }
}
