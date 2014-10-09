package othlon.cherrypig.proxies;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import othlon.cherrypig.blocks.CPFirtileEgg;
import othlon.cherrypig.entity.CPEntityPiggy;
import othlon.cherrypig.render.CPFirtileEggRender;
import othlon.cherrypig.render.CPNestRender;
import othlon.cherrypig.render.CPPiggyRender;
import othlon.cherrypig.tileentities.CPFirtileEggTileEntity;
import othlon.cherrypig.tileentities.CPNestTileEntity;


public class ClientProxy extends CommonProxy{

       public void registerRenderers(){
           RenderingRegistry.registerEntityRenderingHandler(CPEntityPiggy.class, new CPPiggyRender());
           ClientRegistry.bindTileEntitySpecialRenderer(CPNestTileEntity.class, new CPNestRender());
           ClientRegistry.bindTileEntitySpecialRenderer(CPFirtileEggTileEntity.class, new CPFirtileEggRender());
       }
}