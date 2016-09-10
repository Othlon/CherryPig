package othlon.cherrypig.items;

import java.util.List;

import net.minecraft.block.BlockLiquid;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import othlon.cherrypig.CherryPig;

import othlon.cherrypig.entity.CPEntityPiggy;

/**
 * Created by Jen on 3/09/2014.
 */
public class CPCherryPip extends Item {

    public CPCherryPip()
    {
        this.setHasSubtypes(true);
        this.setCreativeTab(CherryPig.tabCherryPig);
    }

    @Override
    public String getUnlocalizedName()
    {
        return "item." + getRegistryName();
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack)
    {
        return getUnlocalizedName();
    }

    @Override
    public EnumActionResult onItemUse(ItemStack item, EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        if(world.isRemote)
        {
            //FIXME: Verify this is the correct behaviour
            return EnumActionResult.PASS;
        }
        else
        {
            final IBlockState blockState = world.getBlockState(pos);

            pos = pos.offset(side);
            double d0 = 0.0D;

            //FIXME: Verify Othlon didn't want pigs spawning on liquids.
            if(side == EnumFacing.UP && blockState.getRenderType() == EnumBlockRenderType.LIQUID)
            {
                d0 = 0.5D;
            }

            Entity entity = spawnCreature(world, pos.getX() + 0.5D, pos.getY() + d0, pos.getZ() + 0.5D);

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

            return EnumActionResult.PASS;
        }
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack item, World world, EntityPlayer player, EnumHand hand)
    {
        if(world.isRemote)
        {
            return ActionResult.newResult(EnumActionResult.PASS, item);
        }
        else
        {
            RayTraceResult movingobjectposition = this.rayTrace(world, player, true);

            if(movingobjectposition == null)
            {
                return ActionResult.newResult(EnumActionResult.FAIL, item);
            }
            else
            {
                if(movingobjectposition.typeOfHit == RayTraceResult.Type.BLOCK)
                {
                    BlockPos pos = movingobjectposition.getBlockPos();

                    if(!world.canMineBlockBody(player, pos)) { return ActionResult.newResult(EnumActionResult.FAIL, item); }

                    if(!player.canPlayerEdit(pos, movingobjectposition.sideHit, item)) { return ActionResult.newResult(EnumActionResult.FAIL, item); }

                    if(world.getBlockState(pos).getBlock() instanceof BlockLiquid)
                    {
                        Entity entity = spawnCreature(world, pos.getX(), pos.getY(), pos.getZ());

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

                return ActionResult.newResult(EnumActionResult.PASS, item);
            }
        }
    }

    private Entity spawnCreature(World world, double x, double y, double z)
    {
        int iAge = -12000;
        CPEntityPiggy piggeh = new CPEntityPiggy(world);
        piggeh.setPosition(x, y, z);
        piggeh.setGrowingAge(iAge);
        world.spawnEntityInWorld(piggeh);
        return piggeh;
    }

    //FIXME: Remove if no longer needed
    /*@Override
    @SideOnly(Side.CLIENT)
    public boolean requiresMultipleRenderPasses()
    {
        return true;
    }*/

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean z){
        if(stack.hasTagCompound()){
            NBTTagCompound nbttagcompound = stack.getTagCompound();
            String string = nbttagcompound.getString("bloop");

            if(string != null){

                list.add("Spawns Cherry Pigs");
            }

        }
    }
}
