package com.github.flash619.MountUp.conf;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import com.github.flash619.MountUp.Reference.Mounts;
import com.github.flash619.MountUp.Utils.SEVERE;

import com.github.flash619.MountUp.MountUp;

public class PlayerLink {
	public static MountUp plugin;
	
	static File playerMounts;
    static FileConfiguration playerMountsCache;
	
	public PlayerLink(MountUp plugin){
		PlayerLink.plugin = plugin;
	}
	/**
	 * Sets up the config objects, should only be done once!
	 * Only use in onEnable
	 */
	public void InitializeClass(){
	    playerMounts = new File(plugin.getDataFolder(), "players.yml");
	    playerMountsCache = YamlConfiguration.loadConfiguration(playerMounts);
	} 
	/**
	 * @param player The player who's mounts are being looked up.
	 * @return Returns a ArrayList of the players mounts as their ID's
	 * To get the mounts names, use it in conjunction with Mounts.GetNames(ArrayListOfID's)
	 */
	public static ArrayList<Integer> GetOwnedMounts(String player){
		ArrayList<Integer> OwnedMounts = new ArrayList<Integer>();
		if(ContainsPlayer(player)){
			for(int i=0;i<Mounts.Mounts.length;i++){
				try{
				if(PlayerHasMount(player,Mounts.Mounts[i])){
					OwnedMounts.add(Mounts.Mounts[i]);
				}
				}catch(NullPointerException e){
					
				}
			}return OwnedMounts;
		}
		return OwnedMounts;
	}
	/**
	 * @param player Players name to check the player.yml for.
	 * @return true or false.
	 * Returns if the player.yml contains a key value for the player.
	 */
    public static boolean ContainsPlayer(String player){
    	try{
    	if(playerMountsCache.contains(player)){
    		return true;
    	}else{
    		return false;
    	}
    	}catch (NullPointerException e){
    		return false;
    	}
    }
    /**
     * @param player Players name to check the player.yml for.
     * @param mount Durability ID of EggMount.
     * @return true or false.
     * Returns if a player owns a specific mount
     */
    public static boolean PlayerHasMount(String player,Integer mount){
    	try{
    		if(playerMountsCache.contains(player+"."+mount)){
    			return true;
    		}else{
    			return false;
    		}
    	}catch(NullPointerException e){
    		return false;
    	}
    }
    /**
     * @param player Players name to check the player.yml for.
     * Adds a player to a player.yml If the player already exists, it will throw a notice.
     */
    public static void addPlayer(String player){
    	try{
    	if(playerMountsCache.contains(player)){
    		SEVERE.notice(1);
    	}else{
        	playerMountsCache.createSection(player);
        	savePlayersConfig();
    	}
    	}catch (NullPointerException e){
    		SEVERE.notice(1);
    	}
    }
    /**
     * @param player Players name to check the player.yml for.
     * @param mount mount Durability ID of EggMount.
     * Adds a mount to a players list, if the player already has that mount, the request will be ignored.
     */
    public static void addPlayerMount(String player, Integer mount){
    	if(ContainsPlayer(player)){
    		if(!PlayerHasMount(player,mount)){
    		playerMountsCache.set(player+"."+mount,true);
    		savePlayersConfig();
    		}
    	}else{
    		addPlayer(player);
    	    addPlayerMount(player, mount);
    	}
    	}
    /**
     * Saves the config to file.
     */
    public static void savePlayersConfig(){ 
    	try {
			playerMountsCache.save(playerMounts);
		} catch (IOException e) {
			SEVERE.error(3);
		}
    }

}
