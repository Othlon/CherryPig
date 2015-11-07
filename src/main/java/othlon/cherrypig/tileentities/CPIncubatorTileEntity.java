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
    private int hatchTime = 2;

    private boolean going= false;


    private IInventory invtenory;
    public CPIncubatorTileEntity() {

        this.maxEggs   = 3;
        this.eggTimers = hatchTime;

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
        if(eggTimers == hatchTime) {
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
    @Override
    public void updateEntity()
    {

        double d1 = (double)this.xCoord + 0.5D;
        double d2 = (double)this.zCoord + 0.5D;

        if(this.going == true){

            //when egg timer (time it was added + 10) is the same as world time...
            if(eggTimers == worldObj.getWorldTime()){
                //set the timer back to one
                eggTimers = hatchTime;

                //pop out a chick
                if (!worldObj.isRemote) {
                    spawnCreature(this.xCoord, this.yCoord + 1D, this.zCoord);

                    //play a pop!
                    this.worldObj.playSoundEffect(this.xCoord, this.yCoord + 1D, this.zCoord , "random.pop", 0.2F, (0.5F * 0.7F + 1.0F) * 2.0F);

                    // this.worldObj.playSound(0.5D , "random.pop", 0.2F, ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.7F + 1.0F) * 2.0F);
                     }

                //turn incubator off
                floopOff();//should turn off flames after spawning a chick
            }

        }//if going
    }


    private void placeEgg(){

    }


    private Entity spawnCreature(double x, double y, double z)
    {
        int iAge = -12000;
        CPEntityChook chook = new CPEntityChook(worldObj);
        chook.setPosition(x, y, z);
        chook.setGrowingAge(iAge);
        worldObj.spawnEntityInWorld(chook);
        return chook;
    }


}
