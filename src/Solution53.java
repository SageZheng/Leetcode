import java.util.Map;

public class Solution53 {


    public int maxSubArray(int[] nums) {
        return maxArray(nums, 0, nums.length - 1);
    }
    public int maxArray(int[] nums, int l, int r){
        if(l==r)
            return nums[l];
        int mid=(l+r)/2;
        int left=maxArray(nums,l,mid);
        int right=maxArray(nums,mid+1,r);
        int leftCrossMax=0;
        int leftSum=0;
        for(int i=mid-1;i>=l;i--){
            leftSum=leftSum+nums[i];
            if(leftCrossMax<leftSum)
                leftCrossMax=leftSum;
        }
        int rightCrossMax=0;
        int rightSum=0;
        for(int i = mid+1; i<=r;i++){
            rightSum=rightSum+nums[i];
            if(rightCrossMax<rightSum)
                rightCrossMax=rightSum;
        }
        int middleMax=leftCrossMax+rightCrossMax+nums[mid];
        return Math.max(middleMax,Math.max(left,right));
    }
    public static void main(String[] argsS){
        int[] nums={5,4,-1,7,8};
        Solution53 s = new Solution53();
        System.out.println(s.maxSubArray(nums));

    }
}
