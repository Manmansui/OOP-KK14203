class Prescription{        //4th CLASS
   private String diseaseName = "Not Stated", medicineName = "Not Stated", medicinePresc = "Not Stated";
   
   void setDiseaseName(String diseaseName){
		this.diseaseName = diseaseName;
   }
    
   void setMedicineName(String medicineName){
		this.medicineName = medicineName;
   }
   
   void setMedicinePresc(String medicinePresc){
		this.medicinePresc = medicinePresc;
   }
   
   String getDiseaseName(){
      return diseaseName;
   }

   String getMedicineName(){
      return medicineName;
   }

   String getMedicinePresc(){
      return medicinePresc;
   }

}