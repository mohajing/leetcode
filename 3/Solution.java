import java.util.HashMap;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> charMap = new HashMap<>();
        int longestLength = 0;
        int currentLength = 0;
        int startIndex = 0;

        for (int i = 0; i < s.length(); i++) {
            Character charString = s.charAt(i);
            Integer previousIndex = charMap.get(charString);
            if (previousIndex != null && startIndex <= previousIndex) {
                if (longestLength < currentLength) longestLength = currentLength;

                currentLength -= previousIndex - startIndex;
                startIndex = previousIndex + 1;
                charMap.put(charString, i);
                continue;
            }

            charMap.put(charString, i);
            currentLength++;
        }

        if (longestLength < currentLength) longestLength = currentLength;

        return longestLength;
    }
    // a b c d e f c p o i
}

public class Solution2 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }
}
