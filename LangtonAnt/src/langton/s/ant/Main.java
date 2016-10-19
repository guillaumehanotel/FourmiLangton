/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package langton.s.ant;

import java.awt.Color;

/**
 *
 * @author Guillaume
 */
public class Main {
    
    public static void main(String[] args) {
        
        Plateau modèle = new Plateau(99);
        FourmiControleur controleur = new FourmiControleur(modèle);
        FourmiGraphique vue = new FourmiGraphique(controleur);
        controleur.associeInterfaceGraphique(vue);
        
        vue.afficheInterface();
        controleur.start();
        
        
        posAnt(modèle);
        
        modèle.getAnt().Bouger();
        posAnt(modèle);
        modèle.getAnt().Bouger();
        posAnt(modèle);
        modèle.getAnt().Bouger();
        posAnt(modèle);
        modèle.getAnt().Bouger();
        posAnt(modèle);
        modèle.getAnt().Bouger();
        posAnt(modèle);
        
        
    }
    
    
    public static void posAnt(Plateau modèle){
        
        Color theColor = modèle.getAnt().getCell().getCouleur();
        String colorName = null;
        if (Color.BLACK.equals(theColor)) 
        {
          colorName = "BLACK";
        } 
        else if (Color.WHITE.equals(theColor)) 
        {
          colorName = "WHITE";
        }
        
        System.out.println("position de la fourmi : ("+modèle.getAnt().getCell().getX()+","+modèle.getAnt().getCell().getY()+")");
        System.out.println("couleur de la case  : "+colorName);
        System.out.println("orientation de la fourmi : "+modèle.getAnt().getOrientation());
        System.out.println();
    }
    
    
    
    
    
}
