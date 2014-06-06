package othlon.cherrypig.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLeavesBase;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.IShearable;
import net.minecraft.util.IIcon;

import java.util.ArrayList;


/**
 * Created by Jen on 30/05/14.
 */
public class CPCherryLeaf extends BlockLeavesBase implements IShearable{

    private IIcon[] textures;
    int[] adjacentTreeBlocks;

    public CPCherryLeaf(){
        super(Material.leaves, false);
        this.setTickRandomly(true);
        this.setStepSound(Block.soundTypeGrass);
    }


    //textures
    @Override
    public void registerBlockIcons(IIconRegister iconRegister){
        textures = new IIcon[2];
        textures[0] = iconRegister.registerIcon("cherrypig:leaves_cherrypig_fancy");
        textures[1] = iconRegister.registerIcon("cherrypig:leaves_cherrypig_fast");
    }

    @Override
    public IIcon getIcon(int side, int meta) {
       return textures[(!isOpaqueCube() ? 0 : 1)];
    }
    @Override
    public boolean isOpaqueCube(){
        return Blocks.leaves.isOpaqueCube();
    }


    @Override
    public boolean isShearable(ItemStack itemStack, IBlockAccess iBlockAccess, int i, int i2, int i3) {
        return false;
    }

    @Override
    public ArrayList<ItemStack> onSheared(ItemStack itemStack, IBlockAccess iBlockAccess, int i, int i2, int i3, int i4) {
        ArrayList<ItemStack> output = new ArrayList<ItemStack>();
        output.add(new ItemStack(this,1,0));
        return output;
    }


}
