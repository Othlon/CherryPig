package othlon.cherrypig.render;

import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import othlon.cherrypig.models.CPFirtileEggModel;
import othlon.cherrypig.tileentities.CPFirtileEggTileEntity;


public class CPFirtileEggRender extends TileEntitySpecialRenderer {

    CPFirtileEggModel model =  new CPFirtileEggModel();
    ResourceLocation tex    =  new ResourceLocation("cherrypig", "textures/blocks/FirtileEgg.png");

    public CPFirtileEggRender(){

    }


    @Override
    public void renderTileEntityAt(TileEntity tileentity, double d0, double d1, double d2, float f){
        renderModelAt((CPFirtileEggTileEntity)tileentity, d0, d1, d2, f);
    }


    public void renderModelAt(CPFirtileEggTileEntity tile, double dX, double dY, double dZ, float f){

        GL11.glPushMatrix(); // start
        {
            FMLClientHandler.instance().getClient().renderEngine.bindTexture(tex);
            GL11.glTranslatef( (float)dX + 0.5F,(float)dY +0.5F, (float)dZ +0.5F);
            GL11.glScalef( 1.0f, 1.0f, 1.0f );
            //GL11.glTranslatef(0.5F, 0.5F, 0.5F);
            GL11.glRotatef(180F, 90.0F, 0.0F, 90.0F);
            this.model.renderAll();
        }
        GL11.glPopMatrix(); // end
    }
}
