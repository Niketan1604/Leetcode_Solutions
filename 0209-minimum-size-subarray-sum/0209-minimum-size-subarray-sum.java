class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length, curSum = 0, l = 0;
        int minSize = n + 1;

        for(int r = 0; r < n; r++){
            curSum += nums[r];
            while(l < r && (curSum - nums[l]) >= target){
                curSum -= nums[l];
                l++;
            }

            if(curSum >= target)
                minSize = Math.min(minSize, r - l + 1);
        }

        return minSize == n + 1 ? 0 : minSize;
    }
}