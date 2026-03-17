package STRING3;
import java.util.Scanner;

public class CountingSortAges {

    public static int[] countingSort(int[] arr, int min, int max) {
        int range = max - min + 1;
        int[] count = new int[range];
        int n = arr.length;

        for(int i=0; i<n; i++) count[arr[i]-min]++;
        for(int i=1; i<range; i++) count[i] += count[i-1];

        int[] output = new int[n];
        for(int i=n-1; i>=0; i--) {
            output[count[arr[i]-min]-1] = arr[i];
            count[arr[i]-min]--;
        }
        return output;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        int[] ages = new int[n];
        for(int i=0; i<n; i++) {
            System.out.print("Enter age of student " + (i+1) + ": ");
            ages[i] = sc.nextInt();
        }

        int[] sortedAges = countingSort(ages, 10, 18);

        System.out.println("Sorted ages: ");
        for(int age : sortedAges) System.out.print(age + " ");
        sc.close();
    }
}