package othlon.cherrypig.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.Facing;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import othlon.cherrypig.CherryPig;
import othlon.cherrypig.entity.CPEntityChook;
import othlon.cherrypig.entity.CPEntityPiggy;

import java.util.List;

/**
 * Created by Jen on 19/11/2014.
 */
public class CPFertileEggItem extends Item {

    public CPFertileEggItem()
    {
        this.setHasSubtypes(true);
        this.setUnlocalizedName("fertile egg");
        this.setCreativeTab(CherryPig.tabCherryPig);
        this.setTextureName("cherrypig:fertileegg");

    }

    @Override
    public String getItemStackDisplayName(ItemStack stack){
        return "Firtile Egg";
    }

    public boolean onItemUse(ItemStack item, EntityPlayer player, World world, int x, int y, int z, int side, float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
        if(world.isRemote)
        {
            return true;
        }
        else
        {
            Block block = world.getBlock(x, y, z);
            x += Facing.offsetsXForSide[side];
            y += Facing.offsetsYForSide[side];
            z += Facing.offsetsZForSide[side];
            double d0 = 0.0D;

            if(side == 1 && block.getRenderType() == 11)
            {
                d0 = 0.5D;
            }

            Entity entity = spawnCreature(world, x + 0.5D, y + d0, z + 0.5D);

            if(entity != null)
            {
                if(entity instanceof EntityLivingBase && item.hasDisplayName())
                {
                    ((EntityLiving) entity).setCustomNameTag(item.getDisplayName());
                }

                if(!player.capabilities.isCreativeMode)
                {
                    --item.stackSize;
                }
            }

            return true;
        }
    }

    @Override
    public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player)
    {
        if(world.isRemote)
        {
            return item;
        }
        else
        {
            MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(world, player, true);

            if(movingobjectposition == null)
            {
                return item;
            }
            else
            {
                if(movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK)
                {
                    int i = movingobjectposition.blockX;
                    int j = movingobjectposition.blockY;
                    int k = movingobjectposition.blockZ;

                    if(!world.canMineBlock(player, i, j, k)) { return item; }

                    if(!player.canPlayerEdit(i, j, k, movingobjectposition.sideHit, item)) { return item; }

                    if(world.getBlock(i, j, k) instanceof BlockLiquid)
                    {
                        Entity entity = spawnCreature(world, i, j, k);

                        if(entity != null)
                        {
                            if(entity instanceof EntityLivingBase && item.hasDisplayName())
                            {
                                ((EntityLiving) entity).setCustomNameTag(item.getDisplayName());
                            }

                            if(!player.capabilities.isCreativeMode)
                            {
                                --item.stackSize;
                            }
                        }
                    }
                }

                return item;
            }
        }
    }

    private Entity spawnCreature(World world, double x, double y, double z)
    {
        int iAge = -12000;
        CPEntityChook chook = new CPEntityChook(world);
        chook.setPosition(x, y, z);
        chook.setGrowingAge(iAge);
        world.spawnEntityInWorld(chook);
        return chook;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean requiresMultipleRenderPasses()
    {
        return true;
    }




}
