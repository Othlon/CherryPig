package othlon.cherrypig.render;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import othlon.cherrypig.entity.CPEntityPiggy;
import othlon.cherrypig.models.CPPiggyModel;

public class CPPiggyRender extends RenderLiving<CPEntityPiggy>{

    private static final ResourceLocation piggyTexture = new ResourceLocation("cherrypig", "textures/entities/pigskin.png");
    //initalizer
    public CPPiggyRender(RenderManager renderManager)
    {
        super(renderManager, new CPPiggyModel(), 0.5f);
    }

    @Override
    protected ResourceLocation getEntityTexture(CPEntityPiggy p_110775_1_)
    {
        return CPPiggyRender.piggyTexture;
    }
}
