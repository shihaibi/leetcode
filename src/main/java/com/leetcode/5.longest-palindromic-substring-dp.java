/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 *
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 *
 * algorithms
 * Medium (27.28%)
 * Likes:    3614
 * Dislikes: 351
 * Total Accepted:    560K
 * Total Submissions: 2.1M
 * Testcase Example:  '"babad"'
 *
 * Given a string s, find the longest palindromic substring in s. You may
 * assume that the maximum length of s is 1000.
 * 
 * Example 1:
 * 
 * 
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "cbbd"
 * Output: "bb"
 * 
 * 
 */
class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();//5
        String str = null;
        if (s == null|| len == 0 || len == 1)
            return s;
        Boolean[][] dp = new Boolean[len][len];
        for (int i = len - 2; i >= 0; i--){
            for (int j = i; j < len; j++){
                dp[i][j] = (s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i+1][j-1]));
                
                if(dp[i][j] && (str == null ||str.length() <= j - i + 1)){
                    str = s.substring(i,j+1);
                }
            }
        }
        return str; 
    }
}

