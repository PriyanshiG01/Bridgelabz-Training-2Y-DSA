package assignment;
import java.util.*;

public class DynamicDigitArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int max = 10;
        int[] digits = new int[max];
        int index = 0;

        while (num != 0) {
            if (index == max) {
                max += 10;
                digits = Arrays.copyOf(digits, max);
            }
            digits[index++] = num % 10;
            num /= 10;
        }

        int largest = 0, second = 0;

        for (int i = 0; i < index; i++) {
            if (digits[i] > largest) {
                second = largest;
                largest = digits[i];
            } else if (digits[i] > second && digits[i] != largest) {
                second = digits[i];
            }
        }

        System.out.println("Largest: " + largest);
        System.out.println("Second Largest: " + second);
    }
}