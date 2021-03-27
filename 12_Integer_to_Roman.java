import javax.crypto.spec.IvParameterSpec;

class Solution {
    public String intToRoman(int num) {
        String symbols[] = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int values[] = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        int index = 0;
        String answer = "";
        while (num > 0) {
            while (num / values[index] == 0) {
                index++;
            }

            answer += symbols[index];
            num -= values[index];
            index = 0;
        }

        return answer;
    }
}