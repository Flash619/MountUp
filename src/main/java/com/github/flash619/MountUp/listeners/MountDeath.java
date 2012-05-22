/**
 * @author Flash619
 * (C)2012 Licensed under the GNU Lesser General Public License v3
 */
package com.github.flash619.MountUp.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import com.github.flash619.MountUp.MountUp;
import com.github.flash619.MountUp.Core.StorageClasses.MountsIndexReference;

/**
 * @author travis
 *
 */
public class MountDeath implements Listener {
	public static MountUp plugin;
	public MountDeath(MountUp plugin){
		MountDeath.plugin=plugin;
	}
	@EventHandler(priority = EventPriority.HIGH)
	public void onEntityDeath(EntityDeathEvent event){
		Entity DyingEntity = event.getEntity();
		Integer EntityID = DyingEntity.getEntityId();
		if(MountsIndexReference.isMountID(EntityID, null)){
			Player MountOwner = MountsIndexReference.getMountOwner(EntityID);
			MountOwner.sendMessage(ChatColor.DARK_PURPLE+"[INFO]: "+ChatColor.GOLD+"Your mount died! Use /mountup to spawn another!");
			MountsIndexReference.removeActiveMount(EntityID, null);
		}
	}

}
