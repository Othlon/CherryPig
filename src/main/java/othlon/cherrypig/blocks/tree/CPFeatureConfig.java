package othlon.cherrypig.blocks.tree;

import com.google.common.collect.ImmutableList;
import net.minecraft.block.BlockState;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.treedecorator.BeehiveTreeDecorator;
import net.minecraftforge.common.IPlantable;
import othlon.cherrypig.init.CPRegistry;

public class CPFeatureConfig {
    private static final BlockState CHERRY_LOG = CPRegistry.CHERRY_LOG.get().getDefaultState();
    private static final BlockState CHERRY_LEAVES = CPRegistry.CHERRY_LEAVES.get().getDefaultState();

    public static final TreeFeatureConfig CHERRY_TREE_WITH_MORE_BEEHIVES_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(CHERRY_LOG), new SimpleBlockStateProvider(CHERRY_LEAVES), new BlobFoliagePlacer(2, 0))).baseHeight(4).heightRandA(2).foliageHeight(3).ignoreVines().decorators(ImmutableList.of(new BeehiveTreeDecorator(0.05F))).setSapling((IPlantable)CPRegistry.CHERRY_SAPLING.get()).build();
    public static final TreeFeatureConfig CHERRY_TREE_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(CHERRY_LOG), new SimpleBlockStateProvider(CHERRY_LEAVES), new BlobFoliagePlacer(2, 0))).baseHeight(4).heightRandA(2).foliageHeight(3).ignoreVines().setSapling((net.minecraftforge.common.IPlantable)CPRegistry.CHERRY_SAPLING.get()).build();
}
