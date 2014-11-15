package othlon.cherrypig.render;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import othlon.cherrypig.models.CPChookModel;


/*
 * Created by Jen on 15/11/2014.
 */
public class CPChookRender extends RenderLiving {

    private static final ResourceLocation chooktexture = new ResourceLocation("chook", "textures/entities/chook.png");
    //initalizer
    public CPChookRender()
    {
        super(new CPChookModel(), 0.5f);
        this.setRenderPassModel(new CPChookModel());
    }


    @Override
    protected ResourceLocation getEntityTexture(Entity p_110775_1_)
    {
        return CPChookRender.chooktexture;
    }

}
