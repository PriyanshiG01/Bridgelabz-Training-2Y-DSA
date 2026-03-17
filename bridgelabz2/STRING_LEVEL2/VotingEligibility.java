package assignment;
import java.util.*;

public class VotingEligibility {

    public static int[] generateRandomAges(int n){
        int[] ages = new int[n];
        Random rand = new Random();
        for(int i=0;i<n;i++){
            ages[i] = rand.nextInt(100); // 0-99
        }
        return ages;
    }

    public static String[][] checkEligibility(int[] ages){
        String[][] result = new String[ages.length][2];
        for(int i=0;i<ages.length;i++){
            result[i][0] = String.valueOf(ages[i]);
            int age = ages[i];
            if(age<0) result[i][1]="Cannot vote";
            else if(age>=18) result[i][1]="Can vote";
            else result[i][1]="Cannot vote";
        }
        return result;
    }

    public static void displayTable(String[][] table){
        System.out.println("Age\tEligibility");
        for(String[] row: table)
            System.out.println(row[0]+"\t"+row[1]);
    }

    public static void main(String[] args){
        int[] ages = generateRandomAges(10);
        String[][] table = checkEligibility(ages);
        displayTable(table);
    }
}