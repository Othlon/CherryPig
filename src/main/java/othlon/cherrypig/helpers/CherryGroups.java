package othlon.cherrypig.helpers;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import othlon.cherrypig.CPRegistry;
import othlon.cherrypig.CherryPig;

public class CherryGroups {
    public static final ItemGroup CHERRY_TAB = new ItemGroup(CherryPig.MODID + ":tab") {
        @OnlyIn(Dist.CLIENT)
        public ItemStack createIcon() {
            return new ItemStack(CPRegistry.CHERRY_FRUIT.get());
        }
    };
}
