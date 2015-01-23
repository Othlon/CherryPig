package othlon.cherrypig.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import othlon.cherrypig.CherryPig;
import othlon.cherrypig.tileentities.CPIncubatorTileEntity;

import java.util.Random;


/**
 * Created by Jen on 23/01/2015.
 */
public class CPIncubator extends BlockContainer {

    public CPIncubator(){
        super(Material.rock);
        this.setHarvestLevel("pickaxe", 0);
        this.setBlockName("Incubator");
        this.setCreativeTab(CherryPig.tabCherryPig);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int idk, float what, float these, float are)
    {

        CPIncubatorTileEntity tEntity = (CPIncubatorTileEntity) world.getTileEntity(x, y, z);
        if (tEntity == null || player.isSneaking())
        {
            return false;
        }

        ItemStack heldItem = player.getCurrentEquippedItem();

        if(heldItem != null){
            if(heldItem.getItem().equals(Items.egg)){

            }
            return true;
        }
        if (tEntity.getStackInSlot(0) == null && heldItem != null)
        {
            ItemStack newItem = heldItem.copy();
            newItem.stackSize = 1;
            --heldItem.stackSize;
            tEntity.setInventorySlotContents(0, newItem);

        } else if (tEntity.getStackInSlot(0) != null && heldItem == null)
        {
            player.inventory.addItemStackToInventory(tEntity.getStackInSlot(0));
            tEntity.setInventorySlotContents(0, null);
          //  tEntity.setActive();
        }
        world.markBlockForUpdate(x, y, z);
        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i){return new CPIncubatorTileEntity();}


    @Override
    public void breakBlock(World world, int x, int y, int z, Block par5, int par6)
    {
        dropItems(world, x, y, z);
        super.breakBlock(world, x, y, z, par5, par6);
    }

    private void dropItems(World world, int x, int y, int z)
    {
        Random rand = new Random();
        TileEntity tileEntity = world.getTileEntity(x, y, z);

        if (!(tileEntity instanceof IInventory))
        {
            return;
        }

        IInventory inventory = (IInventory) tileEntity;

        for (int i = 0; i < inventory.getSizeInventory(); i++)
        {
            ItemStack item = inventory.getStackInSlot(i);

            if (item != null && item.stackSize > 0)
            {
                float rx = rand.nextFloat() * 0.8F + 0.1F;
                float ry = rand.nextFloat() * 0.8F + 0.1F;
                float rz = rand.nextFloat() * 0.8F + 0.1F;
                EntityItem entityItem = new EntityItem(world,
                        x + rx, y + ry, z + rz,
                        new ItemStack(item.getItem(), item.stackSize, item.getItemDamage()));

                if (item.hasTagCompound())
                {
                    entityItem.getEntityItem().setTagCompound((NBTTagCompound) item.getTagCompound().copy());
                }

                float factor = 0.05F;
                entityItem.motionX = rand.nextGaussian() * factor;
                entityItem.motionY = rand.nextGaussian() * factor + 0.2F;
                entityItem.motionZ = rand.nextGaussian() * factor;
                world.spawnEntityInWorld(entityItem);
                item.stackSize = 0;
            }
        }
    }

    @Override
    public int getRenderType(){return -1;}

    @Override
    public boolean isOpaqueCube(){ return false;}

    @Override
    public boolean renderAsNormalBlock(){ return false;}

    @Override
    public boolean hasTileEntity() {return true;}
}
