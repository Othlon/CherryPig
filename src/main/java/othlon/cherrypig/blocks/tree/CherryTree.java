package othlon.cherrypig.blocks.tree;

import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import othlon.cherrypig.init.CPRegistry;

import javax.annotation.Nullable;
import java.util.Random;

public class CherryTree extends Tree {
    @Nullable
    @Override
    protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean hasBeehives) {
        return CPRegistry.CHERRY_TREE.get().withConfiguration(hasBeehives ? CPFeatureConfig.CHERRY_TREE_WITH_MORE_BEEHIVES_CONFIG.getConfig() : CPFeatureConfig.CHERRY_TREE_CONFIG.getConfig());
    }
}
