import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

class PetPanel extends JPanel {// please be carefull , this class have 2 long constructor
   
   Profile a;
   Patient b;
   Prescription c;
   Date d;
   Ward ez;
   
   private JFrame frame2;
    private JLabel header_pet;
    private JLabel pet_name;
    private JLabel pet_age;
    private JLabel pet_type;
    private JLabel s_feature;
    private JLabel entry_date;
    private JLabel jcomp7;
    private JLabel line1;
    private JLabel disease_name;
    private JLabel medicine_name;
    private JTextArea J_sp;
    private JComboBox entry_day;
    private JComboBox entry_month;
    private JComboBox entry_years;
    private JTextField J_name;
    private JTextField J_age;
    private JTextField J_type;
    private JComboBox appoint_day;
    private JComboBox appoint_month;
    private JComboBox appoint_years;
    private JLabel presc_name;
    private JTextField Jdisease;
    private JTextField Jmedicine;
    private JTextArea Jpresc;
    private JLabel medical_header;
    private JLabel ward_header;
    private JLabel confirm;
    private JLabel ward_no;
    private JLabel ward_date;
    private JLabel ward_disc;
    private JRadioButton conf_yes;
    private JRadioButton conf_no;
    private JTextField jWardNo;
    private JComboBox ward_day;
    private JComboBox ward_month;
    private JComboBox ward_year;
    private JComboBox dis_day;
    private JComboBox dis_month;
    private JComboBox dis_years;
    private JButton submit;
    private JButton reset;
    private JButton next;
    private JLabel line2;
    private JLabel cost_panel;
    private JTextField Jcost;
    private ButtonGroup G;

    //construct preComponents
    String[] days = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
                     "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
                     "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
                                   
    String[] months = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        
    String[] years = {"1995", "1996", "1997", "1998", "1999", "2000",
                      "2001", "2002", "2003", "2004", "2005", "2006", "2007",
                      "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015",
                      "2016", "2017", "2018", "2019", "2020"};

