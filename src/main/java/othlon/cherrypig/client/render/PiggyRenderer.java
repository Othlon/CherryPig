package othlon.cherrypig.client.render;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import othlon.cherrypig.entity.PiggyEntity;
import othlon.cherrypig.client.models.CPPiggyModel;

public class PiggyRenderer extends MobRenderer<PiggyEntity, CPPiggyModel<PiggyEntity>> {

    private static final ResourceLocation piggyTexture = new ResourceLocation("cherrypig", "textures/entities/pigskin.png");

    public PiggyRenderer(EntityRendererManager renderManager) {
        super(renderManager, new CPPiggyModel(), 0.5f);
    }

    @Override
    public ResourceLocation getEntityTexture(PiggyEntity entity) {
        return PiggyRenderer.piggyTexture;
    }
}
