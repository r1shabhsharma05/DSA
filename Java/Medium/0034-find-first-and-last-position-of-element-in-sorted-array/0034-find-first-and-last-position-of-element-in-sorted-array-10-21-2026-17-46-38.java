class Solution {
    public int[] searchRange(int[] nums, int target) {
        int f = fb(nums, target, true);
        int l = fb(nums, target, false);

        return new int[]{f, l};
    }

    private int fb(int[] nums, int target, boolean first) {
        int f = 0;
        int l = nums.length - 1;
        int ans = -1;

        while (f <= l) {
            int m = f + (l - f) / 2;

            if (nums[m] == target) {
                ans = m;

                if (first) {
                    l = m - 1;
                } else {
                    f = m + 1;
                }
            } else if (nums[m] < target) {
                f = m + 1;
            } else {
                l = m - 1;
            }
        }

        return ans;
    }
}