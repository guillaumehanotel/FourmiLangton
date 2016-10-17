package langton.s.ant;
 
import java.util.ArrayList;



public class Plateau {
    
    
    private Cellule[][] plateau;
    private int tailleGrille;
    private Fourmi ant;
    
    
    
    public Plateau(int tailleGrille){
        
        this.tailleGrille=tailleGrille;
        
        this.plateau = new Cellule[this.tailleGrille][this.tailleGrille];
        
        for (int i =0; i < this.tailleGrille;i++){
            
            for (int j = 0; i < this.tailleGrille;j++){
                
                
                this.plateau[i][j] = new Cellule(i,j);
                
                
                
            }  
            
        }
        
        this.ant = new Fourmi(new Cellule((this.tailleGrille-1)/2,(this.tailleGrille-1)/2));
        
        
    }

    public Cellule[][] getPlateau() {
        return plateau;
    }

    public void setPlateau(Cellule[][] plateau) {
        this.plateau = plateau;
    }

    public int getTailleGrille() {
        return tailleGrille;
    }

    public void setTailleGrille(int tailleGrille) {
        this.tailleGrille = tailleGrille;
    }

    public Fourmi getAnt() {
        return ant;
    }

    public void setAnt(Fourmi ant) {
        this.ant = ant;
    }
    
    
    
    
    
    
    
    
    
}
