class Solution {
    public int longestSubsequence(int[] nums) {
        int xor = 0;

        for (int x : nums) {
            xor ^= x;
        }

        // Whole array has non-zero XOR.
        if (xor != 0) {
            return nums.length;
        }

        // Remove one non-zero element.
        if (nums.length > 0) {
            for (int x : nums) {
                if (x != 0) {
                    return nums.length - 1;
                }
            }
        }

        // All elements are zero.
        return 0;
    }
}
