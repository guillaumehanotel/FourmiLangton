package com.guillaumehanotel.langtonant.core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.Timer;

import com.guillaumehanotel.langtonant.gui.AntView;



public class AntController implements ActionListener {


	private Plateau model;
	private AntView view;
	private static int moveCounter = 0;
	private int timeDelay;
	private Timer timer;


	public AntController(Plateau model){
		this.model = model;
		timeDelay = 5;
		this.timer= new Timer(timeDelay, null);

	}


	@Override     
	public void actionPerformed(ActionEvent e) {

		String c = ((JButton)e.getSource()).getText(); // on récupère le label du bouton

		if (c.equals("Start")){
			run();
		} else if (c.equals("Stop")){
			timer.stop();
		} else if (c.equals("Slow")){
			runSlower();
		} else if (c.equals("Fast")){
			runFaster();
		} else if (c.equals("Restart")){
			timer.stop();
			reinitialisation();
		} 
		view.update();
	}

	private void runSlower() {
		changeDelay(this.getTimeDelay() < 5 ? timeDelay+1 : timeDelay+5);
	}
	
	private void runFaster() {
		if(this.timeDelay-5 > 0){
			changeDelay(timeDelay-5);
		} else if(this.timeDelay-1 >= 0){
			changeDelay(timeDelay-1);
		}
	}
	
	
	private void changeDelay(int delay) {
		setTimeDelay(delay);
		this.timer.setDelay(delay);
	}
	

	public void run(){
		timer.addActionListener(new ActionListener(){            
			public void actionPerformed(ActionEvent evt) {

				model.getAnt().move();

				if (model.getAnt().isStopped()){
					timer.stop();
				} else {
					moveCounter++;
					view.update();
				}
			}
		}); 
		timer.start();
	}


	public void reinitialisation(){
		changeDelay(5);
		setMoveCounter(0);

		this.model.reinitialisation();
		this.view.reinitialisation();
	}
	

	public int getMoveCounter() {
		return moveCounter;
	}

	public static void setMoveCounter(int cpt) {
		AntController.moveCounter = cpt;
	}

	public Plateau getModel(){
		return this.model;
	}

	public void associeInterfaceGraphique(AntView vue){
		this.view = vue;
	}

	public void setTimeDelay(int timeDelay) {
		this.timeDelay = timeDelay;
	}

	public int getTimeDelay() {
		return timeDelay;
	}

}