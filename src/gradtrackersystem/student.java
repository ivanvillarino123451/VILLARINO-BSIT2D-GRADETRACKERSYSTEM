package gradtrackersystem;

import java.util.Scanner;

     public class student { 
         
       public static void student() {
 
    
      Scanner sc = new Scanner (System.in);
        String response;
        
        do{
            
        System.out.println("1. ADD STUDENT");
        System.out.println("2. VIEW STUDENT ");
        System.out.println("3. UPDATE STUDENT");
        System.out.println("4. DELETE STUDENT");
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
            System.out.println("Do you want to continue? (yes/no): ");
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
 config conf = new config();
System.out.println(" Enter the id to update: ");
int id = sc.nextInt();


while(conf.getSingleValue("SELECT s_id FROM tbl_student WHERE s_id = ?",id)== 0){
System.out.println("Selected ID doesn't exist!!");
System.out.println("Select Student ID Again:");
id = sc.nextInt();
}

System.out.print("New first name :");
String fname = sc.next();
System.out.print("New last name :");
String lname = sc.next();
System.out.print("New email :");
String email = sc.next();
System.out.print("New address :");
String address = sc.next();
System.out.print("New Student date : ");
String date = sc.next();
 
String qry ="UPDATE tbl_student SET s_fname = ?, s_lname = ?, s_email = ?, s_address = ?, s_date = ? WHERE s_id = ?";
conf.updateRecord(qry, fname, lname, email, address, date, id);


   }

 private void deleteStudent(){
     
 Scanner sc = new Scanner(System.in);
System.out.println("Enter ID to delete:");
 config conf = new config();
int id = sc.nextInt();

while(conf.getSingleValue("SELECT s_id FROM tbl_student WHERE s_id = ?",id)== 0){
System.out.println("Selected ID doesn't exist!!");
System.out.println("Select Student ID Again:");
id = sc.nextInt();
}

String qry = "DELETE FROM tbl_student WHERE s_id = ?";
 conf. deleteRecord(qry, id);
 
  }

}
    

