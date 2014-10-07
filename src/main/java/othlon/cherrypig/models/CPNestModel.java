package othlon.cherrypig.models;

/**
 * Created by Jen on 17/09/2014.
 */

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

public class CPNestModel extends ModelBase
    {
        ModelRenderer Side1;
        ModelRenderer Side2;
        ModelRenderer Side3;
        ModelRenderer Side4;
        ModelRenderer btm;

        public CPNestModel()
        {
            this( 0.0f );
        }

        public CPNestModel( float par1 )
        {
            Side1 = new ModelRenderer( this, 0, 0 );
            Side1.setTextureSize( 64, 32 );
            Side1.addBox( -2F, -1.5F, -6F, 4, 3, 12);
            Side1.setRotationPoint( 0F, 5F, -6F );


            Side2 = new ModelRenderer( this, 0, 0 );
            Side2.setTextureSize( 64, 32 );
            Side2.addBox( -2F, -1.5F, -6F, 4, 3, 12);
            Side2.setRotationPoint( -6F, 5F, 0F );


            Side3 = new ModelRenderer( this, 0, 0 );
            Side3.setTextureSize( 64, 32 );
            Side3.addBox( -2F, -1.5F, -6F, 4, 3, 12);
            Side3.setRotationPoint( 6F, 5F, 0F );


            Side4 = new ModelRenderer( this, 0, 0 );
            Side4.setTextureSize( 64, 32 );
            Side4.addBox( -2F, -1.5F, -6F, 4, 3, 12);
            Side4.setRotationPoint( 0F, 5F, 6F );

            //Before
            /*
            btm = new ModelRenderer( this, 0, 9 );
            btm.setTextureSize( 64, 32 );
            btm.addBox( -3.5F, -0.5F, -3.5F, 7, 1, 7);
            btm.setRotationPoint( -1F, -9F, 0F );*/
            //after

                         // texture offset X, Y
            btm = new ModelRenderer( this, 0, 15 );
            btm.setTextureSize( 64, 32 );
            btm.addBox( -6F, -1F, -6F, 12, 2, 12);
            btm.setRotationPoint( 0F, 7F, 0F );
        }



        public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
        {
            Side2.rotateAngleX = 0F;
            Side2.rotateAngleY = 0F;
            Side2.rotateAngleZ = 0F;
            Side2.renderWithRotation(par7);

            Side3.rotateAngleX = 0F;
            Side3.rotateAngleY = 0F;
            Side3.rotateAngleZ = 0F;
            Side3.renderWithRotation(par7);

            btm.rotateAngleX = 0F;
            btm.rotateAngleY = 0F;
            btm.rotateAngleZ = 0F;
            btm.renderWithRotation(par7);

            Side1.rotateAngleX = 0F;
            Side1.rotateAngleY = -1.570796F;
            Side1.rotateAngleZ = 0F;
            Side1.renderWithRotation(par7);

            Side4.rotateAngleX = 0F;
            Side4.rotateAngleY = -1.570796F;
            Side4.rotateAngleZ = 0F;
            Side4.renderWithRotation(par7);

        }

        public void renderAll(){
            Side2.rotateAngleX = 0F;
            Side2.rotateAngleY = 0F;
            Side2.rotateAngleZ = 0F;
            Side2.render( 0.0625f );

            Side3.rotateAngleX = 0F;
            Side3.rotateAngleY = 0F;
            Side3.rotateAngleZ = 0F;
            Side3.render( 0.0625f );

            btm.rotateAngleX = 0F;
            btm.rotateAngleY = 0F;
            btm.rotateAngleZ = 0F;
            btm.render( 0.0625f );

            Side1.rotateAngleX = 0F;
            Side1.rotateAngleY = -1.570796F;
            Side1.rotateAngleZ = 0F;
            Side1.render( 0.0625f );

            Side4.rotateAngleX = 0F;
            Side4.rotateAngleY = -1.570796F;
            Side4.rotateAngleZ = 0F;
            Side4.render( 0.0625f );
        }

    }
