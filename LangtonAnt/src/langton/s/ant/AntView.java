package langton.s.ant;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AntView {
    
    private JFrame frame;
    private JPanel panel;
    private JPanel panel2;
    private JPanel[][] cellules;
    private AntController ctrl;
    private int x; // x de la fourmi
    private int y; // y de la fourmi
    private JButton start;
    private JButton stop;
    private JButton lowspeed;
    private JButton fastspeed;
    private JButton restart;
    private JLabel move;
    private JLabel speed;
    
    
    public AntView (AntController ctrl){
        this.frame=new JFrame("Fourmi de Langton");
        this.ctrl=ctrl;
        this.panel=new JPanel();
        this.panel2 = new JPanel();
        this.cellules = new JPanel[this.ctrl.getModel().getTailleGrille()][this.ctrl.getModel().getTailleGrille()]; 
        this.x =this.ctrl.getModel().getAnt().getCell().getX();
        this.y =this.ctrl.getModel().getAnt().getCell().getY();
        this.fastspeed=new JButton("Fast");
        this.lowspeed=new JButton("Slow");
        this.start=new JButton("Start");
        this.stop=new JButton("Stop");
        this.restart=new JButton("Restart");
        this.move=new JLabel("           Moves :   "+String.valueOf(this.ctrl.getCpt()));
        this.speed =new JLabel("     Vitesse :  "+String.valueOf(this.ctrl.getTimeDelay())+" ms");
       
        
        
        // Fenetre
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setPreferredSize(new Dimension(900,900));
        //this.fenetre.setLocationRelativeTo(null);
        
        
        //Panel     
        this.frame.getContentPane().add(panel,BorderLayout.NORTH);
        this.panel.setPreferredSize(new Dimension(900,800));
        
        //Panel 2
        this.frame.getContentPane().add(panel2);

        //Label
        this.panel2.add(move);
   
        //Button
        this.panel2.add(start);
        this.panel2.add(stop);
        this.panel2.add(lowspeed);
        this.panel2.add(fastspeed);
        this.panel2.add(speed);
        this.panel2.add(restart);
        
        
        this.start.addActionListener(ctrl);
        this.stop.addActionListener(ctrl);
        this.lowspeed.addActionListener(ctrl);
        this.fastspeed.addActionListener(ctrl);
        this.restart.addActionListener(ctrl);
        
      
        
        // Layout : Grille de la taille du plateau 
        GridLayout layout = new GridLayout(this.ctrl.getModel().getTailleGrille(),this.ctrl.getModel().getTailleGrille());
        this.panel.setLayout(layout);
        
        GridLayout layout2 = new GridLayout(1,6);
        this.panel2.setLayout(layout2);
        

        
        for (int i =0;i<this.cellules.length;i++){
            
            for ( int j=0; j<this.cellules[i].length;j++){
              
                this.cellules[i][j] = new JPanel(); // Instanciation des Panels
                this.panel.add(this.cellules[i][j]);  // on les ajoute au panneau
                this.cellules[i][j].setBorder(BorderFactory.createLineBorder(java.awt.Color.GRAY));  // bordure grise sur les panels
                
                if (i == this.ctrl.getModel().getAnt().getCell().getX() && j == this.ctrl.getModel().getAnt().getCell().getY()){ // si la coordonnée correspond à celle de la fourmi,
                    this.cellules[i][j].setBackground(java.awt.Color.red); //  elle sera rouge
                } else {
                    this.cellules[i][j].setBackground(this.ctrl.getModel().getPlateau()[i][j].getCouleur()); // sinon elle sera de la couleur qu'elle doit être
                    
                }
                
            }   
            
        }
   
    }


    public void update(){ // mise à jour des couleurs
             
        this.cellules[x][y].setBackground(this.ctrl.getModel().getPlateau()[x][y].getCouleur());
        
        //update pos ant
        this.x =this.ctrl.getModel().getAnt().getCell().getX();
        this.y =this.ctrl.getModel().getAnt().getCell().getY();

        this.cellules[x][y].setBackground(java.awt.Color.red);
        
        this.move.setText("           Moves :   "+String.valueOf(this.ctrl.getCpt()));
        this.speed.setText("     Vitesse :  "+String.valueOf(this.ctrl.getTimeDelay())+" ms");
        
    }
    

    public void afficheInterface(){
        this.frame.pack();
        this.frame.setVisible(true);   
    }

    public AntController getCtrl() {
        return ctrl;
    }

    public JFrame getFrame() {
        return frame;
    }

    public JLabel getMove() {
        return move;
    }

    public JPanel[][] getCellules() {
        return cellules;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    
    
 
}
