package othlon.cherrypig.entity;

import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.entity.Entity;
import othlon.cherrypig.CherryPig;

/**
 * Created by Jen on 5/09/2014.
 */
public class CPEntities {

    public static void doTheEnitityThing(){
      EntityRegistry.registerModEntity(CPEntityPiggy.class, "CherryPig", 7, CherryPig.instance, 64, 3, true);
    }
}
