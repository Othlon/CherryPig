package othlon.cherrypig.tileentities;

import net.minecraft.inventory.IInventory;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by Jen on 23/01/2015.
 */
public class CPIncubatorTileEntity extends TileEntity {

    //max eggs in incubator
    private int maxEggs;
    //list of egg times
    private long eggTimers[];
    private boolean going= false;

    private IInventory invtenory;
    public CPIncubatorTileEntity() {

        this.maxEggs = 3;
        for(int i = 1; i == maxEggs; i++){  this.eggTimers[i] = 0; }

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

    public long getEggTimers(int eggNum)
    {
        return eggTimers[eggNum];
    }

    public void setiEggTimers(int eggNumListPos, World world)
    {
        eggTimers[eggNumListPos] = world.getWorldTime();
    }

    /*~~~~~~~~~~~~Feedback~~~~~~~~~~~~~*/
    public boolean getFeedBack()
    {
      boolean result = (this.maxEggs > 0) ? true : false;
        return result;
    }
/*~~~~~~going*******/

    public boolean getGoingStatus(){
        return this.going;
    }

/*~~~~~~~~~~~~~~~~~~~~Floop the bool~~~~~~~~~~~~*/
    public void floop(){
       if(going == true)
           going = false;
       else if(going == false)
            going = true;
    }
    //Logic for the actual block is under here
    /*@Override
    public void updateEntity(){


    }*/


}
