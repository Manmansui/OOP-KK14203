import java.util.Scanner;

class Profile{              //1st CLASS
   private String name, ic, address;
   private int age;
   
   void setName(){
      Scanner in = new Scanner(System.in);
      System.out.print("Enter your full name: ");
      name = in.nextLine();
      System.out.println("Name saved to database: " + name);
   }
   void setIc(){
      Scanner in = new Scanner(System.in);
      System.out.print("Enter I/C: ");
      ic = in.nextLine();
      System.out.println("Profile updated: " + ic);
   }
   void setAddress(){
      Scanner in = new Scanner(System.in);
      System.out.print("Enter address: ");
      address = in.nextLine();
      System.out.println("Profile updated: " + address);
   }
   void setAge(){
      Scanner in = new Scanner(System.in);
      System.out.print("Enter your age: ");
      System.out.println("Profile updated: " + age);
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
   int getAge(){
      return age;
   }
   
   
}

class Patient{             //2nd CLASS
   private String petName, petAge, type, specialFeature, history;
   
   void setPetName(){
      Scanner in = new Scanner(System.in);
      System.out.print("Enter the name of the pet: ");
      petName = in.nextLine();
      System.out.println("The pet's name: " + petName);
   }   
      
   void setType(){
      Scanner in = new Scanner(System.in);
      System.out.print("Enter the type of pet: ");
      type = in.nextLine();
      System.out.println("Type of animal saved to database: " + type);
   }
   
   void setPetAge(){
      Scanner in = new Scanner(System.in);
      System.out.print("Enter the age of the pet (include the day/month/year): ");
      petAge = in.nextLine();
      System.out.println("Pet's age: " + petAge);
   }
   
   void setSpecialFeature(){  //for safety purpose, to avoid mishandling,etc
      Scanner in = new Scanner(System.in);
      System.out.print("Do the pet have something unique? E.g. its accesories or special feature on its body. \n");
      System.out.print("Enter its special feature (if have any): ");
      specialFeature = in.nextLine();
      System.out.println("Special Feature: " + specialFeature);
   }

   void setHistory(){
      Scanner in = new Scanner(System.in);
      System.out.print("Does the pet have come here before? (Yes/No) ");
      history = in.nextLine();
      System.out.println("Have the pet come to the clinic? " + history);
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
   
   String getHistory(){
      return history;
   }

}


class Date{          //3rd CLASS
    private String entDate, appDate; //date to be entered in dd/mm/yyyy format
    
    void setEntDate(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter the date of entry: ");
        entDate = scan.nextLine();
    }
    
    void setAppDate(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter the date of appointment: ");
        appDate = scan.nextLine();
    }
    
    String getEntDate(){
        return entDate;
    }
    
    String getAppDate(){
        return appDate;
    }
}
class Prescription{        //4th CLASS
   private String diseaseName, diagnoseDate, medicineName, medicinePresc;
   
   void setDiseaseName(){
      Scanner scan = new Scanner(System.in);
      System.out.print("Please enter disease name: ");
      diseaseName = scan.nextLine();
   }
   
   void setDiagnoseDate(){
      Scanner scan = new Scanner(System.in);
      System.out.print("Please enter dignose's date: ");
      diagnoseDate = scan.nextLine();
   }
   
   void setMedicineName(){
      Scanner scan = new Scanner(System.in);
      System.out.print("Please enter medicines name: ");
      medicineName = scan.nextLine();
      
   }
   
   void setMedicinePresc(){
      Scanner scan = new Scanner(System.in);
      System.out.print("Please enter medicines prescription: ");
      medicinePresc = scan.nextLine();
      // e.g: take 1 tablet after meal 2 times daily.
   }
   
   String getDiseaseName(){
      return diseaseName;
   }
   
   String getDiagnoseDate(){
      return diagnoseDate;
   }

   String getMedicineName(){
      return medicineName;
   }

   String getMedicinePresc(){
      return medicinePresc;
   }

}

class Ward{          //5th CLASS

   private String date="No need",ward="No need",discharged="No need",need="No need";
   private int cost;
   void confirmation(){
   System.out.print("Does the pet need to be warded?\n");
   System.out.print("Please enter y for yes and n for no\n");
   }
   
   void set_date(){
      Scanner scan = new Scanner(System.in);
      System.out.print("The date of the pet to be warded in:");
      date = scan.nextLine();
      System.out.print("The date have been updated to the database\n\n");
}

    void set_cost(){
      Scanner scan = new Scanner(System.in);
      System.out.print("The cost of the pet overall treament: RM");
      cost = scan.nextInt();
      System.out.print("The cost have been updated to the database\n\n");
}
    void set_need(){
      Scanner scan = new Scanner(System.in);
      System.out.print("Is there any special need of the pet: ");
      need = scan.nextLine();
      System.out.print("The neccesities have been updated to the database\n\n");
}
    void set_ward_number(){
      Scanner scan = new Scanner(System.in);
      System.out.print("The number of ward for the pet is: ");
      ward = scan.nextLine();
      System.out.print("The ward number have been updated to the database\n\n");
}
    void set_discharged(){
      Scanner scan = new Scanner(System.in);
      System.out.print("The date the pet to be discharged: ");
      discharged = scan.nextLine();
      System.out.print("The date to be discharged have been updated to the database\n\n");
}
    String get_date(){
      return date;}
      
    int get_cost(){
      return cost;}
    
    String get_need(){
      return need;}
    
    String get_ward(){
      return ward;}
    
    String get_discharge(){
      return discharged;}
}



public class Main{
   public static void clearScreen() {  
          System.out.print("\033[H\033[2J");  
          System.out.flush();  
      } 