    public PetPanel(JFrame frame, Profile a) {// constructor 1
    
        frame2 = frame;
        this.a = a;
        b = new Patient();
        c = new Prescription();
        d = new Date();
        ez = new Ward();
        
        //construct components
        header_pet = new JLabel ("Pet's Information");
        header_pet.setFont(new Font("Arial", Font.ITALIC, 20)); 
        
        pet_name = new JLabel ("Name");
        pet_name.setFont(new Font("Arial", Font.PLAIN, 12)); 
        pet_age = new JLabel ("Age");
        pet_age.setFont(new Font("Arial", Font.PLAIN, 12)); 
        pet_type = new JLabel ("Type");
        pet_type.setFont(new Font("Arial", Font.PLAIN, 12)); 
        s_feature = new JLabel ("Special feature");
        s_feature.setFont(new Font("Arial", Font.PLAIN, 12));
        J_sp = new JTextArea (5, 5);
        J_sp.setLineWrap(true);
        J_name = new JTextField (5);
        J_age = new JTextField (5);
        J_type = new JTextField (5);

                
        entry_date = new JLabel ("Entry");
        jcomp7 = new JLabel ("Appointment");
        line1 = new JLabel ("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
        
        disease_name = new JLabel ("Disease");
        disease_name.setFont(new Font("Arial", Font.PLAIN, 12));
        medicine_name = new JLabel ("Medicine");
        medicine_name.setFont(new Font("Arial", Font.PLAIN, 12));
        presc_name = new JLabel ("Prescription");
        presc_name.setFont(new Font("Arial", Font.PLAIN, 12));
        
        
        entry_day = new JComboBox (days);
        entry_month = new JComboBox (months);
        entry_years = new JComboBox (years);
        
        appoint_day = new JComboBox (days);
        appoint_month = new JComboBox (months);
        appoint_years = new JComboBox (years);
        
 
        Jdisease = new JTextField (5);
        Jmedicine = new JTextField (5);
        Jpresc = new JTextArea (5, 5);
        
        medical_header = new JLabel ("Medical Checkup");
        medical_header.setFont(new Font("Arial", Font.PLAIN, 15));
        
        ward_header = new JLabel ("Ward ");
        ward_header.setFont(new Font("Arial", Font.PLAIN, 15));
        
        confirm = new JLabel ("Confirmation");
        confirm.setFont(new Font("Arial", Font.PLAIN, 12));
        ward_no = new JLabel ("Ward No.");
        ward_no.setFont(new Font("Arial", Font.PLAIN, 12));
        ward_date = new JLabel ("Ward date");
        ward_date.setFont(new Font("Arial", Font.PLAIN, 12));
        ward_disc = new JLabel ("Discharge date");
        ward_disc.setFont(new Font("Arial", Font.PLAIN, 12));
        conf_yes = new JRadioButton ("Yes");
        conf_no = new JRadioButton ("No");
        G = new ButtonGroup();
        G.add(conf_yes);
        G.add(conf_no);
        
        jWardNo = new JTextField (5);
        
        ward_day = new JComboBox (days);
        ward_month = new JComboBox (months);
        ward_year = new JComboBox (years);
        dis_day = new JComboBox (days);
        dis_month = new JComboBox (months);
        dis_years = new JComboBox (years);
        submit = new JButton ("Submit");
        reset = new JButton ("Reset");
        line2 = new JLabel ("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
        cost_panel = new JLabel ("Cost");
        cost_panel.setFont(new Font("Arial", Font.PLAIN, 12));
        Jcost = new JTextField (5);

        //adjust size and set layout
        setPreferredSize (new Dimension (640, 538));
        setLayout (null);

        //add components
        add (header_pet);
        add (pet_name);
        add (pet_age);
        add (pet_type);
        add (s_feature);
        add (entry_date);
        add (jcomp7);
        add (line1);
        add (disease_name);
        add (medicine_name);
        add (J_sp);
        add (entry_day);
        add (entry_month);
        add (entry_years);
        add (J_name);
        add (J_age);
        add (J_type);
        add (appoint_day);
        add (appoint_month);
        add (appoint_years);
        add (presc_name);
        add (Jdisease);
        add (Jmedicine);
        add (Jpresc);
        add (medical_header);
        add (ward_header);
        add (confirm);
        add (ward_no);
        add (ward_date);
        add (ward_disc);
        add (conf_yes);
        add (conf_no);
        add (jWardNo);
        add (ward_day);
        add (ward_month);
        add (ward_year);
        add (dis_day);
        add (dis_month);
        add (dis_years);
        add (submit);//-----------submit
        add (reset);//---------------reset
        add (line2);
        add (cost_panel);
        add (Jcost);


        //set component bounds (only needed by Absolute Positioning)
        header_pet.setBounds (230, 10, 150, 35);
        pet_name.setBounds (15, 55, 100, 25);
        pet_age.setBounds (15, 85, 100, 25);
        pet_type.setBounds (15, 120, 100, 25);
        s_feature.setBounds (15, 155, 150, 25);
        entry_date.setBounds (425, 50, 100, 25);
        jcomp7.setBounds (425, 100, 100, 25);
        line1.setBounds (20, 220, 490, 25);
        disease_name.setBounds (20, 274, 100, 25);
        medicine_name.setBounds (20, 305, 100, 25);
        J_sp.setBounds (130, 160, 200, 50);//-----------------patient
        entry_day.setBounds (425, 75, 45, 25);
        entry_month.setBounds (470, 75, 45, 25);
        entry_years.setBounds (515, 75, 65, 25);
        J_name.setBounds (130, 55, 141, 25);//-----------------patient
        J_age.setBounds (130, 86, 50, 25);//----------------patient
        J_type.setBounds (130, 121, 106, 25);//--------------patient
        appoint_day.setBounds (425, 125, 45, 25);
        appoint_month.setBounds (470, 125, 45, 25);
        appoint_years.setBounds (515, 125, 65, 25);
        presc_name.setBounds (20, 331, 100, 25);
        Jdisease.setBounds (103, 275, 200, 25);//------presc
        Jmedicine.setBounds (102, 306, 200, 25);//-----presc
        Jpresc.setBounds (102, 338, 180, 80);//------presc
        medical_header.setBounds (100, 245, 115, 25);
        ward_header.setBounds (425, 244, 100, 25);
        confirm.setBounds (330, 275, 100, 25);
        ward_no.setBounds (330, 305, 100, 25);
        ward_date.setBounds (330, 338, 100, 25);
        ward_disc.setBounds (330, 368, 100, 25);
        conf_yes.setBounds (435, 276, 50, 25);
        conf_no.setBounds (495, 276, 55, 25);
        jWardNo.setBounds (430, 310, 100, 25);
        ward_day.setBounds (430, 340, 45, 25);
        ward_month.setBounds (475, 340, 45, 25);
        ward_year.setBounds (519, 340, 65, 25);
        dis_day.setBounds (430, 370, 45, 25);
        dis_month.setBounds (475, 370, 45, 25);
        dis_years.setBounds (519, 370, 65, 25);
        submit.setBounds (222, 490, 100, 25);
        reset.setBounds (102, 490, 100, 25);
        line2.setBounds (20, 419, 440, 25);
        cost_panel.setBounds (20, 445, 74, 25);
        Jcost.setBounds (102, 445, 100, 25);

    
        submit.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){
            
              //class patient
               b.setPetName(J_name.getText());
               b.setType(J_type.getText());
               b.setPetAge(J_age.getText());
               b.setSpecialFeature(J_sp.getText());
              
              //class prescription
               c.setDiseaseName(Jdisease.getText());
               c.setMedicineName(Jmedicine.getText());
               c.setMedicinePresc(Jpresc.getText());
               
              //class date
              String entry = (String)entry_day.getSelectedItem() 
                              + "/" + (String)entry_month.getSelectedItem()
                              + "/" + (String)entry_years.getSelectedItem();
                              
              String appointment = (String)appoint_day.getSelectedItem() 
                              + "/" + (String)appoint_month.getSelectedItem()
                              + "/" + (String)appoint_years.getSelectedItem();
              
               d.setEntDate(entry);
               d.setAppointDate(appointment);
               
              //ward
              String wardz = (String)ward_day.getSelectedItem() 
                              + "/" + (String)ward_month.getSelectedItem()
                              + "/" + (String)ward_year.getSelectedItem();
              String dischargez = (String)dis_day.getSelectedItem() 
                              + "/" + (String)dis_month.getSelectedItem()
                              + "/" + (String)dis_years.getSelectedItem();
              
              
              if(conf_yes.isSelected()){
                 ez.set_date(wardz);
                 ez.set_ward_number(jWardNo.getText());
                 ez.set_discharged(dischargez);
                 ez.set_cost(Jcost.getText());
                 ez.confirmation(true);
                 
              }
              else if(conf_no.isSelected()){
                 ez.set_date("1/1/1995");
                 ez.set_ward_number("NULL");
                 ez.set_discharged("1/1/1995");
                 ez.set_cost(Jcost.getText());
                 ez.confirmation(false);
                 
              }
              
               if(J_name.getText().equals("") || J_type.getText().equals("")
                 || J_age.getText().equals("") || J_sp.getText().equals("") || Jdisease.getText().equals("")
                 || Jmedicine.getText().equals("") || Jpresc.getText().equals("") || jWardNo.getText().equals("")
                 || Jcost.getText().equals("") || (!conf_no.isSelected() && !conf_yes.isSelected())){
                 
                 JOptionPane.showMessageDialog(null, "All field must be fill, Thank you..");
              }else{  
              
                 frame2.getContentPane().removeAll();
                 frame2.getContentPane().add (new LastPanel(frame2, a, b, c, d, ez));             
                 frame2.pack();
                 frame2.setVisible (true);
                 frame2.setLocationRelativeTo(null);
                 
              } 
                       
            }  
         });
         
