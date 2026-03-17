package assignment;
import java.util.*;

public class WordsWithLengths {

    public static int stringLength(String s) {
        int count=0;
        try { while(true){ s.charAt(count); count++; } }
        catch(IndexOutOfBoundsException e){}
        return count;
    }

    public static String[] splitWords(String text){
        int len = stringLength(text);
        int wordCount = 1;
        for(int i=0;i<len;i++) if(text.charAt(i)==' ') wordCount++;
        String[] words = new String[wordCount];
        int index=0, start=0;
        for(int i=0;i<len;i++){
            if(text.charAt(i)==' '){
                words[index++] = text.substring(start,i);
                start = i+1;
            }
        }
        words[index] = text.substring(start,len);
        return words;
    }

    public static String[][] wordsWithLengths(String[] words){
        String[][] result = new String[words.length][2];
        for(int i=0;i<words.length;i++){
            result[i][0] = words[i];
            result[i][1] = String.valueOf(stringLength(words[i]));
        }
        return result;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String[] words = splitWords(text);
        String[][] table = wordsWithLengths(words);

        System.out.println("Word\tLength");
        for(int i=0;i<table.length;i++){
            System.out.println(table[i][0] + "\t" + table[i][1]);
        }
    }
}