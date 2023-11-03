import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class LC_20 {
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