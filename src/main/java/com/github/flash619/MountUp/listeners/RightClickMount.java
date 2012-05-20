package com.github.flash619.MountUp.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import com.github.flash619.MountUp.MountUp;
import com.github.flash619.MountUp.Core.Events.MountDown;
import com.github.flash619.MountUp.Core.StorageClasses.ActiveMountsIndex;
import com.github.flash619.MountUp.Core.StorageClasses.MountsIndexReference;

public class RightClickMount implements Listener{
	public static MountUp plugin;
	public RightClickMount(MountUp plugin){
		RightClickMount.plugin=plugin;
	}
	@EventHandler(priority = EventPriority.HIGH)
	void onClick(PlayerInteractEntityEvent event){
		Player player = event.getPlayer();
		if(MountsIndexReference.containsKey(player)){
			player.getTargetBlock(null, 2);
			Entity RightClickedEntity = event.getRightClicked();
			Entity Mount = player.getVehicle();
			ActiveMountsIndex PlayerIndex = MountsIndexReference.getPAMI(player);
			if(Mount!=null){
				if(RightClickedEntity==Mount){
					PlayerIndex.ActiveMount.eject();
					player.sendMessage(ChatColor.DARK_PURPLE+"INFO: "+ChatColor.GOLD+"You have been dismounted.");
					MountDown PlayerMountDown = new MountDown(PlayerIndex.ActiveMount,player);
					Bukkit.getServer().getPluginManager().callEvent(PlayerMountDown);
				}
			}else{
				if(RightClickedEntity.getEntityId()==PlayerIndex.ActiveMount.getEntityId()){
					PlayerIndex.ActiveMount.setPassenger(player);
					player.sendMessage(ChatColor.DARK_PURPLE+"INFO: "+ChatColor.GOLD+"You hop back on your mount...");
					com.github.flash619.MountUp.Core.Events.MountUp PlayerMountUp = new com.github.flash619.MountUp.Core.Events.MountUp(PlayerIndex.ActiveMount,player);
					Bukkit.getServer().getPluginManager().callEvent(PlayerMountUp);
				}
			}
		}
	}

}
