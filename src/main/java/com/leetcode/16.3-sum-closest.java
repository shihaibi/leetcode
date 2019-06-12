import javax.lang.model.util.ElementScanner6;

/*
 * @lc app=leetcode id=16 lang=java
 *
 * [16] 3Sum Closest
 *
 * https://leetcode.com/problems/3sum-closest/description/
 *
 * algorithms
 * Medium (45.77%)
 * Likes:    1120
 * Dislikes: 82
 * Total Accepted:    351K
 * Total Submissions: 766.8K
 * Testcase Example:  '[-1,2,1,-4]\n1'
 *
 * Given an array nums of n integers and an integer target, find three integers
 * in nums such that the sum is closest to target. Return the sum of the three
 * integers. You may assume that each input would have exactly one solution.
 * 
 * Example:
 * 
 * 
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 * 
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 * 
 */
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = 1000000;
        int nlen = nums.length;
        for(int i = 0; i < nlen - 2; i++){
            if(i == 0 || (i > 0 && nums[i] > nums[i - 1])){
                int l = i + 1, r = nlen - 1;
                
                while(l < r){
                    int sum = nums[i] + nums[l] + nums[r];
                    if(sum > target)
                        r--;
                    else if(sum < target)
                        l++;
                    else 
                        return target;
                    if( Math.abs(result - target) > Math.abs(sum - target))
                        result = sum;
                        
                }


                
            }
        }
        return result; 
        
    }
}

