package othlon.cherrypig.render;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import othlon.cherrypig.models.CPNestModel;

/**
 * Created by Jen on 17/09/2014.
 */
public class CPNestRender extends TileEntitySpecialRenderer {

    private static final ResourceLocation nestTex = new ResourceLocation("cherrypig", "textures/entities/minipigpig.png");

    //initalizer
    public CPNestRender() {
        super(new CPNestModel(), 0.5f);

        // setRenderPassModel(new CPNestModel());
    }


    @Override
    protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
        return CPNestRender.nestTex;
    }
}

