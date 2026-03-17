package assignment;
import java.util.*;

public class ShortestLongestWord {

    public static int stringLength(String s) {
        int count=0; try{ while(true){ s.charAt(count); count++; } }
        catch(IndexOutOfBoundsException e){} return count;
    }

    public static String[] splitWords(String text){
        int len = stringLength(text);
        int wordCount = 1;
        for(int i=0;i<len;i++) if(text.charAt(i)==' ') wordCount++;
        String[] words = new String[wordCount];
        int index=0,start=0;
        for(int i=0;i<len;i++){
            if(text.charAt(i)==' '){
                words[index++] = text.substring(start,i);
                start = i+1;
            }
        }
        words[index] = text.substring(start,len);
        return words;
    }

    public static String[] findShortestLongest(String[] words){
        String shortest = words[0], longest = words[0];
        for(String w: words){
            if(stringLength(w) < stringLength(shortest)) shortest = w;
            if(stringLength(w) > stringLength(longest)) longest = w;
        }
        return new String[]{shortest,longest};
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String[] words = splitWords(text);
        String[] result = findShortestLongest(words);

        System.out.println("Shortest word: " + result[0]);
        System.out.println("Longest word: " + result[1]);
    }
}