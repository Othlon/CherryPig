package othlon.cherrypig.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import othlon.cherrypig.CherryPig;
import othlon.cherrypig.tileentities.CPFertileEggTileEntity;

import java.util.Random;

/**
 * Created by Jen on 9/10/2014.
 */
public class CPFertileEgg extends BlockContainer{

    //block bounds
    float minX = 0.4F;
    float minY = 0.0F;
    float minY2 = -0.825F;
    float minZ = 0.4F;

    float maxX = 0.6F;
    float maxY = 0.25F;
    float maxY2 = -0.575F;
    float maxZ = 0.6F;

    public CPFertileEgg(){
        super(Material.dragonEgg);
        this.setHarvestLevel("hoe", 0);
        this.setBlockName("FertileEgg");
        this.setCreativeTab(CherryPig.tabCherryPig);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i){return new CPFertileEggTileEntity();}

    @Override
    public void updateTick( World world, int x, int y, int z, Random random){
        if( !world.isRemote){
            if( world.getBlockLightValue(x, y + 1, z) >= 9 && random.nextInt(7) == 0){

            }
        }
    }

    @Override
    public int getRenderType(){return -1;}

    @Override
    public boolean isOpaqueCube(){ return false;}

    @Override
    public boolean renderAsNormalBlock(){ return false;}
    
    @Override
	public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
    	if(world.getBlock(x, y - 1, z) == CPBlocks.nest){
    		setBlockBounds(minX, minY2, minZ, maxX, maxY2, maxZ);
    	}else{
    		setBlockBounds(minX, minY, minZ, maxX, maxY, maxZ);
    	}
    }
}
