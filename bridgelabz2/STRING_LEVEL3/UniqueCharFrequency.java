package STRING3;
import java.util.Scanner;

public class UniqueCharFrequency {

    public static char[] uniqueCharacters(String str) {
        char[] unique = new char[str.length()];
        int index = 0;
        for(int i = 0; i < str.length(); i++) {
            boolean isUnique = true;
            for(int j = 0; j < i; j++) {
                if(str.charAt(i) == str.charAt(j)) {
                    isUnique = false;
                    break;
                }
            }
            if(isUnique) unique[index++] = str.charAt(i);
        }
        char[] result = new char[index];
        for(int i = 0; i < index; i++) result[i] = unique[i];
        return result;
    }

    public static String[][] frequencyUsingUnique(String str) {
        int[] freq = new int[256];
        for(int i = 0; i < str.length(); i++) freq[str.charAt(i)]++;

        char[] unique = uniqueCharacters(str);
        String[][] result = new String[unique.length][2];
        for(int i = 0; i < unique.length; i++) {
            result[i][0] = Character.toString(unique[i]);
            result[i][1] = Integer.toString(freq[unique[i]]);
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

        String[][] freq = frequencyUsingUnique(text);
        display(freq);
        sc.close();
    }
}