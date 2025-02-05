'''
Given an array of positive integers nums, return the maximum possible sum of an ascending subarray in nums.

A subarray is defined as a contiguous sequence of numbers in an array.

A subarray [numsl, numsl+1, ..., numsr-1, numsr] is ascending if for all i where l <= i < r, numsi  < numsi+1. Note that a subarray of size 1 is ascending.
'''


class Solution:
    def maxAscendingSum(self, nums: List[int]) -> int:

        totalMax = 0
        curMax = 0

        # len = 1
        if len(nums) == 1:
            return nums[0]

        for i, num in enumerate(nums):
            # If at end of array, check if ascending, change max
            if (i == len(nums) - 1):
                if (nums[i - 1] < num):
                    curMax = num + curMax

                if totalMax < curMax:
                    totalMax = curMax

            # If not first index, and not ascending, change max
            if (num <= nums[i - 1]):
                if (totalMax < curMax):
                    totalMax = curMax
                curMax = 0

            curMax += num
        return totalMax
        
