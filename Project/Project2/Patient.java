class Patient{             //2nd CLASS
   private String petName = "Not Stated", petAge = "Not Stated", type = "Not Stated", specialFeature = "Not Stated";
   
   void setPetName(String petName){
      this.petName = petName;
   }   
      
   void setType(String type){
      this.type = type;
   }
   
   void setPetAge(String petAge){
      this.petAge = petAge;
   }
   
   void setSpecialFeature(String specialFeature){  
      this.specialFeature = specialFeature;
   }

  
   String getPetName(){
      return petName;
   }   
   
   String getType(){
      return type;
   }
   
   String getPetAge(){
      return petAge;
   }
   
   String getSpecialFeature(){
      return specialFeature;
   }

}