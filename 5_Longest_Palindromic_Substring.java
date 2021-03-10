class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandFromMiddle(s, i, i); // "aba" 처럼 가운데 char 을 중심으로 pelindrom 인 경우 length 구함.
            int len2 = expandFromMiddle(s, i, i + 1); // "abba" 처럼 좌우가 완전히 동일한 경우 length 구함.
            int len = Math.max(len1, len2);
            if (len > end - start) { // 기존 longest length 보다 클 경우 start, end index 변경
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }
    
    private int expandFromMiddle(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}