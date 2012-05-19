/**
 * @author Flash619
 * (C)2012 Licensed under the GNU Lesser General Public License v3
 */
package com.github.flash619.MountUp.listeners.MountRelated;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTargetEvent;

import com.github.flash619.MountUp.MountUp;
import com.github.flash619.MountUp.Core.MountCreation.SpawnEngine;
import com.github.flash619.MountUp.Core.StorageClasses.ActiveMountsIndex;



public class MountInteractionDetection implements Listener{
	public static MountUp plugin;
	public MountInteractionDetection(MountUp plugin){
		MountInteractionDetection.plugin=plugin;
	}
	@EventHandler(priority = EventPriority.MONITOR)
	public void InteractAggroMob(EntityTargetEvent event){
			final EntityTargetEvent realEvent = (EntityTargetEvent) event;
			if(realEvent.getTarget() instanceof Player){
			Player[] PlayerList = Bukkit.getServer().getOnlinePlayers();
			for(int i=0;i<PlayerList.length;i++){
				if(SpawnEngine.ActiveMounts.containsKey(PlayerList[i].getName())){
					ActiveMountsIndex PlayerIndex = (ActiveMountsIndex) SpawnEngine.ActiveMounts.get(PlayerList[i].getName());
					if(realEvent.getEntity().getEntityId()==PlayerIndex.ActiveMount.getEntityId()){
						event.setCancelled(true);
					}
				}
			}
		}
	}
	/*public void onMountDamageEntity(EntityTargetEvent event){
		if(event.getTarget() instanceof Player){
			Entity Targeter = event.getEntity();
			Integer ID = Targeter.getEntityId();
			Player[] PlayerList = Bukkit.getServer().getOnlinePlayers();
			for(int i=0;i<PlayerList.length;i++){
				if(SpawnEngine.ActiveMounts.containsKey(PlayerList[i])){
					ActiveMountsIndex PlayerIndex = (ActiveMountsIndex) SpawnEngine.ActiveMounts.get(PlayerList[i]);
					if(ID==PlayerIndex.ActiveMount.getEntityId()){
						event.setCancelled(true);
					}
				}
			}
		}
	}*/

}
