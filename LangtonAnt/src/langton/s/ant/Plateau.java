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
            
            for (int j = 0; j < this.tailleGrille;j++){
                
                if( (   i == (this.tailleGrille-1)/2   )   &&  (  j == (this.tailleGrille-1)/2   )  )    {
                    
                    Cellule cell = new Cellule(i,j);
                    this.plateau[i][j] = cell;
                    this.ant = new Fourmi(cell);
                    this.ant.associePlateau(this);
                    cell.setEstPrésent(true);
                    
                } else {
                    this.plateau[i][j] = new Cellule(i,j);
                }
                
                
                
            }  
            
        }
        
        
        
        
    }
    
    
    public Cellule getCelluleGauche(int x, int y){
        
        Cellule res;
        
        if(x-1 >= 0){
            res = this.getPlateau()[x-1][y];
        } else {
            res = this.getPlateau()[x][y];
        }
        
        return res;
    }
    
    
    public Cellule getCelluleDroite(int x, int y){
          
        Cellule res;
        
        if(x+1 <= this.tailleGrille-1){
            res = this.getPlateau()[x+1][y];
        } else {
            res = this.getPlateau()[x][y];
        }
        
        return res;
    }
    
    public Cellule getCelluleHaut(int x, int y){
        
        Cellule res;
        
        if(y+1 <= this.tailleGrille-1){
            res = this.getPlateau()[x][y+1];
        } else {
            res = this.getPlateau()[x][y];
        }
        
        return res;
    }
    
    public Cellule getCelluleBas(int x, int y){
        
        Cellule res;
        
        if(y-1 >= 0){
            res = this.getPlateau()[x][y-1];
        } else {
            res = this.getPlateau()[x][y];
        }
        
        return res;
    }
    
    
    

    public Cellule[][] getPlateau() {
        return plateau;
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
