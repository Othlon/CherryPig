package othlon.cherrypig.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class CPBabbyModel extends ModelBase {
    //fields
    ModelRenderer Shape1;
    ModelRenderer Shape2;

    public CPBabbyModel()
    {
        textureWidth  = 64;
        textureHeight = 32;

        Shape1 = new ModelRenderer(this, 44, 0);
        Shape1.addBox(0F, 0F, 0F, 5, 4, 5);
        Shape1.setRotationPoint(-3F, 20F, -3F);
        Shape1.setTextureSize(64, 32);
        Shape1.mirror = true;
        setRotation(Shape1, 0F, 0F, 0F);
        Shape2 = new ModelRenderer(this, 56, 9);
        Shape2.addBox(0F, 0F, 0F, 2, 2, 1);
        Shape2.setRotationPoint(-1.5F, 22F, -4F);
        Shape2.setTextureSize(64, 32);
        Shape2.mirror = true;
        setRotation(Shape2, 0F, 0F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        Shape1.render(f5);
        Shape2.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
    {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity );
    }

}
