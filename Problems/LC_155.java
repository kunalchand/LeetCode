import java.util.ArrayDeque;

class Element {
    protected Integer value;
    protected Integer min;

    public Element() {
        // Default call. So required.
    }

    public Element(Integer value, Integer min) {
        this.value = value;
        this.min = min;
    }
}

class LC_155 extends Element {
    // https://leetcode.com/problems/min-stack/
    private ArrayDeque<Element> stack;

    public LC_155() {
        stack = new ArrayDeque<>();
    }

    public void push(int val) {
        stack.push(
                new Element(val, Math.min(val, stack.peekFirst() == null ? Integer.MAX_VALUE : stack.peekFirst().min)));
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peekFirst().value;
    }

    public int getMin() {
        return stack.peekFirst().min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */