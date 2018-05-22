package com.guillaumehanotel.langtonant.utils;

import java.awt.Color;
import java.lang.reflect.Method;
import java.util.HashMap;

import com.guillaumehanotel.langtonant.beans.Orientation;
import com.guillaumehanotel.langtonant.core.Plateau;

public class AntBehavior {
	
	private static AntBehavior instance;
	private final HashMap<Orientation, Method> blackBehavior; 
	private final HashMap<Orientation, Method> whiteBehavior; 
	
	private AntBehavior() {
		this.blackBehavior = new HashMap<Orientation, Method>();
		this.whiteBehavior = new HashMap<Orientation, Method>();
		
		try {	
			initBehaviors();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}
	
	private void initBehaviors() throws NoSuchMethodException, SecurityException {
		this.blackBehavior.put(Orientation.NORTH, Plateau.class.getMethod("getCelluleGauche", int.class, int.class));
		this.blackBehavior.put(Orientation.SOUTH, Plateau.class.getMethod("getCelluleDroite", int.class, int.class));
		this.blackBehavior.put(Orientation.WEST, Plateau.class.getMethod("getCelluleBas", int.class, int.class));
		this.blackBehavior.put(Orientation.EAST, Plateau.class.getMethod("getCelluleHaut", int.class, int.class));
		
		this.whiteBehavior.put(Orientation.NORTH, Plateau.class.getMethod("getCelluleDroite", int.class, int.class));
		this.whiteBehavior.put(Orientation.SOUTH, Plateau.class.getMethod("getCelluleGauche", int.class, int.class));
		this.whiteBehavior.put(Orientation.WEST, Plateau.class.getMethod("getCelluleHaut", int.class, int.class));
		this.whiteBehavior.put(Orientation.EAST, Plateau.class.getMethod("getCelluleBas", int.class, int.class));
	}
	
	public Method getBehavior(Color color, Orientation orientation) {
		return (color == Color.BLACK) ? blackBehavior.get(orientation) : whiteBehavior.get(orientation);
	}
	
	public static AntBehavior getInstance() {
		if(instance == null) {
			instance = new AntBehavior();
		}
		return instance;
	}
	
}
