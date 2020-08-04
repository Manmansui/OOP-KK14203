import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.io.*;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
//=====================================



class LoginPanel extends JPanel {
    private JLabel header, jcomp2, jcomp3;
    private TextField jtf_user;//-===================
    private JPasswordField jpf_pass;
    private JButton b_log;
    private JLabel success;
    private JButton reset;
    private  JFrame frame;
    Border border = BorderFactory.createLoweredBevelBorder();
    
    //============================================
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem REGISTER;
    

    public LoginPanel(JFrame frame1, Login log) {
        UIManager.put("Button.background", Color.GRAY);
        frame = frame1;
        
        
        //==================================================//
        menuBar = new JMenuBar();
        menu = new JMenu("Menu");
        menu.setMnemonic(KeyEvent.VK_M);
        
        
        REGISTER = new JMenuItem("Register. ", KeyEvent.VK_T);
        REGISTER.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_1, ActionEvent.ALT_MASK));
        menu.add(REGISTER);
        
        menuBar.add(menu);
        add(menuBar);   
        menuBar.setBounds(2, 0, 640, 27); 
        
        
        //construct components
        header = new JLabel ("Veterinary Registration System");
        header.setFont(new Font("Arial", Font.ITALIC, 20));
        header.setBorder(border); 
        header.setOpaque(true);
        header.setToolTipText("firman 123");
        header.setForeground(Color.DARK_GRAY);
        
        jcomp2 = new JLabel ("Username");
        jcomp2.setFont(new Font("Arial", Font.PLAIN, 15)); 
        
        jcomp3 = new JLabel ("Password");
        jcomp3.setFont(new Font("Arial", Font.PLAIN, 15)); 
        
        jtf_user = new TextField ();
        jtf_user.setFont(new Font("Arial", Font.PLAIN, 15));
        jtf_user.setText("firman");
        
        jpf_pass = new JPasswordField ();
        jpf_pass.setFont(new Font("Arial", Font.PLAIN, 15));
        jpf_pass.setText("123");
   
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
        header.setBounds (110, 40, 290, 35);
        jcomp2.setBounds (55, 100, 100, 25);
        jcomp3.setBounds (55, 135, 100, 25);
        jpf_pass.setBounds (160, 135, 210, 30);//-----
        jtf_user.setBounds (160, 95, 210, 29);
        reset.setBounds (270, 185, 100, 25);
        b_log.setBounds (160, 185, 100, 25);
        success.setBounds (55, 210, 250, 25);
        
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
         
         REGISTER.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent ev) {
           System.out.println("OK");
           System.out.println("test");
                  frame.getContentPane().removeAll();
                  frame.getContentPane().add (new RegisterPanel(frame, log));             
                  frame.pack();
                  frame.setVisible (true);
         }
       });
       
       
    }
    
}

