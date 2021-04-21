import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> answer = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (nums[i] != nums[i-1])) {
                int left = i + 1;
                int right = nums.length - 1;
                int need = 0 - nums[i];

                while (left < right) {
                    if (nums[left] + nums[right] == need) {
                        answer.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }

                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }

                        left++;
                        right--;
                    } else if (nums[left] + nums[right] > need) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }

        return answer;
    }
}