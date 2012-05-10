package com.github.flash619.MountUp.commands;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.flash619.MountUp.MountUp;

public class IgnoreMounts implements CommandExecutor {
	
	public static MountUp plugin;
	
	public IgnoreMounts(MountUp plugin){
	}
	
	public static Map<Player, Boolean> IgnoreMounts = new HashMap<Player, Boolean>();
	
	public static boolean IsIgnoring(Player player){          //Returns if a player is in the ignore list
		if(IgnoreMounts.containsKey(player)){
			return true;
		}else{
			return false;
		}
	}
	public static void AddIgnoring(Player player){           //Adds the requested player to the ignore list
		if(!IgnoreMounts.containsKey(player)){
			IgnoreMounts.put(player, true);
		}
	}
	public static void RemoveIgnoring(Player player){       //Removes the requested player from the ignore list.
		if(IgnoreMounts.containsKey(player)){
			IgnoreMounts.remove(player);
		}
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String buyflight, String[] args){      //COMMAND: Listens for /ignoremounts if called, toggles the ignore on the spawn eggs.
		if(cmd.getName().equalsIgnoreCase("IgnoreMounts")){
			if(args.length==0){
				Player player = (Player) sender;
				if(IsIgnoring(player)){
					    RemoveIgnoring(player);
						sender.sendMessage(ChatColor.DARK_PURPLE + "[INFO]" + ChatColor.GOLD + "You are no longer ignoring mounts, spawn eggs will summon a mount if you don't have a mount of that kind yet. Use "+ChatColor.DARK_PURPLE+"/IgnoreMounts "+ChatColor.GOLD+"again to toggle this ability.");
						return true;
				}else{
						AddIgnoring(player);
						sender.sendMessage(ChatColor.DARK_PURPLE + "[INFO]" + ChatColor.GOLD + "You are now ignoring mounts, spawn eggs will work as they normally do. Use "+ChatColor.DARK_PURPLE+"/IgnoreMounts "+ChatColor.GOLD+"again to toggle this ability.");
						return true;
				}
			}else{
				return false;
			}
		}
		return false;
		
	}

}
