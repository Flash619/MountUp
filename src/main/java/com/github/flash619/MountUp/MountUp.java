package com.github.flash619.MountUp;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.github.flash619.MountUp.commands.ClearMounts;
import com.github.flash619.MountUp.commands.IgnoreMounts;
import com.github.flash619.MountUp.conf.ConfigLink;
import com.github.flash619.MountUp.conf.PlayerLink;
import com.github.flash619.MountUp.listeners.Login;
import com.github.flash619.MountUp.listeners.MountDeath;
import com.github.flash619.MountUp.listeners.MountSpawn;
import com.github.flash619.MountUp.listeners.RightClickMount;
import com.github.flash619.MountUp.listeners.SpawnEggThrow;
import com.github.flash619.MountUp.listeners.MountRelated.MountInteractionDetection;


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
	private ClearMounts ClearMountsExecutor;
	private com.github.flash619.MountUp.commands.MountUp MountUpExecutor;
	
	static {
		getVersion();
	}
	@Override
	public void onEnable(){
		Config.InitialLoad();
		Logger log = this.getLogger();
		
		    if(Config.isVerboseEnabled()){
			    log.info("Loading event listeners...");
		    }
		Login LoginListener = new Login(this);
		SpawnEggThrow EggListener = new SpawnEggThrow(this);
		MountInteractionDetection MountInteraction = new MountInteractionDetection(this);
		MountSpawn NewMount = new MountSpawn(this);
		RightClickMount MountToggle = new RightClickMount(this);
		MountDeath OnMountDeath = new MountDeath(this);
		    if(Config.isVerboseEnabled()){
		   	    log.info("Initializing config objects");
		    }
		PlayerLink.InitializeClass();
		IgnoreMountsExecutor = new IgnoreMounts(this);
		ClearMountsExecutor = new ClearMounts(this);
		MountUpExecutor = new com.github.flash619.MountUp.commands.MountUp(this);
		    if(Config.isVerboseEnabled()){
			    log.info("Registering events.");
		    }
		Bukkit.getServer().getPluginManager().registerEvents(LoginListener, this);
		Bukkit.getServer().getPluginManager().registerEvents(EggListener, this);
		Bukkit.getServer().getPluginManager().registerEvents(NewMount, this);
		Bukkit.getServer().getPluginManager().registerEvents(MountToggle, this);
		Bukkit.getServer().getPluginManager().registerEvents(MountInteraction, this);
		Bukkit.getServer().getPluginManager().registerEvents(OnMountDeath, this);
		getCommand("IgnoreMounts").setExecutor(IgnoreMountsExecutor);
		getCommand("ClearMounts").setExecutor(ClearMountsExecutor);
		getCommand("MountUp").setExecutor(MountUpExecutor);
	        if(Config.isVerboseEnabled()){
		        log.info("Load finished.");
	        }
		
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
