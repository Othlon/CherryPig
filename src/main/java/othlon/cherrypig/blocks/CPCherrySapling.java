package othlon.cherrypig.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import othlon.cherrypig.CherryPig;
import othlon.cherrypig.worldgen.CPCherryTreeGen;

import java.util.List;
import java.util.Random;

/**
 * Created by Jen on 30/05/14.
 */
public class CPCherrySapling extends BlockSapling {

    private IIcon texture;

    public CPCherrySapling() {
        float f = 0.4F;
        setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
        this.setHardness(0.0F);
        this.setStepSound(Block.soundTypeGrass);
        this.setCreativeTab(CherryPig.tabCherryPig);
        this.setBlockName("CherryPig Sapling");



    }

    @Override
    public boolean onBlockActivated(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
        return p_149727_1_.isRemote || new CPCherryTreeGen().generate(p_149727_1_, p_149727_1_.rand, p_149727_2_, p_149727_3_, p_149727_4_);
    }

    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {


        texture = iconRegister.registerIcon("cherrypig:cherrypig_sapling");
    }

    public boolean isValidPosition(World world, int x, int y, int z, int metadata) {

        Block block = world.getBlock(x, y - 1, z);

        return block == Blocks.grass || block == Blocks.dirt || block == Blocks.farmland || block.canSustainPlant(world, x, y - 1, z, ForgeDirection.UP, this);

    }

    @Override
    public void getSubBlocks(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_) {
        //noinspection unchecked
        p_149666_3_.add(new ItemStack(p_149666_1_, 1, 0));
    }

    @Override
    public boolean canPlaceBlockOnSide(World world, int x, int y, int z, int side) {
        return isValidPosition(world, x, y, z, -1);
    }

    @Override
    public void func_149878_d(World world, int x, int y, int z, Random rand) {
//        super.func_149878_d(world, x, y, z, rand);

    }
}
