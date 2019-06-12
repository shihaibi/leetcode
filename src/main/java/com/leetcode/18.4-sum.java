
/*
 * @lc app=leetcode id=18 lang=java
 *
 * [18] 4Sum
 *
 * https://leetcode.com/problems/4sum/description/
 *
 * algorithms
 * Medium (30.57%)
 * Likes:    1078
 * Dislikes: 217
 * Total Accepted:    236.9K
 * Total Submissions: 773.4K
 * Testcase Example:  '[1,0,-1,0,-2,2]\n0'
 *
 * Given an array nums of n integers and an integer target, are there elements
 * a, b, c, and d in nums such that a + b + c + d = target? Find all unique
 * quadruplets in the array which gives the sum of target.
 * 
 * Note:
 * 
 * The solution set must not contain duplicate quadruplets.
 * 
 * Example:
 * 
 * 
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 * 
 * A solution set is:
 * [
 * ⁠ [-1,  0, 0, 1],
 * ⁠ [-2, -1, 1, 2],
 * ⁠ [-2,  0, 0, 2]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return knum(nums, target, 4, 0);
    }
    public ArrayList<List<Integer>> knum(int[] nums, int target, int k, int index){
        ArrayList<List<Integer>> res = new ArrayList<>();
        int nlen = nums.length;
        if(nums == null || nums.length < k - index || index >= nlen){
            return res;
        }
        if(k > 2){
            for(int i = index; i < nlen - (k - 1); i++){
                if(i > index && nums[i] == nums[i - 1] )
                    continue;
                ArrayList<List<Integer>> temp = knum(nums, target-nums[i], k - 1, i + 1);
                for(List<Integer> j : temp){
                    j.add(0, nums[i]);
                }
                res.addAll(temp);
                
            }
            return res;
        }else {
            int i = index, j = nlen - 1;
            while(i < j){
                if(nums[i] + nums[j] == target){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    res.add(temp);
                    while(i < j && nums[i] == nums[i+1])
                        i++;
                    while(i < j && nums[j] == nums[j-1])
                        j--;
                    i++; j--;
                }else if(nums[i] + nums[j] < target){
                    i++;
                }else{
                    j--;
                }
                    
            }
            return res;
        }
        
    }
}

