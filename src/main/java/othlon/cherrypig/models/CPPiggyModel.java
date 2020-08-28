package othlon.cherrypig.models;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import othlon.cherrypig.entity.PiggyEntity;

public class CPPiggyModel<E extends PiggyEntity> extends EntityModel<E> {
    //adult
    ModelRenderer Body;
    ModelRenderer BackRightTrotter;
    ModelRenderer FrontRightTrotter;
    ModelRenderer BackLeftTrotter;
    ModelRenderer FrontLeftTrotter;
    ModelRenderer Tail;
    ModelRenderer SubFaceFront;
    ModelRenderer Snout;
    ModelRenderer LeftEar;
    ModelRenderer RightEar;

    //child
    ModelRenderer babybody;
    ModelRenderer babyface;
    ModelRenderer FRTrotter;
    ModelRenderer FLTrotter;
    ModelRenderer BLTrotter;
    ModelRenderer BRTrotter;
    ModelRenderer babyTail;

    public CPPiggyModel() {
        this(0.0F);
    }

    public CPPiggyModel(float scale) {
        super(RenderType::getEntityCutoutNoCull);
        textureWidth  = 64;
        textureHeight = 32;
/*~~~~~~~~~~~~~~~~~~~~~~~~Baby Model~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
        babybody = new ModelRenderer( this, 46, 3 );
        babybody.setTextureSize( 64, 32 );
        babybody.addBox( -2F, -2F, -2.5F, 4, 4, 5);
        babybody.setRotationPoint( 0F, 21F, 0F );

        babyface = new ModelRenderer( this, 56, 0 );
        babyface.setTextureSize( 64, 32 );
        babyface.addBox( -1.5F, -1F, -0.5F, 3, 2, 1);
        babyface.setRotationPoint( 0F, 22F, -3F );

        FRTrotter = new ModelRenderer( this, 52, 0 );
        FRTrotter.setTextureSize( 64, 32 );
        FRTrotter.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 1);
        FRTrotter.setRotationPoint( 1F, 23F, -1F );

        FLTrotter = new ModelRenderer( this, 52, 0 );
        FLTrotter.setTextureSize( 64, 32 );
        FLTrotter.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 1);
        FLTrotter.setRotationPoint( -1F, 23F, -1F );

        BLTrotter = new ModelRenderer( this, 52, 0 );
        BLTrotter.setTextureSize( 64, 32 );
        BLTrotter.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 1);
        BLTrotter.setRotationPoint( -1F, 23F, 2F );

        BRTrotter = new ModelRenderer( this, 52, 0 );
        BRTrotter.setTextureSize( 64, 32 );
        BRTrotter.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 1);
        BRTrotter.setRotationPoint( 1F, 23F, 2F );

        babyTail = new ModelRenderer( this, 56, 15 );
        babyTail.setTextureSize( 64, 32 );
        babyTail.addBox( 0.5F, -2.5F, 0F, 3, 3, 0);
        babyTail.setRotationPoint( 0F, 21F, 2F );
/*~~~~~~~~~~~~~~~~~~~~~~Adult Model~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
        Body = new ModelRenderer( this, 0, 16 );
        Body.setTextureSize( 64, 32 );
        Body.addBox( -6F, -4F, -4F, 8, 8, 8);
        Body.setRotationPoint( 0F, 19F, -3.992621E-06F );

        BackRightTrotter = new ModelRenderer( this, 4, 14 );
        BackRightTrotter.setTextureSize( 64, 32 );
        BackRightTrotter.addBox( -0.5F, -2F, -0.5F, 1, 4, 1);
        BackRightTrotter.setRotationPoint( -5F, 22F, 3F );

        FrontRightTrotter = new ModelRenderer( this, 0, 14 );
        FrontRightTrotter.setTextureSize( 64, 32 );
        FrontRightTrotter.addBox( -0.5F, -2F, -0.5F, 1, 4, 1);
        FrontRightTrotter.setRotationPoint( -5F, 22F, -3F );

        BackLeftTrotter = new ModelRenderer( this, 0, 19 );
        BackLeftTrotter.setTextureSize( 64, 32 );
        BackLeftTrotter.addBox( -0.5F, -2F, -0.5F, 1, 4, 1);
        BackLeftTrotter.setRotationPoint( 1F, 22F, 3F );

        FrontLeftTrotter = new ModelRenderer( this, 4, 19 );
        FrontLeftTrotter.setTextureSize( 64, 32 );
        FrontLeftTrotter.addBox( -0.5F, -2F, -0.5F, 1, 4, 1);
        FrontLeftTrotter.setRotationPoint( 1F, 22F, -3.000004F );

        Tail = new ModelRenderer( this, 24, 16 );
        Tail.setTextureSize( 64, 32 );
        Tail.addBox( 0F, -4F, 0F, 0, 4, 4);
        Tail.setRotationPoint( -2F, 21F, 3.999996F );

        SubFaceFront = new ModelRenderer( this, 0, 0 );
        SubFaceFront.setTextureSize( 64, 32 );
        SubFaceFront.addBox( -3.5F, -6F, -4.5F, 7, 6, 7);
        SubFaceFront.setRotationPoint( -2F, 22F, -2.000004F );

        Snout = new ModelRenderer( this, 24, 14 );
        Snout.setTextureSize( 64, 32 );
        Snout.addBox( -2F, -1.5F, -1.5F, 4, 3, 3);
        Snout.setRotationPoint( -2F, 21.04509F, -6.000004F );

        LeftEar = new ModelRenderer( this, 32, 24 );
        LeftEar.setTextureSize( 64, 32 );
        LeftEar.addBox( -0.5F, -0.5F, -1.5F, 1, 5, 3);
        LeftEar.setRotationPoint( 1.522447F, 16.49154F, -4.93504F );

        RightEar = new ModelRenderer( this, 32, 24 );
        RightEar.setTextureSize( 64, 32 );
        RightEar.addBox( -0.5F, -0.5F, -1.5F, 1, 5, 3);
        RightEar.setRotationPoint( -5.553936F, 16.49154F, -4.93504F );
    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        if(this.isChild){
            babybody.render(matrixStack, buffer, packedLight, packedOverlay);
            babyface.render(matrixStack, buffer, packedLight, packedOverlay);
            FRTrotter.render(matrixStack, buffer, packedLight, packedOverlay);
            FLTrotter.render(matrixStack, buffer, packedLight, packedOverlay);
            BLTrotter.render(matrixStack, buffer, packedLight, packedOverlay);
            BRTrotter.render(matrixStack, buffer, packedLight, packedOverlay);
            babyTail.rotateAngleY = -1.570796F;
            babyTail.render(matrixStack, buffer, packedLight, packedOverlay);
        }
        else {
            SubFaceFront.render(matrixStack, buffer, packedLight, packedOverlay);
            Body.render(matrixStack, buffer, packedLight, packedOverlay);
            Snout.render(matrixStack, buffer, packedLight, packedOverlay);
            LeftEar.render(matrixStack, buffer, packedLight, packedOverlay);
            RightEar.render(matrixStack, buffer, packedLight, packedOverlay);
            Tail.render(matrixStack, buffer, packedLight, packedOverlay);

            //trotters
            FrontLeftTrotter.render(matrixStack, buffer, packedLight, packedOverlay);
            FrontRightTrotter.render(matrixStack, buffer, packedLight, packedOverlay);
            BackLeftTrotter.render(matrixStack, buffer, packedLight, packedOverlay);
            BackRightTrotter.render(matrixStack, buffer, packedLight, packedOverlay);

        }
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    @Override
    public void setRotationAngles(E entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        /******* BABY ANIMATION ******/
        FRTrotter.rotateAngleX  = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        FLTrotter.rotateAngleX  = MathHelper.cos(limbSwing * 0.6662F + 3.14159F) * 1.4F * limbSwingAmount;
        BRTrotter.rotateAngleX  = MathHelper.cos(limbSwing * 0.6662F + 3.14159F) * 1.4F * limbSwingAmount;
        BLTrotter.rotateAngleX  = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        babyTail.rotationPointX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;


        /****** ADULT ANIMATION ******/
        FrontRightTrotter.rotateAngleX  = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        FrontLeftTrotter.rotateAngleX   = MathHelper.cos(limbSwing * 0.6662F + 3.14159F) * 1.4F * limbSwingAmount;
        BackRightTrotter.rotateAngleX   = MathHelper.cos(limbSwing * 0.6662F + 3.14159F) * 1.4F * limbSwingAmount;
        BackLeftTrotter.rotateAngleX    = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        Tail.rotationPointX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    }
}
