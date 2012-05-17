package com.github.flash619.MountUp.Core.Events;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class MountUp extends Event{
	
	 private static final HandlerList handlers = new HandlerList();
	 private Player player;
	 private LivingEntity mount;
	 /**
	  * @param Eventmount The mount that was given a passenger.
	  * @param Eventplayer The player initiating the event.
	  */
	 public MountUp(LivingEntity Eventmount, Player Eventplayer){
		 player = Eventplayer;
		 mount = Eventmount;
	 }
	 /**
	  * @return TThe mount that was given a passenger.
	  */
	 public LivingEntity getMount(){
		 return mount;
	 }
	 /**
	  * @return The player initiating the event.
	  */
	 public Player getPlayer(){
		 return player;
	 }
	 
	 public HandlerList getHandlers() {
	     return handlers;
	 }

     public static HandlerList getHandlerList() {
        return handlers;
     }

}
