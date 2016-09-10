package othlon.cherrypig.worldgen;

import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;

/**
 * Created by Jen on 24/09/2014.
 */
public class CPTreeWorldGen implements IWorldGenerator
{

    public CPTreeWorldGen(){
        genCherryTree = new CPCherryTreeGen(3, false);
    }

    CPCherryTreeGen genCherryTree;
    public static boolean retrogen;

    @Override
    public void generate (Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
    {
        int xSpawn, ySpawn, zSpawn;
        int xPos = chunkX * 16 + 8, zPos = chunkZ * 16 + 8;
        String biomeName = world.getWorldChunkManager().getBiomeGenAt(xPos, zPos).biomeName;

        if (biomeName == null) {
            return;
        }
        if (biomeName == "Forest" || biomeName == "AutumnWoods" || biomeName == "BirchForest" || biomeName == "PineForest" || biomeName == "Rainforest" || biomeName == "TemperateRainforest"
                || biomeName == "Woodlands" || biomeName == "Plains")
        {

                for (int iter = 0; iter < 3; iter++)
                {
                    xSpawn = xPos + random.nextInt(16);
                    ySpawn = random.nextInt(300) + 64;
                    zSpawn = zPos + random.nextInt(16);
                    genCherryTree.generate(world, random, xSpawn, ySpawn, zSpawn);
                }


        }
    }


}
