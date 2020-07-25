class Date{          //3rd CLASS
    private String entDate = "Not Stated", appointDate = "Not Stated"; //date to be entered in dd/mm/yyyy format
    private String[] a_Entry;
    private String[] a_Appoint;
    
    void setEntDate(String entDate){
        this.entDate = entDate;
    }
    
    void setAppointDate(String appointDate){
        this.appointDate = appointDate;
    }
    
   //-----------------------------
   //for getting individual value of day, month and years.
   String[] getAppoint(){
      a_Appoint = new String[3];
      for(int i=0; i<3; i++){
         a_Appoint = appointDate.split("/");
      }
      return a_Appoint;
   }
   
   String[] getEntry(){
      a_Entry = new String[3];
      for(int i=0; i<3; i++){
         a_Entry = entDate.split("/");
      }
      return a_Entry;
   }
   //------------------------------
    
    String getEntDate(){
        return entDate;
    }
    
    String getAppointDate(){
        return appointDate;
    }
}