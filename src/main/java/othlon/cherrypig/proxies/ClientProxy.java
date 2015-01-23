package othlon.cherrypig.proxies;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import othlon.cherrypig.entity.CPEntityChook;
import othlon.cherrypig.entity.CPEntityPiggy;
import othlon.cherrypig.render.*;
import othlon.cherrypig.tileentities.CPFertileEggTileEntity;
import othlon.cherrypig.tileentities.CPIncubatorTileEntity;
import othlon.cherrypig.tileentities.CPNestTileEntity;


public class ClientProxy extends CommonProxy{

       public void registerRenderers(){
           RenderingRegistry.registerEntityRenderingHandler(CPEntityPiggy.class, new CPPiggyRender());
           RenderingRegistry.registerEntityRenderingHandler(CPEntityChook.class, new CPChookRender());


           ClientRegistry.bindTileEntitySpecialRenderer(CPNestTileEntity.class, new CPNestRender());
          // MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(CPBlocks.nest), WHAT DO YOU WANT HERE!?);


           ClientRegistry.bindTileEntitySpecialRenderer(CPFertileEggTileEntity.class, new CPFirtileEggRender());
          // MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(CPBlocks.egg),);


           ClientRegistry.bindTileEntitySpecialRenderer(CPIncubatorTileEntity.class, new CPIncubatorRender());

       }
}