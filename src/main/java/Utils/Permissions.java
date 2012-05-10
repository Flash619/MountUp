package Utils;

import org.bukkit.entity.Player;

import com.github.flash619.MountUp.MountUp;
import com.github.flash619.MountUp.Reference.Mounts;

public class Permissions {
	public static MountUp plugin;
	public Permissions(MountUp plugin){
		Permissions.plugin = plugin;
	}
	
	public static boolean hasEggPerm(Player player,Integer ID){//returns if a player has the permissions for the specified egg. 
		if(IsSpawnEgg(ID)){
		String PermissionString = ("MountUp.EggSpawn."+ID);
		if(player.hasPermission(PermissionString)){
			return true;
		}else{
			return false;
		}
		}else{
			return false;
		}
	}
	public static boolean IsSpawnEgg(Integer ID){//Returns wether the ID is a spawn egg, and is listed in the usable spawn egg list at Mounts.Mounts[]
		for(int i=0;i<Mounts.Mounts.length;i++){
			if(Mounts.Mounts[i]==ID){
				return true;
			}
		}
		return false;
	}

}
