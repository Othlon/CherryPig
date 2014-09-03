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

/**
 * Created by Jen on 3/09/2014.
 */
public class CPCherryPigFruit extends Item {

    private Class<? extends Entity> entityClass;

    private CPCherryPigFruit(Class<? extends Entity> entityClass)
    {
        this.entityClass = entityClass;
        this.setHasSubtypes(true);
        this.setUnlocalizedName("CherryPigFruit");
        this.setCreativeTab(CherryPig.tabCherryPig);
        this.setTextureName("cherrypig:minicherry");
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack){
        return "SpawnCherryPig";
    }

    public boolean onItemUse(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
        if(p_77648_3_.isRemote)
        {
            return true;
        }
        else
        {
            Block block = p_77648_3_.getBlock(p_77648_4_, p_77648_5_, p_77648_6_);
            p_77648_4_ += Facing.offsetsXForSide[p_77648_7_];
            p_77648_5_ += Facing.offsetsYForSide[p_77648_7_];
            p_77648_6_ += Facing.offsetsZForSide[p_77648_7_];
            double d0 = 0.0D;

            if(p_77648_7_ == 1 && block.getRenderType() == 11)
            {
                d0 = 0.5D;
            }

            Entity entity = spawnCreature(p_77648_3_, p_77648_4_ + 0.5D, p_77648_5_ + d0, p_77648_6_ + 0.5D);

            if(entity != null)
            {
                if(entity instanceof EntityLivingBase && p_77648_1_.hasDisplayName())
                {
                    ((EntityLiving) entity).setCustomNameTag(p_77648_1_.getDisplayName());
                }

                if(!p_77648_2_.capabilities.isCreativeMode)
                {
                    --p_77648_1_.stackSize;
                }
            }

            return true;
        }
    }

    @Override
    public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_)
    {
        if(p_77659_2_.isRemote)
        {
            return p_77659_1_;
        }
        else
        {
            MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(p_77659_2_, p_77659_3_, true);

            if(movingobjectposition == null)
            {
                return p_77659_1_;
            }
            else
            {
                if(movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK)
                {
                    int i = movingobjectposition.blockX;
                    int j = movingobjectposition.blockY;
                    int k = movingobjectposition.blockZ;

                    if(!p_77659_2_.canMineBlock(p_77659_3_, i, j, k)) { return p_77659_1_; }

                    if(!p_77659_3_.canPlayerEdit(i, j, k, movingobjectposition.sideHit, p_77659_1_)) { return p_77659_1_; }

                    if(p_77659_2_.getBlock(i, j, k) instanceof BlockLiquid)
                    {
                        Entity entity = spawnCreature(p_77659_2_, i, j, k);

                        if(entity != null)
                        {
                            if(entity instanceof EntityLivingBase && p_77659_1_.hasDisplayName())
                            {
                                ((EntityLiving) entity).setCustomNameTag(p_77659_1_.getDisplayName());
                            }

                            if(!p_77659_3_.capabilities.isCreativeMode)
                            {
                                --p_77659_1_.stackSize;
                            }
                        }
                    }
                }

                return p_77659_1_;
            }
        }
    }

    private Entity spawnCreature(World world, double p_77840_2_, double p_77840_4_, double p_77840_6_)
    {
        Entity entity = null;

        for(int j = 0; j < 1; ++j)
        {
            try
            {
                entity = this.entityClass.getConstructor(new Class[]
                        { World.class }).newInstance(new Object[]
                        { world });
            }
            catch(InstantiationException e)
            {
                e.printStackTrace();
            }
            catch(IllegalAccessException e)
            {
                e.printStackTrace();
            }
            catch(IllegalArgumentException e)
            {
                e.printStackTrace();
            }
            catch(InvocationTargetException e)
            {
                e.printStackTrace();
            }
            catch(NoSuchMethodException e)
            {
                e.printStackTrace();
            }
            catch(SecurityException e)
            {
                e.printStackTrace();
            }

            if(entity != null && entity instanceof EntityLivingBase)
            {
                EntityLiving entityliving = (EntityLiving) entity;
                entity.setLocationAndAngles(p_77840_2_, p_77840_4_, p_77840_6_, MathHelper.wrapAngleTo180_float(world.rand.nextFloat() * 360.0F), 0.0F);
                entityliving.rotationYawHead = entityliving.rotationYaw;
                entityliving.renderYawOffset = entityliving.rotationYaw;
                entityliving.onSpawnWithEgg((IEntityLivingData) null);
                world.spawnEntityInWorld(entity);
                entityliving.playLivingSound();
            }
        }

        return entity;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean requiresMultipleRenderPasses()
    {
        return true;
    }

    public static CPCherryPigFruit create(Class<? extends Entity> entity)
    {
        return new CPCherryPigFruit(entity);
    }

}
