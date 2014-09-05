package othlon.cherrypig.render;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import othlon.cherrypig.entity.CPEntityPiggy;

public class CPPiggyRender extends RenderLiving{

    private static final ResourceLocation piggyTexture = new ResourceLocation("cherrypig", "textures/entity/minipigpig.png");
    //initalizer
    public CPPiggyRender()
    {
        super(new CPPiggyModel(), 0.5f);
        this.setRenderPassModel(new CPPiggyModel());
    }
    protected float handleRotationFloat(CPEntityPiggy p_77044_1_, float p_77044_2_)
    {
        return p_77044_1_.getRotationYawHead();
    }


    protected ResourceLocation getEntityTexture(CPEntityPiggy p_110775_1_)
    {
        return CPPiggyRender.piggyTexture;
    }

    @Override
    protected int shouldRenderPass(EntityLivingBase p_77032_1_, int p_77032_2_, float p_77032_3_)
    {
        return this.shouldRenderPass((CPEntityPiggy) p_77032_1_, p_77032_2_, p_77032_3_);
    }

    @Override
    protected float handleRotationFloat(EntityLivingBase p_77044_1_, float p_77044_2_)
    {
        return this.handleRotationFloat((CPEntityPiggy) p_77044_1_, p_77044_2_);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity p_110775_1_)
    {
        return this.getEntityTexture((CPEntityPiggy) p_110775_1_);
    }


}
