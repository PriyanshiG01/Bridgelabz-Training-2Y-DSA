package STRING3;
import java.io.*;

public class InputStreamReaderWriteFile {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));

        String input;
        System.out.println("Enter text (type 'exit' to stop):");
        while(!(input = br.readLine()).equalsIgnoreCase("exit")) {
            bw.write(input);
            bw.newLine();
        }

        br.close();
        isr.close();
        bw.close();
    }
}