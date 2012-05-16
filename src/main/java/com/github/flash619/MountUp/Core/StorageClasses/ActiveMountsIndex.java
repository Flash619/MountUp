package com.github.flash619.MountUp.Core.StorageClasses;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public class ActiveMountsIndex {
	public LivingEntity ActiveMount = null; //The Mount that the PLAYER owns that is currently active.
	public Player MountOwner = null; //The player that currently owns the ACTIVEMOUNT.
}
