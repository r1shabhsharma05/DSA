class Solution {
    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;
        long mod1 = 1000000007L;
        long mod2 = 1000000009L;
        long base = 91138233L;
        long[] pow1 = new long[n + 1];
        long[] pow2 = new long[n + 1];
        long[] pref1 = new long[n + 1];
        long[] pref2 = new long[n + 1];
        pow1[0] = 1;
        pow2[0] = 1;
        for (int i = 0; i < n; i++) {
            pow1[i + 1] = pow1[i] * base % mod1;
            pow2[i + 1] = pow2[i] * base % mod2;
            pref1[i + 1] = (pref1[i] * base + nums[i] + 1007) % mod1;
            pref2[i + 1] = (pref2[i] * base + nums[i] + 1007) % mod2;
        }
        int lo = 1, hi = n, ans = n;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (hasUnique(nums, mid, pow1, pref1, mod1, pow2, pref2, mod2)) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }

    private boolean hasUnique(int[] nums, int len, long[] pow1, long[] pref1, long mod1, long[] pow2, long[] pref2,
            long mod2) {
        java.util.HashMap<Long, Integer> freq = new java.util.HashMap<>();
        int n = nums.length;
        for (int i = 0; i + len <= n; i++) {
            long h1 = (pref1[i + len] - pref1[i] * pow1[len] % mod1 + mod1) % mod1;
            long h2 = (pref2[i + len] - pref2[i] * pow2[len] % mod2 + mod2) % mod2;
            long key = (h1 << 32) ^ h2;
            freq.put(key, freq.getOrDefault(key, 0) + 1);
        }
        for (int c : freq.values()) {
            if (c == 1)
                return true;
        }
        return false;
    }
}
