package com.github.flash619.MountUp.Core.Events;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.Location;

public class MountEntitySpawn extends Event{
	
	 private static final HandlerList handlers = new HandlerList();
	    private LivingEntity Mount;
	    private Player Owner;
	    private Location SpawnLocation;
	    private String HashKey;
	    
	    /**
	     * @param entity The mount that was spawned.
	     * @param source The player who spawned it.
	     * @param location The block xyz cordinates of the spawn.
	     * @param Key The key referring to the active mount in the hash map.
	     */
	    public MountEntitySpawn(LivingEntity entity,Player source,Location location,String Key) {
	        Mount = entity;
	        Owner = source;
	        SpawnLocation = location;
	        HashKey = Key;
	    }
	    /**
	     * @return Returns the LivingEntity() of the newly spawned mount.
	     */
	    public LivingEntity getMount() {
	        return Mount;
	    }
	    /**
	     * @return Returns the Player associated in the mount spawn event.
	     */
	    public Player getOwner(){
	    	return Owner;
	    }
	    /**
	     * @return Returns the XYZ location of the spawned mount.
	     */
	    public Location getSpawnLocation(){
	    	return SpawnLocation;
	    }
	    /**
	     * @return Returns the ActiveMounts HashMap Key of the newly ActiveMount.
	     */
	    public String getHashMapKey(){
	    	return HashKey;
	    }
	 
	    public HandlerList getHandlers() {
	        return handlers;
	    }

	    public static HandlerList getHandlerList() {
	        return handlers;
	    }
	}