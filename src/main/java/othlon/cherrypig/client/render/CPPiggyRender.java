package othlon.cherrypig.client.render;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import othlon.cherrypig.entity.CPEntityPiggy;
import othlon.cherrypig.models.CPPiggyModel;

public class CPPiggyRender extends MobRenderer<CPEntityPiggy, CPPiggyModel<CPEntityPiggy>> {

    private static final ResourceLocation piggyTexture = new ResourceLocation("cherrypig", "textures/entities/pigskin.png");

    public CPPiggyRender(EntityRendererManager renderManager) {
        super(renderManager, new CPPiggyModel(), 0.5f);
    }

    @Override
    public ResourceLocation getEntityTexture(CPEntityPiggy entity) {
        return CPPiggyRender.piggyTexture;
    }
}
