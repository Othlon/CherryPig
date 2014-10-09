package othlon.cherrypig.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import othlon.cherrypig.CherryPig;
import othlon.cherrypig.tileentities.CPFirtileEggTileEntity;

/**
 * Created by Jen on 9/10/2014.
 */
public class CPFirtileEgg extends BlockContainer{

    //block bounds
    float minX = 0.4F;
    float minY = 0.0F;
    float minZ = 0.4F;

    float maxX = 0.6F;
    float maxY = 0.25F;
    float maxZ = 0.6F;

    public CPFirtileEgg(){
        super(Material.dragonEgg);
        this.setHarvestLevel("hoe", 0);
        this.setBlockName("FirtileEgg");
        this.setCreativeTab(CherryPig.tabCherryPig);
        this.setBlockBounds(minX,minY,minZ,maxX,maxY,maxZ);


    }

    @Override
    public TileEntity createNewTileEntity(World world, int i){return new CPFirtileEggTileEntity();}

    @Override
    public int getRenderType(){return -1;}

    @Override
    public boolean isOpaqueCube(){ return false;}

    @Override
    public boolean renderAsNormalBlock(){ return false;}
}
