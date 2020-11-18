package othlon.cherrypig.blocks.tree;

import com.google.common.collect.ImmutableList;
import net.minecraft.block.BlockState;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.FeatureSpread;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.TwoLayerFeature;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.treedecorator.BeehiveTreeDecorator;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;
import othlon.cherrypig.CherryPig;
import othlon.cherrypig.init.CPRegistry;

public class CPFeatureConfig {
    private static final BeehiveTreeDecorator MANY_BEEHIVES = new BeehiveTreeDecorator(0.05F);
    private static final BlockState CHERRY_LOG = CPRegistry.CHERRY_LOG.get().getDefaultState();
    private static final BlockState CHERRY_LEAVES = CPRegistry.CHERRY_LEAVES.get().getDefaultState();

    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> CHERRY_TREE_CONFIG = register("cherry_tree", CPRegistry.CHERRY_TREE.get().withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(CPFeatureConfig.CHERRY_LOG), new SimpleBlockStateProvider(CPFeatureConfig.CHERRY_LEAVES), new BlobFoliagePlacer(FeatureSpread.func_242252_a(2), FeatureSpread.func_242252_a(0), 3), new StraightTrunkPlacer(4, 2, 0), new TwoLayerFeature(1, 0, 1))).setIgnoreVines().build()));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> CHERRY_TREE_WITH_MORE_BEEHIVES_CONFIG = register("cherry_tree_with_bees", CPRegistry.CHERRY_TREE.get().withConfiguration((CHERRY_TREE_CONFIG.getConfig().func_236685_a_(ImmutableList.of(MANY_BEEHIVES)))));

    private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String key, ConfiguredFeature<FC, ?> feature) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(CherryPig.MODID, key), feature);
    }
}