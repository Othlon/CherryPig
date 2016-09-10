package othlon.cherrypig.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import othlon.cherrypig.CherryPig;

/**
 * Created by Jen on 29/11/2014.
 */
public class CPCharcoalBlock extends Block {

    public CPCharcoalBlock(){
        super(Material.ROCK);

        this.setHardness(5.0F);
        this.setResistance(10.0F);
        this.setSoundType(SoundType.STONE);
        this.setCreativeTab(CherryPig.tabCherryPig);
    }

    @Override
    public String getUnlocalizedName()
    {
        return "tile." + getRegistryName();
    }
}
