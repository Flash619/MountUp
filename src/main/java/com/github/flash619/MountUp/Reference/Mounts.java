package com.github.flash619.MountUp.Reference;

import java.util.ArrayList;

import org.bukkit.entity.EntityType;

import com.github.flash619.MountUp.MountUp;

public class Mounts {
	/*
	 * ALL references go to this file.
	 *  *Mounts List
	 *  Commented out mounts are commented out FOR A REASON. 
	 *  Incompatibilities will be dealt with after the alpha framework is fully established.
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
			//	55,//Slime
			//	62,//Magma Cube
			//	96,//Mooshroom
			//	56 //Ghast
			};
		public static String[] MountType = new String[]{
			//This must always be linked to the above table! THESE SHOULD ALWAYS BE REFERENCED FROM THE BUKKIT JAVA DOC OF ENTITY NAMES
			"WOLF",
			"SPIDER",
			"PIG",
			"SHEEP",
			"COW",
		//	"SLIME",
		//	"MAGMA_CUBE",
		//	"MOOSHROOM",
		//	"GHAST"
		};
	    public static String[] MountName = new String[]{
	    	////This must always be linked to the above table!
	    	"Wolf",
	    	"Spider",
	    	"Pig",
	    	"Sheep",
	    	"Cow",
	    //	"Slime",
	    //  "Magma Cube",
	    //	"Mooshroom",
	    //	"Ghast"
	    };
	    /**
	     * @param IDList The Integer List of Mount ID's to convert to Names.
	     * @return The list of names in the same order as the list of Integers.
	     */
	    public static ArrayList<String> getMountNames(ArrayList<Integer> IDList){
	    	ArrayList<String> MountNames = new ArrayList<String>();
	    	if(!IDList.isEmpty()){
	    		for(int i=0;i<Mounts.length;i++){
	    			if(IDList.contains(Mounts[i])){
	    				MountNames.add(MountName[i]);
	    			}
	    		}return MountNames;
	    	}return MountNames;
	    }
	    /**
	     * @param ID The Integer ID of the mount to convert to its respective name.
	     * @return the name of the mount as a String.
	     */
	    public static String getMountName(Integer ID){
	    	if(!ID.equals(null)){
	    		for(int i=0;i<Mounts.length;i++){
	    			if(ID.equals(Mounts[i])){
	    				return MountName[i];
	    			}
	    		}return null;
	    	}return null;
	    }
	    /**
	     * @param Name The name of the mount to look up.
	     * @return the ID of the mount who's name was provided.
	     */
	    public static Integer getMountID(String Name){
	    	Integer ID=null;
	    	for(int i=0;i<MountName.length;i++){
	    		if(Name.equalsIgnoreCase(MountName[i])){
	    			ID = Mounts[i];
	    			return ID;
	    		}
	    	}return ID;
	    }
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
