package SchoolSystem;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Student {

    private String FIRST_NAME;
    private String LAST_NAME;
    private String YEAR;
    private String STUDENT_ID;
    private ArrayList<String> COURSES = new ArrayList<String>();
    private static int FEES_PAID = 0;
    private static int FEES_TO_BE_PAID = 0;
    private static int id = 1000;

    public Student(){
        Scanner in = new Scanner(System.in);

        System.out.print("Enter student first name: ");
        this.FIRST_NAME = in.nextLine();

        System.out.print("Enter student last name: ");
        this.LAST_NAME = in.nextLine();

        System.out.print("1 - Freshamn\n2 - Sophomore\n3 - Junior\n4 - Senior\nEnter student year: ");
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
                    System.out.println("Enrolled in:");
                    for(int i=0; i<this.COURSES.size(); i++){
                        System.out.println(this.COURSES.get(i));
                    }
                    System.out.println(this.FEES_TO_BE_PAID + "$ has to be paid");
                    break;
                default:
                    System.out.println("Wrong number, try again!");
                    break;
            }
        }
    }
    private void checkFEES(){
        System.out.println("Fees left to be paid: "+ (this.FEES_TO_BE_PAID-FEES_PAID)+"$\nWould You like to pay now?\n(1 - Yes\n2 - No");
        Scanner in = new Scanner(System.in);
        String check = in.nextLine();
        if(check.equals("1")){
            payFEE();
        }

    }
    private void payFEE(){
        System.out.println("Enter amount of fee You want to pay: ");
        Scanner in = new Scanner(System.in);
        String amount = in.nextLine();
        this.FEES_PAID += Integer.valueOf(amount);
        System.out.println("Fees left to be paid: "+ (this.FEES_TO_BE_PAID-FEES_PAID)+"$");
    }
}
