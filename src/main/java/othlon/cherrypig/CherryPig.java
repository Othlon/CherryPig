package othlon.cherrypig;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import othlon.cherrypig.blocks.CPBlocks;
import othlon.cherrypig.blocks.CPCherryLeaf;
import othlon.cherrypig.blocks.CPCherryLog;
import othlon.cherrypig.blocks.CPCherrySapling;
import othlon.cherrypig.entity.CPEntities;
import othlon.cherrypig.helpers.CPCreativeTab;
import othlon.cherrypig.items.CPItem;
import othlon.cherrypig.proxies.CommonProxy;
import othlon.cherrypig.render.CPPiggyRender;
import othlon.cherrypig.tileentities.CPTileEntites;
import othlon.cherrypig.worldgen.CPTreeWorldGen;

@Mod(modid = "cherrypig", name = "CherryPig", version = "1.1.1")
public class CherryPig {
    @Mod.Instance
    public static CherryPig instance;

    public static CreativeTabs tabCherryPig;

    @SidedProxy(clientSide = "othlon.cherrypig.proxies.ClientProxy", serverSide = "othlon.cherrypig.proxies.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        tabCherryPig = new CPCreativeTab(CreativeTabs.getNextID(), "tabCherryPig");
        CPBlocks.doTheBlockThing();
        CPItem.doTheItemThing();
        proxy.registerRenderers();
        CPEntities.doTheEnitityThing();
        CPTileEntites.doTheTileEntityThings();
        CPCookBook.cookfood();
        CPCookBook.cookblocks();
    }//end pre init

    public static CPTreeWorldGen trees;
    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        GameRegistry.registerWorldGenerator(trees = new CPTreeWorldGen(), 20);
    }
}
