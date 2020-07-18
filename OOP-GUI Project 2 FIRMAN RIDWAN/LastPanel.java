import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.io.*;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

class LastPanel extends JPanel{

   Profile a;
   Patient b;
   Prescription c;
   Date d;
   Ward ez;
   

    private JTextArea info;
    private JLabel header3;
    private JButton print;
    private JButton exit;
    private JButton back;
    private JLabel printResult;
    private JScrollPane SP;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem NEWOWNER;
    private JMenuItem EXIT;


    JFrame frame3;
    JFrame popup;//frame for popup filename
    String filename = "text.txt";//user can change to another filename//
    String result = "";
    String extension = "";
    String finals = "";
    Border border = BorderFactory.createLineBorder(Color.BLACK, 1);

    public LastPanel(JFrame frame2, Profile a, Patient b, Prescription c, Date d, Ward ez) {
    
        frame3 = frame2;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.ez = ez;
    
    
        //----------------------
        menuBar = new JMenuBar();
        menu = new JMenu("Menu");
        menu.setMnemonic(KeyEvent.VK_M);
        
        NEWOWNER = new JMenuItem("New owner.", KeyEvent.VK_T);
        NEWOWNER.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_1, ActionEvent.ALT_MASK));
        menu.add(NEWOWNER);
        
        
        EXIT = new JMenuItem("Exit.",KeyEvent.VK_G);
        EXIT.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_1, ActionEvent.ALT_MASK));
        menu.add(EXIT);       
                
                
        menuBar.add(menu);
        add(menuBar);   
        menuBar.setBounds(2, 0, 100, 27); 
        
        NEWOWNER.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent ev) {
           System.out.println("OK");
           frame3.getContentPane().removeAll();
           frame3.getContentPane().add (new ProfilePanel(frame3));             
           frame3.pack();
           frame3.setLocationRelativeTo(null);
           frame3.setVisible (true);
         }
       });
       
        EXIT.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent ev) {
            popup = new JFrame();
            int dialogResult = JOptionPane.showConfirmDialog (popup, "Are you sure?","Warning",JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if(dialogResult == JOptionPane.YES_OPTION){
              System.exit(0);
            }
         }
       });
       
        //------------------------
        //construct components
        info = new JTextArea (20, 20);
        info.setFont(new Font("Arial", Font.PLAIN, 15));
        header3 = new JLabel ("Information:");
        header3.setFont(new Font("Arial", Font.ITALIC, 15));
        print = new JButton ("Print");
        exit = new JButton ("Exit");
        back = new JButton ("Edit");
        printResult = new JLabel("");
        printResult.setBorder(border);
	printResult.setFont(new Font("Arial", Font.BOLD, 10));
        SP = new JScrollPane(info);

        //adjust size and set layout
        setPreferredSize (new Dimension (640, 538));
        setLayout (null);

        //add components
        //add (info);
        add (header3);
        add (print);
        add (exit);
        add (back);
        add (printResult);
        add (SP);
        
        revalidate();
        repaint();


        //set component bounds (only needed by Absolute Positioning)
        header3.setBounds (70, 25, 100, 25);
        print.setBounds (185, 470, 100, 25);
        exit.setBounds (300, 470, 100, 25);
        back.setBounds (70, 470, 100, 25);
        printResult.setBounds(410, 470, 225, 25);
        SP.setBounds (70, 50, 420, 400);
        SP.setBorder(border);//--------------
        SP.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        
        result = "#DETAILS#" +
                        "\nOwner: " + a.getName() +
                        "\nI/C: " + a.getIc() +
                        "\nAge: " + a.getAge() +
                        "\nAddress " + a.getAddress() +
                        "\n" +
                        "\nPet's name: " + b.getPetName() +
                        "\nPet's age: " + b.getPetAge() +
                        "\nPet's type: " + b.getType() +
                        "\nPet's Special feature: " + b.getSpecialFeature() +
                        "\n" +
                        "\nEntry date: " + d.getEntDate() +
                        "\nAppoinment date: " + d.getAppointDate() +
                        "\n" +
                        "\nDisease: " + c.getDiseaseName() +
                        "\nMedicine: " + c.getMedicineName() +
                        "\nMedicine prescription: " + c.getMedicinePresc() +
                        "\n" + 
                        "\nWard confirmation: " + ez.getConfirmation();
         if(ez.getConfirmation().equals("Yes")){
            result += "\nWarding date: " + ez.get_date() +
                      "\nWard No: " + ez.get_ward() + 
                      "\nDate of discharge: " + ez.get_discharge() +
                      "\n" +
                      "\nTreatment cost: " + ez.get_cost();
         }else{
            result += "\n\nTreatment cost: " + ez.get_cost();
         }
         
        finals += result +
                  "\n--------------------------------------------------------\n\n";//for print differ between differ owner;         
        info.setText(result);//----------
        info.setEditable(false);
        
        back.addActionListener(new ActionListener(){  //---------------Back button
            public void actionPerformed(ActionEvent e){
              frame3.getContentPane().removeAll();
              frame3.getContentPane().add (new PetPanel(frame3, a, b, c, d, ez));             
              frame3.pack();
              frame3.setVisible (true);
              frame3.setLocationRelativeTo(null);
                       
            }  
         });
         
         print.addActionListener(new ActionListener(){  //---------------Back button
            public void actionPerformed(ActionEvent e){
              popup = new JFrame();
                 filename=JOptionPane.showInputDialog(popup,"Enter Filename(Include file extension): ");
              if(filename==null)   
                 popup.dispose();
              else{
              
                 //-----------------
                 File f = new File(filename);
                  if(f.isFile()) { 
                      popup = new JFrame();
                      int testing = JOptionPane.showConfirmDialog (popup, "The filename already exist with data, proceed?(YES=Delete & Add, NO=Just Add)",
                                                                   "Warning",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
                      if(testing == JOptionPane.YES_OPTION){
                         justWriter();
                        }
                      else if(testing == JOptionPane.NO_OPTION) writeInput();
                      else{ 
                         popup.dispose();
                      }
                        
                  }else{
                    writeInput();
                  }
              }
              
            }
         });
         
         exit.addActionListener(new ActionListener(){  //---------------exit button
            public void actionPerformed(ActionEvent e){
            popup = new JFrame();
            int dialogResult = JOptionPane.showConfirmDialog (popup, "Are you sure?","Warning",JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if(dialogResult == JOptionPane.YES_OPTION){
              System.exit(0);
            }else 
               popup.dispose();
            }  
         });

        
        
    }
    public void writeInput(){
      File file = new File(filename);
		FileWriter fr = null;
		BufferedWriter br = null;
		PrintWriter pr = null;
		try {
			// to append to file, you need to initialize FileWriter using below constructor. ok sir
			fr = new FileWriter(file, true);
			br = new BufferedWriter(fr);
			pr = new PrintWriter(br);
			pr.println(finals);
         printResult.setText("Successfully printing data to " + filename);
		} catch (IOException e) {			
         printResult.setText(e.toString());
		} finally {
			try {
				pr.close();
				br.close();
				fr.close();
			} catch (IOException e) {
				printResult.setText("Error! Missing file");
			}catch(NullPointerException f){
            printResult.setText("Error! filename cannot empty");
         }
		}
    }
    
    public void justWriter(){
    
    try{
      PrintWriter out = new PrintWriter(filename); 
      out.println(finals);
      out.close();
      printResult.setText("Successfully printing data to " + filename);  
      }catch(IOException e){
        System.out.println("ERROR: " + e);
     } 
       
   }

}
