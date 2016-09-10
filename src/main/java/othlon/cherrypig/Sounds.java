package othlon.cherrypig;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by AtomicBlom on 10/09/2016.
 */
public class Sounds
{
    public static SoundEvent pigTalk;

    public static void registerSounds()
    {
        //FIXME: Remove this once SoundEvent is added to ObjectHolderRef
        pigTalk = registerSound("pigTalk");
    }

    private static SoundEvent registerSound(String soundName) {
        final ResourceLocation soundID = new ResourceLocation(CherryPig.MODID, soundName);
        return GameRegistry.register(new SoundEvent(soundID).setRegistryName(soundID));
    }
}
