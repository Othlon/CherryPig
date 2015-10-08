package othlon.cherrypig.tileentities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by Jen on 23/01/2015.
 */
public class CPIncubatorTileEntity extends TileEntity implements IInventory {

    public static final int invSize = 3;
    private ItemStack[] inventory;
    private boolean isActive;//start a counter when active?

    //list of egg times


    public CPIncubatorTileEntity() {

       // this.inventory = new ItemStack[1];
        //isActive       = false;

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
public Packet getDescriptionPacket(){

    NBTTagCompound tileTag = new NBTTagCompound();
    this.writeToNBT(tileTag);
 //   return new Packettile

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
