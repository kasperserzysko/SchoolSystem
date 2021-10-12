package school.system;

import java.util.ArrayList;
import java.util.Scanner;

public class Student {

    private String FIRST_NAME;
    private String LAST_NAME;
    private String YEAR;
    private String STUDENT_ID;
    private ArrayList<String> COURSES = new ArrayList<String>();
    private int FEES_PAID;
    private static int FEES_TO_BE_PAID = 0;
    private static int id = 1000;

    public Student(){
        Scanner in = new Scanner(System.in);

        System.out.print("Enter student first name: ");
        this.FIRST_NAME = in.nextLine();

        System.out.print("Enter student last name: ");
        this.LAST_NAME = in.nextLine();

        System.out.print("1 - Freshamn\n2 - Sophomore\n3 - Junior\n4 - Senior\nEnter student year:");
        this.YEAR = in.nextLine();

        setSTUDENT_ID();
        enroll();
    }

    private void setSTUDENT_ID(){
        id++;
        this.STUDENT_ID =  this.YEAR + ""+ id;
    }

    private void enroll(){

        boolean repeat = false;
        while(!repeat) {
        System.out.print("1 - Math (600$)\n2 - History(600$)\n3 - English(600$)\n0 - Quit and save\nEnter course to enroll: ");
        Scanner in = new Scanner(System.in);
        String answer = in.nextLine();
            switch (answer) {
                case "1":
                    if (this.COURSES.contains("Math")) {
                        System.out.println("You have already signed up for this course\n");
                    } else {
                        this.COURSES.add("Math");
                        this.FEES_TO_BE_PAID +=600;
                        System.out.println("You have signed up for math!\n");
                    }
                    break;
                case "2":
                    if (this.COURSES.contains("History")) {
                        System.out.println("You have already signed up for this course\n");
                    } else {
                        this.COURSES.add("History");
                        this.FEES_TO_BE_PAID +=600;
                        System.out.println("You have signed up for history!\n");
                    }
                    break;
                case "3":
                    if (this.COURSES.contains("English")) {
                        System.out.println("You have already signed up for this course\n");
                    } else {
                        this.COURSES.add("English");
                        this.FEES_TO_BE_PAID +=600;
                        System.out.println("You have signed up for english!\n");
                    }
                    break;
                case "0":
                    repeat = true;
                    System.out.println(this.FEES_TO_BE_PAID + "$ has to be paid");
                    break;
                default:
                    System.out.println("Wrong number, try again!");
                    break;
            }
        }
    }
}
