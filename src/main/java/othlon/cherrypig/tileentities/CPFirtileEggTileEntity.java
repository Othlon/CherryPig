package othlon.cherrypig.tileentities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import othlon.cherrypig.entity.CPEntityChook;


import java.util.List;

public class CPFirtileEggTileEntity extends TileEntity {

    @Override
    public void updateEntity() {

    }
   /* public boolean isUseableByPlayer(EntityPlayer p_70300_1_)
    {
        //return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : p_70300_1_.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
    }

    public boolean onBlockActivated(World world, double x, double y, double z){
        this.spawnCreature(world, x, y, z);
        return true;
    }
    private Entity spawnCreature(World world, double x, double y, double z)
    {
        int iAge = -24000;
        CPEntityChook chook = new CPEntityChook(world);
        chook.setPosition(x, y, z);
        chook.setGrowingAge(iAge);
        world.spawnEntityInWorld(chook);
        return chook;
    }*/
}
