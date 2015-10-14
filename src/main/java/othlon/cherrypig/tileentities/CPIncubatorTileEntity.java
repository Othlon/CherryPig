package othlon.cherrypig.tileentities;

import net.minecraft.entity.Entity;
import net.minecraft.inventory.IInventory;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import othlon.cherrypig.entity.CPEntityChook;

/**
 * Created by Jen on 23/01/2015.
 */
public class CPIncubatorTileEntity extends TileEntity {

    //max eggs in incubator
    private int maxEggs;
    //list of egg times
    private long eggTimers;

    private boolean going= false;


    private IInventory invtenory;
    public CPIncubatorTileEntity() {

        this.maxEggs   = 3;
        this.eggTimers = 1;

    }

    public void readFromNBT(NBTTagCompound nbt)
    {

        super.readFromNBT(nbt);
    }


    public void writeToNBT(NBTTagCompound nbt)
    {

        super.writeToNBT(nbt);

    }

    @Override
    public Packet getDescriptionPacket()
    {

        NBTTagCompound tileTag = new NBTTagCompound();
        this.writeToNBT(tileTag);
        return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 3, tileTag);

    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt)
    {
        this.readFromNBT(pkt.func_148857_g());
    }


 /*~~~~~~~~~~~~~Max Egg # Setters and Getters~~~~~~~~~~~~~~~*/

    public int  getMaxEggs()           { return maxEggs;   }

    public void setMaxEggs(int newNum) { maxEggs = newNum; }




/*~~~~~~~~~~~~~Egg Timer Setters and Getters~~~~~~~~~~~~~~~*/

  /*  public long getEggTimers(int eggNum)
    {
        return eggTimers[eggNum];
    }

    public void setiEggTimers(int eggNumListPos, World world)
    {
        eggTimers[eggNumListPos] = world.getWorldTime();
    }*/

    public boolean addAnEgg(World world)
    {
        if(eggTimers == 10) {
            eggTimers += world.getWorldTime();
            return true;
        } else {
            return false;
        }
    }


/*~~~~~~going*******/

    public boolean getGoingStatus(){
        return this.going;
    }


/*~~~~~Floop the bool~~~~~~~~~~~~*/
    public void floopOn(){
        if(going == false)
            going = true;
    }
    public void floopOff(){
        if(going == true)
            going = false;
    }
    //Logic for the actual block is under here
    public void updateEntity(World world)
    {
        if(going){
            if(eggTimers == world.getWorldTime()){
                eggTimers = 1;
                spawnCreature(world, this.xCoord + 0.5D, this.yCoord + 0.5D, this.zCoord + 0.5D);
                floopOff();//should turn off flames after spawning a chick

            }
        }
    }


    private Entity spawnCreature(World world, double x, double y, double z)
    {
        int iAge = -12000;
        CPEntityChook chook = new CPEntityChook(world);
        chook.setPosition(x, y, z);
        chook.setGrowingAge(iAge);
        world.spawnEntityInWorld(chook);
        return chook;
    }

}
