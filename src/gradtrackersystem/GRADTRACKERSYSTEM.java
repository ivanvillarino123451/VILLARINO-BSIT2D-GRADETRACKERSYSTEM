package gradtrackersystem;

import java.util.Scanner;

public class GRADTRACKERSYSTEM {

      
    public static void main(String[] args) {
        
        
        try (Scanner sc = new Scanner(System.in)) {
        boolean exit = true;
            
       do{                
            System.out.println("\n-----------------------------------");
            System.out.println("WELCOME TO GRADE TRACKER SYSTEM       "); 
            System.out.println("\n-----------------------------------");
            System.out.println("1. STUDENT");     
            System.out.println("2. TEACHER");
            System.out.println("3. SUBJECT");
            System.out.println("4. RECORD");
            System.out.println("5. EXIT");   
            
            System.out.println("\n-----------------------------------");      
            System.out.print("Enter Selection: ");
            int action = sc.nextInt();
            System.out.println("\n-----------------------------------");
            
             
            switch(action){
                case 1:
                    student st = new student ();    
                    st.student();
                    break;
                    
                case 2:
                    teacher teacher = new teacher ();
                    teacher.teacher();
                    break;
                    
                case 3:
                    subject subject = new subject ();
                    subject.subject();
                    
                    break;
                    
                case 4:
                    record record = new record ();
                    record.record();
                    break;
                    
                case 5:
                    System.out.println("Exiting... SURE? (yes/no): ");
                    String resp = sc.next();
                    if(resp.equalsIgnoreCase("yes")){
                        exit = false;
                    }
                    break;
                    
                default:
                    System.out.println("Invalid action. Try Again!!");
                    break;
            }
            
          }while (exit);
            System.out.println("THANK YOU, BYE!");
        }
    }
 }
    
    

