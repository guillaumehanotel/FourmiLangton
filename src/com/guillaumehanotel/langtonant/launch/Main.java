package com.guillaumehanotel.langtonant.launch;

import com.guillaumehanotel.langtonant.core.AntController;
import com.guillaumehanotel.langtonant.core.Plateau;
import com.guillaumehanotel.langtonant.gui.AntView;

/**
 *
 * @author Guillaume Hanotel
 */
public class Main {
	
	public static void main(String[] args) {

		boolean borderMode = true;
		
		Plateau modele = new Plateau(151, borderMode); // chiffre impair
		AntController controleur = new AntController(modele);
		AntView vue = new AntView(controleur);
		controleur.associeInterfaceGraphique(vue);
		vue.afficheInterface();

	}
}
