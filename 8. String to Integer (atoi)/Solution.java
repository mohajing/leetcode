class Solution {
    public int myAtoi(String s) {
        int index = 0;
        int result = 0;

        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }

        if (index >= s.length()) {
            return 0;
        }

        int sign = 1;
        if (s.charAt(index) == '+' || s.charAt(index) == '-') {
            if (s.charAt(index++) == '-') {
                sign = -1;
            }
        }

        int resultLength = 0;
        boolean digitStart = false;
        while (index < s.length()) {
            if (s.charAt(index) < '0' || s.charAt(index) > '9') {
                return result * sign;
            }

            if (digitStart == false && s.charAt(index) == '0') {
                index++;
                continue;
            }

            digitStart = true;

            if (++resultLength > 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            if (resultLength == 10) {
                int lastDigit = sign == 1 ? Integer.MAX_VALUE % 10 : Math.abs(Integer.MIN_VALUE % 10);
                if (Integer.MAX_VALUE / 10 < result
                        || (Integer.MAX_VALUE / 10 == result && lastDigit < s.charAt(index) - '0')) {
                            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
            }

            result = result * 10 + (s.charAt(index++) - '0');

        }

        return result * sign;
    }
}