package com.github.flash619.MountUp.Reference;

import java.util.ArrayList;

import org.bukkit.entity.EntityType;

import com.github.flash619.MountUp.MountUp;
import com.github.flash619.MountUp.Core.StorageClasses.MountsTable.MountInfo;

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
	    /**
	     * @param IDList The Integer List of Mount ID's to convert to Names.
	     * @return The list of names in the same order as the list of Integers.
	     */
	    public static ArrayList<String> getMountNames(ArrayList<Integer> IDList){
	    	ArrayList<String> MountNames = new ArrayList<String>();
	    	if(!IDList.isEmpty()){
	    		MountNames = MountInfo.getMountNames(IDList);
	    	}return MountNames;
	    }
	    /**
	     * @param ID The Integer ID of the mount to convert to its respective name.
	     * @return the name of the mount as a String.
	     */
	    public static String getMountName(Integer ID){
	    	if(ID!=null){
	    		String name = MountInfo.getMountByID(ID).getName();
	    		return name;
	    	}return null;
	    }
	    /**
	     * @param Name The name of the mount to look up.
	     * @return the ID of the mount who's name was provided.
	     */
	    public static Integer getMountID(String Name){
	    	Integer ID=null;
	    	if(Name!=null){
	    		ID = MountInfo.getMountByName(Name).getId();
	    		return ID;
	    	}return ID;
	    }
		/**
		 * @param ID The Durability ID of the mount for referencing.
		 * @return The CreatureType
		 */
		public static EntityType getMountDurRef(Integer ID){
			if(MountInfo.isValidID(ID)){
				EntityType CreatureType = EntityType.fromName(MountInfo.getMountByID(ID).name());
				return CreatureType;
			}
			return null;
		}

}
