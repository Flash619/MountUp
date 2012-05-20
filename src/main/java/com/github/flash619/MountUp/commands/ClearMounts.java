package com.github.flash619.MountUp.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.flash619.MountUp.MountUp;
import com.github.flash619.MountUp.Core.StorageClasses.MountsIndexReference;

public class ClearMounts  implements CommandExecutor {
	public static MountUp plugin;
	public ClearMounts(MountUp plugin){
		ClearMounts.plugin = plugin;
	}
	public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args){
		if(cmd.getName().equalsIgnoreCase("clearmounts")){
            Player player = (Player) sender;
            MountsIndexReference.clearMounts(player);
            return true;
		}
		return false;
	}

}
