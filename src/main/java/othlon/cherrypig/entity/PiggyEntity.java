package othlon.cherrypig.entity;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import othlon.cherrypig.CPRegistry;

/**
 * Created by Jen on 2/09/2014.
 */
public class PiggyEntity extends PigEntity {

    public float field_70886_e;
    public float destPos;
    public float field_70884_g;
    public float field_70888_h;
    public float field_70889_i = 1.0F;
    /** The time until the next egg is spawned. */
    public int timeUntilNextEgg;
    public boolean field_152118_bv;


    public PiggyEntity(EntityType<? extends PigEntity> entityType, World world)
    {
        super(entityType, world);

//        //this.getNavigator().setAvoidsWater(true);
//        this.timeUntilNextEgg = this.rand.nextInt(6000) + 6000;
//        this.tasks.addTask(1, new SwimGoal(this));
//        this.tasks.addTask(2, new LeapAtTargetGoal(this, 0.4F));
//        //this.tasks.addTask(3, new EntityAIAttackOnCollide(this, 1.0D, true));
//        this.tasks.addTask(4, new RandomWalkingGoal(this, 1.0D));
//        this.tasks.addTask(4, new TemptGoal(this, 1.2D, CPItem.cherryFruit, false));
//        this.tasks.addTask(5, new LookAtGoal(this, PlayerEntity.class, 8.0F));
//        this.tasks.addTask(5, new LookRandomlyGoal(this));
//        this.targetTasks.addTask(1, new HurtByTargetGoal(this, true));
    }

    public PigEntity createChild(AgeableEntity p_90011_1_){
        return new PiggyEntity(CPRegistry.CHERRY_PIG.get(), this.world);
    }

    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    public void tick()
    {
        super.tick();
        this.field_70888_h = this.field_70886_e;
        this.field_70884_g = this.destPos;                                  //what are these int exactly?
        this.destPos = (float)((double)this.destPos + (double)(this.onGround ? -1 : 4) * 0.3D);


        if (this.destPos < 0.0F)
        {
            this.destPos = 0.0F;
        }

        if (this.destPos > 1.0F)
        {
            this.destPos = 1.0F;
        }

        if (!this.onGround && this.field_70889_i < 1.0F)
        {
            this.field_70889_i = 1.0F;
        }

        this.field_70889_i = (float)((double)this.field_70889_i * 0.9D);

        Vec3d motion = getMotion();
        if (!this.onGround && motion.getY() < 0.0D)
        {
            Double motionY = motion.getY();
            motionY *= 0.6D;
            setMotion(motion.x, motionY, motion.z);
        }

        this.field_70886_e += this.field_70889_i * 2.0F;

        if (!this.world.isRemote && !this.isChild() && !this.func_152116_bZ() && --this.timeUntilNextEgg <= 0)
        {
            this.playSound(CPRegistry.PIG_TALK.get(), 1.0F, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
            this.entityDropItem(new ItemStack(CPRegistry.CHERRY_FRUIT.get(), 1));
            this.timeUntilNextEgg = this.rand.nextInt(6000) + 6000;
        }
    }

    public boolean func_152116_bZ()
    {
        return this.field_152118_bv;
    }

    public boolean isBreedingItem(ItemStack p_70877_1_)
    {
        return p_70877_1_ != null && p_70877_1_.getItem() == CPRegistry.CHERRY_FRUIT.get();
    }
}
