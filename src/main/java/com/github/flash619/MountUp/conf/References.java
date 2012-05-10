package com.github.flash619.MountUp.conf;

import com.github.flash619.MountUp.MountUp;

public class References {
	
	public static MountUp plugin;
	
	public References(MountUp plugin){
		References.plugin = plugin;
	}
	
	public boolean containsPlayer(String player){
		return false;
	}

}
