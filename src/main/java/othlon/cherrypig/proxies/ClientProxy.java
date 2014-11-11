package othlon.cherrypig.proxies;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import othlon.cherrypig.blocks.CPBlocks;
import othlon.cherrypig.blocks.CPFirtileEgg;
import othlon.cherrypig.blocks.CPNest;
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
           MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(CPBlocks.nest), WHAT DO YOU WANT HERE!?);


           ClientRegistry.bindTileEntitySpecialRenderer(CPFirtileEggTileEntity.class, new CPFirtileEggRender());
           MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(CPBlocks.egg), Item.getItemFromBlock(CPBlocks.egg));

       }
}