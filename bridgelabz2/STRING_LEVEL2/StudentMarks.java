package assignment;
import java.util.*;

public class StudentMarks {

    public static int[][] generateRandomMarks(int students){
        int[][] marks = new int[students][3];
        Random rand = new Random();
        for(int i=0;i<students;i++){
            for(int j=0;j<3;j++){
                marks[i][j] = rand.nextInt(101); // 0-100
            }
        }
        return marks;
    }

    public static double[][] calculateTotalAveragePercentage(int[][] marks){
        double[][] stats = new double[marks.length][3];
        for(int i=0;i<marks.length;i++){
            int total = marks[i][0]+marks[i][1]+marks[i][2];
            double avg = Math.round((total/3.0)*100.0)/100.0;
            double percent = Math.round((total/300.0*100.0)*100.0)/100.0;
            stats[i][0] = total; stats[i][1] = avg; stats[i][2] = percent;
        }
        return stats;
    }

    public static String[] calculateGrade(double[][] stats){
        String[] grades = new String[stats.length];
        for(int i=0;i<stats.length;i++){
            double percent = stats[i][2];
            if(percent>=90) grades[i]="A";
            else if(percent>=75) grades[i]="B";
            else if(percent>=60) grades[i]="C";
            else if(percent>=50) grades[i]="D";
            else grades[i]="F";
        }
        return grades;
    }

    public static void displayResults(int[][] marks,double[][] stats,String[] grades){
        System.out.println("Student\tPhysics\tChemistry\tMath\tTotal\tAvg\t% \tGrade");
        for(int i=0;i<marks.length;i++){
            System.out.println((i+1)+"\t"+marks[i][0]+"\t"+marks[i][1]+"\t"+marks[i][2]+"\t"+
                    (int)stats[i][0]+"\t"+stats[i][1]+"\t"+stats[i][2]+"\t"+grades[i]);
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of students: ");
        int n = sc.nextInt();
        int[][] marks = generateRandomMarks(n);
        double[][] stats = calculateTotalAveragePercentage(marks);
        String[] grades = calculateGrade(stats);
        displayResults(marks,stats,grades);
    }
}