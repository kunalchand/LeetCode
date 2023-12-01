import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Set;

public class LC_150 {
    // https://leetcode.com/problems/evaluate-reverse-polish-notation/
    class Solution {
        public boolean isOperator(String str, Set<String> operators) {
            return operators.contains(str);
        }

        public int calculateCombo(String first, String second, String operator) {
            int firstInt = Integer.parseInt(first);
            int secondInt = Integer.parseInt(second);
            char operatorChar = operator.charAt(0);

            if (operatorChar == '+')
                return firstInt + secondInt;
            else if (operatorChar == '-')
                return firstInt - secondInt;
            else if (operatorChar == '/')
                return firstInt / secondInt;
            else if (operatorChar == '*')
                return firstInt * secondInt;
            else
                return 0;
        }

        public int evalRPN(String[] tokens) {
            Set<String> operators = Set.of("+", "-", "*", "/");

            Deque<String> stack = new ArrayDeque<>();

            for (String token : tokens) {
                if (isOperator(token, operators)) {
                    String operator = token;
                    String second = stack.pop();
                    String first = stack.pop();

                    stack.push(String.valueOf(calculateCombo(first, second, operator)));
                } else {
                    stack.push(token);
                }
            }

            return Integer.parseInt(stack.pop());
        }
    }

    public static final <T> void print(T t) {
        System.out.println(t);
    }

    public static void main(String[] args) {
        Solution solution = new LC_150().new Solution();
        print(solution.evalRPN(new String[] { "2", "1", "+", "3", "*" }));
        print(solution.evalRPN(new String[] { "4", "13", "5", "/", "+" }));
        print(solution.evalRPN(new String[] { "10", "6", "9", "3", "+", "-11", "*",
                "/", "*", "17", "+", "5", "+" }));
        print(solution.evalRPN(new String[] { "18" }));
        print(solution.evalRPN(new String[] { "5", "3", "*", "7", "+", "10", "2", "*", "3", "-", "8", "/", "+" }));
    }
}
