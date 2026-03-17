package STRING3;
import java.util.Scanner;
import java.util.HashSet;

public class StringBuilderRemoveDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        StringBuilder sb = new StringBuilder();
        HashSet<Character> set = new HashSet<>();
        for(char ch : input.toCharArray()) {
            if(!set.contains(ch)) {
                sb.append(ch);
                set.add(ch);
            }
        }

        System.out.println("String without duplicates: " + sb.toString());
        sc.close();
    }
}