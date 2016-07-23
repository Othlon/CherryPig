package othlon.cherrypig.entity;

import cpw.mods.fml.common.registry.EntityRegistry;
import othlon.cherrypig.CherryPig;

/**
 * Created by Jen on 5/09/2014.
 */
public class CPEntities {

    static int entityID = EntityRegistry.findGlobalUniqueEntityId();

    //spawn egg colours
    static int mainColour = 0x990000;
    static int subColour  = 0x669900;

    public static void doTheEnitityThing(){

      EntityRegistry.registerModEntity(CPEntityPiggy.class, "CherryPig", entityID, CherryPig.instance, 64, 3, true);

        //registrer spawn egg
       // EntityList.IDtoClassMapping.put(entityID, CherryPig.instance);
       // EntityList.classToStringMapping.put(entityID, "CherryPig");
        //EntityList.entityEggs.put(entityID, new EntityList.EntityEggInfo(entityID, mainColour, subColour));



    }
}
