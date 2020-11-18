package othlon.cherrypig.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.LeavesBlock;


public class CherryLeavesBlock extends LeavesBlock {

    //int[] adjacentTreeBlocks;
    //ItemStack fruit = new ItemStack(CPItem.cherryFruit,1 , 0);

    public CherryLeavesBlock(Block.Properties builder) {
        super(builder);
//        this.setTickRandomly(true);
//        this.setHardness(0.13F);
//        setSoundType(SoundType.PLANT);
//        this.setLightOpacity(1);
//        this.setCreativeTab(CherryPig.tabCherryPig);

//        this.setDefaultState(this.blockState.getBaseState().withProperty(CHECK_DECAY, Boolean.valueOf(true)).withProperty(DECAYABLE, Boolean.valueOf(true)));
    }

//    @Override
//    public String getUnlocalizedName()
//    {
//        return "tile." + getRegistryName();
//    }
//
//    protected BlockStateContainer createBlockState()
//    {
//        return new BlockStateContainer(this, new IProperty[] {CHECK_DECAY, DECAYABLE});
//    }
//
//    @Override
//    public boolean isOpaqueCube(BlockState state)
//    {
//        return Blocks.LEAVES.isOpaqueCube(state);
//    }
//
//    /**
//     * Convert the given metadata into a BlockState for this Block
//     */
//    @Deprecated
//    public BlockState getStateFromMeta(int meta)
//    {
//        return this.getDefaultState().withProperty(DECAYABLE, Boolean.valueOf((meta & 4) == 0)).withProperty(CHECK_DECAY, Boolean.valueOf((meta & 8) > 0));
//    }
//
//    /**
//     * Convert the BlockState into the correct metadata value
//     */
//    public int getMetaFromState(BlockState state)
//    {
//        int i = 0;
//
//        if (!state.getValue(DECAYABLE).booleanValue())
//        {
//            i |= 4;
//        }
//
//        if (state.getValue(CHECK_DECAY).booleanValue())
//        {
//            i |= 8;
//        }
//
//        return i;
//    }
//
//    @Override
//    @Nullable
//    public BlockPlanks.EnumType getWoodType(int meta)
//    {
//        //Required, but the list is too restrictive, need to override getMetaFromState to work around.
//        return null;
//    }
//
//    @Override
//    public List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune)
//    {
//        return Lists.newArrayList(new ItemStack(this, 1, 0));
//    }
//
//
//    /*
//    @Override
//    public boolean isShearable(ItemStack item, IBlockAccess world, BlockPos pos)
//    {
//        return false;
//    }
//    */
//
//    /*
//    @Override
//    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
//    {
//        return true;
//    }
//    */
//
//    /*
//    @Override
//    public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
//    {
//        byte radius = 1;
//        int bounds = radius + 1;
//
//        if (world.checkChunksExist(x - bounds, y - bounds, z - bounds, x + bounds, y + bounds, z + bounds))
//        {
//            for (int i = -radius; i <= radius; ++i)
//            {
//                for (int j = -radius; j <= radius; ++j)
//                {
//                    for (int k = -radius; k <= radius; ++k)
//                    {
//                        //TODO:				getBlock()
//                        Block block = world.getBlock(x + i, y + j, z + k);
//
//                        if (block.isLeaves(world, x, y, z))
//                        {
//                            block.beginLeavesDecay(world, x + i, y + j, z + k);
//                        }
//                    }
//                }
//            }
//        }
//    }
//    */
//
//    /*
//    @Override
//    //TODO:		updateTick()
//    public void updateTick(World world, int x, int y, int z, Random random)
//    {
//        if (world.isRemote)
//            return;
//
//        int meta = world.getBlockMetadata(x, y, z);
//        if (random.nextInt(25) == 0)
//            if (meta > 0)
//                if ((meta & 3) < 3)
//                {
//                    //TODO: setBlock()
//                    world.setBlock(x, y, z, this, ++meta, 3);
//                }
//
//        if ((meta & 8) != 0) { // && (meta & 4) == 0
//            byte b0 = 4;
//            int i1 = b0 + 1;
//            byte b1 = 32;
//            int j1 = b1 * b1;
//            int k1 = b1 / 2;
//
//            if (adjacentTreeBlocks == null)
//            {
//                adjacentTreeBlocks = new int[b1 * b1 * b1];
//            }
//
//            int l1;
//
//            if (world.checkChunksExist(x - i1, y - i1, z - i1, x + i1, y + i1, z + i1))
//            {
//                int i2;
//                int j2;
//                int k2;
//
//                for (l1 = -b0; l1 <= b0; ++l1)
//                {
//                    for (i2 = -b0; i2 <= b0; ++i2)
//                    {
//                        for (j2 = -b0; j2 <= b0; ++j2)
//                        {
//                            //TODO:				world.getBlock()
//                            Block block = world.getBlock(x + l1, y + i2, z + j2);
//
//                            if (block != null && block.canSustainLeaves(world, x + l1, y + i2, z + j2))
//                            {
//                                adjacentTreeBlocks[(l1 + k1) * j1 + (i2 + k1) * b1 + j2 + k1] = 0;
//                            }
//                            else if (block != null && block.isLeaves(world, x + l1, y + i2, z + j2))
//                            {
//                                adjacentTreeBlocks[(l1 + k1) * j1 + (i2 + k1) * b1 + j2 + k1] = -2;
//                            }
//                            else
//                            {
//                                adjacentTreeBlocks[(l1 + k1) * j1 + (i2 + k1) * b1 + j2 + k1] = -1;
//                            }
//                        }
//                    }
//                }
//
//                for (l1 = 1; l1 <= 4; ++l1)
//                {
//                    for (i2 = -b0; i2 <= b0; ++i2)
//                    {
//                        for (j2 = -b0; j2 <= b0; ++j2)
//                        {
//                            for (k2 = -b0; k2 <= b0; ++k2)
//                            {
//                                if (adjacentTreeBlocks[(i2 + k1) * j1 + (j2 + k1) * b1 + k2 + k1] == l1 - 1)
//                                {
//                                    if (adjacentTreeBlocks[(i2 + k1 - 1) * j1 + (j2 + k1) * b1 + k2 + k1] == -2)
//                                    {
//                                        adjacentTreeBlocks[(i2 + k1 - 1) * j1 + (j2 + k1) * b1 + k2 + k1] = l1;
//                                    }
//
//                                    if (adjacentTreeBlocks[(i2 + k1 + 1) * j1 + (j2 + k1) * b1 + k2 + k1] == -2)
//                                    {
//                                        adjacentTreeBlocks[(i2 + k1 + 1) * j1 + (j2 + k1) * b1 + k2 + k1] = l1;
//                                    }
//
//                                    if (adjacentTreeBlocks[(i2 + k1) * j1 + (j2 + k1 - 1) * b1 + k2 + k1] == -2)
//                                    {
//                                        adjacentTreeBlocks[(i2 + k1) * j1 + (j2 + k1 - 1) * b1 + k2 + k1] = l1;
//                                    }
//
//                                    if (adjacentTreeBlocks[(i2 + k1) * j1 + (j2 + k1 + 1) * b1 + k2 + k1] == -2)
//                                    {
//                                        adjacentTreeBlocks[(i2 + k1) * j1 + (j2 + k1 + 1) * b1 + k2 + k1] = l1;
//                                    }
//
//                                    if (adjacentTreeBlocks[(i2 + k1) * j1 + (j2 + k1) * b1 + (k2 + k1 - 1)] == -2)
//                                    {
//                                        adjacentTreeBlocks[(i2 + k1) * j1 + (j2 + k1) * b1 + (k2 + k1 - 1)] = l1;
//                                    }
//
//                                    if (adjacentTreeBlocks[(i2 + k1) * j1 + (j2 + k1) * b1 + k2 + k1 + 1] == -2)
//                                    {
//                                        adjacentTreeBlocks[(i2 + k1) * j1 + (j2 + k1) * b1 + k2 + k1 + 1] = l1;
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//
//            l1 = adjacentTreeBlocks[k1 * j1 + k1 * b1 + k1];
//
//            if (l1 >= 0)
//            {
//                world.setBlockMetadataWithNotify(x, y, z, meta & -9, 4);
//            }
//            else
//            {
//                this.removeLeaves(world, x, y, z);
//            }
//        }
//    }
//    */
//
//    /*
//    private void removeLeaves(World world, int x, int y, int z)
//    {
//        //TODO: dropBlockAsItem
//        this.dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
//        //TODO: setBlockToAir
//        world.setBlockToAir(x, y, z);
//    }
//    */
//
//    @Nullable
//    @Override
//    public Item getItemDropped(BlockState state, Random rand, int fortune)
//    {
//        return Item.getItemFromBlock(CPBlocks.cherrySapling);
//    }
//
//    /*
//    @Override
//    public void dropBlockAsItemWithChance(World world, BlockPos pos, IBlockState state, float chance, int fortune)
//    {
//        if(world.isRemote)return;
//
//        if(world.rand.nextInt(12) == 0) {
//            Item item = this.getItemDropped(metadata, world.rand, fortune);
//            this.dropBlockAsItem(world, x, y, z, new ItemStack(item, 1, this.damageDropped(metadata)));
//        }
//        if(world.rand.nextInt(7) == 0)
//        {
//
//           this.dropBlockAsItem(world, x, y, z, new ItemStack(CPItem.cherryFruit, 1));
//        }
//    }
//    */
//
//    /*
//    @Override
//    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ)
//    {
//        int meta = world.getBlockMetadata(x, y, z);
//        if ((meta & 3) == 3)
//        {
//            //TODO: setBlock
//            world.setBlock(x, y, z, this, meta - 3, 3);
//            EntityItem entityitem = new EntityItem(world, x, y, z, fruit);
//
//            if (!world.isRemote)
//            {
//                world.spawnEntityInWorld(entityitem);
//                if (!(player instanceof FakePlayer))
//                    entityitem.onCollideWithPlayer(player);
//            }
//            return true;
//        }
//        else
//            return false;
//    }
//    */
//
//    /*
//    @Override
//    public void beginLeavesDecay(IBlockState state, World world, BlockPos pos)
//    {
//        world.setBlockMetadataWithNotify(x, y, z, world.getBlockMetadata(x, y, z) | 8, 4);
//    }
//    */
//
//    @Override
//    public int damageDropped(BlockState state)
//    {
//        return 15;
//    }
//
//    @Override
//    public int quantityDropped(Random random)
//    {
//        return random.nextInt(20) == 0 ? 1 : 0;
//    }
}
