package assignment;
import java.util.*;

public class ArrayIndexOutOfBoundsDemo {

    public static void generateException(String[] arr) {
        System.out.println(arr[arr.length]); // out of bounds
    }

    public static void handleException(String[] arr) {
        try {
            System.out.println(arr[arr.length]);
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of names: ");
        int n = sc.nextInt();
        String[] arr = new String[n];
        for(int i=0;i<n;i++) arr[i] = sc.next();

        // generateException(arr);
        handleException(arr);
    }
}