import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> answer = new ArrayList<>();

        for (int i = 0; i < nums.length - 3; i++) {
            if (i == 0 || (nums[i] != nums[i - 1])) {
                for (int j = i + 1; j < nums.length - 2; j++) {
                    if (j == i + 1 || (nums[j] != nums[j - 1])) {
                        int left = j + 1;
                        int right = nums.length - 1;
                        int need = target - nums[i] - nums[j];
        
                        while (left < right) {
                            if (need == nums[left] + nums[right]) {
                                answer.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[left], nums[right])));

                                while (left < right && nums[left] == nums[left + 1]) {
                                    left++;
                                }

                                while (left < right && nums[right] == nums[right - 1]) {
                                    right--;
                                }

                                left++;
                                right--;
                            } else if (need < nums[left] + nums[right]) {
                                right--;
                            } else {
                                left++;
                            }
                        }
                    }
                }
            }
        }
        return answer;
    }
}