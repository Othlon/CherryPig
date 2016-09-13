package othlon.cherrypig.proxies;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import othlon.cherrypig.CPEvents;
import othlon.cherrypig.blocks.CPBlocks;
import othlon.cherrypig.entity.CPEntityPiggy;
import othlon.cherrypig.items.CPItem;
import othlon.cherrypig.render.CPPiggyRender;

import static net.minecraft.block.BlockLeaves.CHECK_DECAY;
import static net.minecraft.block.BlockLeaves.DECAYABLE;


public class ClientProxy extends CommonProxy{

       public void registerRenderers(){
           RenderingRegistry.registerEntityRenderingHandler(CPEntityPiggy.class, new IRenderFactory<CPEntityPiggy>() {
               @Override
               public Render<? super CPEntityPiggy> createRenderFor(RenderManager manager)
               {
                   return new CPPiggyRender(manager);
               }
           });

           registerItemModel(CPItem.cherryFruit);
           registerItemModel(CPItem.cherryPie);
           registerItemModel(CPItem.cherryPip);

           registerBlockItemModel(CPBlocks.charchoalBlack);
           registerBlockItemModel(CPBlocks.cherryLeaf);
           registerBlockItemModel(CPBlocks.cherrySapling);
           registerBlockItemModel(CPBlocks.cherryLog);
           registerBlockItemModel(CPBlocks.cherryPlanks);
           registerBlockItemModel(CPBlocks.cherryStairs);
           registerBlockItemModel(CPBlocks.flintBlock);

           MinecraftForge.EVENT_BUS.register(new CPEvents());

           //Don't use the CHECK_DECAY or DECAYABLE properties for rendering
           ModelLoader.setCustomStateMapper(CPBlocks.cherryLeaf, new StateMap.Builder().ignore(BlockSapling.STAGE, CHECK_DECAY, DECAYABLE).build());
           ModelLoader.setCustomStateMapper(CPBlocks.cherrySapling, new StateMap.Builder().ignore(BlockSapling.TYPE).build());
       }

    private void registerBlockItemModel(Block block) {
        ModelLoader.setCustomModelResourceLocation(
                Item.getItemFromBlock(block),
                0,
                new ModelResourceLocation(block.getRegistryName(), "inventory")
        );
    }

    private void registerItemModel(Item item) {
        ModelLoader.setCustomModelResourceLocation(
                item,
                0,
                new ModelResourceLocation(item.getRegistryName(), "inventory")
        );
    }
}