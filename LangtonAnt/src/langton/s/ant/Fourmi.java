package langton.s.ant;

import java.awt.Color;


public class Fourmi {
    
    private Orientation orientation;
    private Cellule cell;
    private Plateau plateau;

    
    
    public Fourmi(Cellule cell) {
        this.orientation = Orientation.Haut;
        this.cell=cell;
        
        
    }

    
    public void associePlateau(Plateau plat){
        this.plateau=plat;
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
        if(this.getCell().getCouleur()==Color.BLACK){
            switch(this.orientation){
                case Haut : this.cell.setCouleur(Color.WHITE);
                            this.cell.setEstPrésent(false);
                            this.setCell(this.plateau.getCelluleGauche(this.getCell().getX(),this.getCell().getY()));
                            this.cell.setEstPrésent(true);
                            this.setOrientation(Orientation.Gauche);
                            
                            break;
                            
                case Bas : this.cell.setCouleur(Color.WHITE);
                           this.cell.setEstPrésent(false);
                           this.setCell(this.plateau.getCelluleDroite(this.getCell().getX(),this.getCell().getY()));
                           this.cell.setEstPrésent(true);
                           this.setOrientation(Orientation.Droite);
                           break;
                            
                case Gauche : this.cell.setCouleur(Color.WHITE);
                              this.cell.setEstPrésent(false);
                              this.setCell(this.plateau.getCelluleBas(this.getCell().getX(),this.getCell().getY()));
                              this.cell.setEstPrésent(true);
                              this.setOrientation(Orientation.Bas);
                              break;
                              
                case Droite : this.cell.setCouleur(Color.WHITE);
                              this.cell.setEstPrésent(false);
                              this.setCell(this.plateau.getCelluleHaut(this.getCell().getX(),this.getCell().getY()));
                              this.cell.setEstPrésent(true);
                              this.setOrientation(Orientation.Haut);
                              break;    
                default : break;
                
            }
               
        }else {
            switch(this.orientation){
                case Haut : this.cell.setCouleur(java.awt.Color.BLACK);
                            this.cell.setEstPrésent(false);
                            this.setCell(this.plateau.getCelluleDroite(this.getCell().getX(),this.getCell().getY()));
                            this.cell.setEstPrésent(true);
                            this.setOrientation(Orientation.Droite);
                            
                            break;
                            
                case Bas : this.cell.setCouleur(Color.BLACK);
                           this.cell.setEstPrésent(false);
                           this.setCell(this.plateau.getCelluleGauche(this.getCell().getX(),this.getCell().getY()));
                           this.cell.setEstPrésent(true);
                           this.setOrientation(Orientation.Gauche);
                           break;
                            
                case Gauche : this.cell.setCouleur(Color.BLACK);
                              this.cell.setEstPrésent(false);
                              this.setCell(this.plateau.getCelluleHaut(this.getCell().getX(),this.getCell().getY()));
                              this.cell.setEstPrésent(true);
                              this.setOrientation(Orientation.Haut);
                              break;
                              
                case Droite : this.cell.setCouleur(Color.BLACK);
                              this.cell.setEstPrésent(false);
                              this.setCell(this.plateau.getCelluleBas(this.getCell().getX(),this.getCell().getY()));
                              this.cell.setEstPrésent(true);
                              this.setOrientation(Orientation.Bas);
                              break;    
                default : break;
                
            }            
            
            
        }
        
        
        
        
        
    }
    
    
}
