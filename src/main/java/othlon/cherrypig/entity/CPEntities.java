package othlon.cherrypig.entity;

import net.minecraftforge.fml.common.registry.EntityRegistry;
import othlon.cherrypig.CherryPig;

/**
 * Created by Jen on 5/09/2014.
 */
public class CPEntities {
    //spawn egg colours
    static int mainColour = 0x990000;
    static int subColour  = 0x669900;

    public static void doTheEnitityThing(){
        int cpEntityIds = 0;

        EntityRegistry.registerModEntity(CPEntityPiggy.class, "CherryPig", ++cpEntityIds, CherryPig.instance, 64, 3, true);

        //registrer spawn egg
        EntityRegistry.registerEgg(CPEntityPiggy.class, mainColour, subColour);
    }
}
