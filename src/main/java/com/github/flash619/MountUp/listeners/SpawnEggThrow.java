package com.github.flash619.MountUp.listeners;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import com.github.flash619.MountUp.MountUp;
import com.github.flash619.MountUp.Core.SummonMount;
import com.github.flash619.MountUp.Reference.Mounts;
import com.github.flash619.MountUp.commands.IgnoreMounts;
import com.github.flash619.MountUp.conf.PlayerLink;

public class SpawnEggThrow implements Listener{
	
	public static MountUp plugin;
	
	public SpawnEggThrow(MountUp plugin){
		SpawnEggThrow.plugin = plugin;
	}
	/**
	 * @param event The event object taking place.
	 * Catch egg usage event,
	 * Check to see if the player is using a mob egg,
	 * Get the target block for spawn,
	 * start other class functions for starting the mount spawn system,
	 * If the mount is not valid for the spawn egg, or the player already has it, the egg will work as normal,
	 */
	@EventHandler(priority = EventPriority.HIGHEST)                        
	public void onThrow(PlayerInteractEvent event){                        
		Player player=event.getPlayer();                                  
		if (player.getItemInHand().getType() == Material.MONSTER_EGG) { 
		if(!IgnoreMounts.IsIgnoring(player)){                               
		    if(IsValidEgg(player)){           
		    	Block Target = player.getTargetBlock(null, 2);
		    	Double Dist = player.getLocation().distance(Target.getLocation());
		    		if(Dist<=2){
		    			Location SpawnLoc = Target.getLocation();
		    			String PlayerName = player.getName();
		    			Short ID = player.getItemInHand().getDurability();
		    			Integer IDI = ID.intValue();
		    			PlayerLink.addPlayerMount(PlayerName, IDI);
		    			SummonMount.startMount(player, IDI, SpawnLoc);
		    			event.setCancelled(true);
		    		}else{
		    			event.setCancelled(true);
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
