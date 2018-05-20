
package com.guillaumehanotel.langtonant;

import java.awt.Color;



public class Cellule {
    
    private Color couleur;
    private int x,y;
    private boolean estPrésent;
    
    
    
    public Cellule(int x, int y){
        
        
        
        int nombreAleatoire = 1 + (int)(Math.random() * ((2 - 1) + 1));
        
        /*
        if (nombreAleatoire ==1){
            this.couleur=Color.WHITE;
        }else {
            this.couleur=Color.BLACK;
        }
        */
        this.couleur=Color.WHITE;
        
        
        
        this.estPrésent=false;
        this.x=x;
        this.y=y;
        
    }

    public Color getCouleur() {
        return couleur;
    }


    public void setCouleur(Color couleur) {
        this.couleur = couleur;
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

    


    public boolean isEstPrésent() {
        return estPrésent;
    }

    public void setEstPrésent(boolean estPrésent) {
        this.estPrésent = estPrésent;
    }
            
    
    
    
    
    
    
}
