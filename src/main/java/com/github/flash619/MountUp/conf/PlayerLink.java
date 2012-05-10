package com.github.flash619.MountUp.conf;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import Utils.SEVERE;

import com.github.flash619.MountUp.MountUp;
import com.github.flash619.MountUp.Reference.Mounts;

public class PlayerLink {
	public static MountUp plugin;
	
	static File playerMounts;
    static FileConfiguration playerMountsCache;
	
	public PlayerLink(MountUp plugin){
		PlayerLink.plugin = plugin;
	}
	public void InitializeClass(){                                     //Initial load, called on onEnable !Important!
	    playerMounts = new File(plugin.getDataFolder(), "players.yml");
	    playerMountsCache = YamlConfiguration.loadConfiguration(playerMounts);
	}
    public boolean addplayerMounts(String player, Integer mount){      //START CODE THAT WILL UNDERGO REFACING
		Integer[] MountsRef = Mounts.Mounts;                           //Adds a mount to a players owned list.
    		for(int i=0;i < MountsRef.length; i++){                   
    		    if(!playerMountsCache.contains(player+"."+mount)){    
    		    	//TODO Switch up the way that the config for the player is generated and saved, create initial config per player login, reference it here. 
    		    }
    		
    	}
    		return false;
    }                                                                //END CODE THAT WILL UNDERGO REFACING
    public static boolean ContainsPlayer(String player){             //Does player.yml contain a key for a player?
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
    public static boolean PlayerHasMount(String player,Integer mount){//Returns if a player owns a specific mount
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
    public static void addPlayer(String player){                    //Adds a player to a player.yml If the player already exists, it will throw a notice.
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
    public void addPlayerMount(String player, Integer mount){       //Adds a mount to a players list, if the player already has that mount, the request will be ignored.
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
    public static void savePlayersConfig(){                       //Saves the players.yml file
    	try {
			playerMountsCache.save(playerMounts);
		} catch (IOException e) {
			SEVERE.error(3);
		}
    }

}
