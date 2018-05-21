package com.guillaumehanotel.langtonant.gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.guillaumehanotel.langtonant.core.AntController;

@SuppressWarnings("serial")
public class ControlsPanel extends JPanel {
	
	private AntController controller;
	
	private JButton jb_start;
	private JButton jb_stop;
	private JButton jb_lowspeed;
	private JButton jb_fastspeed;
	private JButton jb_restart;
	private JLabel jl_move;
	private JLabel jl_speed;
	
	public ControlsPanel(AntController controller) {
		this.controller = controller;

		setLayout();
		initializeComponents();
		addComponentsToPanel();
		enableListeners();
	}
	
	private void setLayout() {
		GridLayout layout = new GridLayout(1,6);
		this.setLayout(layout);
	}
	
	
	private void initializeComponents() {
		this.jb_fastspeed = new JButton("Fast");
		this.jb_lowspeed = new JButton("Slow");
		this.jb_start = new JButton("Start");
		this.jb_stop = new JButton("Stop");
		this.jb_restart = new JButton("Restart");
		this.jl_move = new JLabel("    Moves :   "+String.valueOf(this.controller.getMoveCounter()));
		this.jl_speed = new JLabel("     Vitesse :  "+String.valueOf(this.controller.getTimeDelay())+" ms");
	}
	
	private void addComponentsToPanel() {
		//Label
		this.add(jl_move);
		this.add(jl_speed);
		//Button
		this.add(jb_start);
		this.add(jb_stop);
		this.add(jb_lowspeed);
		this.add(jb_fastspeed);
		this.add(jb_restart);
	}
	
	private void enableListeners() {
		this.jb_start.addActionListener(controller);
		this.jb_stop.addActionListener(controller);
		this.jb_lowspeed.addActionListener(controller);
		this.jb_fastspeed.addActionListener(controller);
		this.jb_restart.addActionListener(controller);
	}

	public JLabel getJl_move() {
		return jl_move;
	}

	public JLabel getJl_speed() {
		return jl_speed;
	}
	
	

}
