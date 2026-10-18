class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Place each value v in [1..n] at index v-1
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int target = nums[i] - 1;
                int tmp = nums[target];
                nums[target] = nums[i];
                nums[i] = tmp;
            }
        }

        // The first index whose value is wrong reveals the answer
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }
}