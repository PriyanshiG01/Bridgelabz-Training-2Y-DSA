package STRING3;
import java.util.Scanner;

public class BMICalculator {

    // Method to calculate BMI and status
    public static String[][] calculateBMI(double[][] data) {
        String[][] result = new String[data.length][4];

        for(int i = 0; i < data.length; i++) {
            double weight = data[i][0];  // in kg
            double heightCm = data[i][1]; // in cm
            double heightM = heightCm / 100;
            double bmi = weight / (heightM * heightM);

            String status;
            if(bmi < 18.5) status = "Underweight";
            else if(bmi < 25) status = "Normal";
            else if(bmi < 30) status = "Overweight";
            else status = "Obese";

            result[i][0] = String.valueOf(heightCm);
            result[i][1] = String.valueOf(weight);
            result[i][2] = String.format("%.2f", bmi);
            result[i][3] = status;
        }

        return result;
    }

    // Method to display results
    public static void displayResults(String[][] arr) {
        System.out.printf("%-10s %-10s %-10s %-12s%n", "Height(cm)", "Weight(kg)", "BMI", "Status");
        for(String[] person : arr) {
            System.out.printf("%-10s %-10s %-10s %-12s%n", person[0], person[1], person[2], person[3]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] teamData = new double[10][2]; // weight, height

        for(int i = 0; i < 10; i++) {
            System.out.print("Enter weight (kg) of person " + (i+1) + ": ");
            teamData[i][0] = sc.nextDouble();
            System.out.print("Enter height (cm) of person " + (i+1) + ": ");
            teamData[i][1] = sc.nextDouble();
        }

        String[][] bmiResults = calculateBMI(teamData);
        displayResults(bmiResults);

        sc.close();
    }
}