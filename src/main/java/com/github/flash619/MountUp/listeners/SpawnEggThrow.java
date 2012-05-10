package com.github.flash619.MountUp.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import Utils.Permissions;

import com.github.flash619.MountUp.MountUp;
import com.github.flash619.MountUp.Reference.Mounts;
import com.github.flash619.MountUp.commands.IgnoreMounts;

public class SpawnEggThrow implements Listener{
	
	public static MountUp plugin;
	
	public SpawnEggThrow(MountUp plugin){
		SpawnEggThrow.plugin = plugin;
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onThrow(PlayerInteractEvent event){
		Player player=event.getPlayer();
		if (player.getItemInHand().getType() == Material.MONSTER_EGG) {
		if(!IgnoreMounts.IsIgnoring(player)){
		    if(IsValidEgg(player)){
		    	//TODO Link to second stage mount creation events.
		    }
		}
		}
		
	}
	public boolean IsValidEgg(Player player){
			Short ID = player.getItemInHand().getDurability();
			Integer IDI = ID.intValue();
			System.out.println(IDI);
			//if(Permissions.hasEggPerm(player, IDI)){ //TODO Remove the commented permission nodes upon release.
			for(Integer i=0;i<Mounts.Mounts.length;i++){
				if(IDI==Mounts.Mounts[i]){
					return true;
				}
			}
			return false;
			//}else{
			//	return false;
			//}
	}

}
