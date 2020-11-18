package othlon.cherrypig.client;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import othlon.cherrypig.init.CPRegistry;
import othlon.cherrypig.client.render.PiggyRenderer;
import othlon.cherrypig.items.CustomSpawnEggItem;

public class ClientHandler {
    public static void registerRenders(FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(CPRegistry.CHERRY_PIG.get(), PiggyRenderer::new);

        RenderTypeLookup.setRenderLayer(CPRegistry.CHERRY_SAPLING.get(), RenderType.getCutout());;

        //Don't use the CHECK_DECAY or DECAYABLE properties for rendering
//           ModelLoader.setCustomStateMapper(CPBlocks.cherryLeaf, new StateMap.Builder().ignore(SaplingBlock.STAGE, CHECK_DECAY, DECAYABLE).build());
//           ModelLoader.setCustomStateMapper(CPBlocks.cherrySapling, new StateMap.Builder().ignore(SaplingBlock.TYPE).build()); TODO: Not needed
    }

    public static void registerItemColors(final ColorHandlerEvent.Item event) {
        ItemColors colors = event.getItemColors();

        for(CustomSpawnEggItem spawneggitem : CustomSpawnEggItem.getEggs()) {
            colors.register((p_198141_1_, p_198141_2_) -> {
                return spawneggitem.getColor(p_198141_2_);
            }, spawneggitem);
        }
    }
}
