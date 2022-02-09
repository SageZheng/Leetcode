import java.util.Arrays;

public class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        int gap= Integer.MAX_VALUE;
        int res= Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            int left=i+1;
            int right=nums.length-1;
            while(left<right){
                int sum=nums[i]+nums[left]+nums[right];
                int temp=Math.abs(sum-target);
                if(temp==0)
                    return target;
                if(temp<gap){
                    gap=temp;
                    res=sum;
                }
                if(sum>target){
                    right--;
                }
                else
                    left++;
            }
        }
        return res;
    }
}
