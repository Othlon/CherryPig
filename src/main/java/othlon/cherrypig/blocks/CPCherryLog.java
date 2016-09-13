package othlon.cherrypig.blocks;

import net.minecraft.block.BlockLog;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import othlon.cherrypig.CherryPig;


public class CPCherryLog extends BlockLog
{
    public CPCherryLog()
    {
        this.setHardness(2.0F);
        this.setHarvestLevel("axe", 0);
        this.setResistance(5.0F);
        this.setSoundType(SoundType.WOOD);
        this.setCreativeTab(CherryPig.tabCherryPig);

        this.setDefaultState(this.blockState.getBaseState().withProperty(LOG_AXIS, BlockLog.EnumAxis.Y));
    }

    @Override
    public String getUnlocalizedName()
    {
        return "tile." + getRegistryName();
    }

    /**
     * Get the MapColor for this Block and the given BlockState
     */
    @Override
    @Deprecated
    public MapColor getMapColor(IBlockState state)
    {
        switch (state.getValue(LOG_AXIS))
        {
            case X:
            case Z:
            case NONE:
            default:
                return MapColor.RED;

            case Y:
                return MapColor.DIRT;
        }
    }

    /**
     * Convert the given metadata into a BlockState for this Block
     */
    public IBlockState getStateFromMeta(int meta)
    {
        IBlockState iblockstate = this.getDefaultState();

        switch (meta & 12)
        {
            case 0:
                iblockstate = iblockstate.withProperty(LOG_AXIS, BlockLog.EnumAxis.Y);
                break;
            case 4:
                iblockstate = iblockstate.withProperty(LOG_AXIS, BlockLog.EnumAxis.X);
                break;
            case 8:
                iblockstate = iblockstate.withProperty(LOG_AXIS, BlockLog.EnumAxis.Z);
                break;
            default:
                iblockstate = iblockstate.withProperty(LOG_AXIS, BlockLog.EnumAxis.NONE);
        }

        return iblockstate;
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    @SuppressWarnings("incomplete-switch")
    public int getMetaFromState(IBlockState state)
    {
        int i = 0;

        switch (state.getValue(LOG_AXIS))
        {
            case X:
                i |= 4;
                break;
            case Z:
                i |= 8;
                break;
            case NONE:
                i |= 12;
        }

        return i;
    }

    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, LOG_AXIS);
    }
}
