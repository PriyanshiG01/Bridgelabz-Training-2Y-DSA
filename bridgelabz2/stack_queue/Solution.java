package array_level1;
import java.util.*;

class Solution {
    public static void sortStack(Stack<Integer> st) {
        if (st.isEmpty()) return;

        int top = st.pop();
        sortStack(st);
        insert(st, top);
    }

    private static void insert(Stack<Integer> st, int val) {
        if (st.isEmpty() || st.peek() <= val) {
            st.push(val);
            return;
        }

        int top = st.pop();
        insert(st, val);
        st.push(top);
    }
}