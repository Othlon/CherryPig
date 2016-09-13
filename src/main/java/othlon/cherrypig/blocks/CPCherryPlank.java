package othlon.cherrypig.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import othlon.cherrypig.CherryPig;

public class CPCherryPlank extends Block
{
    public CPCherryPlank(){
        super(Material.WOOD);
        this.setHarvestLevel("axe", 0);
        this.setSoundType(SoundType.WOOD);
        this.setCreativeTab(CherryPig.tabCherryPig);
    }

    @Override
    public String getUnlocalizedName()
    {
        return "tile." + getRegistryName();
    }
}
