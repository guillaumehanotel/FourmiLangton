package langton.s.ant;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.Timer;



public class AntController implements ActionListener {
    
    
    private Plateau model;
    private AntView view;
    private static int cpt=0;
    private Timer timer;
    
    
    public AntController(Plateau mod){
        this.model=mod;
        this.timer= new Timer(1,null);
    }
    

       @Override
      
           
    public void actionPerformed(ActionEvent e) {
        
                String c = ((JButton)e.getSource()).getText(); // on récupère le label du bouton

                if (c.equals("Start")){
                   run();
 

                }
  
    }
    
     
    
    public void run(){
          

        timer.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent evt) {

                int x = model.getAnt().getCell().getX();
                int y = model.getAnt().getCell().getY();

                model.getAnt().Bouger();

                int x1 = model.getAnt().getCell().getX();
                int y1 = model.getAnt().getCell().getY();

                if (x == x1 && y == y1){
                    timer.stop();
                } else {

                    cpt++;
                    view.update();
                    
                }
              
            }
        }); 
                
        timer.start();
              
    }
                 
                            
    
    
    public int getCpt() {
        return cpt;
    }
           
    
    public Plateau getModel(){
        return this.model;
    }
    
    
    public void associeInterfaceGraphique(AntView vue){
        this.view=vue;
    }
}