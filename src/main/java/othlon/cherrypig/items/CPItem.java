package othlon.cherrypig.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import othlon.cherrypig.entity.CPEntityPiggy;

/**
 * Created by JayRay on 29/05/2014.
 */
public class CPItem {

    public static Item cherryFruit;
    public static void ItemInit(){
        cherryFruit = new CPCherryPigFruit();
        GameRegistry.registerItem(cherryFruit, "cherryfruit");
    }
}
