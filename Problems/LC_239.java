import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LC_239 {
    // https://leetcode.com/problems/sliding-window-maximum/

    class Solution {
        public int[] listToInt(List<Integer> list) {
            return list.stream().mapToInt(Integer::intValue).toArray();
        }

        public boolean isLeftMaxInDeque(Deque<Integer> deque, int[] nums, int left) {
            return nums[left] == deque.peekFirst();
        }

        public void removeMaxFromDeque(Deque<Integer> deque) {
            deque.removeFirst();
        }

        public void addMaxInResult(ArrayList<Integer> res, Deque<Integer> deque) {
            res.add(deque.peekFirst());
        }

        public void createSecondMax(Deque<Integer> deque, int[] nums, int right) {
            if (deque.size() == 0)
                deque.addLast(nums[right]);
            else {
                while (deque.size() != 0) {
                    if (deque.peekLast() < nums[right])
                        deque.removeLast();
                    else
                        break;
                }
                deque.addLast(nums[right]);
            }
        }

        public int[] maxSlidingWindow(int[] nums, int k) {

            Deque<Integer> deque = new LinkedList<>();

            int left = 0;
            int right = 0;

            ArrayList<Integer> res = new ArrayList<>();

            while (right < nums.length) {
                if (right - left + 1 < k) {
                    createSecondMax(deque, nums, right);
                    right++;
                } else if (right - left + 1 == k) {
                    createSecondMax(deque, nums, right);
                    addMaxInResult(res, deque);
                    right++;
                } else {
                    if (isLeftMaxInDeque(deque, nums, left)) {
                        removeMaxFromDeque(deque);
                        left++;
                        createSecondMax(deque, nums, right);
                        addMaxInResult(res, deque);
                        right++;
                    } else {
                        left++;
                        createSecondMax(deque, nums, right);
                        addMaxInResult(res, deque);
                        right++;
                    }
                }
            }

            return listToInt(res);
        }
    }

    public static final <T> void print(T t) {
        System.out.println(t);
    }

    public static void main(String[] args) {
        Solution solution = new LC_239().new Solution();

        print(Arrays.toString(solution.maxSlidingWindow(new int[] { 1, 3, -1, -3, 5, 3, 6, 7 },
                3)));
    }
}
