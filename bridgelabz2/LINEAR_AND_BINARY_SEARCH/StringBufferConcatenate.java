package STRING3;
import java.util.Scanner;

public class StringBufferConcatenate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of strings: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        StringBuffer sb = new StringBuffer();
        for(int i=0;i<n;i++) {
            System.out.print("Enter string " + (i+1) + ": ");
            sb.append(sc.nextLine());
        }

        System.out.println("Concatenated string: " + sb.toString());
        sc.close();
    }
}