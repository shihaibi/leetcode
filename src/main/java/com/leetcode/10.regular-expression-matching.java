/*
 * @lc app=leetcode id=10 lang=java
 *
 * [10] Regular Expression Matching
 *
 * https://leetcode.com/problems/regular-expression-matching/description/
 *
 * algorithms
 * Hard (25.30%)
 * Likes:    2631
 * Dislikes: 513
 * Total Accepted:    306.6K
 * Total Submissions: 1.2M
 * Testcase Example:  '"aa"\n"a"'
 *
 * Given an input string (s) and a pattern (p), implement regular expression
 * matching with support for '.' and '*'.
 * 
 * 
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * 
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * Note:
 * 
 * 
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters
 * like . or *.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * s = "aa"
 * p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the precedeng element, 'a'.
 * Therefore, by repeating 'a' once, it becomes "aa".
 * 
 * 
 * Example 3:
 * 
 * 
 * Input:
 * s = "ab"
 * p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 * 
 * 
 * Example 4:
 * 
 * 
 * Input:
 * s = "aab"
 * p = "c*a*b"
 * Output: true
 * Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore
 * it matches "aab".
 * 
 * 
 * Example 5:
 * 
 * 
 * Input:
 * s = "mississippi"
 * p = "mis*is*p*."
 * Output: false
 * 
 * 
 */
class Solution {
    public boolean isMatch(String s, String p) {
        int slen = s.length(), plen = p.length();
        boolean[][] dp = new boolean[slen + 1][plen + 1];
        dp[0][0] = true;
        for( int i = 1; i <= plen; i++){
            if(p.charAt(i - 1)=='*'){
                dp[0][i] = dp[0][i-1]||(i > 1&&dp[0][i-2]);
            }
        }
        for (int i = 1; i <= slen; i++){
            for( int j = 1; j <= plen; j++){
                if(p.charAt(j - 1) == s.charAt(i - 1)||p.charAt(j - 1) == '.'){
                    dp[i][j] = dp[i - 1][j - 1];
                }
                if( p.charAt(j - 1) == '*'){
                    if(p.charAt(j - 2) != s.charAt(i - 1) && p.charAt(j - 2) != '.'){
                        dp[i][j] = dp[i][j - 2];
                    }else{
                        dp[i][j] = dp[i][j - 2]||dp[i][j - 1]||dp[i - 1][j];
                    }
                }
            }
        }
        return dp[slen][plen];
        }
}

