import java.util.Arrays;

/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 *
 * https://leetcode.com/problems/3sum/description/
 *
 * algorithms
 * Medium (24.04%)
 * Likes:    3810
 * Dislikes: 427
 * Total Accepted:    556.4K
 * Total Submissions: 2.3M
 * Testcase Example:  '[-1,0,1,2,-1,-4]'
 *
 * Given an array nums of n integers, are there elements a, b, c in nums such
 * that a + b + c = 0? Find all unique triplets in the array which gives the
 * sum of zero.
 * 
 * Note:
 * 
 * The solution set must not contain duplicate triplets.
 * 
 * Example:
 * 
 * 
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * 
 * A solution set is:
 * [
 * ⁠ [-1, 0, 1],
 * ⁠ [-1, -1, 2]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int nlen = nums.length;
        for( int i = 0; i < nlen - 2; i++){
            if (nums[i] > 0) break;
            if( i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int l = i + 1, h = nlen - 1, num = 0 - nums[i];
            while(l < h){
                if(nums[l] + nums[h] == num){
                    result.add(Arrays.asList(nums[i],nums[l],nums[h]));
                    while(l < h && nums[l] == nums[l+1])
                        l++;
                    while(l < h && nums[h] == nums[h-1])
                        h--;
                    l++;
                    h--;
                }else if(nums[l] + nums[h] < num)
                    l++;
                else
                    h--;
            }
            
        }
        return result;
    }
}

