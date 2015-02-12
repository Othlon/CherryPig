package othlon.cherrypig.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import othlon.cherrypig.entity.CPEntityPiggy;

public class CPPiggyModel extends ModelBase {

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

    public CPPiggyModel()
    {
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


    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
       if(this.isChild){

           babybody.renderWithRotation(f5);

           babyface.renderWithRotation(f5);

           FRTrotter.renderWithRotation(f5);

           FLTrotter.renderWithRotation(f5);

           BLTrotter.renderWithRotation(f5);

           BRTrotter.renderWithRotation(f5);

           babyTail.rotateAngleY = -1.570796F;
           babyTail.renderWithRotation(f5);
       }
        else {

           SubFaceFront.render(f5);
           Body.render(f5);
           Snout.render(f5);
           LeftEar.render(f5);
           RightEar.render(f5);
           Tail.render(f5);

           //trotters
           FrontLeftTrotter.render(f5);
           FrontRightTrotter.render(f5);
           BackLeftTrotter.render(f5);
           BackRightTrotter.render(f5);

       }
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    @Override
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
    {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        /******* BABY ANIMATION ******/
            FRTrotter.rotateAngleX  = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
            FLTrotter.rotateAngleX  = MathHelper.cos(f * 0.6662F + 3.14159F) * 1.4F * f1;
            BRTrotter.rotateAngleX  = MathHelper.cos(f * 0.6662F + 3.14159F) * 1.4F * f1;
            BLTrotter.rotateAngleX  = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
            babyTail.rotationPointX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;


        /****** ADULT ANIMATION ******/
            FrontRightTrotter.rotateAngleX  = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
            FrontLeftTrotter.rotateAngleX   = MathHelper.cos(f * 0.6662F + 3.14159F) * 1.4F * f1;
            BackRightTrotter.rotateAngleX   = MathHelper.cos(f * 0.6662F + 3.14159F) * 1.4F * f1;
            BackLeftTrotter.rotateAngleX    = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
            Tail.rotationPointX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
    }

}
