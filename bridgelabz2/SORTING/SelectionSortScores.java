package STRING3;
import java.util.Scanner;

public class SelectionSortScores {

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for(int i=0; i<n-1; i++) {
            int minIndex = i;
            for(int j=i+1; j<n; j++) {
                if(arr[j] < arr[minIndex]) minIndex = j;
            }
            int temp = arr[i]; arr[i] = arr[minIndex]; arr[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        int[] scores = new int[n];
        for(int i=0; i<n; i++) {
            System.out.print("Enter score of student " + (i+1) + ": ");
            scores[i] = sc.nextInt();
        }

        selectionSort(scores);

        System.out.println("Sorted exam scores: ");
        for(int score : scores) System.out.print(score + " ");
        sc.close();
    }
}