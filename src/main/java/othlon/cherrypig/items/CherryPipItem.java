package othlon.cherrypig.items;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext.FluidMode;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.RayTraceResult.Type;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import othlon.cherrypig.CPRegistry;
import othlon.cherrypig.entity.CPEntityPiggy;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Created by Jen on 3/09/2014.
 */
public class CherryPipItem extends Item {

    public CherryPipItem(Item.Properties builder) {
        super(builder);
    }

    @Override
    public ActionResultType onItemUse(ItemUseContext context) {
        World worldIn = context.getWorld();
        if(!worldIn.isRemote) {
            BlockPos pos = context.getPos();
            Direction side = context.getFace();
            ItemStack stack = context.getItem();
            PlayerEntity player = context.getPlayer();

            pos = pos.offset(side);
            double d0 = 0.0D;

            //FIXME: Verify Othlon didn't want pigs spawning on liquids.
            if(side == Direction.UP && worldIn.hasWater(pos)) {
                d0 = 0.5D;
            }

            Entity entity = spawnCreature(worldIn, pos.getX() + 0.5D, pos.getY() + d0, pos.getZ() + 0.5D);

            if(entity != null) {
                if(entity instanceof LivingEntity && stack.hasDisplayName()) {
                    ((MobEntity) entity).setCustomName(stack.getDisplayName());
                }

                if(player != null && !player.abilities.isCreativeMode) {
                    stack.shrink(1);
                }
            }
        }
        return ActionResultType.PASS;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);
        if(!worldIn.isRemote) {
            RayTraceResult rayTraceResult = this.rayTrace(worldIn, playerIn, FluidMode.ANY);

            if(rayTraceResult == null) {
                return ActionResult.resultFail(stack);
            } else {
                if(rayTraceResult.getType() == Type.BLOCK) {
                    BlockRayTraceResult blockTrace = (BlockRayTraceResult) rayTraceResult;
                    BlockPos pos = blockTrace.getPos();

                    if(!worldIn.canMineBlockBody(playerIn, pos)) { return ActionResult.resultFail(stack); }

                    if(!playerIn.canPlayerEdit(pos, blockTrace.getFace(), stack)) { return ActionResult.resultFail(stack); }

                    if(!worldIn.getFluidState(pos).isEmpty()) {
                        Entity entity = spawnCreature(worldIn, pos.getX(), pos.getY(), pos.getZ());

                        if(entity != null) {
                            if(entity instanceof LivingEntity && stack.hasDisplayName()) {
                                ((MobEntity) entity).setCustomName(stack.getDisplayName());
                            }

                            if(!playerIn.abilities.isCreativeMode) {
                                stack.shrink(1);
                            }
                        }
                    }
                }
                return ActionResult.resultPass(stack);
            }
        }
        return ActionResult.resultPass(stack);
    }

    private Entity spawnCreature(World world, double x, double y, double z) {
        int iAge = -12000;
        CPEntityPiggy piggeh = CPRegistry.CHERRY_PIG.get().create(world);
        if(piggeh != null) {
            piggeh.setPosition(x, y, z);
            piggeh.setGrowingAge(iAge);
            world.addEntity(piggeh);
        }
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
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if(stack.hasTag()){
            CompoundNBT tag = stack.getTag();
            String string = tag.getString("bloop");

            if(string != null){

                tooltip.add(new StringTextComponent("Spawns Cherry Pigs"));
            }

        }
    }
}
