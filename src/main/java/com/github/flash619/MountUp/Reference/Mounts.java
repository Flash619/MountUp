package com.github.flash619.MountUp.Reference;

import org.bukkit.entity.EntityType;

import com.github.flash619.MountUp.MountUp;

public class Mounts {
	/*
	 * ALL references go to this file.
	 *  *Mounts List
	 */
	
		public static MountUp plugin;
		public Mounts(MountUp plugin){

		}
		public static Integer[] Mounts = new Integer[]{         
			//Enderdragon will no longer be listed here but
			//instead as a seperate config entity.
				95,//Wo14lf
				52,//Spider
				90,//Pig
				91,//Sheep
				92,//Cow
				55,//Slime
				62,//Magma Cube
				96,//Mooshroom
				56 //Ghast
			};
		public static String[] MountType = new String[]{
			//This must always be linked to the above table! THESE SHOULD ALWAYS BE REFERENCED FROM THE BUKKIT JAVA DOC OF ENTITY NAMES
			"WOLF",
			"SPIDER",
			"PIG",
			"SHEEP",
			"COW",
			"SLIME",
			"MAGMA_CUBE",
			"MOOSHROOM",
			"GHAST"
		};
		/**
		 * @param ID The Durability ID of the mount for referencing.
		 * @return The CreatureType
		 */
		public static EntityType getMountDurRef(Integer ID){
			if(mountIsValidDur(ID)){
				EntityType CreatureType = EntityType.fromName(MountType[getMountListPosition(ID)]);
				return CreatureType;
			}
			return null;
		}
		/**
		 * @param ID The Durability ID of the mount for referencing.
		 * @return The position of the MountID in the Mounts array.
		 */
		public static Integer getMountListPosition(Integer ID){
			for(int i=0;i<Mounts.length;i++){
				if(ID==Mounts[i]){
					return i;
				}
			}
			return null;
		}
		/**
		 * @param ID The Durability ID of the mount for referencing.
		 * @return Whether the mount is contained in the Mounts array.
		 */
		public static boolean mountIsValidDur(Integer ID){
			for(int i=0;i<Mounts.length;i++){
				if(ID==Mounts[i]){
					return true;
				}
			}
			return false;
		}

}
