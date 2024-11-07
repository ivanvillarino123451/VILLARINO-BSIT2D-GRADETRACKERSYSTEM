package gradtrackersystem;

import java.util.Scanner;

public class subject {
    
    
    public static void subject() {
        
         Scanner sc = new Scanner (System.in);
        String response;
        do{
        System.out.println("1. ADD SUBJECT");
        System.out.println("2. VIEW SUBJECT");
        System.out.println("3. UPDATE SUBJECT");
        System.out.println("4. DELETE SUBJECT");
        System.out.println("5. EXIT");
        
        System.out.print("Enter Action: ");
        int action =  sc.nextInt();
         subject  subject; 
        subject = new subject ();
        
        switch(action){
            case 1:
            subject.addsubject();
            break;
            
            case 2:
           subject. viewsubject();
            break; 
            
            case 3:
            subject.viewsubject();    
            subject.updatesubject();
            subject.viewsubject();
            break;
            
            
             case 4:
            subject.viewsubject();  
            subject.deletesubject();
            subject.viewsubject();  
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
       public void addsubject(){ 
           
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        
        
        System.out.print(" name: ");
        String name = sc.next();
        System.out.print(" semester: ");
        String semester = sc.next();
        System.out.print(" description: ");
        String description = sc.next();
        System.out.print(" units : ");
        String units = sc.next();
        
         
        
        String sql;
        sql = "INSERT INTO tbl_subject(s_name, s_semester, s_description, s_units) VALUES ( ?, ?, ?, ?)";
        conf.addRecord(sql, name, semester, description, units);
    }
    public void viewsubject() {  
        
      config conf = new config();
        String Query = "SELECT * FROM tbl_subject";
        String[] Headers = {"ID", "Name", "semester", "description", "units" };
        String[] Columns = {"sub_id", "s_name", "s_semester", "s_description", "s_units"};
        conf.viewRecords(Query, Headers, Columns);
    }
    
    public void updatesubject(){
    
 Scanner sc = new Scanner(System.in);
 config conf = new config();

System.out.println(" Enter the id to update: ");
int id = sc.nextInt();
        

     while(conf.getSingleValue("SELECT sub_id FROM tbl_subject WHERE sub_id = ?",id)== 0){
     System.out.println("Selected ID doesn't exist!!");
     System.out.println("Select Student ID Again:");
     id = sc.nextInt();
}

        System.out.print(" name: ");
        String name = sc.next();
        System.out.print(" semester: ");
        String semester = sc.next();
        System.out.print(" description: ");
        String description = sc.next();
        System.out.print(" units : ");
        String units = sc.next();
        
        
     String qry ="UPDATE tbl_subject SET s_name = ?, s_semester = ?, s_description = ?, s_units = ? WHERE sub_id = ?";
     conf.updateRecord(qry, name, semester, description, units, id);
        
        
   }
    public void deletesubject(){
    
     Scanner sc = new Scanner(System.in);
     config conf = new config();

   
     System.out.println("Enter the id to delete:");
     int id = sc.nextInt();
     
     
     while(conf.getSingleValue("SELECT sub_id FROM tbl_subject WHERE sub_id = ?",id)== 0){
     System.out.println("Selected ID doesn't exist!!");
     System.out.println("Select Student ID Again:");
     id = sc.nextInt();
     
     String qry = "DELETE FROM tbl_subject WHERE sub_id = ?";
      conf.deleteRecord(qry,id);
     
  }
 }
}
    

