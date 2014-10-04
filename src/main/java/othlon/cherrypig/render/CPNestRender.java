package othlon.cherrypig.render;

import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import othlon.cherrypig.blocks.CPBlocks;
import othlon.cherrypig.models.CPNestModel;
import othlon.cherrypig.tileentities.CPNestTileEntity;

/**
 * Created by Jen on 4/10/2014.
 */
public class CPNestRender extends TileEntitySpecialRenderer {

   CPNestModel model;

    public CPNestRender(){
        model = new CPNestModel();
    }


    @Override
    public void renderTileEntityAt(TileEntity tileentity, double d0, double d1, double d2, float f){
        renderModelAt((CPNestTileEntity)tileentity, d0, d1, d2, f);
    }

    public void renderModelAt(CPNestTileEntity tile, double d, double d1, double d2, float f){
        GL11.glPushMatrix(); // start
        {
            GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.5F, (float)d2 + 0.5F); // size
            GL11.glScalef(1.0F, -1F, -1F);

            FMLClientHandler.instance().
                getClient().
                getTextureManager().
                bindTexture(new ResourceLocation("cherrypig:textures/blocks/nest.png"));
            GL11.glRotatef(0, 0.0F, 1.0F, 0.0F);
            this.model.renderAll();
        }
        GL11.glPopMatrix(); // end
    }
}
