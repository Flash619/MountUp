package com.github.flash619.MountUp.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.flash619.MountUp.MountUp;
import com.github.flash619.MountUp.Core.Events.MountDown;
import com.github.flash619.MountUp.Core.MountCreation.SpawnEngine;
import com.github.flash619.MountUp.Core.StorageClasses.ActiveMountsIndex;

public class ClearMounts  implements CommandExecutor {
	public static MountUp plugin;
	public ClearMounts(MountUp plugin){
		ClearMounts.plugin = plugin;
	}
	public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args){
		if(cmd.getName().equalsIgnoreCase("clearmounts")){
			Player player = (Player) sender;
			if(SpawnEngine.ActiveMounts.containsKey(player.getName())){
				ActiveMountsIndex PlayerIndex = (ActiveMountsIndex) SpawnEngine.ActiveMounts.get(player.getName());
				if(!PlayerIndex.ActiveMount.isDead()){
						if(PlayerIndex.ActiveMount.getPassenger()!=null){
					        PlayerIndex.ActiveMount.eject();
							MountDown PlayerMountDown = new MountDown(PlayerIndex.ActiveMount,player);
							Bukkit.getServer().getPluginManager().callEvent(PlayerMountDown);
						}
					PlayerIndex.ActiveMount.remove();
					SpawnEngine.ActiveMounts.remove(player.getName());
					player.sendMessage(ChatColor.DARK_PURPLE+"INFO: "+ChatColor.GOLD+"Your mount was put away for now.");
					return true;
				}else{
					 SpawnEngine.ActiveMounts.remove(player.getName());
					 player.sendMessage(ChatColor.DARK_PURPLE+"INFO: "+ChatColor.GOLD+"Your mount must have been de-spawned or killed, and has been reset.");
					 return true;
				}
			}else{
				player.sendMessage(ChatColor.DARK_PURPLE+"INFO: "+ChatColor.GOLD+"You don't have any active mounts.");
				return true;
			}
		}
		return false;
	}

}
