package othlon.cherrypig.blocks.tree;

import com.google.common.collect.ImmutableList;
import net.minecraft.block.BlockState;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.TwoLayerFeature;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.treedecorator.BeehiveTreeDecorator;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;
import othlon.cherrypig.init.CPRegistry;

public class CPFeatureConfig {
    private static final BeehiveTreeDecorator MANY_BEEHIVES = new BeehiveTreeDecorator(0.05F);
    private static final BlockState CHERRY_LOG = CPRegistry.CHERRY_LOG.get().getDefaultState();
    private static final BlockState CHERRY_LEAVES = CPRegistry.CHERRY_LEAVES.get().getDefaultState();


    public static final BaseTreeFeatureConfig CHERRY_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(CHERRY_LOG), new SimpleBlockStateProvider(CHERRY_LEAVES), new BlobFoliagePlacer(2, 0, 0, 0, 3), new StraightTrunkPlacer(4, 2, 0), new TwoLayerFeature(1, 0, 1))).setIgnoreVines().build();
    public static final BaseTreeFeatureConfig CHERRY_TREE_WITH_MORE_BEEHIVES_CONFIG = CHERRY_TREE_CONFIG.func_236685_a_(ImmutableList.of(MANY_BEEHIVES));

}
