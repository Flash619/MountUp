package com.github.flash619.MountUp.Core;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import com.github.flash619.MountUp.MountUp;
import com.github.flash619.MountUp.Core.MountCreation.SpawnEngine;

public class SummonMount {
	public static MountUp plugin;
	
	public SummonMount(MountUp plugin){
		SummonMount.plugin = plugin;
	}
	/**
	 * @param player The player spawning the mount.
	 * @param mount Durability ID of the animal entity to spawn. If this is a specialty ID use it normally but with the specialty ID instead.
	 * @param location Location to spawn the Entity. Forwarded to SpawnEngine
	 */
	public static void startMount(Player player,Integer mount,Location location){
			if(SpawnEngine.SpawnMountEntity(location, mount, 1, player)){
				player.sendMessage("Mount spawned successfully!");
			}else{
				player.sendMessage("Sorry, but there was an error. Do you already have a active mount?");
			//TODO Finish the rest of the StartMount, connect to the Spawn Engine add scheduled events.
		}
	}
}
