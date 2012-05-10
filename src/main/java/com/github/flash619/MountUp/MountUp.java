package com.github.flash619.MountUp;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.github.flash619.MountUp.conf.ConfigLink;
import com.github.flash619.MountUp.conf.PlayerLink;
import com.github.flash619.MountUp.listeners.Login;
import com.github.flash619.MountUp.listeners.SpawnEggThrow;


public class MountUp extends JavaPlugin{
	/*
	 * MountUp by Flash619
	 * (C)2012 Licensed under the GNU Lesser General Public License v3
	 */
	
	private static String version; //Holds MountUp's Version
	
	static {
		getVersion();              //Ask for the version
	}
	
	@Override
	public void onEnable(){
		Logger log = this.getLogger();
		log.info("MountUp Version " + version + " Loading...");
		
		Login LoginListener = new Login(this);
		SpawnEggThrow EggListener = new SpawnEggThrow(this);
		
		ConfigLink Config = new ConfigLink(this);
		PlayerLink PlayerConf = new PlayerLink(this);
		
		Config.InitialLoad();
		PlayerConf.InitializeClass();
		LoginListener = new Login(this);
		Bukkit.getServer().getPluginManager().registerEvents(LoginListener, this);
		Bukkit.getServer().getPluginManager().registerEvents(EggListener, this);
		
	}
	
	public void onDisable(){
		Logger log = this.getLogger();
		log.info("MountUp Version " + version + " Unloading...");
		PlayerLink.savePlayersConfig();
		
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
