package othlon.cherrypig.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPurpurSlab;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import othlon.cherrypig.CherryPig;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

/**
 * Created by Jen on 23/11/2014.
 */
public abstract class CPCherrySlab extends BlockSlab {

    /*public CPCherrySlab(boolean isDoubleSlab, Material material){
        super(material);

        this.setHardness(2.0F);
        this.setResistance(5.0F);
        this.useNeighborBrightness = true;
        this.setSoundType(SoundType.WOOD);
        //this.setBlockName("cherrywoodplankslab");
        this.setCreativeTab(CherryPig.tabCherryPig);

    }*/
    public static final PropertyEnum<BlockPurpurSlab.Variant> VARIANT = PropertyEnum.<BlockPurpurSlab.Variant>create("variant", BlockPurpurSlab.Variant.class);

    public CPCherrySlab()
    {
        super(Material.WOOD);
        IBlockState iblockstate = this.blockState.getBaseState();

        if (!this.isDouble())
        {
            iblockstate = iblockstate.withProperty(HALF, BlockSlab.EnumBlockHalf.BOTTOM);
        }

        this.setDefaultState(iblockstate.withProperty(VARIANT, BlockPurpurSlab.Variant.DEFAULT));
        this.setHardness(2.0F);
        this.setResistance(5.0F);
        this.setSoundType(SoundType.WOOD);
        this.setCreativeTab(CherryPig.tabCherryPig);
    }

    /**
     * Get the Item that this Block should drop when harvested.
     */
    @Nullable
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(Blocks.PURPUR_SLAB);
    }

    @Deprecated
    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
    {
        return new ItemStack(Blocks.PURPUR_SLAB);
    }

    /**
     * Convert the given metadata into a BlockState for this Block
     */
    @Deprecated
    public IBlockState getStateFromMeta(int meta)
    {
        IBlockState iblockstate = this.getDefaultState().withProperty(VARIANT, BlockPurpurSlab.Variant.DEFAULT);

        if (!this.isDouble())
        {
            iblockstate = iblockstate.withProperty(HALF, (meta & 8) == 0 ? BlockSlab.EnumBlockHalf.BOTTOM : BlockSlab.EnumBlockHalf.TOP);
        }

        return iblockstate;
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    public int getMetaFromState(IBlockState state)
    {
        int i = 0;

        if (!this.isDouble() && state.getValue(HALF) == BlockSlab.EnumBlockHalf.TOP)
        {
            i |= 8;
        }

        return i;
    }

    protected BlockStateContainer createBlockState()
    {
        return this.isDouble() ? new BlockStateContainer(this, new IProperty[] {VARIANT}): new BlockStateContainer(this, new IProperty[] {HALF, VARIANT});
    }

    /**
     * Returns the slab block name with the type associated with it
     */
    public String getUnlocalizedName(int meta)
    {
        return super.getUnlocalizedName();
    }

    public IProperty<?> getVariantProperty()
    {
        return VARIANT;
    }

    public Comparable<?> getTypeForItem(ItemStack stack)
    {
        return BlockPurpurSlab.Variant.DEFAULT;
    }

    public static class Double extends CPCherrySlab
    {
        public boolean isDouble()
        {
            return true;
        }
    }

    public static class Half extends CPCherrySlab
    {
        public boolean isDouble()
        {
            return false;
        }
    }

    public static enum Variant implements IStringSerializable
    {
        DEFAULT;

        public String getName()
        {
            return "default";
        }
    }

}
