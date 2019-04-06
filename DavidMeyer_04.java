/**
 * DavidMeyer_4_01
 *    @author: David Meyer
 *    Program development environment (macOS High Sierra, MacBook pro, IntelliJ)
 *
 *    Raggiamuffin - Word used to describe someone wearing dirty scruffy
 *    clothing, often used when describing children and animals.
 *
 *     “It takes no more time to see the good side of life than to see the bad.”
 *      —Jimmy Buffett (1946 - current)
 *
 *    @Version 1
 *    Due: November 5, 2018
 *    Main(DavidMeyer_03) uses the classes object classes Student and GradeItem
 *     to run tests to create a list of information that is contained within
 *     a .txt file.  Reads the information, puts students together and then
 *     creates a new .txt file and puts all information into that file.
 */

import java.io.*;
import java.text.DecimalFormat;
import java.util.Scanner;

public class DavidMeyer_04{

    private static Student student1 = null;     // Student1 Object
    private static Student student2 = null;     // Student2 Object
    private static GradeItem gradeItem1 = null; // GradeItem1 Object
    private static GradeItem gradeItem2 = null; // GradeItem2 Object
    //private static ArrayList<Student> studentList = new ArrayList();
    //private static ArrayList<GradeItem> gradeList = new ArrayList();
    private static List studentFinalList = new List();
    private static List gradeFinalList = new List();
    private static String xx;
    private static String INPUT_FILENAME = "hw4input" + xx + ".txt";
    //private static File file = new File(INPUT_FILENAME);
    private static String outFile;
    static Scanner scanner = new Scanner(System.in);
    static double totalActual, totalMax, total;
    private static DecimalFormat dF = new DecimalFormat("##.##");




    public static void main(String[] args){

        System.out.println("Enter file you would like to use: ");
        xx = scanner.nextLine();
        outFile = "hw4Output" + xx + ".txt";

        processInput();
        generateReport();

        System.out.println("\n\nOutput File: " + outFile);
        System.exit(0);
    }

    //==========================================--------------------------=====

    /**
     * Make Students into list as well as delete any that should.
     * @param data   If data array is empty, doesn't run. The file doesn't
     *                   have the information in the correct order.
     * @return Array list of Students
     */
    public static void processStudentData(String[] data) {
        try{
            if (data[1].contains("ADD")) {
                    student1 = new Student(data[3], data[4], data[5], data[2]);

                    if(studentFinalList.contains(student1)){
                        System.err.println("Err: Student(ADD) already exists" +
                                ".");
                    }
                    else {
                        //studentFinalList.add(student1);
                        if(studentFinalList.add(student1)){
                            //adds item and checks list
                            System.out.println("Student with ID " + student1.getId()
                                    + " was added.");
                        }
                        else{
                            System.out.println("Student Final List add null.");
                        }
                    }



            } else if (data[1].contains("DEL")) {

                student2 = new Student(data[3], data[4], data[5], data[2]);
                if(studentFinalList.remove(student2)){
                    System.err.println("\nStudent with ID " + student2.getId() + " "
                            + "was deleted.");

                }
            }
        }catch(IllegalArgumentException e){
            System.err.println("Student Constructor " + e.getMessage());
        }

    }

    //==========================================--------------------------=

    /**
     * Make GradeItems into a list by adding.  Also delete from list.
     * @return Array list of GradeItems.
     */
    public static void processGradeItemType (String[] data){
        try {
            if (data[1].contains("ADD")) {
                gradeItem1 = new GradeItem(Integer.parseInt(data[2]),
                        data[3], data[4], data[5], data[6],
                        Integer.parseInt(data[7]),
                        Integer.parseInt(data[8]));


                if(gradeFinalList.contains(gradeItem1)){
                    System.err.println("Err: GradeItem (ADD) already exists" +
                            ".");
                }
                else {
                    if(gradeFinalList.add(gradeItem1)){
                        //adds item and checks as well.
                        System.out.println("Grade with ID "
                                + gradeItem1.getStudentId() + " was added.");
                    }
                    else{
                        System.out.println("Grade Final List add null.");
                    }
                }
            }

            else if (data[1].contains("DEL")) {
                gradeItem2 = new GradeItem(Integer.parseInt(data[2]), data[3],
                        data[4], data[5], data[6], Integer.parseInt(data[7]),
                        Integer.parseInt(data[8]));


                if(gradeFinalList.remove(gradeItem2)){
                    //removes item and check
                    System.err.println("Grade Item with student id " +
                            gradeItem2.getStudentId() + " was removed.");
                }
                else{
                    System.err.println("Grade Item could not be removed.");
                }



            }
        }catch (IllegalArgumentException e){
            System.err.println("GradeItem Constructor " + e.getMessage());
        }
    }

