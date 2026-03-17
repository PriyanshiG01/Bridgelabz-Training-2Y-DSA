package STRING3;
import java.util.Scanner;

public class QuickSortProducts {

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // pivot as last element
        int i = low-1;
        for(int j=low; j<high; j++) {
            if(arr[j] <= pivot) {
                i++;
                int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
            }
        }
        int temp = arr[i+1]; arr[i+1] = arr[high]; arr[high] = temp;
        return i+1;
    }

    public static void quickSort(int[] arr, int low, int high) {
        if(low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of products: ");
        int n = sc.nextInt();
        int[] prices = new int[n];
        for(int i = 0; i < n; i++) {
            System.out.print("Enter price of product " + (i+1) + ": ");
            prices[i] = sc.nextInt();
        }

        quickSort(prices, 0, n-1);

        System.out.println("Sorted product prices: ");
        for(int price : prices) System.out.print(price + " ");
        sc.close();
    }
}