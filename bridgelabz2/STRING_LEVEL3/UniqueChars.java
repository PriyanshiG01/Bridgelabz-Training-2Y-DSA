package STRING3;
import java.util.Scanner;

public class UniqueChars {

    // Method to calculate length without using length()
    public static int stringLength(String str) {
        int count = 0;
        try {
            while(true) {
                str.charAt(count);
                count++;
            }
        } catch(Exception e) {
            return count;
        }
    }

    // Method to find unique characters
    public static char[] uniqueCharacters(String str) {
        int len = stringLength(str);
        char[] unique = new char[len];
        int index = 0;

        for(int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            boolean isUnique = true;
            for(int j = 0; j < i; j++) {
                if(str.charAt(j) == ch) {
                    isUnique = false;
                    break;
                }
            }
            if(isUnique) unique[index++] = ch;
        }

        char[] result = new char[index];
        for(int i = 0; i < index; i++) result[i] = unique[i];
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        char[] uniques = uniqueCharacters(text);
        System.out.print("Unique characters: ");
        for(char ch : uniques) System.out.print(ch + " ");

        sc.close();
    }
}