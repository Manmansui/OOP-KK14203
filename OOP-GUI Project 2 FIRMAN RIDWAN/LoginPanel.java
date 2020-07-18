import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.io.*;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

class LoginPanel extends JPanel {
    private JLabel header, jcomp2, jcomp3;
    private JTextField jtf_user;
    private JPasswordField jpf_pass;
    private JButton b_log;
    private JLabel success;
    private JButton reset;
    private  JFrame frame;
    Border border = BorderFactory.createLoweredBevelBorder();
    

    public LoginPanel(JFrame frame1, Login log) {
        UIManager.put("Button.background", Color.GRAY);
        frame = frame1;
        
        //construct components
        header = new JLabel ("Veterinary Registration System");
        header.setFont(new Font("Arial", Font.ITALIC, 20));
        header.setBorder(border); 
        header.setOpaque(true);
        header.setForeground(Color.DARK_GRAY);
        
        jcomp2 = new JLabel ("Username");
        jcomp2.setFont(new Font("Arial", Font.PLAIN, 15)); 
        
        jcomp3 = new JLabel ("Password");
        jcomp3.setFont(new Font("Arial", Font.PLAIN, 15)); 
        
        jtf_user = new JTextField ();
        jtf_user.setFont(new Font("Arial", Font.PLAIN, 15));
        
        jpf_pass = new JPasswordField ();
        jpf_pass.setFont(new Font("Arial", Font.PLAIN, 15));
   
        b_log = new JButton ("Login");
        success = new JLabel("");
        success.setFont(new Font("Arial", Font.PLAIN, 15));
        reset = new JButton("Reset");

        //adjust size and set layout
        setPreferredSize (new Dimension (520, 291));
        setLayout (null);

        //add components
        add (header);
        add (jcomp2);
        add (jcomp3);
        add (jtf_user);
        add (jpf_pass);
        add (b_log);
        add (success);
        add (reset);

        //set component bounds (only needed by Absolute Positioning)
        header.setBounds (110, 30, 290, 35);
        jcomp2.setBounds (55, 100, 100, 25);
        jcomp3.setBounds (55, 135, 100, 25);
        jpf_pass.setBounds (160, 135, 210, 30);
        jtf_user.setBounds (160, 95, 210, 30);
        reset.setBounds (270, 175, 100, 25);
        b_log.setBounds (160, 175, 100, 25);
        success.setBounds (55, 200, 250, 25);
        
        reset.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){
               jtf_user.setText("");         
               jpf_pass.setText("");             
            }  
         });
        
        b_log.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){
               int trialRem = log.test();
               if(trialRem==0){
                  System.exit(0);
               }
               boolean status=false;
               if(!jtf_user.getText().equals("") && !jpf_pass.getText().equals("")){  
                  status = log.testLogin(jtf_user.getText(), jpf_pass.getText());
               }
               if(status==false) {
                  success.setText("Login failed!!. Trial remaining: " + (trialRem-1));
                  log.failedTest();
               }
               
               
               if(status){
                  System.out.println("test");
                  frame.getContentPane().removeAll();
                  frame.getContentPane().add (new ProfilePanel(frame));             
                  frame.pack();
                  frame.setVisible (true);
               }          
                     
                       
            }  
         });
    }
    
}

