package othlon.cherrypig.helpers;

import net.minecraft.item.Food;

public class CPFoods {
    public static final Food CHERRY_FRUIT = (new Food.Builder()).hunger(1).saturation(0.2F).meat().build();
    public static final Food CHERRY_PIE = (new Food.Builder()).hunger(4).saturation(2.0F).meat().build();
}
