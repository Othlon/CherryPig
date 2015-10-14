package othlon.cherrypig.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
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
import othlon.cherrypig.items.CPItem;
import othlon.cherrypig.tileentities.CPIncubatorTileEntity;

import java.util.Random;


public class CPIncubator extends BlockContainer {


    public CPIncubator(){
        super(Material.rock);
        this.setHarvestLevel("pickaxe", 0);
        this.setBlockTextureName("cherrypig:iqon_incubator");

        this.setBlockName("incubator");
        this.setCreativeTab(CherryPig.tabCherryPig);
    }


    @Override
    public TileEntity createNewTileEntity(World world, int i){return new CPIncubatorTileEntity();}




    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int idk, float what, float these, float are)
    {

        CPIncubatorTileEntity tEntity = (CPIncubatorTileEntity) world.getTileEntity(x, y, z);
        //for shift-clicking
        if (tEntity == null || player.isSneaking())
        {
            return false;
        }

        ItemStack heldItem  = player.getCurrentEquippedItem();

        if(heldItem != null){

            //fertile eggs
            if(heldItem.getItem().equals(CPItem.fertileegg)){
                if( tEntity.addAnEgg(world) == true ){
                --heldItem.stackSize;}
            }
            /*~~~~~~~~~~start up incubator~~~~~~~~~~~*/
            if(heldItem.getItem().equals(Items.flint_and_steel)){

                tEntity.floopOn();
                heldItem.damageItem(2, player);

            }

            //furel?
            return true;
        }

        world.markBlockForUpdate(x, y, z);
        return true;
    }

    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int x, int y, int z, Random randy) {

        CPIncubatorTileEntity tEntity = (CPIncubatorTileEntity) world.getTileEntity(x, y, z);

        int l = world.getBlockMetadata(x, y, z);
        float f = (float)x + 0.5F;
        float f1 = (float)y + 0.0F + randy.nextFloat() * 6.0F / 16.0F;
        float f2 = (float)z + 0.5F;
        float f3 = 0.52F;
        float f4 = randy.nextFloat() * 0.6F - 0.3F;

        if(tEntity.getGoingStatus() == true)
        {
            world.spawnParticle("flame", (double)(f - f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
        }
    }


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
