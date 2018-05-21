
package com.guillaumehanotel.langtonant.beans;

import java.awt.Color;



public class Cell {
    
    private Color color;
    private int x,y;
    private boolean isPresent;
    
    public Cell(int x, int y){
        this.x = x;
        this.y = y;
        initCell();
    }
    
    public void initCell() {
        this.color = Color.WHITE;
        this.isPresent = false;
    }

    public void invertColor() {
		if (this.color == Color.BLACK) {
			this.color = Color.WHITE;
		} else if (this.color == Color.WHITE){
			this.color = Color.BLACK;
		}
	}
    
    public Color getColor() {
        return color;
    }

    public void setColor(Color couleur) {
        this.color = couleur;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isPresent() {
        return isPresent;
    }

    public void setPresence(boolean estPrésent) {
        this.isPresent = estPrésent;
    }
            
}
