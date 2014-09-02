package othlon.cherrypig.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import othlon.cherrypig.entity.CPEntityPiggy;

public class CPPiggyModel extends ModelBase {

    //fields
    ModelRenderer body;
    ModelRenderer face;
    ModelRenderer back;
    ModelRenderer right;
    ModelRenderer left;
    ModelRenderer top;
    ModelRenderer snout;

    public CPPiggyModel()
    {
        textureWidth = 64;
        textureHeight = 32;

        body = new ModelRenderer(this, 0, 0);
        body.addBox(0F, 0F, 0F, 8, 8, 8);
        body.setRotationPoint(-3F, 15F, -3F);
        body.setTextureSize(64, 32);
        body.mirror = true;
        setRotation(body, 0F, 0F, 0F);
        face = new ModelRenderer(this, 50, 0);
        face.addBox(0F, 0F, 0F, 6, 6, 1);
        face.setRotationPoint(-2F, 16F, -4F);
        face.setTextureSize(64, 32);
        face.mirror = true;
        setRotation(face, 0F, 0F, 0F);
        back = new ModelRenderer(this, 0, 0);
        back.addBox(0F, 0F, 0F, 6, 6, 1);
        back.setRotationPoint(-2F, 16F, 5F);
        back.setTextureSize(64, 32);
        back.mirror = true;
        setRotation(back, 0F, 0F, 0F);
        right = new ModelRenderer(this, 14, 20);
        right.addBox(0F, 0F, 0F, 1, 6, 6);
        right.setRotationPoint(-4F, 16F, -2F);
        right.setTextureSize(64, 32);
        right.mirror = true;
        setRotation(right, 0F, 0F, 0F);
        left = new ModelRenderer(this, 0, 20);
        left.addBox(0F, 0F, 0F, 1, 6, 6);
        left.setRotationPoint(5F, 16F, -2F);
        left.setTextureSize(64, 32);
        left.mirror = true;
        setRotation(left, 0F, 0F, 0F);
        top = new ModelRenderer(this, 0, 0);
        top.addBox(0F, 0F, 0F, 6, 1, 6);
        top.setRotationPoint(-2F, 14F, -2F);
        top.setTextureSize(64, 32);
        top.mirror = true;
        setRotation(top, 0F, 0F, 0F);
        snout = new ModelRenderer(this, 50, 7);
        snout.addBox(0F, 0F, 0F, 4, 3, 1);
        snout.setRotationPoint(-1F, 19F, -5F);
        snout.setTextureSize(64, 32);
        snout.mirror = true;
        setRotation(snout, 0F, 0F, 0F);
    }

    @Override
    public void render(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_)
    {
        super.render(p_78088_1_, p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, p_78088_7_);
        this.setRotationAngles(p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, p_78088_7_, p_78088_1_);

        body.render(p_78088_7_);
        face.render(p_78088_7_);
        back.render(p_78088_7_);
        right.render(p_78088_7_);
        left.render(p_78088_7_);
        top.render(p_78088_7_);
        snout.render(p_78088_7_);
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