    //==========================================--------------------------=====

    /**
     * Read input file and take the information for the processing methods to
     * use.
     * If file doesn't exist, this will error.
     */

    public static void processInput(){
        INPUT_FILENAME = "hw4input" + xx + ".txt";  // File Name
        File file = new File(INPUT_FILENAME);

        try {
            Scanner scFile = new Scanner(file);//Scan file
            while (scFile.hasNextLine()) {//Read each line
                String[] data = scFile.nextLine().split(",");
                //Check if first index is "Student"
                if((data[0].contains("STUDENT"))) {
                    if (data.length != 6){
                        throw new IllegalArgumentException("Array student not" +
                                " correct size.");
                    }// End inner If statement
                    else if(data[0].contains("STUDENT"))
                    DavidMeyer_04.processStudentData(data);
                }// End outer if statement
                //TEST 2B START
                else if (data[0].contains("GRADE ITEM")){
                    if(data.length != 9){
                        throw new IllegalArgumentException("Grade Item Array " +
                                "incorrect size.");
                    }
                    DavidMeyer_04.processGradeItemType(data);
                }
                else{
                    System.err.println("Data line does not start with STUDENT" +
                            " or GRADE ITEM");
                }
            } // End while loop
            scFile.close();
        }
        catch (FileNotFoundException e) {
            System.err.println(e.getMessage() + " Error: File not found.");
        }
    }

    //==========================================--------------------------=====

    /**
     * Take information gathered and make a output file with all information
     *      gathered in a formatted way.
     */

    public static void generateReport(){

        try {
            PrintWriter pw = new PrintWriter(outFile);

            Object[] students = studentFinalList.toArray();
            Object[] grades = gradeFinalList.toArray();


            for (int i = 0; i < studentFinalList.getCurrentSize(); i++) {
                pw.printf("%-12s %-8s %-8s %10s%n",
                        ((Student) students[i]).getId(),
                        ((Student) students[i]).getFirstName(),
                        ((Student) students[i]).getLastName(),
                        ((Student) students[i]).getEmail());
                pw.printf("%-12s %-8s %-8s %-8s %-8s %-8s%n",
                        "Date: ",
                        "Course: ",
                        "Item Id: ",
                        "Item Type: ",
                        "Score: ",
                        "MaxScore: ");
                //Reset values for every loop
                totalActual = 0;
                totalMax = 0;
                total = 0;

                for (int j = 0; j < gradeFinalList.getCurrentSize(); j++) {

                    if (((GradeItem) grades[j]).getStudentId().
                            contentEquals(((Student) students[i]).getId())) {
                    pw.printf("%-12s %-10s %-10s %-10s %-10s " +
                                    "%-10s%n",
                            ((GradeItem) grades[j]).getDate(),
                            ((GradeItem) grades[j]).getCourseId(),
                            ((GradeItem) grades[j]).getItemId(),
                            ((GradeItem) grades[j]).getItemType(),
                            ((GradeItem) grades[j]).getActualScore(),
                            ((GradeItem) grades[j]).getMaxScore());

                    totalActual +=
                            ((GradeItem) grades[j]).getActualScore();
                    totalMax += ((GradeItem) grades[j]).getMaxScore();

                    total = (totalActual / totalMax) * 100;

                    }// End If statement
                }
                pw.println("                                             " +
                        "           Total: " + dF.format(total) +
                        "\n==========================================");
            }
            pw.flush();
            pw.close();
            } catch(FileNotFoundException e){
                e.printStackTrace();
            }
        }
}// End Class
