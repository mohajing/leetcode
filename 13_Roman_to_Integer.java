import java.util.HashMap;

class Solution {
    // 앞에서부터 찾기.
    // 2개의 char 로 이뤄진 수가 있어서, 2개 char 찾고 1개 찾아야함.
    public int romanToInt(String s) {
        HashMap<String, Integer> symbolMap = new HashMap<>();
        symbolMap.put("M", 1000);
        symbolMap.put("CM", 900);
        symbolMap.put("D", 500);
        symbolMap.put("CD", 400);
        symbolMap.put("C", 100);
        symbolMap.put("XC", 90);
        symbolMap.put("L", 50);
        symbolMap.put("XL", 40);
        symbolMap.put("X", 10);
        symbolMap.put("IX", 9);
        symbolMap.put("V", 5);
        symbolMap.put("IV", 4);
        symbolMap.put("I", 1);

        int index = 0;
        int length = s.length();
        int answer = 0;

        while (index < length) {
            Integer subAnswer = null;
            if (index + 2 <= length) {
                subAnswer = symbolMap.get(s.substring(index, index + 2));
            }

            if (subAnswer == null) {
                subAnswer = symbolMap.get(s.substring(index, index + 1));
                index++;
            } else {
                index += 2;
            }

            answer += subAnswer;
        }
        return answer;
    }

    // 뒤에서부터 찾기.
    // 뒤에서부터 char 1개씩 값을 가져와서, 이전 값보다 크면 -, 아니면 + 하는 전략.
    public int romanToInt(String s) {
        HashMap<Character, Integer> symbolMap = new HashMap<>();
        symbolMap.put('M', 1000);
        symbolMap.put('D', 500);
        symbolMap.put('C', 100);
        symbolMap.put('L', 50);
        symbolMap.put('X', 10);
        symbolMap.put('V', 5);
        symbolMap.put('I', 1);

        int length = s.length();
        int index = length - 1;
        int answer = 0;
        int prevNum = 0;

        while (index >= 0) {
            int num = symbolMap.get(s.charAt(index--));
            if (num < prevNum) {
                answer -= num;
            } else {
                answer += num;
            }
            prevNum = num;
        }
        return answer;
    }
}