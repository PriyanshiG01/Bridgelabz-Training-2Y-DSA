package STRING3;
import java.io.*;

public class FileReaderWordCount {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("example.txt"));
        String target = "hello";
        int count = 0;
        String line;
        while((line = br.readLine()) != null) {
            String[] words = line.split("\\s+");
            for(String word : words) {
                if(word.equals(target)) count++;
            }
        }
        System.out.println("Word '" + target + "' occurs " + count + " times.");
        br.close();
    }
}