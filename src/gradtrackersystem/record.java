package gradtrackersystem;

import java.util.Scanner;

public class record {
    
    public static void record() {
        
         Scanner sc = new Scanner (System.in);
        String response;
        do{
        System.out.println("1. ADD RECORD");
        System.out.println("2. VIEW RECORD");
        System.out.println("3. UPDATE RECORD");
        System.out.println("4. DELETE RECORD");
        System.out.println("5. EXIT");
        
        System.out.print("Enter Action: ");
        int action =  sc.nextInt();
            record record; 
           record  = new record ();
        
        switch(action){
            case 1:
            record.addrecord();
            break;
            
            case 2:
           record.viewrecord();
            break; 
            
            case 3:
            record.viewrecord();    
            record.updaterecord();
            record.viewrecord();
            break;
            
            
             case 4:
            record.viewrecord();  
            record.deleterecord();
            record.viewrecord();  
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
       public void addrecord(){
           
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        
        
        System.out.print(" Student ID: ");
        String sid = sc.next();
        System.out.print(" Teacher ID: ");
        String tid = sc.next();
        System.out.print("Subject ID: ");
        String subid = sc.next();
        System.out.print(" Grade: ");
        String grade = sc.next();
        System.out.print("Remarks: ");
        String remarks = sc.next();
         
        
        String sql;
        sql = "INSERT INTO tbl_record(s_id, t_id, sub_id, grade, remarks) VALUES (?, ?, ?, ?, ?)";
        conf.addRecord(sql, sid, tid, subid, grade, remarks);
    }
    private void viewrecord() {  
        
      config conf = new config();
        String Query = "SELECT * FROM tbl_record";
        String[] Headers = {"ID", "sid", "tid", "subid", "grade", "remarks"};
        String[] Columns = {"r_id", "s_id", "t_id" , "sub_id", "grade", "remarks"};
 
        conf.viewRecords(Query, Headers,Columns);
    }
    
private void updaterecord(){
    
 Scanner sc = new Scanner(System.in);
System.out.println(" Enter the id to update: ");
int id = sc.nextInt();


 System.out.print(" Student ID: ");
        String sid = sc.next();
        System.out.print(" Teacher ID: ");
        String tid = sc.next();
        System.out.print("Subeject ID: ");
        String subid = sc.next();
        System.out.print(" Grade: ");
        String grade = sc.next();
        System.out.print("Remarks: ");
        String remarks = sc.next();
   }
 private void deleterecord(){
    
     Scanner sc = new Scanner(System.in);
   
     System.out.println("Enter the id to delete:");
        int id = sc.nextInt();     
     
     String qry = "DELETE FROM tbl_record  WHERE r_id = ?";
     
     config conf = new config();
      conf.deleteRecord(qry,id);
     
  }
}
    

