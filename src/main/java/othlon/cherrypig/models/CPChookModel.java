package othlon.cherrypig.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
/**
 * Created by Jen on 15/11/2014.
 */
public class CPChookModel extends ModelBase
{
    //baby chick
    ModelRenderer ChickBody;
    ModelRenderer ChickHead;
    ModelRenderer ChickBeakTop;
    ModelRenderer ChickBeakBtm;
    ModelRenderer ChickLeftWing;
    ModelRenderer ChickRightWing;
    ModelRenderer ChickRightFoot;
    ModelRenderer ChickLeftFoot;

    //adult chook
    ModelRenderer ChookBody;
    ModelRenderer ChookRWing;
    ModelRenderer ChookLWing;
    ModelRenderer ChookTail;
    ModelRenderer ChookHead;
    ModelRenderer ChookBeak;
    ModelRenderer ChookComb;
    ModelRenderer ChookHeadComb;
    ModelRenderer ChookLLeg;
    ModelRenderer ChookLFoot;
    ModelRenderer ChoolRLeg;
    ModelRenderer ChookRFoot;


    public CPChookModel(){
        textureWidth  = 64;
        textureHeight = 32;

        //Baby chick
        ChickBody = new ModelRenderer( this, 48, 12 );
        ChickBody.setTextureSize( 64, 32 );
        ChickBody.addBox( -2F, -2.5F, -2F, 4, 3, 4);
        ChickBody.setRotationPoint( 0F, 22.5F, 0F );

        ChickHead = new ModelRenderer( this, 40, 0 );
        ChickHead.setTextureSize( 64, 32 );
        ChickHead.addBox( -3F, -3F, -3F, 6, 6, 6);
        ChickHead.setRotationPoint( 0F, 19.5F, -2F );

        ChickBeakTop = new ModelRenderer( this, 60, 0 );
        ChickBeakTop.setTextureSize( 64, 32 );
        ChickBeakTop.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 1);
        ChickBeakTop.setRotationPoint( 0F, 20.5F, -3.75F );

        ChickBeakBtm = new ModelRenderer( this, 60, 0 );
        ChickBeakBtm.setTextureSize( 64, 32 );
        ChickBeakBtm.addBox( -0.5F, -0.5F, -0.7F, 1, 1, 1);
        ChickBeakBtm.setRotationPoint( 0F, 20.8F, -3.5F );

        ChickLeftWing = new ModelRenderer( this, 54, 19 );
        ChickLeftWing.setTextureSize( 64, 32 );
        ChickLeftWing.addBox( 0F, -0.5F, -1.5F, 2, 1, 3);
        ChickLeftWing.setRotationPoint( 1.8F, 20.5F, 0F );

        ChickRightWing = new ModelRenderer( this, 54, 19 );
        ChickRightWing.setTextureSize( 64, 32 );
        ChickRightWing.addBox( -2F, -0.5F, -1.5F, 2, 1, 3);
        ChickRightWing.setRotationPoint( -1.8F, 20.5F, 0F );

        ChickRightFoot = new ModelRenderer( this, 63, 0 );
        ChickRightFoot.setTextureSize( 64, 32 );
        ChickRightFoot.addBox( -0.5F, 0F, 0F, 1, 1, 0);
        ChickRightFoot.setRotationPoint( -1F, 23F, 0F );

        ChickLeftFoot = new ModelRenderer( this, 60, 0 );
        ChickLeftFoot.setTextureSize( 64, 32 );
        ChickLeftFoot.addBox( -0.5F, 0F, 0F, 1, 1, 0);
        ChickLeftFoot.setRotationPoint( 1F, 23F, 0F );


        //Adult Chook
        ChookBody = new ModelRenderer( this, 0, 18 );
        ChookBody.setTextureSize( 64, 32 );
        ChookBody.addBox( -3F, -3F, -4F, 6, 6, 8);
        ChookBody.setRotationPoint( 0F, 16F, 0F );

