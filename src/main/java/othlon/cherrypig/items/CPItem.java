package othlon.cherrypig.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

/**
 * Created by JayRay on 29/05/2014.
 */
public class CPItem {

    public static Item cherryPip;
    public static Item cherryFruit;


    public static void doTheItemThing(){
        cherryPip = new CPCherryPip();
        GameRegistry.registerItem(cherryPip, "cherryPip");

        cherryFruit = new CPFood(1,true, 0.2F,  "cherryfruit")
                         .setUnlocalizedName("cherryfruit");


        GameRegistry.registerItem(cherryFruit,"cherryFruit");
    }
}
