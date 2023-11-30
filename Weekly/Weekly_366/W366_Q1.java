
public class W366_Q1 {
    // https://leetcode.com/contest/weekly-contest-366/problems/divisible-and-non-divisible-sums-difference/

    public class Solution {
        public int differenceOfSums(int n, int m) {
            int ans = 0;
            // Iterate through 1 to n
            for (int i = 1; i <= n; i++) {
                // Your code here
                if (i % m == 0) {
                    ans -= i;
                } else {
                    ans += i;
                }
            }

            return ans;
        }
    }

    public static final <T> void print(T t) {
        System.out.println(t);
    }

    public static void main(String[] args) {
        Solution solution = new W366_Q1().new Solution();
        print(solution.differenceOfSums(10, 3)); // 19
        print(solution.differenceOfSums(5, 6)); // -15
        print(solution.differenceOfSums(5, 1)); // -15
    }
}
