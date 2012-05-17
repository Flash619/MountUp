package com.github.flash619.MountUp.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.flash619.MountUp.Core.MountCreation.SpawnEngine;
import com.github.flash619.MountUp.Core.StorageClasses.ActiveMountsIndex;
import com.github.flash619.MountUp.conf.PlayerLink;

public class MountUp {
	public static PlayerLink PlayerLink;
	public static com.github.flash619.MountUp.MountUp plugin;
	public MountUp(com.github.flash619.MountUp.MountUp plugin){
		MountUp.plugin=plugin;
		MountUp.PlayerLink = new PlayerLink(plugin);
	}
	public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args){
		if(cmd.getName().equalsIgnoreCase("mountup")){
			Player player = (Player) sender;
			if(args.length==0){
				if(SpawnEngine.ActiveMounts.containsKey(player.getName())){
				     ActiveMountsIndex PlayerIndex = (ActiveMountsIndex) SpawnEngine.ActiveMounts.get(player.getName());
				    //TODO move to info. player.sendMessage(ChatColor.DARK_PURPLE+"[MountUp] "+ChatColor.GOLD+"Version: "+ChatColor.RED+com.github.flash619.MountUp.MountUp.getVersion());
				     player.sendMessage(ChatColor.GOLD+"========================");
				     player.sendMessage(ChatColor.DARK_PURPLE+"[ActiveMount]:");
				     player.sendMessage(ChatColor.DARK_PURPLE+PlayerIndex.ActiveMount.getType().getName());
				     player.sendMessage(ChatColor.GOLD+"========================");
				     player.sendMessage(ChatColor.DARK_PURPLE+"[AvailableMounts]:");
				     player.sendMessage(ChatColor.DARK_PURPLE+PlayerIndex.ActiveMount.getType().getName());
				}
			}
		}
		return false;
	}

}
