package Utils;

import java.util.logging.Logger;

import com.github.flash619.MountUp.MountUp;

public class SEVERE {
	
	private static MountUp plugin;
	
	public SEVERE(MountUp plugin){
		SEVERE.plugin = plugin;
	}
	
	public static void error(Integer type){
		Logger log = plugin.getLogger();
		
		String[] Errors = new String[5];
		Errors[0]="A unknown severe error has occured. SEVERE was called, but with no matching error ID.";
		Errors[1]="Attempted to add mount to non existant player! ERROR: 1";
		Errors[2]="Tried to create the playerMounts object but it never existed! ERROR: 2";
		Errors[3]="Tried to save the Player.yml but couldn't find a cache to base it off of! ERROR: 3";
		Errors[4]="Attempted to find a mount in the config but the mount was not found. Did you delete a mount from the config? ERROR:4";
		boolean wasFound = false;
		for(int i=0 ; i < Errors.length;i++){
			if(i==type){
				wasFound = true;
				log.severe(Errors[i]);
			}
		}
		if(!wasFound){
			log.severe(Errors[0]);
		}
	}
	public static void notice(Integer type){
		Logger log = plugin.getLogger();
		String[] Notices = new String[4];
		Notices[0]="A unknown severe error has occured. SEVERE was called, but with no matching error ID.";
		Notices[1]="A request was sent to add a player to the player.yml but they where already there so the request was ignored.";
		Notices[2]="Noticed that there is no player.yml in existance and will try to create one...";
		
		boolean wasFound = false;
		for(int i=0 ; i < Notices.length;i++){
			if(i==type){
				wasFound = true;
				log.info(Notices[i]);
			}
		}
		if(!wasFound){
			log.severe(Notices[0]);
		}
	}

}
