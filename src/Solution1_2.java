
import java.util.HashSet;
import java.util.Set;

public class Solution1_2 {
    public int[] twoSum(int[] nums, int target) {
        int[] result=new int[2];
        Set<Integer> sum = new HashSet<>();
        for (int i = 0; i <nums.length;i++){
            sum.add(nums[i]);
        }
        for (int i = 0; i <nums.length;i++){
            if(sum.contains(target-nums[i])&&nums[i]*2!=target){
                result[0]=i;
                for(int j=0;j<nums.length;j++){
                    if(nums[j]==target-nums[i]){
                        result[1]=j;
                        return result;
                    }
                }
            }
        }
        int flag=0;
        for (int i = 0; i <nums.length;i++){
            if(nums[i]*2==target)
                result[flag++]=i;
        }
        return result;
    }
}
