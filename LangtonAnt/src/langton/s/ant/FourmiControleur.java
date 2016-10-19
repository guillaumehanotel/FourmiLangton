
package langton.s.ant;


public class FourmiControleur {
    
    
    private Plateau modèle;
    private FourmiGraphique vue;
    
    
    
    public FourmiControleur(Plateau mod){
        this.modèle=mod;
    }
    
    public void start(){
        for(int i=0; i<500;i++){
            this.modèle.getAnt().Bouger();
            this.vue.getFenetre().repaint();
            this.vue.mise_a_jour();
        try{
            Thread.sleep(250);
            
        } catch(InterruptedException e){ }
            
        }
        
        
    }
           
    
    public Plateau getModèle(){
        return this.modèle;
    }
    
    
    public void associeInterfaceGraphique(FourmiGraphique vue){
        this.vue=vue;
    }
    
    
}
