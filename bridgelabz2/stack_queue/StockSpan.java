package array_level1;
import java.util.*;

class StockSpan {
    public int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && prices[st.peek()] <= prices[i]) {
                st.pop();
            }

            span[i] = st.isEmpty() ? i + 1 : i - st.peek();
            st.push(i);
        }

        return span;
    }
}