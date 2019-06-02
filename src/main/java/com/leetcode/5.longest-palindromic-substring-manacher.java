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
        
        int slen = s.length();
        if ( s == null|| slen == 0 ||slen == 1){
            return s;
        }
        StringBuffer sb = new StringBuffer();
        sb.append("@");
        for(int i = 0; i < slen; i++){
            sb.append("#");
            sb.append(s.charAt(i));
        }
        sb.append("#");
        sb.append("!");
        int sblen = sb.length();
        int[] len = new int[sblen];
        len[0] = 1;
        int max = 0;
        int mark = 0;
        int ans = 0, longest = 0;
        for( int i = 1; i < sblen - 2; i ++ ){
            if ( i <= max){
                len[i] = Math.min(len[2*mark - i], max - i);
            }else len[i] = 1;
            while(sb.charAt(i +len[i])==sb.charAt(i - len[i]))
                len[i]++;
            if(len[i] +i - 1> max){
                max = len[i] + i - 1;
                mark = i;
            }
            if( len[i] - 1 > longest ){
                ans = i/2 - 1;
                longest = len[i] -1;
            }

        }
        if (longest %2 ==0){
            return s.substring(ans - longest/2 + 1, ans+ longest/2 + 1);
        }else
            return s.substring(ans - longest/2, ans+ longest/2 + 1);
    }
}

