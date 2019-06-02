/*
 * @lc app=leetcode id=6 lang=java
 *
 * [6] ZigZag Conversion
 *
 * https://leetcode.com/problems/zigzag-conversion/description/
 *
 * algorithms
 * Medium (31.83%)
 * Likes:    1033
 * Dislikes: 3221
 * Total Accepted:    320.2K
 * Total Submissions: 1M
 * Testcase Example:  '"PAYPALISHIRING"\n3'
 *
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number
 * of rows like this: (you may want to display this pattern in a fixed font for
 * better legibility)
 * 
 * 
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 
 * 
 * And then read line by line: "PAHNAPLSIIGYIR"
 * 
 * Write the code that will take a string and make this conversion given a
 * number of rows:
 * 
 * 
 * string convert(string s, int numRows);
 * 
 * Example 1:
 * 
 * 
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * 
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * 
 */
class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        int slen = s.length();
        List<StringBuilder> rows = new ArrayList<>();
        for(int i = 0; i < Math.min(slen,numRows); i ++){
            rows.add(new StringBuilder());
        }
        int correntRows = 0;
        boolean sign = false;
        
        for(char i:s.toCharArray()){
            rows.get(correntRows).append(i);
            
            if(correntRows == 0 || correntRows == numRows - 1)
                sign = !sign;
            correntRows +=  (sign?1:-1);
        }
        StringBuilder result = new StringBuilder();
        for(StringBuilder i: rows){
            result.append(i);
        }
        return result.toString();
    }
}

