package STRING3;
import java.io.*;

public class FileReaderExample {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("example.txt");
        BufferedReader br = new BufferedReader(fr);

        String line;
        while((line = br.readLine()) != null) {
            System.out.println(line);
        }

        br.close();
        fr.close();
    }
}