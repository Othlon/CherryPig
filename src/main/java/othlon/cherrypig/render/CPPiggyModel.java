package othlon.cherrypig.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import othlon.cherrypig.entity.CPEntityPiggy;

public class CPPiggyModel extends ModelBase {

    //fields
//fields
    ModelRenderer body;
    ModelRenderer face;
    ModelRenderer back;
    ModelRenderer right;
    ModelRenderer left;
    ModelRenderer top;
    ModelRenderer snout;
    ModelRenderer btm;

    public CPPiggyModel()
    {
        textureWidth = 64;
        textureHeight = 32;

        body = new ModelRenderer(this, 28, 16);
        body.addBox(0F, 0F, 0F, 8, 8, 8);
        body.setRotationPoint(-3F, 15F, -3F);
        body.setTextureSize(64, 32);
        body.mirror = true;
        setRotation(body, 0F, 0F, 0F);
        face = new ModelRenderer(this, 0, 0);
        face.addBox(0F, 0F, 0F, 6, 6, 1);
        face.setRotationPoint(-2F, 16F, -4F);
        face.setTextureSize(64, 32);
        face.mirror = true;
        setRotation(face, 0F, 0F, 0F);
        back = new ModelRenderer(this, 14, 0);
        back.addBox(0F, 0F, 0F, 6, 6, 1);
        back.setRotationPoint(-2F, 16F, 5F);
        back.setTextureSize(64, 32);
        back.mirror = true;
        setRotation(back, 0F, 0F, 0F);
        right = new ModelRenderer(this, 14, 7);
        right.addBox(0F, 0F, 0F, 6, 6, 1);
        right.setRotationPoint(-4F, 16F, 4F);
        right.setTextureSize(64, 32);
        right.mirror = true;
        setRotation(right, 0F, 1.570796F, 0F);
        left = new ModelRenderer(this, 0, 7);
        left.addBox(0F, 0F, 0F, 6, 6, 1);
        left.setRotationPoint(5F, 16F, 4F);
        left.setTextureSize(64, 32);
        left.mirror = true;
        setRotation(left, 0F, 1.570796F, 0F);
        top = new ModelRenderer(this, 0, 14);
        top.addBox(0F, 0F, 0F, 6, 6, 1);
        top.setRotationPoint(-2F, 15F, -2F);
        top.setTextureSize(64, 32);
        top.mirror = true;
        setRotation(top, 1.570796F, 0F, 0F);
        snout = new ModelRenderer(this, 28, 0);
        snout.addBox(0F, 0F, 0F, 4, 3, 1);
        snout.setRotationPoint(-1F, 19F, -5F);
        snout.setTextureSize(64, 32);
        snout.mirror = true;
        setRotation(snout, 0F, 0F, 0F);
        btm = new ModelRenderer(this, 14, 14);
        btm.addBox(0F, 0F, 0F, 6, 6, 1);
        btm.setRotationPoint(-2F, 24F, -2F);
        btm.setTextureSize(64, 32);
        btm.mirror = true;
        setRotation(btm, 1.570796F, 0F, 0F);
    }


    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        body.render(f5);
        face.render(f5);
        back.render(f5);
        right.render(f5);
        left.render(f5);
        top.render(f5);
        snout.render(f5);
        btm.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    @Override
    public void setRotationAngles(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_)
    {
        super.setRotationAngles(p_78087_1_, p_78087_2_, p_78087_3_, p_78087_4_, p_78087_5_, p_78087_6_, p_78087_7_);
    }

}
