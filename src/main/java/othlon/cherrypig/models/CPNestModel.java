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
        //fields
        ModelRenderer base;
        ModelRenderer Shape1;
        ModelRenderer Shape2;
        ModelRenderer Shape3;
        ModelRenderer Shape4;

        public CPNestModel()
        {
            textureWidth = 64;
            textureHeight = 32;

            base = new ModelRenderer(this, 0, 15);
            base.addBox(0F, 0F, 0.04444445F, 12, 2, 12);
            base.setRotationPoint(-6F, 22F, -6F);
            base.setTextureSize(64, 32);
            base.mirror = true;
            setRotation(base, 0F, 0F, 0F);

            Shape1 = new ModelRenderer(this, 0, 0);
            Shape1.addBox(0F, 0F, 0F, 4, 3, 12);
            Shape1.setRotationPoint(4F, 20F, -6F);
            Shape1.setTextureSize(64, 32);
            Shape1.mirror = true;
            setRotation(Shape1, 0F, 0F, 0F);

            Shape2 = new ModelRenderer(this, 0, 0);
            Shape2.addBox(0F, 0F, 0F, 4, 3, 12);
            Shape2.setRotationPoint(-8F, 20F, -6F);
            Shape2.setTextureSize(64, 32);
            Shape2.mirror = true;
            setRotation(Shape2, 0F, 0F, 0F);

            Shape3 = new ModelRenderer(this, 0, 0);
            Shape3.addBox(0F, 0F, 0F, 4, 3, 12);
            Shape3.setRotationPoint(-6F, 20F, -4F);
            Shape3.setTextureSize(64, 32);
            Shape3.mirror = true;
            setRotation(Shape3, 0F, 1.570796F, 0F);

            Shape4 = new ModelRenderer(this, 0, 0);
            Shape4.addBox(0F, 0F, 0F, 4, 3, 12);
            Shape4.setRotationPoint(-6F, 20F, 8F);
            Shape4.setTextureSize(64, 32);
            Shape4.mirror = true;
            setRotation(Shape4, 0F, 1.570796F, 0F);
        }

        public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
        {
            super.render(entity, f, f1, f2, f3, f4, f5);
            setRotationAngles(f, f1, f2, f3, f4, f5, entity);
            base.render(f5);
            Shape1.render(f5);
            Shape1.render(f5);
            Shape1.render(f5);
            Shape1.render(f5);
        }

        private void setRotation(ModelRenderer model, float x, float y, float z)
        {
            model.rotateAngleX = x;
            model.rotateAngleY = y;
            model.rotateAngleZ = z;
        }

        public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
        {
            super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        }
//WHY WONT YOU RENDER YOU FUCKING ARSEHOLE!?

        public void renderAll(){
                base.render(0.625F);
                Shape1.render(0.625F);
                Shape2.render(0.625F);
                Shape3.render(0.625F);
                Shape4.render(0.625F);
        }





    }
