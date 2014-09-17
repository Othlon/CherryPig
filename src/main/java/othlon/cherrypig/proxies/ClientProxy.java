package othlon.cherrypig.proxies;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import othlon.cherrypig.entity.CPEntityPiggy;
import othlon.cherrypig.render.CPPiggyRender;
import othlon.cherrypig.tileentities.CPTileEntityNest;

/**
 * Created by Jen on 5/09/2014.
 */
public class ClientProxy extends CommonProxy{

       public void registerRenderers(){
           RenderingRegistry.registerEntityRenderingHandler(CPEntityPiggy.class, new CPPiggyRender());
           //ClientRegistry.bindTileEntitySpecialRenderer(CPTileEntityNest.class, new );
       }
}
