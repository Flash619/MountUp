package com.github.flash619.MountUp.listeners;

import java.util.logging.Logger;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

import com.github.flash619.MountUp.MountUp;
import com.github.flash619.MountUp.Core.Events.MountEntitySpawn;
import com.github.flash619.MountUp.conf.ConfigLink;

public class MountSpawn implements Listener{
	public static ConfigLink Config;
	public static MountUp plugin;
	public MountSpawn(MountUp plugin){
		MountSpawn.plugin = plugin;
	    MountSpawn.Config = new ConfigLink(plugin);
	}
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onSpawn(MountEntitySpawn event){
		String PlayerName = event.getOwner().getName();
		String Location = event.getSpawnLocation().toString();
			if(Config.isVerboseEnabled()){
				Logger log = plugin.getLogger();
				log.info("Player: "+PlayerName+" Spawned a mount entity at: "+Location);
			}
		
	}

}
