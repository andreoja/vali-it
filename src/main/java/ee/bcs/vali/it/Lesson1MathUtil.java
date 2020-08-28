package ee.bcs.vali.it;

import java.util.Scanner;

public class Lesson1MathUtil {

    public static void main(String[] args) {
//        System.out.println(max(4,4,5));
        System.out.println("Enter function name:");
        Scanner scanner = new Scanner(System.in);
        String funkt = scanner.nextLine();
        if (funkt.equalsIgnoreCase("min")) {
            System.out.println("Enter two numbers:");
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if (a < b) {
                System.out.println("First number " + a + " is smaller.");
            } else {
                System.out.println("Second number " + b + " is smaller.");
            }
        }
        else if (funkt.equalsIgnoreCase("max")) {
            System.out.println("Enter two numbers:");
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if (a > b) {
                System.out.println("First number " + a + " is greater.");
            } else {
                System.out.println("Second number " + b + " is greater.");
            }
        }
        else if (funkt.equalsIgnoreCase("abs")) {
            System.out.println("Enter a number:");
            int a = scanner.nextInt();
            if (a < 0) {
                System.out.println("The absolute number for " + a + " is " + -a + ".");
            } else {
                System.out.println("The absolute number for " + a + " is " + a + ".");
            }
        }
        else if (funkt.equalsIgnoreCase("isEven")) {
            System.out.println("Enter a number:");
            int a = scanner.nextInt();
            if (a % 2 == 0) {
                System.out.println("The number " + a + " is even.");
            } else {
                System.out.println("The number " + a + " is not even.");
            }
        }
        else if (funkt.equalsIgnoreCase("min3")) {
            System.out.println("Enter three numbers:");
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            if (a <= b && a <= c) {
                System.out.println("First number " + a + " is smaller.");
            } else if (b <= c && b <= a) {
                System.out.println("Second number " + b + " is smaller.");
            } else {
                System.out.println("Third number " + c + " is smaller.");
            }
        }
        else if (funkt.equalsIgnoreCase("max3")) {
            System.out.println("Enter three numbers:");
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            if (a >= b && a >= c) {
                System.out.println("First number " + a + " is greater.");
            } else if (b >= c && b >= a) {
                System.out.println("Second number " + b + " is greater.");
            } else {
                System.out.println("Third number " + c + " is greater.");
            }
        }
        else {
            System.out.println("There is no such function.");
        }

    }

    public static int min(int a, int b){
        // TODO tagasta a ja b väikseim väärtus

        if (a < b){
            return a;
        }
        else
            return b;
    }

    public static int max(int a, int b){
        // TODO tagasta a ja b suurim väärtus
        a = 3;
        b = 4;
        if (a > b){
            return a;
        }
        else
            return b;
    }

    public static int abs(int a){
        // TODO tagasta a absoluut arv
       if (a < 0)
            return -a;
        else
            return a;
    }

    public static boolean isEven(int a){
        // TODO tagasta true, kui a on paaris arv
        if (a % 2 == 0)
            return true;
        // tagasta false kui a on paaritu arv
        else
            return false;
    }

    public static int min(int a, int b, int c){
        // TODO tagasta a, b ja c väikseim väärtus
        if (a <= b && a <= c) {
            return a;
        } else if (b <= c && b <= a) {
            return b;
        } else {
            return c;}
    }


    public static int max(int a, int b, int c){
        // TODO tagasta a, b ja c suurim väärtus
        if (a >= b && a >= c) {
            return a;
        } else if (b >= c && b >= a) {
            return b;
        } else {
            return c;}
    }

}
