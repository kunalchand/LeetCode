import java.util.HashMap;

public class LC_242 {
    // https://leetcode.com/problems/valid-anagram/

    class Solution {

        public void createMap(HashMap<Character, Integer> map, String str) {
            for (Character c : str.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }

        public boolean compareMap(HashMap<Character, Integer> map1, HashMap<Character, Integer> map2) {
            for (Character c : map1.keySet()) {
                if (map2.getOrDefault(c, 0) == 0)
                    return false;
                else if (map1.get(c).intValue() != map2.get(c).intValue())
                    return false;
            }
            return true;
        }

        public boolean isAnagram(String s, String t) {
            HashMap<Character, Integer> mapS = new HashMap<>();
            HashMap<Character, Integer> mapT = new HashMap<>();

            createMap(mapS, s);
            createMap(mapT, t);

            if (mapS.size() != mapT.size())
                return false;
            else if (compareMap(mapS, mapT) && compareMap(mapT, mapS))
                return true;
            else
                return false;
        }
    }

    public static final <T> void print(T t) {
        System.out.println(t);
    }

    public static void main(String[] args) {
        Solution solution = new LC_242().new Solution();
        print(solution.isAnagram("anagram", "nagaram"));
        print(solution.isAnagram("rat", "car"));
    }
}
