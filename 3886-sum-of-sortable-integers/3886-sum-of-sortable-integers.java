class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for (int k = 1; k <= n; k++) {
            if (n % k == 0 && isSortable(nums, k)) {
                sum += k;
            }
        }

        return sum;
    }

    private boolean isSortable(int[] nums, int k) {
        int n = nums.length;
        int prevMax = Integer.MIN_VALUE;

        for (int start = 0; start < n; start += k) {
            int descents = 0;
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

            for (int i = 0; i < k; i++) {
                int cur = nums[start + i];
                int next = nums[start + (i + 1) % k]; // cyclic neighbor
                if (cur > next) descents++;
                min = Math.min(min, cur);
                max = Math.max(max, cur);
            }

            // a block is a rotation of a sorted array iff it has at most one cyclic descent
            if (descents > 1) return false;

            // after sorting this block, it must not start below the previous block's end
            if (min < prevMax) return false;
            prevMax = max;
        }

        return true;
    }
}