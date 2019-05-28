/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 *
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 *
 * algorithms
 * Hard (26.35%)
 * Likes:    4305
 * Dislikes: 574
 * Total Accepted:    436.3K
 * Total Submissions: 1.7M
 * Testcase Example:  '[1,3]\n[2]'
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * 
 * Find the median of the two sorted arrays. The overall run time complexity
 * should be O(log (m+n)).
 * 
 * You may assume nums1 and nums2 cannot be both empty.
 * 
 * Example 1:
 * 
 * 
 * nums1 = [1, 3]
 * nums2 = [2]
 * 
 * The median is 2.0
 * 
 * 
 * Example 2:
 * 
 * 
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 
 * The median is (2 + 3)/2 = 2.5
 * 
 * 
 */

class Solution {
    
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length < nums2.length) {
            return circle(nums1, nums2, 0, nums1.length);
        } else {
            return circle(nums2, nums1, 0, nums2.length);
        }
    }

    public double circle(int[] nums1, int[] nums2, int imin, int imax) {
        if (imin > imax){
            return 0.0;
        }
        int len1 = nums1.length, len2 = nums2.length;//1,2
        int i = (imin + imax) / 2;//1
        int j = (len1 + len2 + 1) / 2 - i;//1
        if ((i <= imin || (nums1[i - 1] <= nums2[j])) && (i >= imax || (nums2[j - 1] <= nums1[i]))) {
            int left_max = 0, right_min = 0;
            if (i == 0)
                left_max = nums2[j - 1];
            else if (j == 0)
                left_max = nums1[i - 1];
            else
                left_max = Math.max(nums1[i - 1], nums2[j - 1]);
            if ((len1 + len2) % 2 == 1) {
                return (double)left_max;
            } else {
                if (i == len1)
                    right_min = nums2[j];
                else if (j == len2)
                    right_min = nums1[i];
                else
                    right_min = Math.min(nums1[i], nums2[j]);
                return (left_max + right_min)/2.0;

            }
        } else if (i > imin && nums1[i - 1] > nums2[j]) {// i would be decrease
            return circle(nums1, nums2, imin, i - 1);
        } else {
            return circle(nums1, nums2, i + 1, imax);
        }
    }

}
