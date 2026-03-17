package assignment;
import java.util.*;

public class StringToCharArray {

    public static char[] getChars(String s) {
        char[] arr = new char[s.length()];
        for(int i=0;i<s.length();i++)
            arr[i] = s.charAt(i);
        return arr;
    }

    public static boolean compareCharArrays(char[] a1, char[] a2) {
        if(a1.length != a2.length) return false;
        for(int i=0;i<a1.length;i++)
            if(a1[i] != a2[i]) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        String text = sc.next();

        char[] arr1 = getChars(text);
        char[] arr2 = text.toCharArray();

        boolean same = compareCharArrays(arr1, arr2);

        System.out.println("Using custom method: " + Arrays.toString(arr1));
        System.out.println("Using toCharArray(): " + Arrays.toString(arr2));
        System.out.println("Are arrays equal? " + same);
    }
}