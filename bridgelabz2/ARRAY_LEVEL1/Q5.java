package assignment;
import java.util.*;

public class Q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] result = new int[4];

        int k = 0;
        for (int i = 6; i <= 9; i++) {
            result[k++] = num * i;
        }

        k = 0;
        for (int i = 6; i <= 9; i++) {
            System.out.println(num + " * " + i + " = " + result[k++]);
        }
    }
}