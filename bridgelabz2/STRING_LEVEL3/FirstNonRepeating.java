package STRING3;
import java.util.Scanner;

public class FirstNonRepeating {

    public static char firstNonRepeatingChar(String str) {
        int[] freq = new int[256]; // ASCII

        for(int i = 0; i < str.length(); i++) {
            freq[str.charAt(i)]++;
        }

        for(int i = 0; i < str.length(); i++) {
            if(freq[str.charAt(i)] == 1) return str.charAt(i);
        }
        return '-'; // if all repeating
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        String text = sc.nextLine();

        char result = firstNonRepeatingChar(text);
        System.out.println("First non-repeating character: " + result);

        sc.close();
    }
}