        ChookRWing = new ModelRenderer( this, 7, 22 );
        ChookRWing.setTextureSize( 64, 32 );
        ChookRWing.addBox( -0.5F, 0F, -3F, 1, 4, 6);
        ChookRWing.setRotationPoint( -3.5F, 13F, 0F );

        ChookLWing = new ModelRenderer( this, 7, 22 );
        ChookLWing.setTextureSize( 64, 32 );
        ChookLWing.addBox( -0.5F, 0F, -3F, 1, 4, 6);
        ChookLWing.setRotationPoint( 3.5F, 13F, 0F );

        ChookTail = new ModelRenderer( this, 8, 26 );
        ChookTail.setTextureSize( 64, 32 );
        ChookTail.addBox( -2F, -2F, -1F, 4, 4, 2);
        ChookTail.setRotationPoint( 0F, 14F, 4F );

        ChookHead = new ModelRenderer( this, 7, 9 );
        ChookHead.setTextureSize( 64, 32 );
        ChookHead.addBox( -2F, -5F, -2.5F, 4, 6, 3);
        ChookHead.setRotationPoint( 0F, 14F, -3F );

        ChookBeak = new ModelRenderer( this, 0, 22 );
        ChookBeak.setTextureSize( 64, 32 );
        ChookBeak.addBox( -1F, -1F, -1F, 2, 2, 2);
        ChookBeak.setRotationPoint( 0F, 12F, -6F );

        ChookComb = new ModelRenderer( this, 2, 16 );
        ChookComb.setTextureSize( 64, 32 );
        ChookComb.addBox( -0.5F, -1F, -0.5F, 1, 2, 1);
        ChookComb.setRotationPoint( 0F, 14F, -6F );

        ChookHeadComb = new ModelRenderer( this, 2, 13 );
        ChookHeadComb.setTextureSize( 64, 32 );
        ChookHeadComb.addBox( 0F, -2F, -1F, 0, 4, 2);
        ChookHeadComb.setRotationPoint( 0F, 10F, -5F );

        ChookLLeg = new ModelRenderer( this, 7, 19 );
        ChookLLeg.setTextureSize( 64, 32 );
        ChookLLeg.addBox( -0.5F, 0F, 0F, 1, 5, 0);
        ChookLLeg.setRotationPoint( -1.5F, 19F, 0F );

        ChookLFoot = new ModelRenderer( this, -2, 19 );
        ChookLFoot.setTextureSize( 64, 32 );
        ChookLFoot.addBox( -1.5F, 0F, -3F, 3, 0, 3);
        ChookLFoot.setRotationPoint( -1.5F, 24F, 0F );

        ChoolRLeg = new ModelRenderer( this, 7, 19 );
        ChoolRLeg.setTextureSize( 64, 32 );
        ChoolRLeg.addBox( -0.5F, 0F, 0F, 1, 5, 0);
        ChoolRLeg.setRotationPoint( 1.5F, 19F, 0F );

