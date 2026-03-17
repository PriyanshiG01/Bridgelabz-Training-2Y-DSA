package assignment;
import java.util.*;

public class ReverseNumberArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int temp = num, count = 0;

        while (temp != 0) {
            count++;
            temp /= 10;
        }

        int[] arr = new int[count];

        for (int i = 0; i < count; i++) {
            arr[i] = num % 10;
            num /= 10;
        }

        System.out.print("Reversed: ");
        for (int i = 0; i < count; i++) {
            System.out.print(arr[i]);
        }
    }
}