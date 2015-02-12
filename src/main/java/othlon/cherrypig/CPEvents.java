package othlon.cherrypig;

/**
 * Created by Jen on 29/01/2015.
 */

import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.passive.EntityChicken;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

import net.minecraftforge.event.entity.player.EntityInteractEvent;

import othlon.cherrypig.items.CPItem;

public class CPEvents {

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onEntityLoaded(EntityJoinWorldEvent event) {
        /* Make chickens take forever to lay eggs */
        if (event.entity instanceof EntityChicken) {

            ((EntityChicken) event.entity).timeUntilNextEgg = Integer.MAX_VALUE;
        }

    }

    @SubscribeEvent
    public void onEntityInteract(EntityInteractEvent event)
    {
        //if interacting with a chicken
        if (event.target instanceof EntityChicken) {

            EntityPlayer   player = event.entityPlayer;
            ItemStack        held = player.getCurrentEquippedItem();
            EntityChicken chicken = (EntityChicken) event.target;

            //if player holding an item
            if (held != null) {
                if (player.worldObj.isRemote) {
                    Item item = held.getItem();
                    //and the item is one of the following
                    if (item == Items.melon_seeds || item == Items.pumpkin_seeds || item == Items.wheat_seeds || item == CPItem.chickenfeed) {
                        //then do stuff!

                        chicken.dropItem(Items.egg, 1);
                    }
                }
            }
             // if (chicken instanceof EntityChicken) {
            //     chicken.ridingEntity  = player;
            //     player.riddenByEntity = chicken;
            // }


        }

    }

   /* @SubscribeEvent
    public void onEntityUpdate( Living mateEvent){
        EntityChicken chicken = (EntityChicken)mateEvent;

        EntityAIMate theAnimal = (EntityAIMate)mateEvent.theAnimal;
        if(mateEvent.theAnimal == chicken) {
            chicken.createChild(null).dropItem(Items.egg, 1);
        }
    }*/
}
