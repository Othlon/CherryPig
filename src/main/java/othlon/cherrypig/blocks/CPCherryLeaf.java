package othlon.cherrypig.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLeavesBase;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;
import othlon.cherrypig.CherryPig;
import othlon.cherrypig.items.CPItem;

import java.util.ArrayList;
import java.util.Random;


/**
 * Created by Jen on 30/05/14.
 */
public class CPCherryLeaf extends BlockLeavesBase implements IShearable {

    int[] adjacentTreeBlocks;
    private IIcon[] textures;

    public CPCherryLeaf() {

        super(Material.leaves, false);
        this.setTickRandomly(true);
        this.setStepSound(Block.soundTypeGrass);
        this.setCreativeTab(CherryPig.tabCherryPig);
        this.setBlockName("CherryPig Leaves");
    }

    //textures
    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
        textures = new IIcon[2];
        textures[0] = iconRegister.registerIcon("cherrypig:leaves_cherrypig_fancy");
        textures[1] = iconRegister.registerIcon("cherrypig:leaves_cherrypig_fast");
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        return textures[(!isOpaqueCube() ? 0 : 1)];
    }

    @Override
    public boolean isOpaqueCube() {
        return Blocks.leaves.isOpaqueCube();
    }


    @Override
    public boolean isShearable(ItemStack itemStack, IBlockAccess iBlockAccess, int i, int i2, int i3) {
        return false;
    }

    @Override
    public ArrayList<ItemStack> onSheared(ItemStack itemStack, IBlockAccess iBlockAccess, int i, int i2, int i3, int i4) {
        ArrayList<ItemStack> output = new ArrayList<ItemStack>();
        output.add(new ItemStack(this, 1, 0));
        return output;
    }

    @Override
    public boolean shouldSideBeRendered( IBlockAccess world, int x, int y, int z, int fortune)
    {
        return true;
    }


    @Override
    public Item getItemDropped(int metadata, Random rand, int fortune)
    {
        return Item.getItemFromBlock(CPBlocks.cherrySapling);
    }

   @Override
    public void dropBlockAsItemWithChance(World world, int x, int y, int z, int metadata, float chance, int fortune){
        if(world.isRemote)return;


        if(world.rand.nextInt(20) == 0)
        {
            Item item = this.getItemDropped(metadata, world.rand, fortune);
            this.dropBlockAsItem(world, x, y, z, new ItemStack(item, 1, this.damageDropped(metadata)));
        }

        if((metadata & 3) == 3) this.dropBlockAsItem(world, x,y,z, new ItemStack(CPItem.cherryFruit,1 , 0));
        else if ((metadata & 3) == 2 && world.rand.nextInt(8)  == 0) this.dropBlockAsItem(world, x, y, z, new ItemStack(CPItem.cherryFruit,1 , 0));
        else if ((metadata & 3) == 1 && world.rand.nextInt(16) == 0) this.dropBlockAsItem(world, x, y, z, new ItemStack(CPItem.cherryFruit,1 , 0));
        else if ((metadata & 3) == 0 && world.rand.nextInt(32) == 0) this.dropBlockAsItem(world, x, y, z, new ItemStack(CPItem.cherryFruit,1 , 0));


   }

}
