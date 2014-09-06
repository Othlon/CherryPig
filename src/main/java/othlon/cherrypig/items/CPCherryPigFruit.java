package othlon.cherrypig.items;

import java.lang.reflect.InvocationTargetException;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Facing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import othlon.cherrypig.CherryPig;
import othlon.cherrypig.entity.CPEntityBabby;
import othlon.cherrypig.entity.CPEntityPiggy;

/**
 * Created by Jen on 3/09/2014.
 */
public class CPCherryPigFruit extends Item {

    public CPCherryPigFruit()
    {
        this.setHasSubtypes(true);
        this.setUnlocalizedName("CherryPigFruit");
        this.setCreativeTab(CherryPig.tabCherryPig);
        this.setTextureName("cherrypig:minicherry");
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack){
        return "SpawnCherryPig";
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
        Entity piggeh = new CPEntityBabby(world);
        piggeh.setPosition(x, y, z);
        world.spawnEntityInWorld(piggeh);

        return piggeh;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean requiresMultipleRenderPasses()
    {
        return true;
    }

}
