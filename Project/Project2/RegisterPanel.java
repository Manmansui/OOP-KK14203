import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.io.IOException;

public class RegisterPanel extends JPanel {
    private JButton submit;
    private JButton Back;
    private JLabel username;
    private JLabel jcomp4;
    private JLabel Admin;
    private JTextField JuserName;
    private JTextField JPassword;
    private JTextField JAdmincode;
    private JLabel header;
    private JFrame framez;
    private Login logz;
    private String PassFileName = "password.txt";
    private String output = " ";
    

    public RegisterPanel(JFrame frame, Login log) {
    
        framez = frame;
        logz = log;
    
        //construct components
        header = new JLabel ("Registration: ");
        submit = new JButton ("Submit");
        Back = new JButton ("Back");
        username = new JLabel ("Username");
        username.setFont(new Font("Verdana", Font.PLAIN, 11));
        header = new JLabel ("Registration: ");
        header.setFont(new Font("Verdana", Font.PLAIN, 15));
        
        jcomp4 = new JLabel ("Password");
        jcomp4.setFont(new Font("Verdana", Font.PLAIN, 11));
        
        Admin = new JLabel ("Administrator Code");
        Admin.setFont(new Font("Verdana", Font.PLAIN, 11));
        JuserName = new JTextField (5);
        JPassword = new JTextField (5);
        JAdmincode = new JTextField (5);
        JAdmincode.setText("Admin123");

        //adjust size and set layout
        setPreferredSize (new Dimension (520, 291));
        setLayout (null);

        //add components
        add (submit);
        add (Back);
        add (username);
        add (jcomp4);
        add (Admin);
        add (JuserName);
        add (JPassword);
        add (JAdmincode);
        add (header);

        //set component bounds (only needed by Absolute Positioning)
        submit.setBounds (255, 230, 100, 25);
        Back.setBounds (130, 230, 100, 25);
        username.setBounds (65, 65, 100, 25);
        jcomp4.setBounds (65, 105, 100, 25);
        Admin.setBounds (65, 145, 125, 25);
        JuserName.setBounds (200, 65, 175, 25);
        JPassword.setBounds (200, 105, 175, 25);
        JAdmincode.setBounds (200, 145, 105, 25);
        header.setBounds (65, 30, 200, 25);
        
        
        
        submit.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent ev) {
         
         output += JuserName.getText() + " " + JPassword.getText();
         String AdminCode = JAdmincode.getText().toString();
           if(AdminCode.equals("Admin123")){
               writeInput();
               JOptionPane.showMessageDialog(null, "Successfully registered!");
           }else{
               JOptionPane.showMessageDialog(null, "Registration failed!");
           }
           
               
         }
       });
        
        
        Back.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent ev) {
             frame.getContentPane().removeAll();
             frame.getContentPane().add (new LoginPanel(framez, logz));             
             frame.pack();
             frame.setVisible (true);
         }
       });
       
       
        
    }
    
    public void writeInput(){
      File file = new File(PassFileName);
		FileWriter fr = null;
		BufferedWriter br = null;
		PrintWriter pr = null;
		try {
			// to append to file, you need to initialize FileWriter using below constructor. ok sir
			fr = new FileWriter(file, true);
			pr = new PrintWriter(fr);
			pr.print(output);
         System.out.println("Success");
		} catch (IOException e) {			
         System.out.println(e.toString());
		} finally {
			try {
				pr.close();
				br.close();
				fr.close();
			} catch (IOException e) {
				System.out.println(e.toString());
			}catch(NullPointerException f){
           System.out.println("Overall okay");
         }
         
		}
    }
    
    

}
