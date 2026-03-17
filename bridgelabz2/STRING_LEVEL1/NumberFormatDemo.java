package assignment;
import java.util.*;

public class NumberFormatDemo {

    public static void generateException(String s) {
        int n = Integer.parseInt(s);
        System.out.println(n);
    }

    public static void handleException(String s) {
        try {
            int n = Integer.parseInt(s);
            System.out.println(n);
        } catch(NumberFormatException e) {
            System.out.println("Caught NumberFormatException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        String s = sc.next();

        // generateException(s);
        handleException(s);
    }
}