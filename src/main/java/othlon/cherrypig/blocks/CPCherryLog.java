package othlon.cherrypig.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * Created by Jen on 30/05/14.
 */
public class CPCherryLog extends Block{

   public CPCherryLog()
   {

       //material
       super(Material.wood);
        //step sound
       setStepSound(soundTypeWood);
       //creative tab
       setBlockTextureName("cherrypig:cherrypig_treebark");
       //set unlocalised name
       setBlockName("CherryPig Log");

   }

}
