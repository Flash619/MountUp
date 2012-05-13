package com.github.flash619.MountUp.listeners;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import com.github.flash619.MountUp.MountUp;
import com.github.flash619.MountUp.Reference.Mounts;
import com.github.flash619.MountUp.commands.IgnoreMounts;
import com.github.flash619.MountUp.conf.PlayerLink;

public class SpawnEggThrow implements Listener{
	
	public static MountUp plugin;
	
	public SpawnEggThrow(MountUp plugin){
		SpawnEggThrow.plugin = plugin;
	}
	@EventHandler(priority = EventPriority.HIGHEST)                         //Catch egg usage event.
	public void onThrow(PlayerInteractEvent event){                         //Check to see if the player is using a mob egg
		Player player=event.getPlayer();                                    //Check to see if its valid "in the list of mount eggs
		if (player.getItemInHand().getType() == Material.MONSTER_EGG) {     //Get the target block for spawn
		if(!IgnoreMounts.IsIgnoring(player)){                               //Make sure its within the proper radius of 3
		    if(IsValidEgg(player)){                                         //start other class functions.
		    Block Target = player.getTargetBlock(null, 2);                  //If the mount is not valid for the spawn egg, or the player already has it, the egg will work as normal.
		    double Distance = player.getLocation().distance(Target.getLocation());
		    	if(!Target.equals(null)){
		    		if(Distance<=2){
		    			String PlayerName = player.getName();
		    			Short ID = player.getItemInHand().getDurability();
		    			Integer IDI = ID.intValue();
		    			PlayerLink.addPlayerMount(PlayerName, IDI);
		    			//TODO Link to the outside classes for mount creation.
		    			event.setCancelled(true);
		    		}else{
		    			event.setCancelled(true);
		    		}
		    	}
		    }
		}
		}
		
	}
	/**
	 * @param player The player who used the egg.
	 * Checks to see if the egg is in the Mounts list, also returns false if the player already has it in the player.yml
	 */
	public boolean IsValidEgg(Player player){
		    String PlayerName = player.getName();
			Short ID = player.getItemInHand().getDurability();
			Integer IDI = ID.intValue();
			System.out.println(IDI);
			//if(Permissions.hasEggPerm(player, IDI)){ //TODO Remove the commented permission nodes upon release.
			for(Integer i=0;i<Mounts.Mounts.length;i++){
				if(IDI==Mounts.Mounts[i]){
					if(!PlayerLink.PlayerHasMount(PlayerName, IDI)){
					return true;
					}else{
					return false;
					}
				}
			}
			return false;
			//}else{
			//	return false;
			//}
	}

}
