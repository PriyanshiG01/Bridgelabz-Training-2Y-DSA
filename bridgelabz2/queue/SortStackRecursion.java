package array_level1;
import java.util.*;

public class SortStackRecursion {

    static void sortedInsert(Stack<Integer> st, int x) {
        if (st.isEmpty() || st.peek() <= x) {
            st.push(x);
            return;
        }

        int temp = st.pop();
        sortedInsert(st, x);
        st.push(temp);
    }

    static void sortStack(Stack<Integer> st) {
        if (st.isEmpty()) return;

        int x = st.pop();
        sortStack(st);
        sortedInsert(st, x);
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(3);
        st.push(1);
        st.push(4);
        st.push(2);

        sortStack(st);

        while (!st.isEmpty()) {
            System.out.print(st.pop() + " ");
        }
    }
}