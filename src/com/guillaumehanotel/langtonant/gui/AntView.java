package com.guillaumehanotel.langtonant.gui;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.guillaumehanotel.langtonant.core.AntController;

public class AntView {

	private JFrame frame;
	
	private ControlsPanel jp_controls;
	private SketchPanel jp_sketch;
	
	private AntController ctrl;
	
	private int x; // x de la fourmi
	private int y; // y de la fourmi
	



	public AntView (AntController ctrl){
		this.frame = new JFrame("Fourmi de Langton");
		this.ctrl = ctrl;
		
		this.jp_sketch = new SketchPanel(ctrl);
		this.jp_controls = new ControlsPanel(ctrl);
		 
		updateCurrentPosition();

		// Fenetre
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setPreferredSize(new Dimension(900,900));

		// Ajout des panels à la frame
		this.frame.getContentPane().add(jp_sketch,BorderLayout.NORTH);
		this.frame.getContentPane().add(jp_controls);

	}

	
	

	public void update(){ // mise à jour des couleurs

		// la case actuelle n'est plus rouge et retrouve sa couleur d'origine
		this.jp_sketch.getCellules()[x][y].setBackground(this.ctrl.getModel().getPlateau()[x][y].getColor());

		updateCurrentPosition();

		// la nouvelle case de la fourmi devient rouge
		this.jp_sketch.getCellules()[x][y].setBackground(java.awt.Color.red);
		
		updateLabels();

	}
	
	public void updateCurrentPosition() {
		this.x = this.ctrl.getModel().getAnt().getCell().getX();
		this.y = this.ctrl.getModel().getAnt().getCell().getY();
	}

	private void updateLabels() {
		this.jp_controls.getJl_move().setText("    Moves :   "+String.valueOf(this.ctrl.getMoveCounter()));
		this.jp_controls.getJl_speed().setText("     Vitesse :  "+String.valueOf(this.ctrl.getTimeDelay())+" ms");
	}
	
	
	public void reinitialisation() {
		updateCurrentPosition();
		this.jp_sketch.reinitialisation();
	}

	public void afficheInterface(){
		this.frame.pack();
		this.frame.setVisible(true);   
	}

	public AntController getCtrl() {
		return ctrl;
	}

	public JFrame getFrame() {
		return frame;
	}

	public JPanel[][] getCellules() {
		return jp_sketch.getCellules();
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public ControlsPanel getJp_controls() {
		return jp_controls;
	}

	public SketchPanel getJp_sketch() {
		return jp_sketch;
	}

	



}
