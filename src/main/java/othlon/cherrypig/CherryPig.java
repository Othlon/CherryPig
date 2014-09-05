package othlon.cherrypig;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import othlon.cherrypig.blocks.CPBlocks;
import othlon.cherrypig.blocks.CPCherryLeaf;
import othlon.cherrypig.blocks.CPCherryLog;
import othlon.cherrypig.blocks.CPCherrySapling;
import othlon.cherrypig.helpers.CPCreativeTab;
import othlon.cherrypig.items.CPItem;
import othlon.cherrypig.render.CPPiggyRender;

@Mod(modid = "cherrypig")
public class CherryPig {
    @Mod.Instance
    public static CherryPig instance;

    public static CreativeTabs tabCherryPig;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        tabCherryPig = new CPCreativeTab(CreativeTabs.getNextID(), "tabCherryPig");
        CPBlocks.init();
        CPItem.ItemInit();
    }//end pre init
}
