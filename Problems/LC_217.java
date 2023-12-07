import java.util.HashMap;

public class LC_217 {
    // https://leetcode.com/problems/contains-duplicate/

    class Solution {
        public boolean containsDuplicate(int[] nums) {
            HashMap<Integer, Integer> map = new HashMap<>();

            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            if (map.size() != nums.length)
                return true;
            else
                return false;
        }
    }

    public static final <T> void print(T t) {
        System.out.println(t);
    }

    public static void main(String[] args) {
        Solution solution = new LC_217().new Solution();
        print(solution.containsDuplicate(new int[] { 1, 2, 3, 1 }));
        print(solution.containsDuplicate(new int[] { 1, 2, 3, 4 }));
        print(solution.containsDuplicate(new int[] { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 }));
    }
}
