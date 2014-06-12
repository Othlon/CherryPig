package othlon.cherrypig.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import othlon.cherrypig.CherryPig;
import othlon.cherrypig.helpers.CPCreativeTab;

import javax.swing.*;

/**
 * Created by Jen on 30/05/14.
 */
public class CPCherrySapling extends BlockSapling{

    private IIcon texture;

    public CPCherrySapling(){
        float f = 0.4F;
        setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
        this.setHardness(0.0F);
        this.setStepSound(Block.soundTypeGrass);
        this.setCreativeTab(CherryPig.tabCherryPig);

    }

    @Override
    public void registerBlockIcons( IIconRegister iconRegister){


        texture = iconRegister.registerIcon("cherrypig:cherrypig_sapling");
    }

    public boolean isValidPosition(World world, int x, int y, int z, int metadata){

        Block block = world.getBlock(x,y - 1, z);

        return block == Blocks.grass || block == Blocks.dirt || block == Blocks.farmland || block.canSustainPlant(world, x, y - 1, z, ForgeDirection.UP, this);

    }

    @Override
    public boolean canPlaceBlockOnSide(World world, int x, int y, int z, int side)
    {
        return isValidPosition(world, x, y, z, -1);
    }












}
