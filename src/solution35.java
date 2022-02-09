public class solution35 {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if (nums[len - 1] < target) {
            return len;
        }
        int left=0;
        int right = nums.length-1;
        while(left<right){
            int middle = left+(right-left)/2;
            if (nums[middle]<target){
                left=middle+1;
            }
            else {
                right=middle;
            }
        }
        return left;
    }
}
