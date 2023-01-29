/* 11# Power Set
Given a string S, Find all the possible subsequences of the String in lexicographically-sorted order.

Example 1:
Input : str = "abc"
Output: a ab abc ac b bc c
Explanation : There are 7 subsequences that 
can be formed from abc.

Example 2:
Input: str = "aa"
Output: a a aa
Explanation : There are 3 subsequences that 
can be formed from aa. */

class Solution {
    public List<String> AllPossibleStrings(String s) {
        List<String> ans = new ArrayList<String>();
        int n = s.length();
        for(int i=1; i<(1<<n); i++){
            String ss = "";
            for(int bit=0; bit<n; bit++){
                if((i&(1<<bit)) != 0){
                    ss += s.charAt(bit);
                }
            }
            ans.add(ss);
        }
        Collections.sort(ans);
        return ans;
    }
}
