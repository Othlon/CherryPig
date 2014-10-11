package othlon.cherrypig.tileentities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

import java.util.List;

public class CPFirtileEggTileEntity extends TileEntity {

    @Override
    public void updateEntity(){

        /*super.updateEntity();

        @SuppressWarnings("unchecked")
        List<Entity> interestingItems = worldObj.selectEntitiesWithinAABB(Entity.class, getBB().expand(3, 3, 3), this);

        for (Entity entity : interestingItems) {
            double x = (xCoord + 0.5D - entity.posX);
            double y = (yCoord + 0.5D - entity.posY);
            double z = (zCoord + 0.5D - entity.posZ);

            double distance = Math.sqrt(x * x + y * y + z * z);
            if (distance < 1.1) {
                onEntityCollidedWithBlock(entity);
            } else {
                double var11 = 1.0 - distance / 15.0;

                if (var11 > 0.0D) {
                    var11 *= var11;
                    entity.motionX += x / distance * var11 * 0.05;
                    entity.motionY += y / distance * var11 * 0.2;
                    entity.motionZ += z / distance * var11 * 0.05;
                }
            }

        }

        //if (!worldObj.isRemote) outputToNeighbors();*/
    }

   /* public void onEntityCollidedWithBlock(Entity entity) {
        if (!worldObj.isRemote) {
            if (entity instanceof EntityItem && !entity.isDead) {
                EntityItem item = (EntityItem)entity;
                ItemStack stack = item.getEntityItem().copy();
                InventoryUtils.insertItemIntoInventory(inventory, stack);
                if (stack.stackSize == 0) {
                    item.setDead();
                } else {
                    item.setEntityItemStack(stack);
                }
            }
        }
    }*/

}
