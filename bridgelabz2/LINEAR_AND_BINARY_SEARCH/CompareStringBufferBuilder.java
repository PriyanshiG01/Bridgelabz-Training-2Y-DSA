package STRING3;
public class CompareStringBufferBuilder {
    public static void main(String[] args) {
        int n = 1000000;

        long start = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++) sb.append("hello");
        long end = System.nanoTime();
        System.out.println("StringBuilder time: " + (end-start)/1e6 + " ms");

        start = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for(int i=0;i<n;i++) sbf.append("hello");
        end = System.nanoTime();
        System.out.println("StringBuffer time: " + (end-start)/1e6 + " ms");
    }
}