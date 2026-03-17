package assignment;
import java.util.*;

public class StringLengthWithoutLength {

    public static int getLength(String s) {
        int count = 0;
        try {
            while(true) {
                s.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
            // reached end of string
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.next();

        int lenCustom = getLength(str);
        int lenBuiltIn = str.length();

        System.out.println("Length using custom method: " + lenCustom);
        System.out.println("Length using built-in length(): " + lenBuiltIn);
    }
}