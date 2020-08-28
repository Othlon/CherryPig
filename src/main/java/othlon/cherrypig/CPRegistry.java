package othlon.cherrypig;

import net.minecraft.block.Block;
import net.minecraft.block.LogBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import othlon.cherrypig.blocks.CherryLeavesBlock;
import othlon.cherrypig.blocks.CherrySaplingBlock;
import othlon.cherrypig.entity.PiggyEntity;
import othlon.cherrypig.helpers.CPFoods;
import othlon.cherrypig.helpers.CherryGroups;
import othlon.cherrypig.items.CherryPipItem;
import othlon.cherrypig.items.CharcoalBlockItem;
import othlon.cherrypig.items.CustomSpawnEggItem;
import othlon.cherrypig.worldgen.CherryTree;

import java.util.function.Supplier;

public class CPRegistry {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, CherryPig.MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CherryPig.MODID);
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, CherryPig.MODID);
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, CherryPig.MODID);

    public static final RegistryObject<EntityType<PiggyEntity>> CHERRY_PIG = ENTITIES.register("cherry_pig", () -> register("cherry_pig", EntityType.Builder.<PiggyEntity>create(PiggyEntity::new, EntityClassification.CREATURE).size(0.6F, 0.6F)));

    public static final RegistryObject<Block> CHERRY_LEAVES = registerBlock("cherry_leaves", () -> new CherryLeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).notSolid()), itemBuilder());
    public static final RegistryObject<Block> CHERRY_LOG = registerBlock("cherry_log", () -> new LogBlock(MaterialColor.RED, Block.Properties.create(Material.WOOD, MaterialColor.RED).hardnessAndResistance(2.0F).sound(SoundType.WOOD)), itemBuilder());

    public static final RegistryObject<Block> CHERRY_SAPLING = registerBlock("cherry_sapling", () -> new CherrySaplingBlock(new CherryTree(), Block.Properties.create(Material.PLANTS).notSolid().tickRandomly().hardnessAndResistance(0.0F).sound(SoundType.PLANT)), itemBuilder());
    public static final RegistryObject<Block> CHERRY_PLANKS = registerBlock("cherry_wood_plank", () -> new Block(Block.Properties.create(Material.WOOD, MaterialColor.RED).hardnessAndResistance(1.5F, 3.0F).sound(SoundType.WOOD)), itemBuilder());

    public static final RegistryObject<Block> CHERRY_SLAB = registerBlock("cherry_wood_slab", () -> new SlabBlock(Block.Properties.create(Material.WOOD, MaterialColor.RED).hardnessAndResistance(2.0F, 5.0F).sound(SoundType.WOOD)), itemBuilder());

    public static final RegistryObject<Block> CHERRY_STAIRS = registerBlock("cherry_wood_stairs", () -> new StairsBlock(() -> CHERRY_PLANKS.get().getDefaultState(), Block.Properties.from(CHERRY_PLANKS.get())), itemBuilder());

    public static final RegistryObject<Block> CHARCOAL_BLOCK = registerCharcoalBlock("charcoal_block", () -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.BLACK).hardnessAndResistance(5.0F, 6.0F)), itemBuilder());
    public static final RegistryObject<Block> FLINT_BLOCK = registerBlock("flint_block", () -> new Block(Block.Properties.create(Material.IRON, MaterialColor.GRAY).hardnessAndResistance(5.0F, 10.0F).sound(SoundType.METAL)), itemBuilder());

    public static final RegistryObject<Item> CHERRY_PIP = ITEMS.register("cherry_pip", () -> new CherryPipItem(itemBuilder()));
    public static final RegistryObject<Item> CHERRY_FRUIT = ITEMS.register("cherry_fruit", () -> new Item(itemBuilder().food(CPFoods.CHERRY_FRUIT)));
    public static final RegistryObject<Item> CHERRY_PIE = ITEMS.register("cherry_pie", () -> new Item(itemBuilder().food(CPFoods.CHERRY_PIE)));

    public static final RegistryObject<Item> CHERRY_PIGGY_SPAWN_EGG = ITEMS.register("cherry_piggy_spawn_egg" , () -> new CustomSpawnEggItem(() -> CHERRY_PIG.get(), 0x990000, 0x669900, itemBuilder()));

    public static final RegistryObject<SoundEvent> PIG_TALK = SOUND_EVENTS.register("pig.talk", () -> new SoundEvent(new ResourceLocation(CherryPig.MODID, "pig.talk")));

    public static <B extends Block> RegistryObject<B> registerBlock(String name, Supplier<? extends B> supplier, Item.Properties properties) {
        RegistryObject<B> block = CPRegistry.BLOCKS.register(name, supplier);
        ITEMS.register(name, () -> new BlockItem(block.get(), properties));
        return block;
    }

    public static <B extends Block> RegistryObject<B> registerCharcoalBlock(String name, Supplier<? extends B> supplier, Item.Properties properties) {
        RegistryObject<B> block = CPRegistry.BLOCKS.register(name, supplier);
        ITEMS.register(name, () -> new CharcoalBlockItem(block.get(), properties));
        return block;
    }

    public static <T extends Entity> EntityType<T> register(String id, EntityType.Builder<T> builder, boolean sendVelocityUpdates) {
        return builder.setTrackingRange(64).setUpdateInterval(3).setShouldReceiveVelocityUpdates(sendVelocityUpdates).build(id);
    }

    public static <T extends Entity> EntityType<T> register(String id, EntityType.Builder<T> builder) {
        return register(id, builder, true);
    }

    private static Item.Properties itemBuilder() {
        return new Item.Properties().group(CherryGroups.CHERRY_TAB);
    }
}
