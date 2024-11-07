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
       private void addrecord(){
           
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        
        
        student st = new student();
        st.viewStudent();
         
        
        System.out.print(" Student ID: ");
        int sid = sc.nextInt();
  
        while(conf.getSingleValue("SELECT s_id FROM tbl_student WHERE s_id = ?",sid)== 0){
            System.out.println("Selected ID doesn't exist!!");
            System.out.println("Select Student ID Again:");
            sid = sc.nextInt();
        }     
        
        
        teacher teacher = new teacher();
        teacher.viewteacher();
         
            
        System.out.print(" teacher ID: ");
        int tid = sc.nextInt();
  
            
         
            while(conf.getSingleValue("SELECT t_id FROM tbl_teacher WHERE t_id = ?",tid)== 0){
            System.out.println("Selected ID doesn't exist!!");
            System.out.println("Select teacher ID Again:");
            tid = sc.nextInt();
}

            subject sbj = new subject();
            sbj.viewsubject();
 
        System.out.print("Subject ID: ");
        int subid = sc.nextInt();
        
        
            while(conf.getSingleValue("SELECT sub_id FROM tbl_subject WHERE sub_id = ?",subid)== 0){
            System.out.println("Selected ID doesn't exist!!");
            System.out.println("Select subject ID Again:");
            subid = sc.nextInt();
}

        System.out.print(" Grade: ");
        String grade = sc.next();
        System.out.print("Remarks: ");
        String remarks = sc.next();
         
        
        String sql;
        sql = "INSERT INTO tbl_record(s_id, t_id, sub_id, r_grade, r_remarks) VALUES (?, ?, ?, ?, ?)";
        conf.addRecord(sql, sid, tid, subid, grade, remarks);
    }
    public void viewrecord() {  
        
      config conf = new config();
        String Query = "SELECT * FROM tbl_record";
        String[] Headers = {"ID", "rsid", "rtid", "rsubid", "grade", "remarks"};
        String[] Columns = {"r_id", "s_id", "t_id" , "sub_id", "r_grade", "r_remarks"};
 
        conf.viewRecords(Query, Headers,Columns);
    }
    
    public void updaterecord(){
    
  Scanner sc = new Scanner(System.in);
  config conf = new config();

  System.out.println(" Enter the id to update: ");
  int id = sc.nextInt();

        System.out.print(" Teacher ID: ");
        String tid = sc.next();
        System.out.print("Subeject ID: ");
        String subid = sc.next();
        System.out.print(" Grade: ");
        String grade = sc.next();
        System.out.print("Remarks: ");
        String remarks = sc.next();
        
        
  String qry ="UPDATE tbl_record SET r_id= ?, t_id = ?,sub_id = ?, r_grade = ?, r_remarks = ? WHERE r_id = ?";
  conf.updateRecord(qry,id, tid, subid, grade, remarks, id);

        
   }
 public void deleterecord(){
    
     Scanner sc = new Scanner(System.in);
     config conf = new config();
     System.out.println("Enter the id to delete:");
     int id = sc.nextInt();     
     
     while(conf.getSingleValue("SELECT r_id FROM tbl_record WHERE r_id = ?",id)== 0){
     System.out.println("Selected ID doesn't exist!!");
     System.out.println("Select Student ID Again:");
     id = sc.nextInt();
}
  
        
        
     String qry = "DELETE FROM tbl_record  WHERE r_id = ?";
     conf.deleteRecord(qry,id);
     
  }
}