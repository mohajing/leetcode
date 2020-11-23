class Solution {
    // 일정한 규칙으로 string 이 만들어지기 때문에, 이 규칙을 코드로 구현
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        StringBuilder result = new StringBuilder();

        int stringLength = s.length();
        int mainDiff = numRows * 2 - 2;
        int flag = 1;
        int index = 0;

        for (int row = 0; row < numRows; row++) {
            index = row;
            flag = 1;
            while (index < stringLength) {
                result.append(s.charAt(index));
                index += mainDiff + getDiff(flag, row, numRows);
                flag *= -1;
            }
        }

        return result.toString();
    }

    public int getDiff(int flag, int row, int numRows) {
        if (row == 0 || numRows - 1 == row) return 0;

        return flag == 1 ? -1 * row * 2 : (numRows - row) * 2 * -1 + 2;
    }
}