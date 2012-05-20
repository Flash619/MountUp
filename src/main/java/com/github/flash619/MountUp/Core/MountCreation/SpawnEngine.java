package com.github.flash619.MountUp.Core.MountCreation;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import com.github.flash619.MountUp.MountUp;
import com.github.flash619.MountUp.Core.Events.MountEntitySpawn;
import com.github.flash619.MountUp.Core.StorageClasses.MountsIndexReference;
import com.github.flash619.MountUp.Reference.Mounts;

public class SpawnEngine {
	public static MountUp plugin;
	
	public SpawnEngine(MountUp plugin){
		SpawnEngine.plugin = plugin;
	}
	/**
	 * @param location Location to spawn the Entity
	 * @param ID Durability ID of the animal entity to spawn. This can also be a separate code depending on the SpawnCode
	 * @param SpawnCode A flag to determine what type of a spawn is taking place, whether from text commands, or eggs, or a special mount.
	 * @param player The player summoning the mount when the SpawnMountEntity was called.
	 */
	public static boolean SpawnMountEntity(Location location, Integer ID, Integer SpawnCode, Player player){
		if(!MountsIndexReference.containsKey(player)){
			LivingEntity Mount = location.getWorld().spawnCreature(location, Mounts.getMountDurRef(ID));
			Mount.setPassenger(player);
			MountsIndexReference.addEntry(player, Mount);
			MountEntitySpawn EntitySpawnEvent = new MountEntitySpawn(Mount,player,location,player.getName());
			Bukkit.getServer().getPluginManager().callEvent(EntitySpawnEvent);
			//TODO ADD a listener to listen for entity death, if the entity = a mount entity ID go ahead and remove the entity and player key from the hash map ahead of time.
			return true;
		}
		return false;
		
	}
	public static boolean isValidSpawnTarget(Block target){
    	Block Target1 = target.getRelative(0, +1, 0);
    	Block Target2 = Target1.getRelative(0, +1, 0);
    	if(Target1.getType().equals(Material.AIR)&&Target2.getType().equals(Material.AIR)){
    		return true;
    	}else{
    		return false;
    	}
	}
	
}
