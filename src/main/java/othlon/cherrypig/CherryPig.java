package othlon.cherrypig;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import othlon.cherrypig.blocks.CPCherryLeaf;
import othlon.cherrypig.blocks.CPCherryLog;
import othlon.cherrypig.blocks.CPCherrySapling;
import othlon.cherrypig.helpers.CPCreativeTab;

/**
 * Created by Jen on 25/05/14.
 */
@Mod(modid = "cherrypig")
public class CherryPig {
    @Mod.Instance
    public static CherryPig instance;

    public static CreativeTabs tabCherryPig;
    public CPCherryLeaf cherryLeaf;
    public CPCherryLog cherryLog;
    public CPCherrySapling cherrySapling;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        tabCherryPig = new CPCreativeTab(CreativeTabs.getNextID(), "tabCherryPig");
        cherryLog = new CPCherryLog();
        cherrySapling = new CPCherrySapling();
        cherryLeaf = new CPCherryLeaf();

        GameRegistry.registerBlock(cherryLog, "Cherry Log");
        GameRegistry.registerBlock(cherryLeaf, "Cherry Leaf");
        GameRegistry.registerBlock(cherrySapling, "Cherry Sapling");
    }//end pre init
}
