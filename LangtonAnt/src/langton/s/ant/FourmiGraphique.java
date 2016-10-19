package langton.s.ant;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.TreeMap;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.color;
import static javafx.scene.paint.Color.color;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class FourmiGraphique {
    
    private JFrame fenetre;
    private JPanel panneau;
    private JPanel[][] cellules;
    private FourmiControleur ctrl;
    private int x; // x de la fourmi
    private int y; // y de la fourmi
    
    
    public FourmiGraphique (FourmiControleur ctrl){
        this.fenetre=new JFrame("Fourmi de Langton");
        this.ctrl=ctrl;
        this.panneau=new JPanel();
        this.cellules = new JPanel[this.ctrl.getModèle().getTailleGrille()][this.ctrl.getModèle().getTailleGrille()];
        
        this.x =this.getCtrl().getModèle().getAnt().getCell().getX();
        this.y =this.getCtrl().getModèle().getAnt().getCell().getY();
        
        // Fenetre
        
        this.fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.fenetre.setPreferredSize(new Dimension(900,900));
        this.fenetre.setLocationRelativeTo(null);
        //this.fenetre.setResizable(false);
        
        //Panel
        this.fenetre.setContentPane(panneau);
        
        
        // Layout 
        
        GridLayout layout = new GridLayout(this.ctrl.getModèle().getTailleGrille(),this.ctrl.getModèle().getTailleGrille());
        this.fenetre.setLayout(layout);
        
        
        for (int i =0;i<this.cellules.length;i++){
            
            for ( int j=0; j<this.cellules[i].length;j++){
              
                this.cellules[i][j] = new JPanel();
                
                this.panneau.add(this.cellules[i][j]);
                this.cellules[i][j].setBorder(BorderFactory.createLineBorder(java.awt.Color.GRAY));
                
                if (i == this.ctrl.getModèle().getAnt().getCell().getX() && j == this.ctrl.getModèle().getAnt().getCell().getY()){
                    this.cellules[i][j].setBackground(java.awt.Color.red);
                } else {
                    this.cellules[i][j].setBackground(this.ctrl.getModèle().getPlateau()[i][j].getCouleur());
                }
                
            }   
            
        }
        
        this.fenetre.repaint();
        
    }

    
    public void mise_a_jour(){
        
        for (int i =0;i<this.cellules.length;i++){
            
            for ( int j=0; j<this.cellules[i].length;j++){

                if (i == this.ctrl.getModèle().getAnt().getCell().getX() && j == this.ctrl.getModèle().getAnt().getCell().getY()){
                    this.cellules[i][j].setBackground(java.awt.Color.red);
                } else {
                    this.cellules[i][j].setBackground(this.ctrl.getModèle().getPlateau()[i][j].getCouleur());
                }
                
   
            }   
            
        }
        
        
        
        
        
    }
    
    
    

    
        public void afficheInterface()
    {
        this.fenetre.pack();
        this.fenetre.setVisible(true);
        
        
    }

   
    public FourmiControleur getCtrl() {
        return ctrl;
    }

    public JFrame getFenetre() {
        return fenetre;
    }
    
    
    

    
    
    
    
    
    
    
    
    
    
    
}
