package it2d.gradetracker;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Report {

    public void viewReports() {
        Scanner sc = new Scanner(System.in);
        String response = "yes";
        int action;

        do {
           
            System.out.println("1. ALL REPORT");
            System.out.println("2. EXIT REPORT");

            System.out.print("Enter action: ");

            try {
                action = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid action.");
                sc.nextLine();  
                continue;
            }

            if (action == 1) {
                viewAllReports();
            } else if (action == 2) {
                System.out.println("Exiting Reports...");
                break; 
            } else {
                System.out.println("Invalid action! Please enter a valid action.");
                continue;
            }

            
            System.out.println("Do you want to continue view all reports? (yes/no)");
            response = sc.next();
        } while (response.equalsIgnoreCase("yes"));

        
        System.out.println("THANK YOU FOR USING THE REPORTS SYSTEM!");

    
    }

   
    private void viewAllReports() {
        viewStudentReport();
        viewTeacherReport();
        viewSubjectReport();
        viewRecordReport();
    }

    
    private void viewStudentReport() {
       
        config conf = new config();
        String studentQuery = "SELECT * FROM tbl_student";
        String[] studentHeaders = {"STUDENT ID", "First Name", "Last Name", "Email", "address", "date"};
        String[] studentColumns = {"s_id", "s_fname", "s_lname", "s_email", "s_address", "s_date"};
        conf.viewRecords(studentQuery, studentHeaders, studentColumns);
    }

    private void viewTeacherReport() {
        config conf = new config();
        String teacherQuery = "SELECT * FROM tbl_teacher";
        String[] teacherHeaders = {"TEACHER ID", " Name", "Email"};
        String[] teacherColumns = {"t_id", "t_name", "t_email"};
        conf.viewRecords(teacherQuery, teacherHeaders, teacherColumns);
    }

    private void viewSubjectReport() {
        config conf = new config();
        String subjectQuery = "SELECT * FROM tbl_subject";
        String[] subjectHeaders = {" SUBJECT ID", "Name", "semester", "description", "units"};
        String[] subjectColumns = {"sub_id", "s_name", "s_semester", "s_description", "s_units"};
        conf.viewRecords(subjectQuery, subjectHeaders, subjectColumns);
    }

 
    private void viewRecordReport() {
        config conf = new config();
        String recordQuery = "SELECT * FROM tbl_record";
        String[] recordHeaders = {" RECORD ID", "record student ID", "record teacher ID", "record subject ID", "grade", "remarks"};
        String[] recordColumns = {"r_id", "s_id", "t_id", "sub_id", "grade", "remarks"};
        conf.viewRecords(recordQuery, recordHeaders, recordColumns);
    }
}
