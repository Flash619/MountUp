package com.github.flash619.MountUp.conf;

import org.bukkit.configuration.file.FileConfiguration;

import com.github.flash619.MountUp.MountUp;
import com.github.flash619.MountUp.Reference.Mounts;

public class ConfigLink {
	
	private static MountUp plugin;
	
	public ConfigLink(MountUp plugin){
		ConfigLink.plugin = plugin;
	}
	
	public void InitialLoad(){
		final FileConfiguration config = plugin.getConfig();
		//Set default enabled mounts, by default, all are enabled.
		String[] defEnabled=defEnabledMounts();
		
		if(defEnabledMounts()!=null){ //Any Enabled?
		for(int l=0;l<Mounts.Mounts.length; l++){
		config.addDefault("General.AllowedMounts", defEnabled[l]);
		}
		
		}
		config.options().copyDefaults(true);
		plugin.saveConfig();
	}
	
	public String[] defEnabledMounts(){
		String[] enabled = new String[6];
		if(enabled.equals(null)){
			for(int i=0;i < enabled.length; i++){
				if(!Mounts.Mounts.equals(null)){ //Trying to avoid throwing an exception...
				enabled[i]=Mounts.Mounts[i];
				}
			}
			return enabled;
		}else{
			//no need to reconfigure already existent defaults.
			return enabled;
		}
	}

}