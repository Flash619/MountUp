package com.github.flash619.MountUp;

import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

import com.github.flash619.MountUp.conf.PlayerLink;


public class MountUp extends JavaPlugin{
	/*
	 * MountUp by Flash619
	 * (C)2012 Licensed under the GNU Lesser General Public License v3
	 */
	PlayerLink config = new PlayerLink(this);
	
	private static String version; //Holds MountUp's Version
	
	static {
		getVersion();              //Ask for the version
	}
	
	public void onDisable(){
		Logger log = this.getLogger();
		log.info("MountUp Version " + version + " Unloading...");
		
	}
	
	@Override
	public void onEnable(){
		
		Logger log = this.getLogger();
		//PlayerLink.addplayerMounts();
		//if(!config.GetBoolean("General.MountUpEnabled")){
			//log.warning("MountUp was disabled in the config, and will be unloaded.");
			//this.getPluginLoader().disablePlugin(this);
		//}else{
		log.info("MountUp Version " + version + " Loading...");
		//}
	}
	
	
	
	
	public static String getVersion(){ /*
                                        *Returns MountUp Version
                                        */
		if(version != null){
			return version;
		}
		Package p = MountUp.class.getPackage();
		if(p == null){
			p = Package.getPackage("com.flash619.github.MountUp");
		}
		if(p == null){
			version = "(Unknown)";
		}else{
			version = p.getImplementationVersion();
		}
		if(version == null){
			version = "(Unknown)";
		}
		return version;
	}

}
