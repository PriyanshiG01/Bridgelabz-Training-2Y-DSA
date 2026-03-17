package assignment;
import java.util.*;

public class SubstringCharAt {

    public static String getSubstringCharAt(String s, int start, int end) {
        String sub = "";
        for(int i=start; i<end; i++) {
            sub += s.charAt(i);
        }
        return sub;
    }

    public static boolean compareCharAtStrings(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        for(int i=0;i<s1.length();i++)
            if(s1.charAt(i) != s2.charAt(i)) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.next();
        System.out.print("Enter start index: ");
        int start = sc.nextInt();
        System.out.print("Enter end index: ");
        int end = sc.nextInt();

        String sub1 = getSubstringCharAt(text, start, end);
        String sub2 = text.substring(start, end);

        boolean same = compareCharAtStrings(sub1, sub2);

        System.out.println("Substring using charAt(): " + sub1);
        System.out.println("Substring using built-in substring(): " + sub2);
        System.out.println("Are they equal? " + same);
    }
}