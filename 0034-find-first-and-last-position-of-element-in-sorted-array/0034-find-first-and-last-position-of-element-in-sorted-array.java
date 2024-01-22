class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int res[] = new int[2];
        res[0] = -1;
        res[1] = -1;
        while(right >= left){
            int mid = left + (right-left)/2;
            if(nums[mid] == target){
                res[0] = res[1] = mid;
                int dup_mid = mid;
                while(mid >= 0 && nums[mid] == target){
                    res[0] = mid--;
                }
                mid = dup_mid;
                while(mid <= nums.length-1 && nums[mid] == target){
                    res[1] = mid++;
                }
                break;
            }
            else if(nums[mid] > target) right = mid-1;
            else left = mid+1;
        }
        return res;
    }
}