        ChookRFoot = new ModelRenderer( this, -2, 19 );
        ChookRFoot.setTextureSize( 64, 32 );
        ChookRFoot.addBox( -1.5F, 0F, -3F, 3, 0, 3);
        ChookRFoot.setRotationPoint( 1.5F, 24F, 0F );

    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);

        if(this.isChild){
            ChickBody.rotateAngleX = 0F;
            ChickBody.rotateAngleY = 0F;
            ChickBody.rotateAngleZ = 0F;
            ChickBody.renderWithRotation(f5);

            ChickHead.rotateAngleX = 0F;
            ChickHead.rotateAngleY = 0F;
            ChickHead.rotateAngleZ = 0F;
            ChickHead.renderWithRotation(f5);

            ChickBeakTop.rotateAngleX = 0F;
            ChickBeakTop.rotateAngleY = 0F;
            ChickBeakTop.rotateAngleZ = 0F;
            ChickBeakTop.renderWithRotation(f5);

            ChickBeakBtm.rotateAngleX = 0F;
            ChickBeakBtm.rotateAngleY = 0F;
            ChickBeakBtm.rotateAngleZ = 0F;
            ChickBeakBtm.renderWithRotation(f5);

            ChickLeftWing.rotateAngleX = 0F;
            ChickLeftWing.rotateAngleY = 0F;
            ChickLeftWing.rotateAngleZ = 0.5235988F;
            ChickLeftWing.renderWithRotation(f5);

            ChickRightWing.rotateAngleX = 0F;
            ChickRightWing.rotateAngleY = 0F;
            ChickRightWing.rotateAngleZ = -0.5235988F;
            ChickRightWing.renderWithRotation(f5);

            ChickRightFoot.rotateAngleX = 0F;
            ChickRightFoot.rotateAngleY = 0F;
            ChickRightFoot.rotateAngleZ = 0F;
            ChickRightFoot.renderWithRotation(f5);

            ChickLeftFoot.rotateAngleX = 0F;
            ChickLeftFoot.rotateAngleY = 0F;
            ChickLeftFoot.rotateAngleZ = 0F;
            ChickLeftFoot.renderWithRotation(f5);
        }
       else {
            ChookBody.rotateAngleX = 0F;
            ChookBody.rotateAngleY = 0F;
            ChookBody.rotateAngleZ = 0F;
            ChookBody.renderWithRotation(f5);

            ChookRWing.rotateAngleX = 0F;
            ChookRWing.rotateAngleY = 0F;
            ChookRWing.rotateAngleZ = 0F;
            ChookRWing.renderWithRotation(f5);

            ChookLWing.rotateAngleX = 0F;
            ChookLWing.rotateAngleY = 0F;
            ChookLWing.rotateAngleZ = 0F;
            ChookLWing.renderWithRotation(f5);

            ChookTail.rotateAngleX = 0F;
            ChookTail.rotateAngleY = 0F;
            ChookTail.rotateAngleZ = 0F;
            ChookTail.renderWithRotation(f5);

            ChookHead.rotateAngleX = 0F;
            ChookHead.rotateAngleY = 0F;
            ChookHead.rotateAngleZ = 0F;
            ChookHead.renderWithRotation(f5);

            ChookBeak.rotateAngleX = 0F;
            ChookBeak.rotateAngleY = 0F;
            ChookBeak.rotateAngleZ = 0F;
            ChookBeak.renderWithRotation(f5);

            ChookComb.rotateAngleX = 0F;
            ChookComb.rotateAngleY = 0F;
            ChookComb.rotateAngleZ = 0F;
            ChookComb.renderWithRotation(f5);

            ChookHeadComb.rotateAngleX = 0F;
            ChookHeadComb.rotateAngleY = 0F;
            ChookHeadComb.rotateAngleZ = 0F;
            ChookHeadComb.renderWithRotation(f5);

            ChookLLeg.rotateAngleX = 0F;
            ChookLLeg.rotateAngleY = 0F;
            ChookLLeg.rotateAngleZ = 0F;
            ChookLLeg.renderWithRotation(f5);

            ChookLFoot.rotateAngleX = 0F;
            ChookLFoot.rotateAngleY = 0F;
            ChookLFoot.rotateAngleZ = 0F;
            ChookLFoot.renderWithRotation(f5);

            ChoolRLeg.rotateAngleX = 0F;
            ChoolRLeg.rotateAngleY = 0F;
            ChoolRLeg.rotateAngleZ = 0F;
            ChoolRLeg.renderWithRotation(f5);

            ChookRFoot.rotateAngleX = 0F;
            ChookRFoot.rotateAngleY = 0F;
            ChookRFoot.rotateAngleZ = 0F;
            ChookRFoot.renderWithRotation(f5);
        }
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
