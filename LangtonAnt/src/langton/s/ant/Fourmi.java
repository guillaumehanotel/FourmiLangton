package langton.s.ant;


public class Fourmi {
    
    private Orientation orientation;
    private Coordonnée coordonnee;

    
    
    public Fourmi(Coordonnée coordonnee) {
        this.orientation = Orientation.Haut;
        this.coordonnee = coordonnee;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public Coordonnée getCoordonnee() {
        return coordonnee;
    }

    public void setCoordonnee(Coordonnée coordonnee) {
        this.coordonnee = coordonnee;
    }
    
    
    
    
    
    
    
}
