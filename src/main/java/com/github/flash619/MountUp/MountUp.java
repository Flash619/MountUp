package com.github.flash619.MountUp;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.github.flash619.MountUp.commands.IgnoreMounts;
import com.github.flash619.MountUp.conf.ConfigLink;
import com.github.flash619.MountUp.conf.PlayerLink;
import com.github.flash619.MountUp.listeners.Login;
import com.github.flash619.MountUp.listeners.MountSpawn;
import com.github.flash619.MountUp.listeners.SpawnEggThrow;


public class MountUp extends JavaPlugin{
	/**
	 * @author Flash619
	 * MountUp by Flash619
	 * (C)2012 Licensed under the GNU Lesser General Public License v3
	 */
	public static ConfigLink Config;
	public static PlayerLink PlayerLink;
	public MountUp(){
		MountUp.Config = new ConfigLink(this);
		MountUp.PlayerLink = new PlayerLink(this);
	}
	
	private static String version; //Holds MountUp's Version
	private IgnoreMounts IgnoreMountsExecutor;
	
	static {
		getVersion();
	}
	
	@Override
	public void onEnable(){
		Logger log = this.getLogger();
		
		if(Config.isVerboseEnabled()){
			log.info("Loading event listeners...");
		}
		Login LoginListener = new Login(this);
		SpawnEggThrow EggListener = new SpawnEggThrow(this);
		MountSpawn NewMount = new MountSpawn(this);
		if(Config.isVerboseEnabled()){
			log.info("Initializing config objects");
		}
		Config.InitialLoad();
		PlayerLink.InitializeClass();
		IgnoreMountsExecutor = new IgnoreMounts(this);
		if(Config.isVerboseEnabled()){
			log.info("Registering events.");
		}
		Bukkit.getServer().getPluginManager().registerEvents(LoginListener, this);
		Bukkit.getServer().getPluginManager().registerEvents(EggListener, this);
		Bukkit.getServer().getPluginManager().registerEvents(NewMount, this);
		getCommand("IgnoreMounts").setExecutor(IgnoreMountsExecutor);
		
	}
	
	public void onDisable(){
		Logger log = this.getLogger();
		log.info("MountUp Version " + version + " Unloading...");
		if(Config.isVerboseEnabled()){
			log.info("Saving player configs.");
		}
		com.github.flash619.MountUp.conf.PlayerLink.savePlayersConfig();
		
	}
	
	
	/**
	 * @return Returns the version of the implementation. If unknown it will return '(Unknown)'
	 */
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
