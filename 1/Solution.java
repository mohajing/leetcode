import java.util.HashMap;

class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();

    public int[] twoSum(int[] nums, int target) {

        int length = nums.length;
        for (int i = 0; i < length; ++i) {
            map.put(nums[i], i);
        }

        int[] answer = new int[2];

        for (int i = 0; i < length; ++i) {
            int matchedNum = target - nums[i];

            if (map.containsKey(matchedNum) && map.get(matchedNum) != i) {
                answer[0] = i;
                answer[1] = map.get(matchedNum);
                break;
            }
        }
        return answer;
    }
}