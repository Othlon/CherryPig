package othlon.cherrypig.render;

import cpw.mods.fml.client.FMLClientHandler;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import othlon.cherrypig.blocks.CPBlocks;
import othlon.cherrypig.models.CPFirtileEggModel;
import othlon.cherrypig.tileentities.CPFertileEggTileEntity;


public class CPFirtileEggRender extends TileEntitySpecialRenderer {

    CPFirtileEggModel model =  new CPFirtileEggModel();
    ResourceLocation tex    =  new ResourceLocation("cherrypig", "textures/blocks/FirtileEgg.png");

    public CPFirtileEggRender(){

    }


    @Override
    public void renderTileEntityAt(TileEntity tileentity, double d0, double d1, double d2, float f){
        renderModelAt((CPFertileEggTileEntity)tileentity, d0, d1, d2, f);
    }

    public void renderModelAt(CPFertileEggTileEntity tile, double dX, double dY, double dZ, float f){

        GL11.glPushMatrix(); // start
        {
            FMLClientHandler.instance().getClient().renderEngine.bindTexture(tex);
            if(tile.getWorldObj().getBlock(tile.xCoord, tile.yCoord - 1, tile.zCoord) == CPBlocks.nest){
            	GL11.glTranslatef((float)dX + 0.5F,(float)dY -0.35F, (float)dZ +0.5F);
            	tile.getBlockType().setBlockBounds(0.4F, -0.8F, 0.4F, 0.6F, -0.55F, 0.6F);
            }else{
            	GL11.glTranslatef( (float)dX + 0.5F,(float)dY +0.5F, (float)dZ +0.5F);
            }
            GL11.glScalef( 1.0f, 1.0f, 1.0f );
            //GL11.glTranslatef(0.5F, 0.5F, 0.5F);
            GL11.glRotatef(180F, 90.0F, 0.0F, 90.0F);
            this.model.renderAll();
        }
        GL11.glPopMatrix(); // end
    }



    private void renderItem(float x, float y, float z){
        GL11.glPushMatrix();
        GL11.glTranslatef(x, y, z);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        this.model.renderAll();
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glPopMatrix();

    }


   // @Override
    public boolean handleRenderType(ItemStack item, IItemRenderer type){
        return true;
    }

  //  @Override
    public boolean shouldUseRenderHelp(IItemRenderer.ItemRenderType type, ItemStack item, IItemRenderer.ItemRendererHelper helper){

        return true;
    }

  ///  @Override
    public void renderItem(IItemRenderer.ItemRenderType type, ItemStack item, Object... data){
        renderItem(0, 0, 0);
    }



}
