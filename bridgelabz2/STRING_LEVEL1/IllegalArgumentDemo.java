package assignment;
import java.util.*;

public class IllegalArgumentDemo {

    public static void generateException(String s) {
        System.out.println(s.substring(5, 2)); // start > end
    }

    public static void handleException(String s) {
        try {
            System.out.println(s.substring(5,2));
        } catch(StringIndexOutOfBoundsException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        String s = sc.next();

        // generateException(s);
        handleException(s);
    }
}