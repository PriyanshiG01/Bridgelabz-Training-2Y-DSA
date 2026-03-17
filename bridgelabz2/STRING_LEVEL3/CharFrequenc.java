package STRING3;
import java.util.Scanner;

public class CharFrequenc {

    public static String[][] charFrequency(String str) {
        int[] freq = new int[256]; // ASCII

        for(int i = 0; i < str.length(); i++) {
            freq[str.charAt(i)]++;
        }

        int count = 0;
        for(int f : freq) if(f > 0) count++;

        String[][] result = new String[count][2];
        int index = 0;
        for(int i = 0; i < 256; i++) {
            if(freq[i] > 0) {
                result[index][0] = Character.toString((char)i);
                result[index][1] = Integer.toString(freq[i]);
                index++;
            }
        }
        return result;
    }

    public static void display(String[][] arr) {
        System.out.printf("%-10s %-10s%n", "Character", "Frequency");
        for(String[] s : arr)
            System.out.printf("%-10s %-10s%n", s[0], s[1]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        String text = sc.nextLine();

        String[][] freqResult = charFrequency(text);
        display(freqResult);
        sc.close();
    }
}
