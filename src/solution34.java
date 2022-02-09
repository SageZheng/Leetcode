public class solution34 {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        if(len<=0)
            return new int[]{-1,-1};
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
        if(nums[left]!=target)
            return new int[]{-1,-1};
        for(int i=left;i<nums.length;i++){
            if(nums[left]!=nums[i])
                break;
            right=i;
        }
        return new int[]{left,right};
    }
    public static void main(String args[]){
        int[] nums={5,7,7,8,8,10};
        int target=91;
        solution34 s = new solution34();
        int[] res=s.searchRange(nums,target);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
}
