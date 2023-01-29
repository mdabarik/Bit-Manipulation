/*
2# Single Number ii
Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.
You must implement a solution with a linear runtime complexity and use only constant extra space.

Example 1:
Input: nums = [2,2,3,2]
Output: 3

Example 2:
Input: nums = [0,1,0,1,0,1,99]
Output: 99
*/
  
class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i <= 31; i++) {
            int count = 0;
            int mask = 1 << i;
            for (int num : nums) {
                if ((num & mask) != 0) {
                    count++;
                }
            }
            if (count % 3 == 1) {
                res = res | mask;
            }
        }
        return res;
    }
}
