package othlon.cherrypig;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import othlon.cherrypig.client.ClientHandler;
//import othlon.cherrypig.tileentities.CPTileEntites;
//import othlon.cherrypig.worldgen.CPTreeWorldGen;

@Mod(CherryPig.MODID)
public class CherryPig {
    public static final String MODID   = "cherrypig";

    public CherryPig() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        CPRegistry.BLOCKS.register(eventBus);
        CPRegistry.ITEMS.register(eventBus);
        CPRegistry.ENTITIES.register(eventBus);
        CPRegistry.SOUND_EVENTS.register(eventBus);

//        CPCookBook.cookfood(); TODO: Implement the recipes
//        CPCookBook.cookblocks();
//        CPTileEntites.doTheTileEntityThings(); There ain't any

        DistExecutor.runWhenOn(Dist.CLIENT, () -> () -> {
            eventBus.addListener(ClientHandler::registerRenders);
            eventBus.addListener(ClientHandler::registerItemColors); //TODO: Block colors for the leaves
        });
    }

    //public static CPTreeWorldGen trees;
//    public void init(FMLInitializationEvent event){
//        GameRegistry.registerWorldGenerator(new CPTreeWorldGen(), 20);
//    }
}
