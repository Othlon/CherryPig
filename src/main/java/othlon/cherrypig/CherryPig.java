package othlon.cherrypig;

import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import othlon.cherrypig.blocks.tree.CPFeatureConfig;
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
        MinecraftForge.EVENT_BUS.register(this);
//      CPTileEntites.doTheTileEntityThings(); There ain't any

        DistExecutor.runWhenOn(Dist.CLIENT, () -> () -> {
            eventBus.addListener(ClientHandler::registerRenders);
            eventBus.addListener(ClientHandler::registerItemColors); //TODO: Block colors for the leaves
        });
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        CPRegistry.entityAttributes();
    }

    @SubscribeEvent(priority = EventPriority.HIGH)
    public void biomeLoadingEvent(BiomeLoadingEvent event) {
        RegistryKey<Biome> biomeKey = RegistryKey.getOrCreateKey(Registry.BIOME_KEY, event.getName());
        if (BiomeDictionary.hasType(biomeKey, Type.FOREST)) {
            BiomeGenerationSettingsBuilder builder = event.getGeneration();
            if(!builder.getFeatures(Decoration.VEGETAL_DECORATION).contains(CPFeatureConfig.CHERRY_TREE_CONFIG)) {
                builder.withFeature(Decoration.VEGETAL_DECORATION, CPFeatureConfig.CHERRY_TREE_CONFIG.withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(1, 0.05F, 1))));
            }
        }
    }
}
