package assignment;
import java.util.*;

public class SplitWordsCharAt {

    public static int stringLength(String s) {
        int count = 0;
        try {
            while(true) {
                s.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {}
        return count;
    }

    public static String[] splitWords(String text) {
        int len = stringLength(text);
        int wordCount = 1;
        for(int i=0;i<len;i++) if(text.charAt(i)==' ') wordCount++;
        String[] words = new String[wordCount];
        int index = 0, start=0;
        for(int i=0;i<len;i++) {
            if(text.charAt(i)==' ') {
                words[index++] = text.substring(start,i);
                start = i+1;
            }
        }
        words[index] = text.substring(start,len);
        return words;
    }

    public static boolean compareStringArrays(String[] arr1, String[] arr2) {
        if(arr1.length != arr2.length) return false;
        for(int i=0;i<arr1.length;i++)
            if(!arr1[i].equals(arr2[i])) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String[] customWords = splitWords(text);
        String[] builtInWords = text.split(" ");

        System.out.println("Custom split: " + Arrays.toString(customWords));
        System.out.println("Built-in split: " + Arrays.toString(builtInWords));
        System.out.println("Are results equal? " + compareStringArrays(customWords, builtInWords));
    }
}