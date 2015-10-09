package othlon.cherrypig.tileentities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by Jen on 23/01/2015.
 */
public class CPIncubatorTileEntity extends TileEntity implements IInventory {

    //max eggs in incubator
    private int maxEggs;
    //list of egg times
    private long eggTimers[];


    public CPIncubatorTileEntity() {

        this.maxEggs = 3;
        for(int i = 1; i == maxEggs; i++){  this.eggTimers[i] = 0; }

    }

    public void readFromNBT(NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);
    }


    public void writeToNBT(NBTTagCompound nbt)
    {
        super.writeToNBT(nbt);
    }

    @Override
    public Packet getDescriptionPacket()
    {

        NBTTagCompound tileTag = new NBTTagCompound();
        this.writeToNBT(tileTag);
        return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 3, tileTag);

    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt)
    {
        this.readFromNBT(pkt.func_148857_g());
    }
 /*~~~~~~~~~~~~~Max Egg # Setters and Getters~~~~~~~~~~~~~~~*/

    public int  getMaxEggs()           { return maxEggs;   }

    public void setMaxEggs(int newNum) { maxEggs = newNum; }


/*~~~~~~~~~~~~~Egg Timer Setters and Getters~~~~~~~~~~~~~~~*/

    public long getEggTimers(int eggNum)
    {
        return eggTimers[eggNum];
    }

    public void setiEggTimers(int eggNumListPos, World world)
    {
        eggTimers[eggNumListPos] = world.getWorldTime();
    }

    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/


    //Logic for the actual block is under here
    @Override
    public void updateEntity(){

        if (!isActive)
        {
            return;
        }

        if (getStackInSlot(0) == null)
        {
            return;
        }
        ItemStack returnedItem = getStackInSlot(0);
        int worldTime = (int) (worldObj.getWorldTime() % 24000);
        if (worldObj.isRemote)
        {
            return;
        }
        if (worldTime % 1 == 0) {

               NBTTagCompound itemTag = returnedItem.stackTagCompound;

            if (itemTag == null) {
                return;
            }
        }
    }

    public void setActive()
    {
        isActive = false;
    }

    public boolean isActive()
    {
        return isActive;
    }

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack itemstack)
    {
        return slot == 0;
    }

    @Override
    public int getSizeInventory()
    {
        return inventory.length;
    }

    @Override
    public ItemStack getStackInSlot(int slot)
    {
        return inventory[slot];
    }
    @Override
    public ItemStack getStackInSlotOnClosing(int slot)
    {
        ItemStack stack = getStackInSlot(slot);

        if (stack != null)
        {
            setInventorySlotContents(slot, null);
        }

        return stack;
    }
    @Override
    public boolean isUseableByPlayer(EntityPlayer entityPlayer)
    {
        return worldObj.getTileEntity(xCoord, yCoord, zCoord) == this && entityPlayer.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64;
    }

    @Override
    public void openInventory()
    {
    }

    @Override
    public void closeInventory()
    {
    }

    @Override
    public String getInventoryName()
    {
        return "Incubator";
    }

    @Override
    public boolean hasCustomInventoryName()
    {
        return false;
    }

    @Override
    public int getInventoryStackLimit()
    {
        return 1;
    }
    @Override
    public ItemStack decrStackSize(int slot, int amt)
    {
        ItemStack stack = getStackInSlot(slot);

        if (stack != null)
        {
            if (stack.stackSize <= amt)
            {
                setInventorySlotContents(slot, null);
            } else
            {
                stack = stack.splitStack(amt);

                if (stack.stackSize == 0)
                {
                    setInventorySlotContents(slot, null);
                }
            }
        }

        return stack;
    }
    @Override
    public void setInventorySlotContents(int slot, ItemStack itemStack)
    {
        inventory[slot] = itemStack;
        this.worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);

        if (itemStack != null && itemStack.stackSize > getInventoryStackLimit())
        {
            itemStack.stackSize = getInventoryStackLimit();
        }
    }

}
