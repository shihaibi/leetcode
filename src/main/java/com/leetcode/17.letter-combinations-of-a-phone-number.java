import java.util.LinkedList;

/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 *
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 *
 * algorithms
 * Medium (41.65%)
 * Likes:    2213
 * Dislikes: 298
 * Total Accepted:    395.6K
 * Total Submissions: 947.9K
 * Testcase Example:  '"23"'
 *
 * Given a string containing digits from 2-9 inclusive, return all possible
 * letter combinations that the number could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below. Note that 1 does not map to any letters.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * 
 * Note:
 * 
 * Although the above answer is in lexicographical order, your answer could be
 * in any order you want.
 * 
 */
class Solution {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> queue = new LinkedList<>();
        if(digits.isEmpty())
            return queue;
        String[] reflect = new String[]{
            "0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
        };
        char[] digit = digits.toCharArray();
        int dlen = digits.length();
        queue.offer("");
        for( int i = 0; i < dlen; i++){
            char[] k = reflect[Character.getNumericValue(digit[i])].toCharArray();
            while(queue.peek().length() == i){
                String s = queue.poll();
                for(char j : k){
                    queue.offer(s + j);
                }
            }
        }
        return queue;
     }
}

