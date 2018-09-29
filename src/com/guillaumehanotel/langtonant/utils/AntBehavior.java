package com.guillaumehanotel.langtonant.utils;

import java.awt.Color;
import java.lang.reflect.Method;
import java.util.HashMap;

import com.guillaumehanotel.langtonant.beans.Orientation;
import com.guillaumehanotel.langtonant.core.Board;

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
		this.blackBehavior.put(Orientation.NORTH, Board.class.getMethod("getLeftCell", int.class, int.class));
		this.blackBehavior.put(Orientation.SOUTH, Board.class.getMethod("getRightCell", int.class, int.class));
		this.blackBehavior.put(Orientation.WEST, Board.class.getMethod("getBottomCell", int.class, int.class));
		this.blackBehavior.put(Orientation.EAST, Board.class.getMethod("getTopCell", int.class, int.class));
		
		this.whiteBehavior.put(Orientation.NORTH, Board.class.getMethod("getRightCell", int.class, int.class));
		this.whiteBehavior.put(Orientation.SOUTH, Board.class.getMethod("getLeftCell", int.class, int.class));
		this.whiteBehavior.put(Orientation.WEST, Board.class.getMethod("getTopCell", int.class, int.class));
		this.whiteBehavior.put(Orientation.EAST, Board.class.getMethod("getBottomCell", int.class, int.class));
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
