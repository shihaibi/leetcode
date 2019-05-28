
// you use a map to track the right operand 
// in order for the sum to meet its target
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        HashMap<Integer, Integer> tracker = new HashMap<Integer, Integer>();
        for (int i = 0; i < len; i++){
            if(tracker.containsKey(nums[i])){
                int left = tracker.get(nums[i]);
                int []a = new int[]{left ,i };
                return a;
            }else{
                tracker.put(target - nums[i],i);
            }
        }
        return new int[2];

    }
}

