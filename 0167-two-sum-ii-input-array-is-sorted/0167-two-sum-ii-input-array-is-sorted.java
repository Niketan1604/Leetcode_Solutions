class Solution {
    public int[] twoSum(int[] nums, int target) {
        int result[] = new int[2]; // resultant array
        int left = 0;
        int right = nums.length -1;
        while(right >= left){
            if(nums[left]+nums[right] == target){
                result[0] = left + 1;
                result[1] = right + 1;
                break;
            }
            else if(nums[left]+nums[right] > target) right--;
            else left++;
        }
        return result;
    }
}