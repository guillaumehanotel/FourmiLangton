package langton.s.ant;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;



public class AntController implements ActionListener {
    
    
    private Plateau model;
    private AntView view;
    private static int cpt=0;
    private int timeDelay;
    private Timer timer;
    
    
    public AntController(Plateau mod){
        this.model=mod;
        timeDelay=5;
        this.timer= new Timer(timeDelay,null);
        
    }
    

       @Override     
    public void actionPerformed(ActionEvent e) {
        
                String c = ((JButton)e.getSource()).getText(); // on récupère le label du bouton

                if (c.equals("Start")){
                   run();
                } else if (c.equals("Stop")){
                    timer.stop();
                    view.update();
                } else if (c.equals("Slow")){
                    
                    if (this.getTimeDelay()<5){
                        setTimeDelay(timeDelay+1);
                    this.timer.setDelay(timeDelay);
                    } else {
                    
                        setTimeDelay(timeDelay+5);
                        this.timer.setDelay(timeDelay);        
                    }
                    view.update();
                          
                } else if (c.equals("Fast")){
                    
                    if(this.timeDelay-5 >0){
                        
                        setTimeDelay(timeDelay-5);
                        this.timer.setDelay(timeDelay);
                        
                    }else if(this.timeDelay-1 >=0){
                        setTimeDelay(timeDelay-1);
                        this.timer.setDelay(timeDelay);
                    }
                    view.update();
                } else if (c.equals("Restart")){
                    timer.stop();
                    setup();
                    
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
                 
             
    
    public void setup(){
        
        
        setTimeDelay(5);
        setCpt(0);
        
        this.model.getAnt().setCell(this.model.getAnt().getFirstcell());
        this.model.getAnt().setOrientation(Orientation.Haut);
        
        this.view.setX(this.getModel().getAnt().getCell().getX());
        this.view.setY(this.getModel().getAnt().getCell().getY());
              
        
        for (int i =0;i<this.view.getCellules().length;i++){         
            for ( int j=0; j<this.view.getCellules()[i].length;j++){

   
                if (i == this.getModel().getAnt().getCell().getX() && j == this.getModel().getAnt().getCell().getY()){ // si la coordonnée correspond à celle de la fourmi,
                    this.model.getPlateau()[i][j].setEstPrésent(true);
                    this.model.getPlateau()[i][j].setCouleur(Color.red);
                    this.view.getCellules()[i][j].setBackground(java.awt.Color.red); //  elle sera rouge
                    this.model.getPlateau()[i][j].setEstPrésent(true);
                } else {
                    this.model.getPlateau()[i][j].setEstPrésent(false);
                    this.model.getPlateau()[i][j].setCouleur(Color.white);
                    this.view.getCellules()[i][j].setBackground(Color.white); // sinon elle sera de la couleur qu'elle doit être
                    this.model.getPlateau()[i][j].setEstPrésent(false);
                }
                
            }     
        }
        
        view.update();
   
    }
    
    
    
    public int getCpt() {
        return cpt;
    }

    public static void setCpt(int cpt) {
        AntController.cpt = cpt;
    }

    public Plateau getModel(){
        return this.model;
    }
     
    public void associeInterfaceGraphique(AntView vue){
        this.view=vue;
    }

    public void setTimeDelay(int timeDelay) {
        this.timeDelay = timeDelay;
    }

    public int getTimeDelay() {
        return timeDelay;
    }
  
}