class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        int length = (int) (Math.log10(x) + 1);
        int halfSize = length / 2;

        int firstHalf = 0;
        int secondHalf = 0;

        int divider = (int) Math.pow(10, length - 1);
        for (int i = 0; i < halfSize; i++) {
            firstHalf += firstHalf * 10 + x / divider;
            x %= divider;
            divider /= 10;
        }

        for (int i = 0; i < halfSize; i++) {
            secondHalf += secondHalf * 10 + x % 10;
            x /= 10;
        }

        if (firstHalf == secondHalf) return true;

        return false;
    }
}