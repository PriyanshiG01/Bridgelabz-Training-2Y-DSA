package STRING3;
import java.util.Scanner;

public class InsertionSortIDs {

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for(int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i-1;
            while(j >= 0 && arr[j] > key) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();
        int[] empIDs = new int[n];
        for(int i = 0; i < n; i++) {
            System.out.print("Enter Employee ID " + (i+1) + ": ");
            empIDs[i] = sc.nextInt();
        }

        insertionSort(empIDs);

        System.out.println("Sorted Employee IDs: ");
        for(int id : empIDs) System.out.print(id + " ");
        sc.close();
    }
}