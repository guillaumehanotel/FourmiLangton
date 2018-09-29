package com.guillaumehanotel.langtonant.launch;

import com.guillaumehanotel.langtonant.core.AntController;
import com.guillaumehanotel.langtonant.core.Board;
import com.guillaumehanotel.langtonant.gui.AntView;



public class Main {
	
	public static void main(String[] args) {

		boolean borderMode = true;
		
		Board board = new Board(151, borderMode); // chiffre impair
		AntController controller = new AntController(board);
		AntView view = new AntView(controller);
		controller.bindInterface(view);
		view.displayInterface();

	}
}
