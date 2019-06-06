/*
 * @lc app=leetcode id=14 lang=java
 *
 * [14] Longest Common Prefix
 *
 * https://leetcode.com/problems/longest-common-prefix/description/
 *
 * algorithms
 * Easy (33.55%)
 * Likes:    1372
 * Dislikes: 1318
 * Total Accepted:    471K
 * Total Submissions: 1.4M
 * Testcase Example:  '["flower","flow","flight"]'
 *
 * Write a function to find the longest common prefix string amongst an array
 * of strings.
 * 
 * If there is no common prefix, return an empty string "".
 * 
 * Example 1:
 * 
 * 
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * 
 * 
 * Note:
 * 
 * All given inputs are in lowercase letters a-z.
 * 
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        int maxLen = Integer.MAX_VALUE;
        for(String str: strs){
            maxLen = Math.min(maxLen, str.length());
        }
        int l = 0, h = maxLen - 1;
        while(l <= h){
            int middle = (l + h)/2;
            if(isright(strs, middle))
                l = middle + 1;
            else
                h = middle - 1;
        }
        return strs[0].substring(0, h + 1);
    }
    public boolean isright(String[] strs, int middle){
        String sub = strs[0].substring(0,middle + 1);
        for(String str: strs){
            if(str.indexOf(sub) != 0)
                return false;
        }
        return true;
    }
}

