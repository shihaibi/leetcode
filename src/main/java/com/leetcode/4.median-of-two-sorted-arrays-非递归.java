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
        if(nums1.length > nums2.length){
            int[] a = nums1;
            nums1 = nums2;
            nums2 = a;
        }
        int len1 = nums1.length, len2 = nums2.length;
        int half = (len1 + len2 + 1)/2;
        int imin = 0, imax = len1;
        while(imin <= imax){
            int i = (imax + imin)/2;
            int j = half - i;
            if(i > imin && nums1[i - 1] > nums2[j]){
                imax = i - 1;
            }else if(i < imax && nums2[j - 1] > nums1[i]){
                imin = i + 1;
            }else{
                int max_left, min_right;
                if (i == 0){
                    max_left = nums2[j - 1];
                }else if (j == 0){
                    max_left = nums1[i - 1];
                }else{
                    max_left = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                if ((len1 + len2)%2 == 1){
                    return max_left;
                }else {
                    if (i == len1){
                        min_right = nums2[j];
                    }else if(j == len2){
                        min_right = nums1[i];
                    }else{
                        min_right = Math.min(nums1[i], nums2[j]);
                    }
                    return (max_left + min_right)/2.0;
                }
            }
        }
        return 0.0;
    }
}

