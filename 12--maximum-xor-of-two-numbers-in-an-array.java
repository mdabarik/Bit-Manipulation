/* 13# Maximum XOR of Two Numbers in an array
Given an integer array nums, return the maximum result of nums[i] XOR nums[j], where 0 <= i <= j < n.

Example 1:
Input: nums = [3,10,5,25,2,8]
Output: 28
Explanation: The maximum result is 5 XOR 25 = 28.

Example 2:
Input: nums = [14,70,53,83,49,91,36,80,92,51,66,70]
Output: 127 */

class Solution {
    class Trie {
        Trie[] children;
        public Trie() {
            children = new Trie[2];
        }
    }
    public int findMaximumXOR(int[] nums) {
        Trie root = new Trie();
        for(int num: nums) {
            Trie curNode = root;
            for(int i = 31; i >= 0; i--) {
                int curBit = (num >> i) & 1;
                if(curNode.children[curBit] == null) {
                    curNode.children[curBit] = new Trie();
                }
                curNode = curNode.children[curBit];
            }
        }
        int max = Integer.MIN_VALUE;
        for(int num: nums) {
            Trie curNode = root;
            int curSum = 0;
            for(int i = 31; i >= 0; i--) {
                int curBit = (num >> i) & 1;
                if (curNode.children[curBit ^ 1] != null) {
                    curSum += (1 << i);
                    curNode = curNode.children[curBit ^ 1];
                } else {
                    curNode = curNode.children[curBit];
                }
            }
            max = Math.max(curSum, max);
        }
        return max;
    }
}

/*
[3,10,5,25,2,8]

    16    8    4    2    1
3:                  1    1
10:       1         1
9:        1              1
5:             1         1
12:       1    1
25: 1     1              1
21: 1          1         1
2:                  1    
23: 1          1    1    1
8:        1              

3:   0, 0, 0, 1, 1
10:  0, 1, 0, 1, 0
5:   0, 0, 1, 0, 1
25:  1, 1, 0, 0, 1
2:   0, 0, 0, 1, 0
8:   0, 1, 0, 0, 0
*/
