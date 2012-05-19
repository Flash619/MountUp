/**
 * @author Flash619
 * (C)2012 Licensed under the GNU Lesser General Public License v3
 */
package com.github.flash619.MountUp.MountConversion;

import static org.junit.Assert.*;

import org.junit.Test;

import com.github.flash619.MountUp.Reference.Mounts;


public class testMountConversion{

    @Test
    public void testToID()
    {    
    	Integer I = Mounts.getMountID("Wolf");
    	Integer C = 95;
        assertEquals(C,I);
    }
    @Test
    public void testToName()
    {
    	Integer I = 95;
    	String C = "Wolf";
    	String A = Mounts.getMountName(I);
    	Boolean R = false;
    	if(C.equalsIgnoreCase(A)){
    		R = true;
    	}
    	assertTrue(R);
    }
    @Test
    public void testGetArrayPos()
    {
    	Integer I = 95;
    	Integer C = 0;
    	Integer A = Mounts.getMountListPosition(I);
    	assertEquals(C,A);
    }
    @Test
    public void testArrayAccuracy(){
        Integer L = Mounts.MountType.length;
        Integer T = 0;
        for(int i=0;i<L;i++){
        Integer RI = Mounts.Mounts[i];
        String RN = Mounts.MountName[i];
        String RT = Mounts.MountType[i].toString();
        Integer CI = Mounts.getMountID(RN);
        if(CI==RI){
        	if(Mounts.getMountDurRef(RI).toString().equalsIgnoreCase(RT)){
        		T++;
        	}
        }
        }
        assertEquals(L,T);
    }
}
