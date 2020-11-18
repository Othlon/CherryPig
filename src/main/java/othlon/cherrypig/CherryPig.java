package othlon.cherrypig;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import othlon.cherrypig.client.ClientHandler;
import othlon.cherrypig.init.CPRegistry;

@Mod(CherryPig.MODID)
public class CherryPig {
    public static final String MODID = "cherrypig";

    public CherryPig() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        CPRegistry.BLOCKS.register(eventBus);
        CPRegistry.ITEMS.register(eventBus);
        CPRegistry.ENTITIES.register(eventBus);
        CPRegistry.SOUND_EVENTS.register(eventBus);
        CPRegistry.FEATURES.register(eventBus);

        eventBus.addListener(EventPriority.LOWEST, this::commonSetup);
//        CPTileEntites.doTheTileEntityThings(); There ain't any

        DistExecutor.runWhenOn(Dist.CLIENT, () -> () -> {
            eventBus.addListener(ClientHandler::registerRenders);
            eventBus.addListener(ClientHandler::registerItemColors); //TODO: Block colors for the leaves
        });
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        for(Biome biome : ForgeRegistries.BIOMES.getValues())
        {
            CPRegistry.setupBiomeFeatures(biome);
        }
        CPRegistry.entityAttributes();
    }

    //public static CPTreeWorldGen trees;
//    public void init(FMLInitializationEvent event){
//        GameRegistry.registerWorldGenerator(new CPTreeWorldGen(), 20);
//    }
}
