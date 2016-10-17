package langton.s.ant;


public class Fourmi {
    
    private Orientation orientation;
    private Cellule cell;

    
    
    public Fourmi(Cellule cell) {
        this.orientation = Orientation.Haut;
        this.cell=cell;
        
        
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public Cellule getCell() {
        return cell;
    }

    public void setCell(Cellule cell) {
        this.cell = cell;
    }


 
    
    public void Bouger(){
        if(this.getCell().getCouleur()==Color.Black){
            
        }
    }
    
    
}
