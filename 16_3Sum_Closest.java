import java.util.*;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int answer = Integer.MAX_VALUE;
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            int need = target - nums[i];

            while (left < right) {
                int diff = need - (nums[left] + nums[right]);
                if (diff == 0) {
                    return target;
                } else if (diff > 0) {
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    left++;
                } else {
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    right--;
                }

                if (Math.abs(diff) < minDiff) {
                    minDiff = Math.abs(diff);
                    answer = target - diff;
                }
            }
        }

        return answer;
    }
}