   public static void main(String[] args){
      String cont;
      do{
      Profile owner1 = new Profile();                                                 //class profile
      owner1.setName();
      owner1.setIc();
      owner1.setAddress();
      owner1.setAge();
      System.out.println("Name: " + owner1.getName());
      System.out.println("I/C: " + owner1.getIc());
      System.out.println("Address: " + owner1.getAddress());
      System.out.println("Age: " + owner1.getAge());
      System.out.println();      
      
      Scanner scan = new Scanner(System.in);
      System.out.print("Enter number of pets for appointment: ");
      int num_pet = scan.nextInt();
      
      Patient[] pet = new Patient[num_pet];
      Date[] petDate = new Date[num_pet];
      Prescription[] pets = new Prescription[num_pet];
      Ward[] petsWard = new Ward[num_pet]; 
      
      for (int i = 0; i < num_pet; i++){                                 
             pet[i] = new Patient();
             petDate[i] = new Date();       
             pets[i] = new Prescription();
             petsWard[i] = new Ward();
      }
      
      for (int i = 0; i < num_pet; i++){                                
            //class Patient
            pet[i].setPetName();                     
            pet[i].setType();
            pet[i].setPetAge();
            pet[i].setSpecialFeature();
            pet[i].setHistory();
            System.out.println();                  
            
            System.out.println("\nList of the pet's details");
            System.out.println("Pet's Name: " + pet[i].getPetName());
            System.out.println("Pet's Type: " + pet[i].getType());
            System.out.println("Pet's Age: " + pet[i].getPetAge());
            System.out.println("Pet's special feature: " + pet[i].getSpecialFeature());
            System.out.println("Have the pet come before? " + pet[i].getHistory());
            System.out.println("#Database updated.\n");       
            
            //class Date
            petDate[i].setEntDate();
            petDate[i].setAppDate();
            System.out.println("Entry Date: " + petDate[i].getEntDate());
            System.out.println("Appointment Date: " + petDate[i].getAppDate());
            System.out.println("#Database updated.\n");
            
            //class Prescription
            System.out.println("Pet " + (i+1) + " prescription");                               
            pets[i].setDiseaseName();
            pets[i].setDiagnoseDate();
            pets[i].setMedicineName();
            pets[i].setMedicinePresc();
            System.out.println();
            
            System.out.println("Pet " + (i+1) + " prescription");                                
            System.out.println("Disease: " + pets[i].getDiseaseName());
            System.out.println("Diagnose date: " + pets[i].getDiagnoseDate());
            System.out.println("Medicine: " + pets[i].getMedicineName());
            System.out.println("Medicine Prescription: " + pets[i].getMedicinePresc());
            System.out.println("#Database updated.\n"); 
            
            //class Ward
            String input;                                                                    
      
            petsWard[i].confirmation();
            Scanner need = new Scanner(System.in);
            input = need.nextLine();
      
            if (input.charAt(0) == 'y'){
               System.out.print("The pet need to be warded\n");
               petsWard[i].set_date(); 
               petsWard[i].set_need();
               petsWard[i].set_ward_number();
               petsWard[i].set_discharged();
               petsWard[i].set_cost();
               System.out.println("Ward's Detail; ");
               System.out.println("The pet date to be warded in: " + petsWard[i].get_date());
               System.out.println("The pet special necessities: " + petsWard[i].get_need());
               System.out.println("The pet ward number : " + petsWard[i].get_ward());
               System.out.println("The pet date to be discharged: " + petsWard[i].get_discharge());
               System.out.println("Treatment cost: " + petsWard[i].get_cost());
            }
            
            else {
               System.out.print("The pet does not need to be warded\n");
               petsWard[i].set_cost();
               System.out.println("Treatment cost: RM" + petsWard[i].get_cost());
               System.out.println();
            }
            
         }

      
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println("********************************************************");
      System.out.println("#DETAILS#");//printing overall details.
      System.out.println("Owner: " + owner1.getName());
      System.out.println("I/C: " + owner1.getIc());
      System.out.println("Address: " + owner1.getAddress());
      System.out.println("Age: " + owner1.getAge());

      
      int totalCost = 0;
      for (int i = 0; i < num_pet; i++){
    	   System.out.println("\n\nPet's Name: " + pet[i].getPetName());
    	   System.out.println("Pet's Type: " + pet[i].getType());
    	   System.out.println("Pet's Age: " + pet[i].getPetAge());
    	   System.out.println("Pet's special feature: " + pet[i].getSpecialFeature());
    	   System.out.println("Clinical history: " + pet[i].getHistory());
         System.out.println("Entry Date: " + petDate[i].getEntDate());
         System.out.println("Appointment Date: " + petDate[i].getAppDate());
         System.out.println("Disease: " + pets[i].getDiseaseName());
         System.out.println("Diagnose date: " + pets[i].getDiagnoseDate());
         System.out.println("Medicine: " + pets[i].getMedicineName());
         System.out.println("Medicine Prescription: " + pets[i].getMedicinePresc());
    	   System.out.println("Warding date: " + petsWard[i].get_date());
         System.out.println("Pet extra necessities: " + petsWard[i].get_need());
         System.out.println("Ward number : " + petsWard[i].get_ward());
         System.out.println("Date of discharged: " + petsWard[i].get_discharge());
         System.out.println("Treatment cost: RM" + petsWard[i].get_cost());
         totalCost += petsWard[i].get_cost();
      }
      
      if (num_pet>1){
         System.out.println("\nTotal treatment cost: RM" + totalCost);
      }
      
   System.out.print("\nDo you want to continue to use the program for a new owner?\ny for yes and n for no\n");
   Scanner ques = new Scanner(System.in);
   cont = ques.next();
   }while(cont.equals("y"));
      
      System.out.println("\n********************************************************");

   
  System.out.print("***********************THANK YOU************************");
  }
}
