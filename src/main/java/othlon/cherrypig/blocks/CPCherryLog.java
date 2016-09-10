package othlon.cherrypig.blocks;

import net.minecraft.block.BlockLog;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import othlon.cherrypig.CherryPig;


public class CPCherryLog extends BlockLog {
    @SideOnly(Side.CLIENT)
    IIcon logIcon;
    IIcon logIconTopBtm;

    public CPCherryLog() {
        this.setHardness(2.0F);
        this.setHarvestLevel("axe", 0);
        this.setResistance(5.0F);
        this.setStepSound(soundTypeWood);
        this.setBlockName("cherrylog");
        this.setCreativeTab(CherryPig.tabCherryPig);

    }


    @Override
    public void registerBlockIcons(IIconRegister thisdude) {
        logIcon       = thisdude.registerIcon("cherrypig:cherrypig_treebark");
        logIconTopBtm = thisdude.registerIcon("cherrypig:cherrypig_treelog");
    }


    @Override
    @SideOnly(Side.CLIENT)
    protected IIcon getSideIcon(int meta)
    {
        return this.logIcon;
    }

    @Override
    @SideOnly(Side.CLIENT)
    protected IIcon getTopIcon(int meta)
    {
        return this.logIconTopBtm;
    }

    @Override
    public boolean isWood(IBlockAccess world, int x, int y, int z)
    {
        return true;
    }

}
