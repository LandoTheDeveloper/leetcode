/*
Given an array of positive integers nums, return the maximum possible sum of an ascending subarray in nums.

A subarray is defined as a contiguous sequence of numbers in an array.

A subarray [numsl, nums[l+1], ..., nums[r-1], nums[r] is ascending if for all i where l <= i < r, nums[i]  < nums[i+1]. Note that a subarray of size 1 is ascending.
*/

class Solution {
    public int maxAscendingSum(int[] nums) {
        int curMax = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++){
            // Return arrays length of 1
            if (nums.length == 1) {
                return nums[0];
            }

            // At end of array, check if ascending, change max
            if (i == nums.length - 1) {
                if (nums[i - 1] < nums[i]) {
                    curMax += nums[i];
                }
                if (max < curMax) {
                    max = curMax;
                }
            }
            
            // If not first index, and not ascending, change max
            if ((i != 0) && nums[i] <= nums[i-1]) {
                if (max < curMax) {
                    max = curMax;
                }
                curMax = 0;

            }

            // Add index to curMax
            curMax += nums[i];

        }

        // Res
        return max;
    }
}
