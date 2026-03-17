package assignment;
import java.util.*;

public class VowelsConsonantsCount {

    public static String charType(char ch){
        if(ch>='A' && ch<='Z') ch += 32;
        if(ch>='a' && ch<='z'){
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u') return "Vowel";
            else return "Consonant";
        }
        return "Not a Letter";
    }

    public static int[] countVowelsConsonants(String s){
        int vowels=0, consonants=0;
        for(int i=0;i<s.length();i++){
            String type = charType(s.charAt(i));
            if(type.equals("Vowel")) vowels++;
            else if(type.equals("Consonant")) consonants++;
        }
        return new int[]{vowels, consonants};
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String s = sc.nextLine();
        int[] count = countVowelsConsonants(s);
        System.out.println("Vowels: "+count[0]);
        System.out.println("Consonants: "+count[1]);
    }
}