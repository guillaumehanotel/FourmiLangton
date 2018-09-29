package com.guillaumehanotel.langtonant.gui;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

import com.guillaumehanotel.langtonant.core.AntController;

@SuppressWarnings("serial")
public class SketchPanel extends JPanel {
	
	private AntController controller;
	
	private JPanel[][] cellules;
	
	public SketchPanel(AntController controller) {
		this.controller = controller;
		
		setLayout();
		setSize();
		initCells();

	}
	
	void reinitialisation() {
		for (int i =0;i<this.cellules.length;i++){
			for ( int j=0; j<this.cellules[i].length;j++){
				setCellColor(i, j);
			}   
		}
	}
	
	private void initCells() {
		this.cellules = new JPanel[this.controller.getBoard().getGridLength()][this.controller.getBoard().getGridLength()];
		
		for (int i =0;i<this.cellules.length;i++){
			for ( int j=0; j<this.cellules[i].length;j++){
				this.cellules[i][j] = new JPanel(); // Instantiation des Panels
				this.add(this.cellules[i][j]);  // on les ajoute au panneau
				setCellColor(i, j);
			}   
		}
	}

	private void setCellColor(int i, int j) {
		if(isAntPosition(i, j)){ // si la coordonnee correspond à celle de la fourmi,
			this.cellules[i][j].setBackground(java.awt.Color.red); //  elle sera rouge
		} else {
			this.cellules[i][j].setBackground(this.controller.getBoard().getBoard()[i][j].getColor()); // sinon elle sera de la couleur qu'elle doit etre
		}
	}
	
	private boolean isAntPosition(int i, int j) {
		return (i == this.controller.getBoard().getAnt().getCell().getX() && j == this.controller.getBoard().getAnt().getCell().getY());
	}
	
	private void setLayout() {
		// Layout : Grille de la taille du board
		GridLayout layout = new GridLayout(this.controller.getBoard().getGridLength(),this.controller.getBoard().getGridLength());
		this.setLayout(layout);
	}

	private void setSize() {
		this.setPreferredSize(new Dimension(900,800));
	}


	public JPanel[][] getCellules() {
		return cellules;
	}
	

}
