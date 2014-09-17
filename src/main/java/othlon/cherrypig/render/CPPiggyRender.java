package othlon.cherrypig.render;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import othlon.cherrypig.models.CPPiggyModel;

public class CPPiggyRender extends RenderLiving{

    private static final ResourceLocation piggyTexture = new ResourceLocation("cherrypig", "textures/entities/minipigpig.png");
    //initalizer
    public CPPiggyRender()
    {
        super(new CPPiggyModel(), 0.5f);
        this.setRenderPassModel(new CPPiggyModel());
    }


    @Override
    protected ResourceLocation getEntityTexture(Entity p_110775_1_)
    {
        return CPPiggyRender.piggyTexture;
    }


}
