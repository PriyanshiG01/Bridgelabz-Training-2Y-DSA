package assignment;
import java.util.*;

public class ToUpperCharAt {

    public static String toUpperCharAt(String s) {
        String result = "";
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            if(ch >= 'a' && ch <= 'z') ch -= 32;
            result += ch;
        }
        return result;
    }

    public static boolean compareStrings(String s1, String s2) {
        if(s1.length()!=s2.length()) return false;
        for(int i=0;i<s1.length();i++)
            if(s1.charAt(i)!=s2.charAt(i)) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String upperCustom = toUpperCharAt(text);
        String upperBuiltIn = text.toUpperCase();

        boolean same = compareStrings(upperCustom, upperBuiltIn);

        System.out.println("Uppercase using charAt(): " + upperCustom);
        System.out.println("Uppercase using built-in: " + upperBuiltIn);
        System.out.println("Are results same? " + same);
    }
}
