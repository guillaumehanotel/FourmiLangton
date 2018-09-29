package com.guillaumehanotel.langtonant.core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.Timer;

import com.guillaumehanotel.langtonant.gui.AntView;



public class AntController implements ActionListener {


	private Board board;
	private AntView view;
	private static int moveCounter = 0;
	private int timeDelay;
	private Timer timer;


	public AntController(Board board){
		this.board = board;
		timeDelay = 5;
		this.timer= new Timer(timeDelay, null);

	}


	@Override     
	public void actionPerformed(ActionEvent e) {

		String c = ((JButton)e.getSource()).getText(); // on récupère le label du bouton

        switch (c) {
            case "Start":
                run();
                break;
            case "Stop":
                timer.stop();
                break;
            case "Slow":
                runSlower();
                break;
            case "Fast":
                runFaster();
                break;
            case "Restart":
                timer.stop();
                reinitialization();
                break;
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
	

	private void run(){
		timer.addActionListener(new ActionListener(){            
			public void actionPerformed(ActionEvent evt) {

				board.getAnt().move();

				if (board.getAnt().isStopped()){
					timer.stop();
				} else {
					moveCounter++;
					view.update();
				}
			}
		}); 
		timer.start();
	}


	private void reinitialization(){
		changeDelay(5);
		setMoveCounter(0);

		this.board.reinitialization();
		this.view.reinitialization();
	}
	

	public int getMoveCounter() {
		return moveCounter;
	}

	private static void setMoveCounter(int cpt) {
		AntController.moveCounter = cpt;
	}

	public Board getBoard(){
		return this.board;
	}

	public void bindInterface(AntView vue){
		this.view = vue;
	}

	private void setTimeDelay(int timeDelay) {
		this.timeDelay = timeDelay;
	}

	public int getTimeDelay() {
		return timeDelay;
	}

}