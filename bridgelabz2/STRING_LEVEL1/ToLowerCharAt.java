package assignment;
import java.util.*;

public class ToLowerCharAt {

    public static String toLowerCharAt(String s) {
        String result = "";
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            if(ch >= 'A' && ch <= 'Z') ch += 32;
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

        String lowerCustom = toLowerCharAt(text);
        String lowerBuiltIn = text.toLowerCase();

        boolean same = compareStrings(lowerCustom, lowerBuiltIn);

        System.out.println("Lowercase using charAt(): " + lowerCustom);
        System.out.println("Lowercase using built-in: " + lowerBuiltIn);
        System.out.println("Are results same? " + same);
    }
}