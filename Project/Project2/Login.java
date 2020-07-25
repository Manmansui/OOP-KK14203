import java.io.*;
import java.io.IOException;
class Login implements Master{
   private static String username = "";
   private static String password = "";
   private static String[] data;
   private static int trial = 4;
   private static String filename = "password.txt";

   public Login(){
      
   }

   public boolean testLogin(String user, String pass){//Reading from file to check for username and password.
      boolean test = false;
      
        try{
         
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            String line;
               while ((line = br.readLine()) != null) {
                  data = line.split(" ");
               }
           for(int i=0; i<data.length; i++){
              if(user.equals(data[i]) && pass.equals(data[i+1])) { 
                 test = true;
                 break;
              }   
           }  
        }catch(Exception e){
            System.out.println("Error: " + e.toString());
        }
     return test;   
   }
   
   public void failedTest(){
      trial--;
   }
   
   public int test(){
      return trial;
   }
}