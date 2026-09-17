import java.util.*;

class Solution {
    public int minSumOfLengths(int[] arr, int target) {

        int n = arr.length;
        int INF = 1000000000;

        // best[i] = minimum length of a valid subarray
        // present in arr[0...i]
        int[] best = new int[n];
        Arrays.fill(best, INF);

        // prefix sum -> latest index
        HashMap<Long, Integer> map = new HashMap<>();

        map.put(0L, -1);

        long prefixSum = 0;

        int minLength = INF;
        int answer = INF;

        for (int i = 0; i < n; i++) {

            prefixSum += arr[i];

            // We need:
            // prefixSum - previousPrefix = target
            long required = prefixSum - target;

            if (map.containsKey(required)) {

                int j = map.get(required);

                // Current subarray = [j + 1 ... i]
                int currentLength = i - j;

                // Previous subarray must end before j
                if (j >= 0 && best[j] != INF) {
                    answer = Math.min(
                        answer,
                        currentLength + best[j]
                    );
                }

                // Store shortest subarray found so far
                minLength = Math.min(minLength, currentLength);
            }

            // Best answer up to index i
            best[i] = minLength;

            // Store latest prefix sum index
            map.put(prefixSum, i);
        }

        return answer == INF ? -1 : answer;
    }
}