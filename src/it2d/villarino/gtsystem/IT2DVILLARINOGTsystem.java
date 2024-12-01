package IT2DVILLARINOGTsystem;

import it2d.villarino.gtsystem.record;
import it2d.villarino.gtsystem.student;
import it2d.villarino.gtsystem.subject;
import it2d.villarino.gtsystem.teacher;

import java.util.Scanner;

public class IT2DVILLARINOGTsystem {

  
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
  
       
        try (Scanner sc = new Scanner(System.in)) {
            boolean exit = true;
            
            
            System.out.println("1. student");
            System.out.println("2. teacher");
            System.out.println("3. subject");
            System.out.println("4. record");
            System.out.println("5. EXIT");   
            
            System.out.print("Enter Action: ");
            int act = sc.nextInt();
            
            switch(act){
                case 1:
                    student student = new student (); 
                    student.addStudent();
                  
                    break;
                
                case 2:
                    teacher teacher = new teacher ();
                    teacher.addteacher();
                    break;
                    
                case 3:
                    subject subject = new subject ();
                    subject.addsubject();
                    break;
                    
               case 4:
                    record record = new record ();
                    record.addrecord();
                     break;
                    
                    
                case 5:
                    System.out.println("Exiting... ARE YOU SURE? (yes/no): ");
                    String resp = sc.next();
                    if(resp.equalsIgnoreCase("yes")){
                        exit = false;
                    }
                    break;
                    
                default:
                    System.out.println("Invalid action. Try Again!!");
                    break;
            }
            while (exit);
            System.out.println("TENKS, BYE!");
        }
        
    }
}
    



