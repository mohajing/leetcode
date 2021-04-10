class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length <= 0) return "";

        String answer = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String newString = strs[i];
            int newStringLength = newString.length();
            int answerLength = answer.length();
            int compareLength = answerLength > newStringLength ? newStringLength : answerLength;

            if (compareLength == 0) return "";

            for (int j = 0; j < compareLength; j++) {
                if (answer.charAt(j) != newString.charAt(j)) {
                    answer = answer.substring(0, j);
                    break;
                }

                if (j == compareLength - 1) {
                    answer = answerLength > newStringLength ? newString : answer;
                }
            }
        }

        return answer;
    }
}