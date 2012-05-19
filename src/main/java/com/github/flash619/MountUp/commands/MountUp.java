package com.github.flash619.MountUp.commands;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.flash619.MountUp.Core.SummonMount;
import com.github.flash619.MountUp.Core.MountCreation.SpawnEngine;
import com.github.flash619.MountUp.Core.StorageClasses.ActiveMountsIndex;
import com.github.flash619.MountUp.Reference.Mounts;
import com.github.flash619.MountUp.conf.PlayerLink;

public class MountUp implements CommandExecutor {
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
				     	player.sendMessage(ChatColor.GOLD+"========================");
				     	player.sendMessage(ChatColor.DARK_PURPLE+"[ActiveMount]:");
				     	player.sendMessage(ChatColor.BLUE+PlayerIndex.ActiveMount.getType().getName());
					}
				     player.sendMessage(ChatColor.GOLD+"========================");
				     player.sendMessage(ChatColor.DARK_PURPLE+"[AvailableMounts]:");
				     ArrayList<Integer> AvailableMountsIds = com.github.flash619.MountUp.conf.PlayerLink.GetOwnedMounts(player.getName());
				     ArrayList<String>AvailableMounts = Mounts.getMountNames(AvailableMountsIds);
				     for(int i=0;i<AvailableMounts.size();i++){
				    	 player.sendMessage(ChatColor.BLUE+AvailableMounts.get(i));
				     }
				     player.sendMessage(ChatColor.GOLD+"========================");
				     return true;
			}else if(args[0].equalsIgnoreCase("info")){
				 player.sendMessage(ChatColor.DARK_PURPLE+"[MountUp] "+ChatColor.GOLD+"Version: "+ChatColor.RED+com.github.flash619.MountUp.MountUp.getVersion());
				 player.sendMessage(ChatColor.DARK_PURPLE+"By, Flash619");
			}else if(args.length>0&&args.length<2){
				String Name = args[0];
				Integer ID = Mounts.getMountID(Name);
				if(ID!=null){
						Location l = player.getLocation();
						SummonMount.startMount(player, ID, l);
						return true;
				}
			}
		}
		return false;
	}

}
