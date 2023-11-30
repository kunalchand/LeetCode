public class LC_155 {
    // https://leetcode.com/problems/min-stack/

    class MinStack {
        private class ValStack {
            private int val;
            private ValStack down;

            private ValStack(int val, ValStack down) {
                this.val = val;
                this.down = down;
            }
        }

        private class MinCountStack {
            private int min;
            private int count;
            private MinCountStack down;

            private MinCountStack(int min, int count, MinCountStack down) {
                this.min = min;
                this.count = count;
                this.down = down;
            }
        }

        private ValStack valStackHead;
        private MinCountStack minCountStackHead;

        public MinStack() {
            valStackHead = null;
            minCountStackHead = null;
        }

        public void push(int val) {
            // Push in ValStack
            if (valStackHead == null)
                valStackHead = new ValStack(val, null);
            else
                valStackHead = new ValStack(val, valStackHead);

            // Push in MinCountStack
            if (minCountStackHead == null)
                minCountStackHead = new MinCountStack(val, 1, null);
            else {
                if (val == minCountStackHead.min)
                    minCountStackHead.count++;
                else if (val < minCountStackHead.min) {
                    minCountStackHead = new MinCountStack(val, 1, minCountStackHead);
                }
            }
        }

        public void pop() {
            if (valStackHead.val == minCountStackHead.min) {
                if (minCountStackHead.count == 1) {
                    minCountStackHead = minCountStackHead.down;
                } else {
                    minCountStackHead.count--;
                }
            }

            valStackHead = valStackHead.down;
        }

        public int top() {
            return valStackHead.val;
        }

        public int getMin() {
            return minCountStackHead.min;
        }

        public final <T> void print(T t) {
            System.out.println(t);
        }

        public void printValStack() {
            ValStack p = valStackHead;
            while (p != null) {
                print("val = " + p.val);
                p = p.down;
            }
            print("");
        }

        public void printMinCountStack() {
            MinCountStack p = minCountStackHead;
            while (p != null) {
                print("min = " + p.min + "count = " + p.count);
                p = p.down;
            }
            print("");
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

    public static final <T> void print(T t) {
        System.out.println(t);
    }

    public static void main(String[] args) {
        print("\nTest Case 1: ");
        MinStack minStack = new LC_155().new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        print(minStack.getMin()); // return -3
        minStack.pop();
        print(minStack.top()); // return 0
        print(minStack.getMin()); // return -2

        print("\nTest Case 2: ");
        MinStack obj = new LC_155().new MinStack();
        obj.push(2);
        obj.push(0);
        obj.push(3);
        obj.push(0);
        print(obj.getMin()); // return 0
        obj.pop();
        print(obj.getMin()); // return 0
        obj.pop();
        print(obj.getMin()); // return 0
        obj.pop();
        print(obj.getMin()); // return 2
    }
}