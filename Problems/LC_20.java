import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class LC_20 {
    // https://leetcode.com/problems/valid-parentheses/

    class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();

            List<Character> openBrackets = Arrays.asList('[', '{', '(');

            List<Character> closeBrackets = Arrays.asList(']', '}', ')');

            for (Character c : s.toCharArray()) {
                if (stack.size() != 0) {
                    if (closeBrackets.contains(c) && openBrackets.contains(stack.peek())) {
                        if (c == ']' && stack.peek() == '[')
                            stack.pop();
                        else if (c == '}' && stack.peek() == '{')
                            stack.pop();
                        else if (c == ')' && stack.peek() == '(')
                            stack.pop();
                        else
                            stack.push(c);
                    } else
                        stack.push(c);
                } else
                    stack.push(c);
            }

            return stack.size() == 0;
        }
    }

    public static final <T> void print(T t) {
        System.out.println(t);
    }

    public static void main(String[] args) {
        Solution solution = new LC_20().new Solution();
        print(solution.isValid("()"));
        print(solution.isValid("()[]{}"));
        print(solution.isValid("(]"));
    }
}