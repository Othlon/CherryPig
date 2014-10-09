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
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.util.ForgeDirection;
import othlon.cherrypig.CherryPig;
import othlon.cherrypig.worldgen.CPCherryTreeGen;

import java.util.List;
import java.util.Random;

public class CPCherrySapling extends BlockSapling {

    private IIcon texture;

    public CPCherrySapling() {
        float f = 0.4F;
        setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
        this.setHardness(0.0F);
        this.setStepSound(Block.soundTypeGrass);
        this.setCreativeTab(CherryPig.tabCherryPig);
        this.setBlockName("cherrysapling");

    }

    @Override
    public boolean canBlockStay(World world, int x, int y, int z)
    {
        return isValidPosition(world, x, y, z, -1);
    }

    @Override
    public void updateTick( World world, int x, int y, int z, Random random){
        if( !world.isRemote){
            if( world.getBlockLightValue(x, y + 1, z) >= 9 && random.nextInt(7) == 0){
                this.func_149878_d(world, x, y, z, random);
            }
        }
    }

    @Override
    // growTree
    public void func_149878_d(World world,int x, int y, int z, Random rand){
        //int meta = world.getBlockMetadata(x, y, z) ;
        Object obj = null;
        int rnd = rand.nextInt(8);

        if(obj == null) {
            obj = new CPCherryTreeGen(4,false);
        }
        if(obj != null) {
            world.setBlockToAir(x, y, z);
            if(!((WorldGenerator)obj).generate(world, rand, x, y, z)){

           }
        }

    }

    //@Override
    public boolean generate(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
        return false;
    }

    @Override
    public void registerBlockIcons(IIconRegister iconRegister){

        texture = iconRegister.registerIcon("cherrypig:cherrypig_sapling");
    }

    public IIcon getIcon(int side, int metadata){
        return texture;
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



}
