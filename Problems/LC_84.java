import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LC_84 {
    // https://leetcode.com/problems/largest-rectangle-in-histogram/

    class Solution {
        class Bar {
            private int location;
            private int height;
            private int previousSmallestBar;
            private int nextSmallestBar;

            Bar(int location, int height) {
                this.location = location;
                this.height = height;
                this.previousSmallestBar = -2;
                this.nextSmallestBar = -2;
            }

            public int getLocation() {
                return location;
            }

            public int getHeight() {
                return height;
            }

            public int getPreviousSmallestBar() {
                return previousSmallestBar;
            }

            public int getNextSmallestBar() {
                return nextSmallestBar;
            }

            public void setPreviousSmallestBar(int value) {
                this.previousSmallestBar = value;
            }

            public void setNextSmallestBar(int value) {
                this.nextSmallestBar = value;
            }

            @Override
            public String toString() {
                return "(" + location + ", " + height + ", " + previousSmallestBar + ", " + nextSmallestBar + ")";
            }
        }

        public void pushInStack(Deque<Bar> stack, Bar bar, String type) {
            if (stack.size() == 0)
                stack.push(bar);
            else {
                if (stack.peekFirst().getHeight() > bar.getHeight()) {
                    Bar topBar = stack.pop();

                    if (type.equals("NextSmallestBar"))
                        topBar.setNextSmallestBar(bar.getLocation());
                    else if (type.equals("PreviousSmallestBar"))
                        topBar.setPreviousSmallestBar(bar.getLocation());

                    pushInStack(stack, bar, type);
                } else {
                    stack.push(bar);
                }
            }
        }

        public int calculateArea(int height, int left, int right) {
            int width = right - left - 1;
            return (height * width);
        }

        public int largestRectangleArea(int[] heights) {
            List<Bar> earth = new ArrayList<>();

            // Generate the earth list with dummy bars at each ends
            earth.add(new Bar(0, 0));
            for (int i = 0; i < heights.length; i++) {
                earth.add(new Bar(i + 1, heights[i]));
            }
            earth.add(new Bar(heights.length + 1, 0));

            Deque<Bar> stack = new ArrayDeque<>();

            // Calculate Previous Smallest Bar
            for (int i = earth.size() - 2; i >= 0; i--) {
                pushInStack(stack, earth.get(i), "PreviousSmallestBar");
            }

            stack.clear();

            // Calculate Next Smallest Bar
            for (int i = 1; i < earth.size(); i++) {
                pushInStack(stack, earth.get(i), "NextSmallestBar");
            }

            int maxArea = Integer.MIN_VALUE;

            for (int i = 1; i < earth.size() - 1; i++) {
                Bar bar = earth.get(i);
                int height = bar.getHeight();
                int left = bar.getPreviousSmallestBar();
                int right = bar.getNextSmallestBar();
                maxArea = Math.max(maxArea, calculateArea(height, left, right));
            }

            return maxArea;
        }
    }

    public static final <T> void print(T t) {
        System.out.println(t);
    }

    public static void main(String[] args) {
        Solution solution = new LC_84().new Solution();
        print(solution.largestRectangleArea(new int[] { 2, 1, 5, 6, 2, 3 }));
        print(solution.largestRectangleArea(new int[] { 2, 4 }));
    }
}
