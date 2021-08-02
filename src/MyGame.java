

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class MyGame extends JFrame implements ActionListener {
     JLabel heading;
    Font font =new Font("",Font.BOLD,30);
    
    JPanel mainPanel;
    JButton[] btns=new JButton[9];
    int gameChances[]={2,2,2,2,2,2,2,2,2};
    int activePlayer=0;
    int wps[][] = {
        {0, 1, 2},

        {3, 4, 5},

        {6, 7, 8},

        {0, 3, 6},

        {1, 4, 7},

        {2, 5, 8}, 
        {0, 4, 8},

        {2, 4, 6}};
    int winner=2;
    boolean gameOver =false;
    MyGame()
    {
        setTitle("Tic Tac Toe Game"); 
    setSize(450,450);
    ImageIcon icon =new ImageIcon("src/img/tic.png");
                
        setIconImage(icon.getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createGUI();
        setVisible(true);
    }
    private void createGUI()
    {this.getContentPane().setBackground(Color.decode("#17202A"));
        this.setLayout(new BorderLayout());
        heading=new JLabel("Tic Tac Toe");

        heading.setFont(font);
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        heading.setForeground(Color.white);
        
        this.add(heading,BorderLayout.NORTH);
        mainPanel =new JPanel();
        mainPanel .setLayout(new GridLayout(3,3));
        
        for(int i=1;i<=9;i++){
            JButton btn =new JButton();
//            ImageIcon icon = new ImageIcon("src/img/X.jpg");
//            Image scaleImage = icon.getImage().getScaledInstance(70, 70,Image.SCALE_DEFAULT);

//            btn.setIcon(new ImageIcon(scaleImage));
            btn.setBackground(Color.BLACK);
            btn.setFont(font);
            mainPanel.add(btn);
            btns[i-1]=btn;
            btn.addActionListener(this);
            btn.setName(String.valueOf(i-1));
        }
                 
        
        this.add(mainPanel,BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
   JButton currentButton=(JButton)   e.getSource();
   String  nameStr=currentButton.getName();
   int name=Integer.parseInt(nameStr.trim());
   
   if(gameOver)
   {
       JOptionPane.showMessageDialog(this, "Game Over!!");
       return;
   }
 if(  gameChances[name]==2)
 {
     if(activePlayer==1)
     {   ImageIcon icon = new ImageIcon("src/img/O.png");
            Image scaleImage = icon.getImage().getScaledInstance(120, 120,Image.SCALE_DEFAULT);

         currentButton.setIcon(new ImageIcon(scaleImage));
         
         gameChances[name]=activePlayer;
         activePlayer=0;  
     }
     else
     {ImageIcon icon2 = new ImageIcon("src/img/X.jpg");
            Image scaleImage2 = icon2.getImage().getScaledInstance(70, 70,Image.SCALE_DEFAULT);

         currentButton.setIcon(new ImageIcon(scaleImage2));
          gameChances[name]=activePlayer;
       activePlayer=1;  
     }
     for(int[]temp:wps)
     {String xx = null;
         if( (gameChances[temp [0]] ==gameChances[temp [1]])&& (gameChances [temp[1]] ==gameChances [temp[2]])&&gameChances [temp[2]]!=2)
         {
            winner=gameChances[temp[0]]; 
            gameOver=true;
            if(winner==0)xx="X";
            else xx="O";
            JOptionPane.showMessageDialog(this, "Player "+ xx+" has won the game.");
            int i= JOptionPane.showConfirmDialog(this, "Do you want to play more?");
            System.out.print(i);
            if(i==0){
                this.setVisible(false);
                new MyGame();
            }
            else if(i==1)
            {
                System.exit(0);
            }
            else
            {
                
            }
            break;
         }

     }
     int c=0;
     for(int x:gameChances)
     {
         if(x==2)
         {
             c++;
             break;
         }
     }
     if(c==0&&gameOver==false)
     {
         JOptionPane.showMessageDialog(this, "Game is Draw");
       int i= JOptionPane.showConfirmDialog(this, "Do you want to play more?");
   
            if(i==0){
                this.setVisible(false);
                new MyGame();
            }
            else if(i==1)
            {
                System.exit(0);
            }
            else
            {
                
            }
            gameOver=true;
     }
 }
 else
 {
     JOptionPane.showMessageDialog(this, "Position Already Occupied!!");
 }
    }
}
