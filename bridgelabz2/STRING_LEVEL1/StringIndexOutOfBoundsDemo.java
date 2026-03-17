package assignment;
import java.util.*;

public class StringIndexOutOfBoundsDemo {

    public static void generateException(String s) {
        System.out.println(s.charAt(s.length())); // index beyond length
    }

    public static void handleException(String s) {
        try {
            System.out.println(s.charAt(s.length()));
        } catch(StringIndexOutOfBoundsException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = sc.next();

        // generateException(s); // Uncomment to crash
        handleException(s);
    }
}
