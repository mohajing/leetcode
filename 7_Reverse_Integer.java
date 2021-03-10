class Solution {
    public int reverse(int x) {
        if (x == 0) return 0;

        int originX = x;
        int length = (int) (Math.log10(Math.abs(x)) + 1);
        int divider = (int) Math.pow(10, length - 1);

        int result = 0;
        for (int i = 0; i < length; i++) {
            int quotient = x / divider;
            int value = quotient * (int) Math.pow(10, i);

            if (i == 9) {
                if (quotient > 2 || quotient < -2) {
                    return 0;
                }

                if (isPositive(originX)) {
                    if (Integer.MAX_VALUE - result < value) {
                        return 0;
                    }
                } else {
                    if (Integer.MIN_VALUE - result > value) {
                        return 0;
                    }
                }
            }
            result += value;
            x %= divider;
            divider /= 10;
        }

        return result;
    }

    public boolean isPositive(int x) {
        return x > 0;
    }
}