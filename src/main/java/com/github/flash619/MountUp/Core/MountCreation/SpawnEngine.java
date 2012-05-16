package com.github.flash619.MountUp.Core.MountCreation;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import com.github.flash619.MountUp.MountUp;
import com.github.flash619.MountUp.Core.Events.MountEntitySpawn;
import com.github.flash619.MountUp.Core.StorageClasses.ActiveMountsIndex;
import com.github.flash619.MountUp.Reference.Mounts;

public class SpawnEngine {
	public static MountUp plugin;
	
	public SpawnEngine(MountUp plugin){
		SpawnEngine.plugin = plugin;
	}
	/**
	 * Containment for all active mounts and their respective players.
	 */
    public static Map<String, Object> ActiveMounts = new HashMap<String, Object>();
	/**
	 * @param location Location to spawn the Entity
	 * @param ID Durability ID of the animal entity to spawn. This can also be a separate code depending on the SpawnCode
	 * @param SpawnCode A flag to determine what type of a spawn is taking place, whether from text commands, or eggs, or a special mount.
	 * @param player The player summoning the mount when the SpawnMountEntity was called.
	 */
	public static boolean SpawnMountEntity(Location location, Integer ID, Integer SpawnCode, Player player){
		ActiveMountsIndex AMI = new ActiveMountsIndex();
		String Key = (player.getName());
		if(!ActiveMounts.containsKey(Key)){
			LivingEntity Mount =location.getWorld().spawnCreature(location, Mounts.getMountDurRef(ID));
			AMI.ActiveMount = Mount;
			AMI.MountOwner = player;
			ActiveMounts.put(Key, AMI);
			MountEntitySpawn EntitySpawnEvent = new MountEntitySpawn(Mount,player,location,Key);
			Bukkit.getServer().getPluginManager().callEvent(EntitySpawnEvent);
			//TODO Add the rest of the method...do that....tomorrow.  <jokeing, ha, ha, ha...*facedesk*
			return true;
		}
		return false;
		
	}
	
}
