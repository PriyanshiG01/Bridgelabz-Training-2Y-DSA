package assignment;
import java.util.*;

public class TrimSpacesCharAt {

    public static int[] findTrimIndexes(String s){
        int start=0, end=s.length()-1;
        while(start<=end && s.charAt(start)==' ') start++;
        while(end>=start && s.charAt(end)==' ') end--;
        return new int[]{start,end};
    }

    public static String substringCharAt(String s, int start, int end){
        String sub="";
        for(int i=start;i<=end;i++) sub += s.charAt(i);
        return sub;
    }

    public static boolean compareStrings(String s1,String s2){
        if(s1.length()!=s2.length()) return false;
        for(int i=0;i<s1.length();i++)
            if(s1.charAt(i)!=s2.charAt(i)) return false;
        return true;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String s = sc.nextLine();

        int[] indexes = findTrimIndexes(s);
        String trimmedCustom = substringCharAt(s,indexes[0],indexes[1]);
        String trimmedBuiltIn = s.trim();
        boolean same = compareStrings(trimmedCustom, trimmedBuiltIn);

        System.out.println("Trimmed (custom): '"+trimmedCustom+"'");
        System.out.println("Trimmed (built-in): '"+trimmedBuiltIn+"'");
        System.out.println("Are they equal? "+same);
    }
}