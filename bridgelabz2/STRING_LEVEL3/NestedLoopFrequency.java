package STRING3;
import java.util.Scanner;

public class NestedLoopFrequency {

    public static String[][] frequencyNested(String str) {
        char[] chars = str.toCharArray();
        int n = chars.length;
        int[] freq = new int[n];

        for(int i = 0; i < n; i++) freq[i] = 1;

        for(int i = 0; i < n; i++) {
            if(chars[i] == '0') continue;
            for(int j = i+1; j < n; j++) {
                if(chars[i] == chars[j]) {
                    freq[i]++;
                    chars[j] = '0';
                }
            }
        }

        int count = 0;
        for(char c : chars) if(c != '0') count++;
        String[][] result = new String[count][2];
        int index = 0;
        for(int i = 0; i < n; i++) {
            if(chars[i] != '0') {
                result[index][0] = Character.toString(chars[i]);
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

        String[][] freq = frequencyNested(text);
        display(freq);
        sc.close();
    }
}