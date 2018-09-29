package com.guillaumehanotel.langtonant.beans;

import java.awt.Color;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.guillaumehanotel.langtonant.core.Board;
import com.guillaumehanotel.langtonant.utils.AntBehavior;

public class Ant {

	private Orientation orientation;
	private Cell firstcell;
	private Cell cell;
	private Board board;
	
	private boolean isStopped;


	public Ant(Cell cell) {
		this.firstcell=cell;
		initAnt();
	}
	
	public void initAnt() {
		this.orientation = Orientation.NORTH;
		this.cell = this.firstcell;
		cell.setPresence(true);
		this.isStopped = false;
	}

	public void move(){
		Cell previousCell = this.cell;
		try {
			this.turnByColor(this.cell.getColor());
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		checkIsStopped(previousCell);
	}
	
	private void checkIsStopped(Cell previousCell) {
		if (previousCell == this.cell) {
			isStopped = true;
		}
	}

	private void turnByColor(Color color) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		this.cell.invertColor();
		changeCell(color);
		changeOrientation(color);
	}

	private void changeCell(Color color) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		AntBehavior antBrain = AntBehavior.getInstance();
		Method behavior = antBrain.getBehavior(color, this.orientation);

		this.cell.setPresence(false);
		this.setCell((Cell)behavior.invoke(this.board, this.getCell().getX(), this.getCell().getY()));
		this.cell.setPresence(true);	
	}

	private void changeOrientation(Color color) {
		this.setOrientation((color == Color.black) ? this.orientation.rotateOppositeClockwise() : this.orientation.rotateClockwise());
	}
	
	
	
	public void associeBoard(Board board){
		this.board=board;
	}

	public Orientation getOrientation() {
		return orientation;
	}

	private void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}

	public Cell getCell() {
		return cell;
	}

	public void setCell(Cell cell) {
		this.cell = cell;
	}

	public Cell getFirstcell() {
		return firstcell;
	}

	public boolean isStopped() {
		return isStopped;
	}


}
