/**
 * @author Flash619
 * (C)2012 Licensed under the GNU Lesser General Public License v3
 */
package com.github.flash619.MountUp.Core.StorageClasses;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.ChatColor;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public class MountsIndexReference {
	
   public static Map<String, Object> ActiveMounts = new HashMap<String, Object>();
     /**
      * @param owner The person who will be owning the initial active mount.
      * @param Mount The initial active mount to set as active.
      */
     public static void addEntry(Player owner,LivingEntity Mount){
	     ActiveMountsIndex AMI = new ActiveMountsIndex();
			AMI.ActiveMount = Mount;
			AMI.MountOwner = owner;
			AMI.MountEntityID = Mount.getEntityId();
			ActiveMounts.put(owner.getName(), AMI);
     }
     /**
      * @param owner The player who's entry will be removed from the hash map.
      */
     public static void removeEntry(Player owner){
    	 String N = owner.getName();
    	 ActiveMounts.remove(N);
     }
     /**
      * @param owner The player to see if the HashMap contains a entry for.
      * @return whether or not a entry was found.
      */
     public static boolean containsKey(Player owner){
    	 if(ActiveMounts.containsKey(owner.getName())){
    		 return true;
    	 }else{return false;}
     }
     /**
      * @param owner The player for who's PAMI to retrieve.
      * @return the ActiveMountsIndex object, PAMI, for the player.
      */
     public static ActiveMountsIndex getPAMI(Player owner){
    	 if(containsKey(owner)){
    		 ActiveMountsIndex PAMI = (ActiveMountsIndex) ActiveMounts.get(owner.getName());
    		 return PAMI;
    	 }
    	 return null;
     }
     /**
      * @param owner The player to check and see if their mount is dead for.
      * @param MID The Mount Identification Number.
      * @return Whether or not the mount still exists.
      */
     public static boolean isMountDead(Player owner,Integer MID){  //MID for future use.
    	 if(containsKey(owner)){
        	 ActiveMountsIndex PAMI = getPAMI(owner);
        	 if(PAMI.ActiveMount.isDead()){
        		 return true;
        	 }else{return false;}
    		 
    	 }else{return false;}
     }
     /**
      * @param PAMI The ActiveMountsIndex object, PAMI, for the player.
      * @param MID The Mount Identification Number.
      */
     public static void despawnAllMounts(ActiveMountsIndex PAMI,Integer MID){ //MID for later use.
    	 PAMI.ActiveMount.remove();
     }
     /**
      * @param PAMI The ActiveMountsIndex object, PAMI, for the player.
      * @param MID The Mount Identification Number.
      * @return Whether or not the mount has a passenger.
      */
     public static boolean hasPassenger(ActiveMountsIndex PAMI,Integer MID){ //MID for future use.
    	 if(PAMI.ActiveMount.getPassenger()!=null){
    		 return true;
    	 }else{return false;}
     }
     /**
      * @param PAMI The ActiveMountsIndex object, PAMI, for the player.
      * @param MID MID The Mount Identification Number.
      */
     public static void ejectPassenger(ActiveMountsIndex PAMI,Integer MID){ //MID for future use.
    	 if(hasPassenger(PAMI,null)){
    		 PAMI.ActiveMount.getPassenger().eject();
    	 }
     }
     /**
      * @param owner The player who's mounts to de-spawn.
      */
     public static void clearMounts(Player owner){
    	 if(containsKey(owner)){
    		 ActiveMountsIndex PAMI = getPAMI(owner);
    		 if(!isMountDead(owner,null)){ //NULL for future use.
    			 if(hasPassenger(PAMI,null)){
    				 ejectPassenger(PAMI,null);
    			 }
    				 despawnAllMounts(PAMI,null);
    				 removeEntry(owner);
    				 owner.sendMessage(ChatColor.DARK_PURPLE+"INFO: "+ChatColor.GOLD+"Your mount was put away for now.");
    		 }else{
				 removeEntry(owner);
    			 owner.sendMessage(ChatColor.DARK_PURPLE+"INFO: "+ChatColor.GOLD+"Your mount must have been de-spawned or killed, and has been reset.");
    		 }
    	 }else{
    		 owner.sendMessage(ChatColor.DARK_PURPLE+"INFO: "+ChatColor.GOLD+"You don't have any active mounts.");
    	 }
     }

}
