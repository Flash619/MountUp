package com.github.flash619.MountUp.listeners;

import org.bukkit.entity.Egg;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

import com.github.flash619.MountUp.MountUp;

public class SpawnEggThrow implements Listener{
	
	public static MountUp plugin;
	
	public SpawnEggThrow(MountUp plugin){
		SpawnEggThrow.plugin = plugin;
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onThrow(CreatureSpawnEvent event){
		if(event.getSpawnReason().equals("SPAWNER_EGG")){
			
			event.getEntity()
		}
		String Eggy = eggtype.toString();
		player
	}

}
