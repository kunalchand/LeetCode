import java.util.ArrayList;
import java.util.List;

public class LC_22 {
    // https://leetcode.com/problems/generate-parentheses/

    class Solution {
        public void helper(List<String> answer, String str, int left, int right) {
            // numebr of applied right baces are more than the applied left braces
            if (left > right)
                return;
            // All the brackets are applied
            else if (left == 0 && right == 0) {
                answer.add(str);
                return;
            } else if (left < 0 || right < 0)
                return;

            // Add a left bracket
            helper(answer, str + "(", left - 1, right);

            // Add a right bracket
            helper(answer, str + ")", left, right - 1);

            return;
        }

        public List<String> generateParenthesis(int n) {
            List<String> answer = new ArrayList<String>();

            helper(answer, "", n, n);

            return answer;
        }
    }

    public static final <T> void print(T t) {
        System.out.println(t);
    }

    public static void main(String[] args) {
        Solution solution = new LC_22().new Solution();
        print(solution.generateParenthesis(3));
        print(solution.generateParenthesis(1));
        print(solution.generateParenthesis(4));
    }
}
