import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.io.*;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

class ProfilePanel extends JPanel{
    Profile a;


    private JLabel patient_profile;
    private JLabel jcomp2;
    private JLabel ic_num;
    private JLabel jcomp4;
    private JLabel jcomp5;
    private JButton Submit;
    private JButton reset;
    private JTextField J_Name;
    private JTextField J_IC;
    private JTextField J_Age;
    private JTextArea Jaddress;
    private JLabel notice;
    JFrame frame;
    Border border = BorderFactory.createLineBorder(Color.BLACK, 1);

    public ProfilePanel(JFrame frame) {
        //construct components
        a = new Profile();
        patient_profile = new JLabel ("       Pet's owner profile");
        patient_profile.setFont(new Font("Arial", Font.PLAIN, 20));
        patient_profile.setBorder(border);
        
        jcomp2 = new JLabel ("Name");
        jcomp2.setFont(new Font("Arial", Font.PLAIN, 15));
        
        ic_num = new JLabel ("I/C");
        ic_num.setFont(new Font("Arial", Font.PLAIN, 15));
        
        jcomp4 = new JLabel ("Age");
        jcomp4.setFont(new Font("Arial", Font.PLAIN, 15));
        
        jcomp5 = new JLabel ("Address");
        jcomp5.setFont(new Font("Arial", Font.PLAIN, 15));
        
        reset = new JButton ("Reset");
        Submit = new JButton ("Submit");
        
        J_Name = new JTextField ();
        J_Name.setFont(new Font("Arial", Font.PLAIN, 15));
        
        J_IC = new JTextField ();
        J_IC.setFont(new Font("Arial", Font.PLAIN, 15));
        
        J_Age = new JTextField ();
        J_IC.setFont(new Font("Arial", Font.PLAIN, 15));

        Jaddress = new JTextArea (5, 5);
        Jaddress.setLineWrap(true); 
        
        notice = new JLabel("");

        //adjust size and set layout
        setPreferredSize (new Dimension (520, 291));
        setLayout (null);

        //add components
        add (patient_profile);
        add (jcomp2);
        add (ic_num);
        add (jcomp4);
        add (jcomp5);
        add (Submit);
        add (reset);
        add (J_Name);
        add (J_IC);
        add (J_Age);
        add (Jaddress);
        add (notice);

        //set component bounds (only needed by Absolute Positioning)
        patient_profile.setBounds (135, 20, 250, 30);
        jcomp2.setBounds (40, 60, 100, 25);
        ic_num.setBounds (40, 90, 100, 25);
        jcomp4.setBounds (40, 122, 100, 25);
        jcomp5.setBounds (40, 150, 100, 25);
        reset.setBounds (270, 245, 100, 25);
        Submit.setBounds (140, 245, 100, 25);
        notice.setBounds (140,270, 250, 25);
        J_Name.setBounds (135, 60, 275, 25);
        J_IC.setBounds (135, 91, 195, 25);
        J_Age.setBounds (135, 123, 60, 25);
        Jaddress.setBounds (135, 155, 195, 75);
        
        Submit.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){
                boolean test = true;
               
                
                if(J_Name.getText().equals("") || J_IC.getText().equals("") || Jaddress.getText().equals("") || J_Age.getText().equals("")){ 
                    notice.setText("All field must be fill!.Thank you");// better add popup panel for error
                    test = false;
                } 
                
                a.setName(J_Name.getText());    //set value to profile class
                a.setIc(J_IC.getText());       
                a.setAddress(Jaddress.getText());      
                a.setAge(J_Age.getText());
                
                if(test){
                  frame.getContentPane().removeAll();
                  frame.getContentPane().add (new PetPanel(frame, a));             
                  frame.pack();
                  frame.setVisible (true);
                  frame.setLocationRelativeTo(null);
                }
                
                       
            }  
         });
         
         reset.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){
                J_Name.setText("");
                J_IC.setText("");       
                Jaddress.setText("");      
                J_Age.setText("");        
            }  
         });
    }
         
}
