import java.util.*;

class Solution {
    static HashMap<Character, Integer> map;
    static {
        map = new HashMap<>();
        map.put('(', 1);
        map.put('{', 2);
        map.put('[', 3);
        map.put(')', -1);
        map.put('}', -2);
        map.put(']', -3);
    }
    
    public boolean isValid(String s) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            int val = map.get(s.charAt(i));
            if (val > 0) {
                stack.push(val);
            } else {
                if (stack.empty() || stack.pop() + val != 0) return false;
            }
        }

        if (!stack.empty()) return false;

        return true;
    }
}