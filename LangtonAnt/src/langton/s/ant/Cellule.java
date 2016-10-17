
package langton.s.ant;



public class Cellule {
    
    private Color couleur;
    private Coordonnée coordonnee;
    private boolean estPrésent;
    
    
    
    public Cellule(){
        this.couleur=Color.White;
        this.estPrésent=false;
        
    }

    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }

    public Coordonnée getCoordonnee() {
        return coordonnee;
    }

    public void setCoordonnee(Coordonnée coordonnee) {
        this.coordonnee = coordonnee;
    }

    public boolean isEstPrésent() {
        return estPrésent;
    }

    public void setEstPrésent(boolean estPrésent) {
        this.estPrésent = estPrésent;
    }
            
    
    
    
    
    
    
}
