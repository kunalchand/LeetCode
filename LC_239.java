import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LC_239 {
    public static int[] listToInt(List<Integer> list) {
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static boolean isLeftMaxInDeque(Deque<Integer> deque, int[] nums, int left) {
        return nums[left] == deque.peekFirst();
    }

    public static void removeMaxFromDeque(Deque<Integer> deque) {
        deque.removeFirst();
    }

    public static void addMaxInResult(ArrayList<Integer> res, Deque<Integer> deque) {
        res.add(deque.peekFirst());
    }

    public static void createSecondMax(Deque<Integer> deque, int[] nums, int right) {
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
