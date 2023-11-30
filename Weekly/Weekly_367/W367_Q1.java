import java.util.Arrays;

public class W367_Q1 {
    // https://leetcode.com/contest/weekly-contest-367/problems/find-indices-with-index-and-value-difference-i/

    class Solution {
        public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
            int[] ans = { -1, -1 };
            for (int i = 0; i < nums.length; i++) {
                for (int j = i; j < nums.length; j++) {
                    if (Math.abs(i - j) >= indexDifference && Math.abs(nums[i] - nums[j]) >= valueDifference) {
                        ans[0] = i;
                        ans[1] = j;
                        return ans;
                    }
                }
            }
            return ans;
        }
    }

    public static final <T> void print(T t) {
        System.out.println(t);
    }

    public static void main(String[] args) {
        Solution solution = new W367_Q1().new Solution();
        print(Arrays.toString(solution
                .findIndices(new int[] { 5, 1, 4, 1 }, 2, 4))); // [0, 3]

        print(Arrays.toString(solution
                .findIndices(new int[] { 2, 1 }, 0, 0))); // [0, 0]

        print(Arrays.toString(solution
                .findIndices(new int[] { 1, 2, 3 }, 2, 4))); // [-1, -1]
    }
}