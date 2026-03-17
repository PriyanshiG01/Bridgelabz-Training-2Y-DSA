package STRING3;
public class LinearSearchWord {
    public static String findSentence(String[] sentences, String word) {
        for(String s : sentences) {
            if(s.contains(word)) return s;
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        String[] arr = {"Hello world", "Java is fun", "OpenAI GPT"};
        System.out.println(findSentence(arr, "Java"));
    }
}