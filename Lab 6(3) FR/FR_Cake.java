
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.ArrayList;
import java.io.*;
import java.io.IOException;

class cakePanel extends JPanel implements ActionListener{
    private JLabel jcomp1;
    private JLabel jcomp2;
    private JButton btnAdd;
    private JTextArea jt1;
    private JComboBox jcb;
    private JButton btnOrder;
    private static Cake cake;//-----------------
    private static ArrayList<String> order;
    private JButton save;
    private JFrame framezx;
    private String filename;
    private String finals = "";
    private String cakeName = "";
    public boolean checkOrder = false;
    
  //  public cakePanel(){
      
    //}

    public cakePanel(Cake cake, String cakeName) {
        this.cakeName = cakeName;
        this.cake = cake;
        order = new ArrayList<String>();
        //construct preComponents
        String[] jcbItems = {"[Select]"};

        //construct components
        jcomp1 = new JLabel (cakeName);//-------------------
        jcomp2 = new JLabel ("Toppings Selection");
        btnAdd = new JButton ("Add Topping");
        jt1 = new JTextArea (5, 5);
        JScrollPane jt1_sp = new JScrollPane(jt1);
        jcb = new JComboBox (jcbItems);
        btnOrder = new JButton ("Order");
        save = new JButton("Save");
        
        save.addActionListener(this);
        btnAdd.addActionListener(this);
        btnOrder.addActionListener(this);

        //adjust size and set layout
        setPreferredSize (new Dimension (514, 325));
        setLayout (null);

        //add components
        add (jcomp1);
        add (jcomp2);
        add (btnAdd);
        add (jt1_sp);
        add (jcb);
        add (btnOrder);
        add (save);

        //set component bounds (only needed by Absolute Positioning)
        jcomp1.setBounds (195, 10, 100, 25);
        jcomp2.setBounds (25, 55, 125, 25);
        btnAdd.setBounds (365, 55, 125, 25);
        jt1_sp.setBounds (25, 120, 465, 180);
        jcb.setBounds (180, 55, 180, 25);
        btnOrder.setBounds (365, 90, 125, 25);
        save.setBounds (230, 90, 125, 25);
    }
    
   public void actionPerformed(ActionEvent ae){
      String command = ae.getActionCommand(); 
      String checkzx = "";
      
      if(command.equals("Add Topping")){
         
         order.add(jcb.getSelectedItem().toString());      
         jt1.append(jcb.getSelectedItem().toString() + "\n");   
      }
      else if(command.equals("Order")){

         setCheck();
         String str_order[] = new String[order.size()]; 
  
         // ArrayList to Array Conversion 
         for (int j = 0; j < order.size(); j++) { 
            // Assign each value to String array 
            str_order[j] = order.get(j); 
         }
         
           
         cake.cakeOrder(str_order, 1, 2);//----------------------------------
         String txt = cake.printOrder_GUI();
         jt1.append(txt);
      }//-----------------------
      
      else if(command.equals("Save") && getCheck()==false){
         JOptionPane.showMessageDialog(null, "Please order first, Thank you..");
      }
 
      
      else if(command.equals("Save") && getCheck()==true){
        finals = cake.printOrder_GUI();
        framezx = new JFrame();
        filename=JOptionPane.showInputDialog(framezx,"Enter Filename(Include file extension): ");
              if(filename==null)   
                 framezx.dispose();
              else{
                 File f = new File(filename);
                  if(f.isFile()) { 
                      framezx = new JFrame();
                      int testing = JOptionPane.showConfirmDialog (framezx, "The filename already exist with data, proceed?(YES=Delete & Add, NO=Just Add)",
                                                                   "Warning",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
                      if(testing == JOptionPane.YES_OPTION){
                         justWriter();
                        }
                      else if(testing == JOptionPane.NO_OPTION) writeInput();
                      else{ 
                         framezx.dispose();
                      }
                        
                  }else{
                    writeInput();
                  }
              }
       } 
       
   }
   public void setCheck(){
      checkOrder = true;
   }   
   public boolean getCheck(){
      return checkOrder;
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
        // printResult.setText("Successfully printing data to " + filename);
		} catch (IOException e) {			
           System.out.println(e.toString());
		}catch(NullPointerException f){
           System.out.println("Error bh null pointer");
      }
      
       finally {
			try {
				pr.close();
				br.close();
				fr.close();
			} catch (IOException e) {
				System.out.println("Error! Missing file");//----------------------------
			}catch(NullPointerException f){
           System.out.println("Error! filename cannot empty");
         }
		}
    }
    
    public void justWriter(){
    
    try{
      PrintWriter out = new PrintWriter(filename); 
      out.println(finals);
      out.close();
         System.out.println("Successfully printing data to " + filename);  
      }catch(IOException e){
        System.out.println("ERROR: " + e);
     } 
       
   }
       
   public void updateCB(String[] topping){
      for(int i=0; i<topping.length; i++){
         jcb.addItem(topping[i]);
      }      
   }

   
}
public class FR_Cake{

   private static Cake cake;

   public static void main (String[] args) {
      cake = new Cake("Generic");
      //array list removed here 
      
      JFrame frame = new JFrame ("MyCakes");
      String[] topping = {"Lava Chocolate", "Cream Cheese", "Candy Pop", "Fondant"};
      cake.setCake(topping, 45.00, 65.00, 80.00); 
      
      cakePanel capp = new cakePanel(cake, cake.name + " cake."); //-------------------
      capp.updateCB(topping);
      
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add (capp);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible (true);
   }
}