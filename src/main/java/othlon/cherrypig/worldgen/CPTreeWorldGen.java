package othlon.cherrypig.worldgen;

/**
 * Created by Jen on 24/09/2014.
 */
public class CPTreeWorldGen //implements IWorldGenerator
{

//    public CPTreeWorldGen(){
//        genCherryTree = new CPCherryTreeGen(3, false);
//    }
//
//    CPCherryTreeGen genCherryTree;
//    public static boolean retrogen;
//
//    @Override
//    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, AbstractChunkProvider chunkProvider)
//    {
//        int xSpawn, ySpawn, zSpawn;
//        int xPos = chunkX * 16 + 8, zPos = chunkZ * 16 + 8;
//
//        String biomeName = world.getBiomeForCoordsBody(new BlockPos(xPos, 64, zPos)).getBiomeName();;
//
//        if (biomeName == null) {
//            return;
//        }
//        if (biomeName == "Forest" || biomeName == "AutumnWoods" || biomeName == "BirchForest" || biomeName == "PineForest" || biomeName == "Rainforest" || biomeName == "TemperateRainforest"
//                || biomeName == "Woodlands" || biomeName == "Plains")
//        {
//
//                for (int iter = 0; iter < 3; iter++)
//                {
//                    xSpawn = xPos + random.nextInt(16);
//                    ySpawn = random.nextInt(300) + 64;
//                    zSpawn = zPos + random.nextInt(16);
//                    genCherryTree.generate(world, random, new BlockPos(xSpawn, ySpawn, zSpawn));
//                }
//
//
//        }
//    }


}
