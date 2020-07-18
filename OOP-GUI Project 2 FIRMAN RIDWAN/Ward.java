class Ward{          //5th CLASS

   private String wardDate="No need",dischargedDate="No need",neccessity="No need", ward_number = "Not Stated"; 
   private boolean confirmation;//--
   private String cost = "Not Stated";//--
   
   //for getting individual value(implement edit button in Last panel)

   private String[] a_Ward;
   private String[] a_Discharge;
   
   void confirmation(boolean f){
		confirmation = f;
   }
   
   void set_date(String wardDate){
		this.wardDate = wardDate;
   }

    void set_cost(String cost){
		this.cost = cost;
   }
    void set_need(String neccessity){
		this.neccessity = neccessity;
   }
    void set_ward_number(String ward_number){
		this.ward_number = ward_number;
   }
    void set_discharged(String dischargedDate){
		this.dischargedDate = dischargedDate;
   }
   //-----------------------------------
   //for getting individual value of day, month and years.
   String[] getA_Ward(){
      a_Ward = new String[3];
      for(int i=0; i<3; i++){
         a_Ward = wardDate.split("/");
      }
      return a_Ward;
   }
   
   String[] getA_Discharge(){
      a_Discharge = new String[3];
      for(int i=0; i<3; i++){
         a_Discharge = dischargedDate.split("/");
      }
      return a_Discharge;
   }
   //-----------------------------------
   
   String getConfirmation(){
	   if(confirmation){
		   return "Yes";
	   }else{
		   return "No"; 
	   }
   }
   
   String get_date(){///=================================
      return wardDate;
   }
      
   String get_cost(){
      return cost;
   }
    
    String get_need(){//=============================
      return neccessity; 
    }
    
    String get_ward(){
      return ward_number;
    }
    
    String get_discharge(){
      return dischargedDate;
    }
	
	
}
