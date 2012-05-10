package com.github.flash619.MountUp.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.github.flash619.MountUp.MountUp;
import com.github.flash619.MountUp.conf.PlayerLink;

public class Login implements Listener{
	
	public static MountUp plugin;
	public Login(MountUp plugin){
		Login.plugin = plugin;
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onLogin(PlayerJoinEvent event){ //
		Player PlayerRaw = event.getPlayer();   //Finds if a player is listed in the player.yml, if not it adds them.
		String player = PlayerRaw.getName();    ///
		if(!PlayerLink.ContainsPlayer(player)){
			PlayerLink.addPlayer(player);
		}
	}
	

}
