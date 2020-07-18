class Profile{              //1st CLASS
   private String name, ic, address, age;
   
  public void setName(String name){
      this.name = name;
   }
   public void setIc(String ic){
	  this.ic = ic;
   }
   public void setAddress(String address){
      this.address = address;
   }
   public void setAge(String age){
      this.age = age;
   }
   
   String getName(){
      return name;
   }
   String getIc(){
      return ic;
   }
   String getAddress(){
      return address;
   }
   String getAge(){
      return age;
   }
   
}