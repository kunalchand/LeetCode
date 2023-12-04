import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class LC_739 {
    // https://leetcode.com/problems/daily-temperatures/

    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            int[] ans = new int[temperatures.length];

            Deque<Integer> stack = new ArrayDeque<>();

            for (int i = temperatures.length - 1; i >= 0; i--) {

                while (stack.size() != 0) {
                    // Warmer day found
                    if (temperatures[i] < temperatures[stack.peekFirst()]) {
                        ans[i] = stack.peekFirst() - i;
                        stack.push(i);
                        break;
                    }
                    // Equal or less temperature, so pop and look forward for warm
                    else {
                        stack.pop();
                    }
                }

                // When no future warm day possible
                if (stack.size() == 0) {
                    ans[i] = 0;
                    stack.push(i);
                }
            }

            return ans;
        }
    }

    public static final <T> void print(T t) {
        System.out.println(t);
    }

    public static void main(String[] args) {
        Solution solution = new LC_739().new Solution();
        print(Arrays.toString(solution.dailyTemperatures(new int[] { 73, 74, 75, 71, 69, 72, 76, 73 })));
        print(Arrays.toString(solution.dailyTemperatures(new int[] { 30, 40, 50, 60 })));
        print(Arrays.toString(solution.dailyTemperatures(new int[] { 30, 60, 90 })));
    }
}