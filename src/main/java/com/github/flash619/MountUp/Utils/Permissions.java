package com.github.flash619.MountUp.Utils;

import org.bukkit.entity.Player;

import com.github.flash619.MountUp.MountUp;
import com.github.flash619.MountUp.Core.StorageClasses.MountsTable.MountInfo;

public class Permissions {
	public static MountUp plugin;
	public Permissions(MountUp plugin){
		Permissions.plugin = plugin;
	}
	/**
	 * @param player The player who's permissions will be checked.
	 * @param ID The ID of the mount.
	 * @return True or false for Has or does not have permissions.
	 */
	public static boolean hasEggPerm(Player player,Integer ID){//returns if a player has the permissions for the specified egg. 
		if(MountInfo.isValidID(ID)){
		String PermissionString = ("MountUp.EggSpawn."+ID);
		if(player.hasPermission(PermissionString)){
			return true;
		}else{
			return false;
		}
		}else{
			return false;
		}
	}
}
