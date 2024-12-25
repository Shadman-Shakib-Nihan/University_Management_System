package classes;

import javax.swing.*;
import java.awt.*;

public class Welcome extends JFrame implements Runnable {
    Thread t;

    public Welcome() { 
        
        ImageIcon i1 = new ImageIcon("icons/welcome.jpg");
        Image i2 = i1.getImage().getScaledInstance(700, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
          

            t=new Thread(this);
            t.start();

            setLocation(330, 120);
            setSize(700, 600);
            setVisible(true);
            

        }

        public void run(){
            try{
                Thread.sleep(3000);
                setVisible(false);

                new Login();


            }catch(Exception e){

            }

        }
}
