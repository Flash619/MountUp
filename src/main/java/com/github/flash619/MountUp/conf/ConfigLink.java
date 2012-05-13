package com.github.flash619.MountUp.conf;

import org.bukkit.configuration.file.FileConfiguration;

import Utils.SEVERE;

import com.github.flash619.MountUp.MountUp;
import com.github.flash619.MountUp.Reference.Mounts;

public class ConfigLink {
	
	private static MountUp plugin;
	
	public ConfigLink(MountUp plugin){
		ConfigLink.plugin = plugin;
	}
	
	public void InitialLoad(){
		final FileConfiguration config = plugin.getConfig();
		                                                                  //Set default enabled mounts, by default, everything except flying mounts aka enderdragon.
		
		if(Mounts.Mounts!=null){
		for(int l=0;l<Mounts.Mounts.length; l++){
			if(!Mounts.Mounts[l].equals(Mounts.Mounts[0])){
		config.addDefault("General.AllowedMounts."+Mounts.Mounts[l], true);
			}else{
		config.addDefault("General.AllowedMounts."+Mounts.Mounts[l], false);		
			}
		}
		
		}
		config.options().copyDefaults(true);                           //copy the new defaults to the file.
		plugin.saveConfig();
	}
	public boolean isEnabled(String mount){                            //Check to see if a mount is enabled.
		final FileConfiguration config = plugin.getConfig();
		try{
		if(config.contains("General.AllowedMounts."+mount)){
		if(config.getBoolean("General.AllowedMounts."+mount)){
			return true;
		}else{
			return false;
		}
		}else{
			return false;
		}
		}catch(NullPointerException e){
			SEVERE.error(4);
			return false;
		}
	}

}