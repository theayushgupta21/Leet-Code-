import java.util.Arrays;

class Solution {

    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);

        int n = nums.length;

        int closestSum = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < n - 2; i++) {

            int left = i + 1;
            int right = n - 1;

            while (left < right) {

                int presentSum = nums[i] + nums[left] + nums[right];

                if (presentSum == target) {
                    return presentSum;
                }

                if (Math.abs(presentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = presentSum;
                }

                if (presentSum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return closestSum;
    }
}