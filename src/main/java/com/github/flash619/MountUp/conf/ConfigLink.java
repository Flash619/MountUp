package com.github.flash619.MountUp.conf;

import org.bukkit.configuration.file.FileConfiguration;

import com.github.flash619.MountUp.Utils.SEVERE;

import com.github.flash619.MountUp.MountUp;
import com.github.flash619.MountUp.Reference.Mounts;

public class ConfigLink {
	
	private static MountUp plugin;
	
	public ConfigLink(MountUp plugin){
		ConfigLink.plugin = plugin;
	}
	/**
	 * Loads the intial config and adds the defaults, should only be ran at startup!
	 */
	public void InitialLoad(){
		final FileConfiguration config = plugin.getConfig();
		if(Mounts.MountName!=null){
		for(int l=0;l<Mounts.MountName.length; l++){
		config.addDefault("General.AllowedMounts."+Mounts.MountName[l], true);
		}
		
		}
		config.addDefault("General.VerboseMode", false);
		config.options().copyDefaults(true);
		plugin.saveConfig();
	}
	/**
	 * @param Durability ID for MountEgg
	 * @return Returns true if it is enabled, otherwise false.
	 */
	public boolean isEnabledMount(Integer IDI){
		final FileConfiguration config = plugin.getConfig();
		try{
		if(config.contains("General.AllowedMounts."+Mounts.getMountName(IDI))){
		if(config.getBoolean("General.AllowedMounts."+Mounts.getMountName(IDI))){
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
	/**
	 * @return Whether or not Verbose Mode is enabled. true/false
	 */
	public boolean isVerboseEnabled(){
		final FileConfiguration config = plugin.getConfig();
		if(config.getBoolean("General.VerboseMode")){
			return true;
		}else{
			return false;
		}
	}

}