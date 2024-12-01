package it2d.villarino.gtsystem;

import java.util.Scanner;

public class teacher {
     
 public static void main(String[] args){
        
     Scanner sc = new Scanner (System.in);
        String response;
        do{
        System.out.println("1. ADD");
        System.out.println("2. VIEW");
        System.out.println("3. UPDATE");
        System.out.println("4. DELETE");
        System.out.println("5. EXIT");
        
        System.out.print("Enter Action: ");
        int action =  sc.nextInt();
        teacher teacher = new teacher();
        switch(action){
                case 1:
            teacher.addteacher();
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
            System.out.println("Do1 you want to continue? (yes/no): ");
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
    

private void updateteacher(){
 Scanner sc = new Scanner(System.in);

System.out.println(" Enter the id to update: ");
int id = sc.nextInt();

System.out.println("New name");
String nname = sc.next();
System.out.println("New email:");
String nemail = sc.next();


   }

 private void deleteteacher(){

    Scanner sc = new Scanner(System.in);
    
    
System.out.println("Enter the id to delete:");
int id = sc.nextInt();

String qry = "DELETE FROM tbl_teacher WHERE c_id = ?";

 config conf = new config();
 conf. deleteRecord(qry, id);
 
  }

 }
    
