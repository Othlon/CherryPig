package othlon.cherrypig.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import othlon.cherrypig.CherryPig;
import othlon.cherrypig.tileentities.CPNestTileEntity;


public class CPNest extends BlockContainer{

    public CPNest(){
        super(Material.leaves);
        this.setHarvestLevel("hoe", 0);
        this.setBlockName("Nest");
        this.setCreativeTab(CherryPig.tabCherryPig);

    }

    @Override
    public TileEntity createNewTileEntity(World world, int i){return new CPNestTileEntity();}

    @Override
    public int getRenderType(){return -1;}

    @Override
    public boolean isOpaqueCube(){ return false;}

    @Override
    public boolean renderAsNormalBlock(){ return false;}
}
