package othlon.cherrypig.entity;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import othlon.cherrypig.init.CPRegistry;

/**
 * Created by Jen on 2/09/2014.
 */
public class PiggyEntity extends PigEntity {

    public float destPos;
    /** The time until the next egg is spawned. */
    public int timeUntilNextEgg;


    public PiggyEntity(EntityType<? extends PigEntity> entityType, World world) {
        super(entityType, world);
        this.setPathPriority(PathNodeType.WATER, -1.0F);

        this.timeUntilNextEgg = this.rand.nextInt(6000) + 6000;
    }

    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return PiggyEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 10.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.25D).createMutableAttribute(Attributes.ATTACK_DAMAGE, 1.0D);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(2, new LeapAtTargetGoal(this, 0.4F));
        //this.goalSelector.addGoal(3, new EntityAIAttackOnCollide(this, 1.0D, true));
        this.goalSelector.addGoal(4, new RandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(4, new TemptGoal(this, 1.2D, false, Ingredient.fromItems(CPRegistry.CHERRY_FRUIT.get())));
        this.goalSelector.addGoal(5, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.addGoal(5, new LookRandomlyGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
    }

    public PigEntity createChild(AgeableEntity p_90011_1_) {
        return new PiggyEntity(CPRegistry.CHERRY_PIG.get(), this.world);
    }

    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    public void tick() {
        super.tick();
        this.destPos = (float)((double)this.destPos + (double)(this.onGround ? -1 : 4) * 0.3D);

        if (this.destPos < 0.0F) {
            this.destPos = 0.0F;
        }

        if (this.destPos > 1.0F) {
            this.destPos = 1.0F;
        }

        Vector3d motion = getMotion();
        if (!this.onGround && motion.getY() < 0.0D) {
            Double motionY = motion.getY();
            motionY *= 0.6D;
            setMotion(motion.x, motionY, motion.z);
        }


        if (!this.world.isRemote && !this.isChild() && --this.timeUntilNextEgg <= 0) {
            this.playSound(SoundEvents.ENTITY_CHICKEN_EGG, 1.0F, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
            this.entityDropItem(new ItemStack(CPRegistry.CHERRY_FRUIT.get(), 1));
            this.timeUntilNextEgg = this.rand.nextInt(6000) + 6000;
        }
    }

    public boolean isBreedingItem(ItemStack stack) {
        return stack != null && stack.getItem() == CPRegistry.CHERRY_FRUIT.get();
    }
}
