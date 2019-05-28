/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
 *
 * https://leetcode.com/problems/add-two-numbers/description/
 *
 * algorithms
 * Medium (31.12%)
 * Likes:    5178
 * Dislikes: 1327
 * Total Accepted:    875.7K
 * Total Submissions: 2.8M
 * Testcase Example:  '[2,4,3]\n[5,6,4]'
 *
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * Example:
 * 
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * 
 * 
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result,p = new ListNode(0);
        result = p;
        int number = 0;
        while(l1 != null || l2 != null || number != 0){
            if(l1 != null){
                number += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                number += l2.val;
                l2 = l2.next;
            }
            p.next = new ListNode(number%10);
            p = p.next;
            number = number/10;

        }
        return result.next;
    }
}

