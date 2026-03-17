package STRING3;
import java.util.Scanner;

public class PalindromeCheck {

    // Logic 1: Compare start & end
    public static boolean isPalindromeSimple(String str) {
        int start = 0, end = str.length()-1;
        while(start < end) {
            if(str.charAt(start) != str.charAt(end)) return false;
            start++; end--;
        }
        return true;
    }

    // Logic 2: Recursion
    public static boolean isPalindromeRecursive(String str, int start, int end) {
        if(start >= end) return true;
        if(str.charAt(start) != str.charAt(end)) return false;
        return isPalindromeRecursive(str, start+1, end-1);
    }

    // Logic 3: Reverse array comparison
    public static boolean isPalindromeArray(String str) {
        char[] arr = str.toCharArray();
        char[] rev = new char[arr.length];
        for(int i = 0; i < arr.length; i++) rev[i] = arr[arr.length-1-i];

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != rev[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        String text = sc.nextLine();

        System.out.println("Palindrome (Simple): " + isPalindromeSimple(text));
        System.out.println("Palindrome (Recursive): " + isPalindromeRecursive(text, 0, text.length()-1));
        System.out.println("Palindrome (Array): " + isPalindromeArray(text));

        sc.close();
    }
}