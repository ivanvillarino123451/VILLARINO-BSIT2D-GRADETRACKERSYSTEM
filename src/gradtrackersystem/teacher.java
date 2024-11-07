package gradtrackersystem;

import java.util.Scanner;

public class teacher {
    
    
     public static void teacher() {
        
     Scanner sc = new Scanner (System.in);
        String response;
        do{
        System.out.println("1. ADD TEACHER");
        System.out.println("2. VIEW TEACHER");
        System.out.println("3. UPDATE TEACHER");
        System.out.println("4. DELETE TEACHER");
        System.out.println("5. EXIT");
        
        System.out.print("Enter Action: ");
        int action =  sc.nextInt();
        teacher teacher = new teacher();
        switch(action){
            case 1:
                   teacher.addteacher();
                   teacher.viewteacher();                   
            break;
            
            case 2:
                   teacher.viewteacher();
            break; 
            
            case 3:
                  teacher.viewteacher();
                  teacher.updateteacher();
                  teacher.viewteacher();
            break;
            
            
            case 4:
                   teacher.viewteacher();  
                   teacher.deleteteacher();
                   teacher.viewteacher();  
            break;
            
             case 5:
            System.out.println("existing");
            break;
            default: 
            System.out.println("Invalid action. Please try again!:");
            
        }
            System.out.println("Do you want to continue? (yes/no): ");
            response = sc.next();  
        }while(response.equalsIgnoreCase("yes"));
        System.out.println("Thank you so much!"); 
    }
     
     
         
       public void addteacher(){
        Scanner sc = new Scanner(System.in);
        config conf = new config();
       
        
        System.out.print(" teacher id:");
        String id= sc.next();
        System.out.print(" teacher name: ");
        String name = sc.next();
        System.out.print(" teacher email:");
        String email = sc.next();
   
        String sql = "INSERT INTO tbl_teacher(t_name,t_email) VALUES ( ?, ?)";
        conf.addRecord(sql, name, email);
        
    }
    public void viewteacher() {  
        
        config conf = new config();
        String  Query = "SELECT * FROM tbl_teacher";
        String[] Headers = {"Teacher ID", " Name",  "Email" };
        String[] Columns = {"t_id", "t_name","t_email"};
        conf.viewRecords(Query, Headers, Columns);
    }
    
    public void updateteacher(){
    
 Scanner sc = new Scanner(System.in);
 config conf = new config();

System.out.print(" Enter ID to update: ");
int id = sc.nextInt();

while(conf.getSingleValue("SELECT t_id FROM tbl_teacher WHERE t_id = ?",id)== 0){
System.out.println("Selected ID doesn't exist!!");
System.out.println("Select teacher ID Again:");
id = sc.nextInt();
}

System.out.print("New name:");
String name = sc.next();
System.out.print("New email:");
String email = sc.next();

String qry ="UPDATE tbl_teacher SET t_name = ?,t_email = ? WHERE t_id = ?";
conf.updateRecord(qry, name, email, id);


}
 public void deleteteacher(){
     
    Scanner sc = new Scanner(System.in);
    config conf = new config();
    System.out.println("Enter the id to delete:");
    int id = sc.nextInt();
 
    while(conf.getSingleValue("SELECT t_id FROM tbl_teacher WHERE t_id = ?",id)== 0){
    System.out.println("Selected ID doesn't exist!!");
    System.out.println("Select teacher ID Again:");
    id = sc.nextInt();
}
    
String qry = "DELETE FROM tbl_teacher WHERE t_id = ?";
 conf. deleteRecord(qry, id);
 
  }
}
    
    