         reset.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){
            
              //class patient
               J_name.setText("");
               J_type.setText("");
               J_age.setText("");
               J_sp.setText("");
              
              //class prescription
               Jdisease.setText("");
               Jmedicine.setText("");
               Jpresc.setText("");
               
              //class date
              entry_day.setSelectedIndex(0); 
              entry_month.setSelectedIndex(0);
              entry_years.setSelectedIndex(0);
                              
              appoint_day.setSelectedIndex(0); 
              appoint_month.setSelectedIndex(0);
              appoint_years.setSelectedIndex(0);
              
               
              //ward
              ward_day.setSelectedIndex(0);
              ward_month.setSelectedIndex(0);
              ward_year.setSelectedIndex(0);
              
              dis_day.setSelectedIndex(0);
              dis_month.setSelectedIndex(0);
              dis_years.setSelectedIndex(0);
              
              conf_yes.setSelected(false);
              conf_no.setSelected(false);
              
              jWardNo.setText("");
              Jcost.setText("");
              
                       
            }  
         });

   
   }
   
   public PetPanel(JFrame frame, Profile a, Patient b, Prescription c, Date d, Ward ez) {//this for implementation of edit button
    
        frame2 = frame;
        this.a = a;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.ez = ez;
        
        
        //construct components
        header_pet = new JLabel ("Pet's Information");
        header_pet.setFont(new Font("Arial", Font.ITALIC, 20)); 
        
        pet_name = new JLabel ("Name");
        pet_name.setFont(new Font("Arial", Font.PLAIN, 12)); 
        pet_age = new JLabel ("Age");
        pet_age.setFont(new Font("Arial", Font.PLAIN, 12)); 
        pet_type = new JLabel ("Type");
        pet_type.setFont(new Font("Arial", Font.PLAIN, 12)); 
        s_feature = new JLabel ("Special feature");
        s_feature.setFont(new Font("Arial", Font.PLAIN, 12));
        J_sp = new JTextArea (5, 5);
        J_sp.setLineWrap(true);
        J_name = new JTextField (5);
        J_age = new JTextField (5);
        J_type = new JTextField (5);
                
        entry_date = new JLabel ("Entry");
        jcomp7 = new JLabel ("Appointment");
        line1 = new JLabel ("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
        
        disease_name = new JLabel ("Disease");
        disease_name.setFont(new Font("Arial", Font.PLAIN, 12));
        medicine_name = new JLabel ("Medicine");
        medicine_name.setFont(new Font("Arial", Font.PLAIN, 12));
        presc_name = new JLabel ("Prescription");
        presc_name.setFont(new Font("Arial", Font.PLAIN, 12));
        
        
        entry_day = new JComboBox (days);
        entry_month = new JComboBox (months);
        entry_years = new JComboBox (years);
        
        appoint_day = new JComboBox (days);
        appoint_month = new JComboBox (months);
        appoint_years = new JComboBox (years);
        
 
        Jdisease = new JTextField (5);
        Jmedicine = new JTextField (5);
        Jpresc = new JTextArea (5, 5);
        
        medical_header = new JLabel ("Medical Checkup");
        medical_header.setFont(new Font("Arial", Font.PLAIN, 15));
        
        ward_header = new JLabel ("Ward ");
        ward_header.setFont(new Font("Arial", Font.PLAIN, 15));
        
        confirm = new JLabel ("Confirmation");
        confirm.setFont(new Font("Arial", Font.PLAIN, 12));
        ward_no = new JLabel ("Ward No.");
        ward_no.setFont(new Font("Arial", Font.PLAIN, 12));
        ward_date = new JLabel ("Ward date");
        ward_date.setFont(new Font("Arial", Font.PLAIN, 12));
        ward_disc = new JLabel ("Discharge date");
        ward_disc.setFont(new Font("Arial", Font.PLAIN, 12));
        conf_yes = new JRadioButton ("Yes");
        conf_no = new JRadioButton ("No");
        G = new ButtonGroup();
        G.add(conf_yes);
        G.add(conf_no);
        
        jWardNo = new JTextField (5);
        
        ward_day = new JComboBox (days);
        ward_month = new JComboBox (months);
        ward_year = new JComboBox (years);
        dis_day = new JComboBox (days);
        dis_month = new JComboBox (months);
        dis_years = new JComboBox (years);
        submit = new JButton ("Submit");
        reset = new JButton ("Reset");
        line2 = new JLabel ("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
        cost_panel = new JLabel ("Cost");
        cost_panel.setFont(new Font("Arial", Font.PLAIN, 12));
        Jcost = new JTextField (5);

        //adjust size and set layout
        setPreferredSize (new Dimension (640, 538));
        setLayout (null);

        //add components
        add (header_pet);
        add (pet_name);
        add (pet_age);
        add (pet_type);
        add (s_feature);
        add (entry_date);
        add (jcomp7);
        add (line1);
        add (disease_name);
        add (medicine_name);
        add (J_sp);
        add (entry_day);
        add (entry_month);
        add (entry_years);
        add (J_name);
        add (J_age);
        add (J_type);
        add (appoint_day);
        add (appoint_month);
        add (appoint_years);
        add (presc_name);
        add (Jdisease);
        add (Jmedicine);
        add (Jpresc);
        add (medical_header);
        add (ward_header);
        add (confirm);
        add (ward_no);
        add (ward_date);
        add (ward_disc);
        add (conf_yes);
        add (conf_no);
        add (jWardNo);
        add (ward_day);
        add (ward_month);
        add (ward_year);
        add (dis_day);
        add (dis_month);
        add (dis_years);
        add (submit);//-----------submit
        add (reset);//---------------reset
        add (line2);
        add (cost_panel);
        add (Jcost);
        
        //if the edit button clicked, all the field was already fill as below -----only for second constructor-----
        //ward class
        String[] a_Entry = d.getEntry();
        String[] a_Appoint = d.getAppoint();
        
     entry_day.setSelectedItem(a_Entry[0]);
     entry_month.setSelectedItem(a_Entry[1]);
     entry_years.setSelectedItem(a_Entry[2]);

     appoint_day.setSelectedItem(a_Appoint[0]);   
     appoint_month.setSelectedItem(a_Appoint[1]);
     appoint_years.setSelectedItem(a_Appoint[2]);   
     
         String[] a_Ward = ez.getA_Ward();
         String[] a_Discharge = ez.getA_Discharge();
     
     ward_day.setSelectedItem(a_Ward[0]); 
     ward_month.setSelectedItem(a_Ward[1]);
     ward_year.setSelectedItem(a_Ward[2]);
     
     dis_day.setSelectedItem(a_Discharge[0]); 
     dis_month.setSelectedItem(a_Discharge[1]);
     dis_years.setSelectedItem(a_Discharge[2]);
     
     jWardNo.setText(ez.get_ward());
     Jcost.setText(ez.get_cost());
     
     J_name.setText(b.getPetName());
     J_age.setText(b.getPetAge());
     J_sp.setText(b.getSpecialFeature());
     J_type.setText(b.getType());
     
     
     Jdisease.setText(c.getDiseaseName());
     Jmedicine.setText(c.getMedicineName()); 
     Jpresc.setText(c.getMedicinePresc());
     
     
     
     
    //--------------end------------
       

        //set component bounds (only needed by Absolute Positioning)
        header_pet.setBounds (228, 10, 200, 35);
        pet_name.setBounds (15, 55, 100, 25);
        pet_age.setBounds (15, 85, 100, 25);
        pet_type.setBounds (15, 120, 100, 25);
        s_feature.setBounds (15, 155, 150, 25);
        entry_date.setBounds (425, 50, 100, 25);
        jcomp7.setBounds (425, 100, 100, 25);
        line1.setBounds (20, 220, 490, 25);
        disease_name.setBounds (20, 274, 100, 25);
        medicine_name.setBounds (20, 305, 100, 25);
        J_sp.setBounds (130, 160, 200, 50);//-----------------patient
        entry_day.setBounds (425, 75, 45, 25);
        entry_month.setBounds (470, 75, 45, 25);
        entry_years.setBounds (515, 75, 65, 25);
        J_name.setBounds (130, 55, 141, 25);//-----------------patient
        J_age.setBounds (130, 86, 50, 25);//----------------patient
        J_type.setBounds (130, 121, 106, 25);//--------------patient
        appoint_day.setBounds (425, 125, 45, 25);
        appoint_month.setBounds (470, 125, 45, 25);
        appoint_years.setBounds (515, 125, 65, 25);
        presc_name.setBounds (20, 331, 100, 25);
        Jdisease.setBounds (103, 275, 200, 25);//------presc
        Jmedicine.setBounds (102, 306, 200, 25);//-----presc
        Jpresc.setBounds (102, 338, 180, 80);//------presc
        medical_header.setBounds (100, 245, 115, 25);
        ward_header.setBounds (425, 244, 100, 25);
        confirm.setBounds (330, 275, 100, 25);
        ward_no.setBounds (330, 305, 100, 25);
        ward_date.setBounds (330, 338, 100, 25);
        ward_disc.setBounds (330, 368, 100, 25);
        conf_yes.setBounds (435, 276, 50, 25);
        conf_no.setBounds (495, 276, 55, 25);
        jWardNo.setBounds (430, 310, 100, 25);
        ward_day.setBounds (430, 340, 45, 25);
        ward_month.setBounds (475, 340, 45, 25);
        ward_year.setBounds (519, 340, 65, 25);
        dis_day.setBounds (430, 370, 45, 25);
        dis_month.setBounds (475, 370, 45, 25);
        dis_years.setBounds (519, 370, 65, 25);
        submit.setBounds (264, 490, 100, 25);
        reset.setBounds (144, 490, 100, 25);
        line2.setBounds (20, 419, 440, 25);
        cost_panel.setBounds (20, 445, 74, 25);
        Jcost.setBounds (102, 445, 100, 25);
    
        submit.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){
            
              //class patient
               b.setPetName(J_name.getText());
               b.setType(J_type.getText());
               b.setPetAge(J_age.getText());
               b.setSpecialFeature(J_sp.getText());
              
              //class prescription
               c.setDiseaseName(Jdisease.getText());
               c.setMedicineName(Jmedicine.getText());
               c.setMedicinePresc(Jpresc.getText());
               
              //class date
              String entry = (String)entry_day.getSelectedItem() 
                              + "/" + (String)entry_month.getSelectedItem()
                              + "/" + (String)entry_years.getSelectedItem();
                              
              String appointment = (String)appoint_day.getSelectedItem() 
                              + "/" + (String)appoint_month.getSelectedItem()
                              + "/" + (String)appoint_years.getSelectedItem();
              
               d.setEntDate(entry);
               d.setAppointDate(appointment);
               
              //ward
              String wardz = (String)ward_day.getSelectedItem() 
                              + "/" + (String)ward_month.getSelectedItem()
                              + "/" + (String)ward_year.getSelectedItem();
              String dischargez = (String)dis_day.getSelectedItem() 
                              + "/" + (String)dis_month.getSelectedItem()
                              + "/" + (String)dis_years.getSelectedItem();
                              

                  
              
              if(conf_yes.isSelected()){
                 ez.set_date(wardz);
                 ez.set_ward_number(jWardNo.getText());
                 ez.set_discharged(dischargez);
                 ez.set_cost(Jcost.getText());
                 ez.confirmation(true);              
                
              }
              else if(conf_no.isSelected()){
                 ez.set_date("1/1/1995");
                 ez.set_ward_number("NULL");
                 ez.set_discharged("1/1/1995");
                 ez.set_cost(Jcost.getText());
                 ez.confirmation(false);

              }
              
              //all field must be fill
              if(J_name.getText().equals("") || J_type.getText().equals("")
                 || J_age.getText().equals("") || J_sp.getText().equals("") || Jdisease.getText().equals("")
                 || Jmedicine.getText().equals("") || Jpresc.getText().equals("") || jWardNo.getText().equals("")
                 || Jcost.getText().equals("") || (!conf_no.isSelected() && !conf_yes.isSelected())){
                 
                 JOptionPane.showMessageDialog(null, "All field must be fill, Thank you..");
              }else{  
              
                 frame2.getContentPane().removeAll();
                 frame2.getContentPane().add (new LastPanel(frame2, a, b, c, d, ez));             
                 frame2.pack();
                 frame2.setVisible (true);
                 frame2.setLocationRelativeTo(null);
                 
              }       
            }  
         });
         
         reset.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){
            
              //class patient
               J_name.setText("");
               J_type.setText("");
               J_age.setText("");
               J_sp.setText("");
              
              //class prescription
               Jdisease.setText("");
               Jmedicine.setText("");
               Jpresc.setText("");
               
              //class date
              entry_day.setSelectedIndex(0); 
              entry_month.setSelectedIndex(0);
              entry_years.setSelectedIndex(0);
                              
              appoint_day.setSelectedIndex(0); 
              appoint_month.setSelectedIndex(0);
              appoint_years.setSelectedIndex(0);
              
               
              //ward
              ward_day.setSelectedIndex(0);
              ward_month.setSelectedIndex(0);
              ward_year.setSelectedIndex(0);
              
              dis_day.setSelectedIndex(0);
              dis_month.setSelectedIndex(0);
              dis_years.setSelectedIndex(0);
              
              conf_yes.setSelected(false);
              conf_no.setSelected(false);
              
              jWardNo.setText("");
              Jcost.setText("");
                       
            }  
         });
   
   }

}
