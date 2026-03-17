package assignment;
import java.util.*;

public class VowelsConsonantsTable {

    public static String charType(char ch){
        if(ch>='A' && ch<='Z') ch += 32;
        if(ch>='a' && ch<='z'){
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u') return "Vowel";
            else return "Consonant";
        }
        return "Not a Letter";
    }

    public static String[][] analyzeString(String s){
        String[][] table = new String[s.length()][2];
        for(int i=0;i<s.length();i++){
            table[i][0] = String.valueOf(s.charAt(i));
            table[i][1] = charType(s.charAt(i));
        }
        return table;
    }

    public static void displayTable(String[][] table){
        System.out.println("Char\tType");
        for(String[] row: table)
            System.out.println(row[0]+"\t"+row[1]);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String s = sc.nextLine();
        String[][] table = analyzeString(s);
        displayTable(table);
    }
}
