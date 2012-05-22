/**
 * @author Flash619
 * (C)2012 Licensed under the GNU Lesser General Public License v3
 */
package com.github.flash619.MountUp.Core.StorageClasses;

import java.util.ArrayList;

public class MountsTable {
	public enum MountInfo{
		WOLF("Wolf",250,95),
		SPIDER("Spider",175,52),
		PIG("Pig",100,90),
		SHEEP("Sheep",50,91),
		COW("Cow",50,92),
		CHICKEN("Chicken",10,93);
		
		String name;
		int speed;
		int id;
		
		MountInfo(String name,int speed,int id){
			this.name=name;
			this.speed=speed;
			this.id=id;
		}
		/**
		 * 
		 * @return Mounts speed in percent.
		 */
		public int getSpeed(){
			return speed;
		}
		/**
		 * 
		 * @return The mounts Durability ID Reference.
		 */
		public int getId(){
			return id;
		}
		/**
		 * 
		 * @return The mounts name.
		 */
		public String getName(){
			return name;
		}
		/**
		 * 
		 * @param id The Durability ID of the mount to look up.
		 * @return The mount enum object.
		 */
        public static MountInfo getMountByID(int id){
        	for(MountInfo mount:MountInfo.values()){
        		if(mount.getId()==id){
        			return mount;
        		}
        	}
			return null;
        }
        /**
         * 
         * @param name The name value of the mount to lookup.
         * @return The mount enum object.
         */
        public static MountInfo getMountByName(String name){
        	for(MountInfo mount:MountInfo.values()){
        		if(mount.getName().equalsIgnoreCase(name)){
        			return mount;
        		}
        	}
			return null;
        }
        /**
         * 
         * @param id The Durability ID of the mount to look up.
         * @return Whether or not the ID is contained within the mounts list.
         */
        public static boolean isValidID(int id){
        	for(MountInfo mount:MountInfo.values()){
        		if(mount.getId()==id){
        			return true;
        		}
        	}return false;
        }
        /**
         * 
         * @param idlist The ArrayList of ID's to convert to names.
         * @return The list of names as an ArrayList.
         */
		public static ArrayList<String> getMountNames(ArrayList<Integer> idlist){
        	ArrayList<String> Names = new ArrayList<String>();
        	for(MountInfo mount:MountInfo.values()){
        		if(idlist.contains(mount.getId())){
        			Names.add(mount.getName());
        		}
        	}return Names;
        }
	}
}
