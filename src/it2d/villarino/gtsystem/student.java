package it2d.villarino.gtsystem;

import java.util.Scanner;

public class student{
    
   public static void main(String[] args) {
    
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
          student student; 
            student = new student();
        switch(action){
            case 1:
                  
            student.addStudent();
            break;
            
            case 2:
              
           student.viewStudent();
            break;
           
            case 3:
            student.viewStudent();    
            student.updateStudent();   
            student.viewStudent();    
            
            break;
            
            
            case 4: 
            student.viewStudent();        
            student.deleteStudent(); 
            student.viewStudent();    
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
       public void addStudent(){
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        
        
        System.out.print("Student First Name: ");
        String fname = sc.next();
        System.out.print("Student Last Name: ");
        String lname = sc.next();
        System.out.print("Student Email: ");
        String email = sc.next();
        System.out.print("Student address : ");
        String address = sc.next();
        System.out.print("Student date : ");
        String date = sc.next();

         
        

        String sql;
        sql = "INSERT INTO tbl_student(s_fname, s_lname, s_email, s_address, s_date) VALUES (?, ?, ?, ?, ?)";


        conf.addRecord(sql, fname, lname, email, address, date);


    }

    private void viewStudent() {  
        config conf = new config();
        String studentQuery = "SELECT * FROM tbl_student";
        String[] studentHeaders = {"student ID", "First Name", "Last Name", "Email", "address","date" };
        String[] studentColumns = {"s_id", "s_fname", "s_lname", "s_email", "s_address","s_date"};


        conf.viewRecords(studentQuery, studentHeaders,studentColumns);
    }
    

private void updateStudent(){
 Scanner sc = new Scanner(System.in);

System.out.println(" Enter the id to update: ");
int id = sc.nextInt();

System.out.println("New first name");
String nfname = sc.next();
System.out.println("New last name:");
String nlname = sc.next();
System.out.println("New email:");
String nemail = sc.next();
System.out.println("New address:");
String address = sc.next();
System.out.print("Student date : ");
String date = sc.next();

   }

 private void deleteStudent(){

    Scanner sc = new Scanner(System.in);
    
    
System.out.println("Enter the id to delete:");
int id = sc.nextInt();

String qry = "DELETE FROM tbl_student WHERE c_id = ?";

 config conf = new config();
 conf. deleteRecord(qry, id);
 
  }
}