package othlon.cherrypig.worldgen;

/**
 * Created by Jen on 9/06/14.
 */
public class CPCherryTreeGen { //extends TreeFeature {
//    public int minTreeHeight;
//
//    public CPCherryTreeGen(int minTreeHeight, boolean vines) {
//        super(true, minTreeHeight, CPBlocks.cherryLog.getDefaultState(), CPBlocks.cherryLeaf.getDefaultState(), vines);
//        this.minTreeHeight = minTreeHeight;
//    }
//
//    public CPCherryTreeGen() {
//        this(4, false);
//    }
//
//
//    @Override
//    public boolean generate(World par1World, Random par2Random, BlockPos position)
//    {
//        int par4 = position.getY();
//        int par3 = position.getX();
//        int par5 = position.getZ();
//
////        return super.generate(worldIn, rand, position);
////    }
//
//    //public boolean generate(World par1World, Random par2Random, int par3, int par4, int par5) {
//        int l = par2Random.nextInt(3) + this.minTreeHeight;
//        boolean flag = true;
//
//        if (par4 >= 1 && par4 + l + 1 <= 256) {
//            byte b0;
//            int k1;
//            Block block;
//
//            for (int i1 = par4; i1 <= par4 + 1 + l; ++i1) {
//                b0 = 1;
//
//                if (i1 == par4) {
//                    b0 = 0;
//                }
//
//                if (i1 >= par4 + 1 + l - 2) {
//                    b0 = 2;
//                }
//
//                for (int j1 = par3 - b0; j1 <= par3 + b0 && flag; ++j1) {
//                    for (k1 = par5 - b0; k1 <= par5 + b0 && flag; ++k1) {
//                        if (i1 >= 0 && i1 < 256) {
//                            //block = par1World.getBlock(j1, i1, k1);
//
//                            if (!this.isReplaceable(par1World, new BlockPos(j1, i1, k1))) {
//                                flag = false;
//                            }
//                        } else {
//                            flag = false;
//                        }
//                    }
//                }
//            }
//
//            if (!flag) {
//                return false;
//            } else {
//                BlockPos blockBeneath = position.down();
//                final BlockState blockState1 = par1World.getBlockState(blockBeneath);
//                Block block2 = blockState1.getBlock();
//
//                boolean isSoil = block2.canSustainPlant(blockState1, par1World, blockBeneath, Direction.UP, (SaplingBlock) Blocks.SAPLING);
//                if (isSoil && par4 < 256 - l - 1) {
//                    block2.onPlantGrow(blockState1, par1World, blockBeneath, position);
//                    b0 = 3;
//                    byte b1 = 0;
//                    int l1;
//                    int i2;
//                    int j2;
//                    int i3;
//
//                    for (k1 = par4 - b0 + l; k1 <= par4 + l; ++k1) {
//                        i3 = k1 - (par4 + l);
//                        l1 = b1 + 1 - i3 / 2;
//
//                        for (i2 = par3 - l1; i2 <= par3 + l1; ++i2) {
//                            j2 = i2 - par3;
//
//                            for (int k2 = par5 - l1; k2 <= par5 + l1; ++k2) {
//                                int l2 = k2 - par5;
//
//                                if (Math.abs(j2) != l1 || Math.abs(l2) != l1 || par2Random.nextInt(2) != 0 && i3 != 0) {
//
//                                    final BlockPos pos = new BlockPos(i2, k1, k2);
//                                    BlockState blockState = par1World.getBlockState(pos);
//                                    Block block1 = blockState.getBlock();
//
//                                    if (block1.isAir(blockState, par1World, pos) || block1.isLeaves(blockState, par1World, pos)) {
//                                        this.setBlockAndNotifyAdequately(par1World, pos, CPBlocks.cherryLeaf.getDefaultState());
//                                    }
//                                }
//                            }
//                        }
//                    }
//
//                    for (k1 = 0; k1 < l; ++k1) {
//                        BlockPos pos = new BlockPos(par3, par4 + k1, par5);
//                        final BlockState blockState = par1World.getBlockState(pos);
//                        block = blockState.getBlock();
//
//                        if (block.isAir(blockState, par1World, pos) || block.isLeaves(blockState, par1World, pos) || block == CPBlocks.cherrySapling) {
//                            this.setBlockAndNotifyAdequately(par1World, pos, CPBlocks.cherryLog.getDefaultState());
//                        }
//                    }
//
//                    return true;
//                } else {
//                    return false;
//                }
//            }
//        } else {
//            return false;
//        }
//    }
//
//    @Override
//    public boolean isReplaceable(World world, BlockPos pos)
//    {
//        BlockState block = world.getBlockState(pos);
//        return isCherryTreeBlock(block) || super.isReplaceable(world, pos);
//    }
//
//    private boolean isCherryTreeBlock(BlockState blockState) {
//        Block block = blockState.getBlock();
//        return block == CPBlocks.cherryLeaf || block == CPBlocks.cherryLog || block == CPBlocks.cherrySapling;
//    }
}