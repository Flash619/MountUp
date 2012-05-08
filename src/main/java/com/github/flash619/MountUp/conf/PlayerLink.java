package com.github.flash619.MountUp.conf;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import com.github.flash619.MountUp.MountUp;
import com.github.flash619.MountUp.Reference.Mounts;

public class PlayerLink {
	private static MountUp plugin;
	public PlayerLink(MountUp plugin){
		PlayerLink.plugin = plugin;
	}
	
	static public FileConfiguration playerMounts = null;
	static File playerMountsCache = null;
	
    public static FileConfiguration loadplayerMounts() {
    	Logger log = plugin.getLogger();
        if (playerMounts == null) {
            if (playerMountsCache == null)
            	playerMountsCache = new File(plugin.getDataFolder(), "commands.yml");
            if (playerMountsCache.exists()) {
            	playerMounts = YamlConfiguration.loadConfiguration(playerMountsCache);
            } else {
                InputStream defConfigStream = plugin.getResource("commands.yml");
                playerMounts = YamlConfiguration.loadConfiguration(defConfigStream);
            }
        }
        return playerMounts;
    }
    public void saveplayerMounts() {
    	Logger log = plugin.getLogger();
        if (playerMounts == null || playerMountsCache == null)
            return;
        try {
        	playerMounts.save(playerMountsCache);
        } catch (IOException e) {
            log.severe("Unable to save config to " + playerMountsCache + '.');
        }
    }
    public static boolean addplayerMounts(String player, String mount){
		String[] MountsRef = Mounts.Mounts;
    		for(int i=0;i < MountsRef.length; i++){
    		    if(!playerMounts.contains(player+"."+mount)){
    		    	
    		    }
    		
    	}
    }

}
