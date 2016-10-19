
package langton.s.ant;


public class FourmiControleur {
    
    
    private Plateau modèle;
    private FourmiGraphique vue;
    
    
    
    public FourmiControleur(Plateau mod){
        this.modèle=mod;
    }
    

    public void start(){
        
        boolean stop = false;
        
        
        
        while( stop != true){
        
        
            
            int x = this.modèle.getAnt().getCell().getX();
            int y = this.modèle.getAnt().getCell().getY();
            
            this.modèle.getAnt().Bouger();
            
            int x1 = this.modèle.getAnt().getCell().getX();
            int y1 = this.modèle.getAnt().getCell().getY();
            
            if (x == x1 && y == y1){
                stop=true;
            } else {
            
                
                this.vue.mise_a_jour();
               
                
                try{
                    Thread.sleep(2);

                } catch(InterruptedException e){ }

            }
        }
        
        
        
        
        
    }
           
    
    public Plateau getModèle(){
        return this.modèle;
    }
    
    
    public void associeInterfaceGraphique(FourmiGraphique vue){
        this.vue=vue;
    }
    
    
}
