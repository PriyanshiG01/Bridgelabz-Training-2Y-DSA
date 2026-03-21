package array_level1;
import java.util.*;

class ZeroSumSubarrays {
    public int countZeroSum(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, count = 0;

        map.put(0, 1);

        for (int num : arr) {
            sum += num;

            if (map.containsKey(sum)) {
                count += map.get(sum);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}