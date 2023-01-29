/*
Given an integer array nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once. You can return the answer in any order.

You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.

Example 1:
Input: nums = [1,2,1,3,2,5]
Output: [3,5]
Explanation:  [5, 3] is also a valid answer.

Example 2:
Input: nums = [-1,0]
Output: [-1,0]

Example 3:
Input: nums = [0,1]
Output: [1,0]
*/


class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        int bit = 1;
        for (int i = 0; i < 32; i++) {
            int set_bit = 1 << i;
            if ((xor & set_bit) != 0) {
                bit = set_bit;
                break;
            }
        }
        int bucket1 = 0;
        int bucket2 = 0;
        for (int num : nums) {
            if ((num & bit) != 0) {
                bucket1 ^= num;
            } else {
                bucket2 ^= num;
            }
        }
        int[] arr = new int[] {bucket1, bucket2};
        return arr;
    }
}
