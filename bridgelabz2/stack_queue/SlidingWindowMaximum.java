package array_level1;
import java.util.*;

class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>();
        int n = nums.length;
        int[] res = new int[n - k + 1];

        for (int i = 0; i < n; i++) {
            if (!dq.isEmpty() && dq.peek() < i - k + 1) {
                dq.poll();
            }

            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            dq.offer(i);

            if (i >= k - 1) {
                res[i - k + 1] = nums[dq.peek()];
            }
        }

        return res;
    }
}