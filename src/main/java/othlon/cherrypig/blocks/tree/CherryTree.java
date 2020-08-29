package othlon.cherrypig.blocks.tree;

import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import othlon.cherrypig.init.CPRegistry;

import javax.annotation.Nullable;
import java.util.Random;

public class CherryTree extends Tree {
    @Nullable
    @Override
    protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random random, boolean hasBeehives) {
        return CPRegistry.CHERRY_TREE.get().withConfiguration(hasBeehives ? CPFeatureConfig.CHERRY_TREE_WITH_MORE_BEEHIVES_CONFIG : CPFeatureConfig.CHERRY_TREE_CONFIG);
    }
}
