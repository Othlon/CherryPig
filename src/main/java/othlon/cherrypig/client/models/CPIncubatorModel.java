package othlon.cherrypig.client.models;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Created by Jen on 23/01/2015.
 */
public class CPIncubatorModel<E extends Entity> extends EntityModel<E> {

    ModelRenderer Base;
    ModelRenderer nestBase;
    ModelRenderer nestWallA;
    ModelRenderer nestWallB;
    ModelRenderer nestWallC;
    ModelRenderer nestWallD;

    float nestWallsPointY = -6F;
    public CPIncubatorModel()
    {
        this( 0.0f );
    }

    public CPIncubatorModel(float scale )
    {
        Base = new ModelRenderer( this, 0, 0 );
        Base.setTextureSize( 64, 64 );
        Base.addBox( -8F, -5.5F, -8F, 16, 11, 16);
        Base.setRotationPoint( 0F, 2.5F, 0F );
        //Base.addChild(nestBase);

        nestBase = new ModelRenderer( this, -14, 41 );
        nestBase.setTextureSize( 64, 64 );
        nestBase.addBox( -7F, -1F, -7F, 14, 2, 14);
        nestBase.setRotationPoint( 0F, -3F, 0F );

        nestWallA = new ModelRenderer( this, 0, 57 );
        nestWallA.setTextureSize( 64, 64 );
        nestWallA.addBox( -8F, -2F, -1.5F, 16, 4, 3);
        nestWallA.setRotationPoint( 0F, nestWallsPointY, 6.5F );
        nestWallB = new ModelRenderer( this, 0, 57 );
        nestWallB.setTextureSize( 64, 64 );
        nestWallB.addBox( -8F, -2F, -1.5F, 16, 4, 3);
        nestWallB.setRotationPoint( 0F, nestWallsPointY, -6.5F );
        nestWallC = new ModelRenderer( this, 38, 57 );
        nestWallC.setTextureSize( 64, 64 );
        nestWallC.addBox( -5F, -2F, -1.5F, 10, 4, 3);
        nestWallC.setRotationPoint( -6.5F, nestWallsPointY, 0F );
        nestWallD = new ModelRenderer( this, 38, 57 );
        nestWallD.setTextureSize( 64, 64 );
        nestWallD.addBox( -5F, -2F, -1.5F, 10, 4, 3);
        nestWallD.setRotationPoint( 6.5F, nestWallsPointY, 0F );
    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        Base.rotateAngleX = 0F;
        Base.rotateAngleY = 0F;
        Base.rotateAngleZ = 0F;
        Base.render(matrixStack, buffer, packedLight, packedOverlay);

        nestBase.rotateAngleX = 0F;
        nestBase.rotateAngleY = 0F;
        nestBase.rotateAngleZ = 0F;
        nestBase.render(matrixStack, buffer, packedLight, packedOverlay);

        nestWallA.rotateAngleX = 0F;
        nestWallA.rotateAngleY = 0F;
        nestWallA.rotateAngleZ = 0F;
        nestWallA.render(matrixStack, buffer, packedLight, packedOverlay);

        nestWallB.rotateAngleX = 0F;
        nestWallB.rotateAngleY = 0F;
        nestWallB.rotateAngleZ = 0F;
        nestWallB.render(matrixStack, buffer, packedLight, packedOverlay);

        nestWallC.rotateAngleX = 0F;
        nestWallC.rotateAngleY = -1.570796F;
        nestWallC.rotateAngleZ = 0F;
        nestWallC.render(matrixStack, buffer, packedLight, packedOverlay);

        nestWallD.rotateAngleX = 0F;
        nestWallD.rotateAngleY = -1.570796F;
        nestWallD.rotateAngleZ = 0F;
        nestWallD.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    @Override
    public void setRotationAngles(E entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

//    public void renderAll() {
//        Base.rotateAngleX = 0F;
//        Base.rotateAngleY = 0F;
//        Base.rotateAngleZ = 0F;
//        Base.render(0.0625f);
//
//        nestBase.rotateAngleX = 0F;
//        nestBase.rotateAngleY = 0F;
//        nestBase.rotateAngleZ = 0F;
//        nestBase.render(0.0625f);
//
//        nestWallA.rotateAngleX = 0F;
//        nestWallA.rotateAngleY = 0F;
//        nestWallA.rotateAngleZ = 0F;
//        nestWallA.render(0.0625f);
//
//        nestWallB.rotateAngleX = 0F;
//        nestWallB.rotateAngleY = 0F;
//        nestWallB.rotateAngleZ = 0F;
//        nestWallB.render(0.0625f);
//
//        nestWallC.rotateAngleX = 0F;
//        nestWallC.rotateAngleY = -1.570796F;
//        nestWallC.rotateAngleZ = 0F;
//        nestWallC.render(0.0625f);
//
//        nestWallD.rotateAngleX = 0F;
//        nestWallD.rotateAngleY = -1.570796F;
//        nestWallD.rotateAngleZ = 0F;
//        nestWallD.render(0.0625f);
//    }
}
