package othlon.cherrypig.items;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

/**
 * Created by JayRay on 29/05/2014.
 */
public class CPItem {

    public static Item cherryPip;
    public static Item cherryFruit;
    public static Item cherryPie;
    public static Item spawnEgg;


    public static void doTheItemThing(){
        cherryPip = new CPCherryPip()
                .setRegistryName("cherrypip");
        GameRegistry.register(cherryPip);

        cherryFruit = new CPFood(1,true, 0.2F)
                .setRegistryName("cherryfruit");
        GameRegistry.register(cherryFruit);
        OreDictionary.registerOre("cropCherry", cherryFruit);
        OreDictionary.registerOre("listAllfruit", cherryFruit);
        OreDictionary.registerOre("foodCherry", cherryFruit);


        cherryPie = new CPFood(4,true, 2F)
                .setRegistryName("cherrypie");
        GameRegistry.register(cherryPie);
    }
}
