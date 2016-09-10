package othlon.cherrypig;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import othlon.cherrypig.blocks.CPBlocks;
import othlon.cherrypig.entity.CPEntities;
import othlon.cherrypig.helpers.CPCreativeTab;
import othlon.cherrypig.items.CPItem;
import othlon.cherrypig.proxies.CommonProxy;
import othlon.cherrypig.worldgen.CPTreeWorldGen;
//import othlon.cherrypig.tileentities.CPTileEntites;
//import othlon.cherrypig.worldgen.CPTreeWorldGen;

@Mod(modid = CherryPig.MODID, name = CherryPig.NAME, version = CherryPig.VERSION)
public class CherryPig {


    public static final String VERSION = "1.4.2";
    public static final String MODID   = "cherrypig";
    public static final String NAME    = "CherryPig";
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Mod.Instance
    public static CherryPig instance;

    public static CreativeTabs tabCherryPig;

   // public static CommonHandler handler = new CommonHandler();

    @SidedProxy(clientSide = "othlon.cherrypig.proxies.ClientProxy", serverSide = "othlon.cherrypig.proxies.CommonProxy")
    public static CommonProxy proxy;


    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {

        tabCherryPig = new CPCreativeTab(CreativeTabs.getNextID(), "CherryPigTab");

        CPBlocks.doTheBlockThing();
        CPItem.doTheItemThing();
        proxy.registerRenderers();
        CPEntities.doTheEnitityThing();
        //CPTileEntites.doTheTileEntityThings();
        CPCookBook.cookfood();
        CPCookBook.cookblocks();
        GameRegistry.registerFuelHandler( new CPFuelHandler() );

        Sounds.registerSounds();

    }//end pre init

    //public static CPTreeWorldGen trees;
    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        GameRegistry.registerWorldGenerator(new CPTreeWorldGen(), 20);
    }
}
