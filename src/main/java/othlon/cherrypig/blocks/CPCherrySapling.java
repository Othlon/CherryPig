package othlon.cherrypig.blocks;

import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.TerrainGen;
import othlon.cherrypig.CherryPig;
import othlon.cherrypig.worldgen.CPCherryTreeGen;
import java.util.List;
import java.util.Random;

public class CPCherrySapling extends BlockSapling {

    public CPCherrySapling() {
        //float f = 0.4F;
        //setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
        this.setHardness(0.0F);
        this.setSoundType(SoundType.PLANT);
        this.setCreativeTab(CherryPig.tabCherryPig);

        this.setDefaultState(this.blockState.getBaseState().withProperty(STAGE, Integer.valueOf(0)));
    }

    @Override
    public String getUnlocalizedName()
    {
        return "tile." + getRegistryName();
    }

    @Override
    public void generateTree(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (!TerrainGen.saplingGrowTree(worldIn, rand, pos)) return;
        WorldGenerator worldgenerator;// = (WorldGenerator)(rand.nextInt(10) == 0 ? new WorldGenBigTree(true) : new WorldGenTrees(true));
        int i = 0;
        int j = 0;
        boolean flag = false;

        worldgenerator = new CPCherryTreeGen(4, false);

        IBlockState iblockstate2 = Blocks.AIR.getDefaultState();

        worldIn.setBlockState(pos, iblockstate2, 4);

        if (!worldgenerator.generate(worldIn, rand, pos.add(i, 0, j)))
        {
            worldIn.setBlockState(pos, state, 4);
        }
    }

    @Override
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List<ItemStack> list)
    {
        list.add(new ItemStack(itemIn, 1, 0));
    }

    /**
     * Convert the given metadata into a BlockState for this Block
     */
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(STAGE, Integer.valueOf((meta & 8) >> 3));
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    public int getMetaFromState(IBlockState state)
    {
        int i = 0;
        i = i | ((Integer)state.getValue(STAGE)).intValue() << 3;
        return i;
    }

    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {TYPE, STAGE});
    }
}
