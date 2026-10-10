class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        long operations = (long) k1 + k2;
        int maxDiff = 0;
        long totalDiff = 0;

        int[] diff = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            maxDiff = Math.max(maxDiff, diff[i]);
            totalDiff += diff[i];
        }

        if (operations >= totalDiff) {
            return 0;
        }

        int[] freq = new int[maxDiff + 1];

        for (int d : diff) {
            freq[d]++;
        }

        for (int d = maxDiff; d > 0 && operations > 0; d--) {
            int count = freq[d];
            if (count == 0) continue;

            long reduce = Math.min(operations, (long) count);

            freq[d] -= (int) reduce;
            freq[d - 1] += (int) reduce;
            operations -= reduce;
        }

        long answer = 0;

        for (int d = 1; d <= maxDiff; d++) {
            answer += (long) d * d * freq[d];
        }

        return answer;
    }
}