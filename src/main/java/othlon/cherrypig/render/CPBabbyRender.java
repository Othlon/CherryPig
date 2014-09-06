package othlon.cherrypig.render;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;


public class CPBabbyRender extends RenderLiving {
    private static final ResourceLocation piggyTexture = new ResourceLocation("cherrypig", "textures/entities/minipigpig.png");
    //initalizer
    public CPBabbyRender()
    {
        super(new CPBabbyModel(), 0.5f);
        this.setRenderPassModel(new CPBabbyModel());
    }


    @Override
    protected ResourceLocation getEntityTexture(Entity p_110775_1_)
    {
        return CPBabbyRender.piggyTexture;
    }


}
