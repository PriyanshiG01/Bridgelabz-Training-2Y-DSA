package STRING3;
import java.io.*;

public class InputStreamReaderExample {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("example.txt");
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        BufferedReader br = new BufferedReader(isr);

        String line;
        while((line = br.readLine()) != null) {
            System.out.println(line);
        }

        br.close();
        isr.close();
        fis.close();
    }
}