package othlon.cherrypig.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Created by Jen on 9/10/2014.
 */
public class CPFirtileEggModel extends ModelBase
    {
        ModelRenderer EggA;
        ModelRenderer EggB;
        ModelRenderer EggC;

        //height of the model
        float eggBase = 7F;
        float eggBody = eggBase - 1F;
        float eggTop  = eggBody - 1.5F;


        public CPFirtileEggModel()
        {
            this( 0.0f );
        }

        public CPFirtileEggModel( float par1 )
        {
            EggA = new ModelRenderer( this, 0, 0 );
            EggA.setTextureSize( 64, 32 );
            EggA.addBox(  -1.5F, -2F, -1.5F, 3, 2, 3);
            EggA.setRotationPoint( 0F, eggBase, 0F );

            EggB = new ModelRenderer( this, 0, 7 );
            EggB.setTextureSize( 64, 32 );
            EggB.addBox( -1F, -1.5F, -1F, 2, 3, 2);
            EggB.setRotationPoint( 0F, eggBody, 0F );

            EggC = new ModelRenderer( this, 0, 15 );
            EggC.setTextureSize( 64, 32 );
            EggC.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 1);
            EggC.setRotationPoint( 0F, eggTop, 0F );
        }

        public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
        {
            EggA.rotateAngleX = 0F;
            EggA.rotateAngleY = 0F;
            EggA.rotateAngleZ = 0F;
            EggA.renderWithRotation(par7);

            EggB.rotateAngleX = 0F;
            EggB.rotateAngleY = 0F;
            EggB.rotateAngleZ = 0F;
            EggB.renderWithRotation(par7);

            EggC.rotateAngleX = 0F;
            EggC.rotateAngleY = 0F;
            EggC.rotateAngleZ = 0F;
            EggC.renderWithRotation(par7);

        }

        public void renderAll() {
            EggA.rotateAngleX = 0F;
            EggA.rotateAngleY = 0F;
            EggA.rotateAngleZ = 0F;
            EggA.renderWithRotation(0.0625f);

            EggB.rotateAngleX = 0F;
            EggB.rotateAngleY = 0F;
            EggB.rotateAngleZ = 0F;
            EggB.renderWithRotation(0.0625f);

            EggC.rotateAngleX = 0F;
            EggC.rotateAngleY = 0F;
            EggC.rotateAngleZ = 0F;
            EggC.renderWithRotation(0.0625f);

        }
}
