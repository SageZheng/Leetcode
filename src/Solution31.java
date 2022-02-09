import java.util.Arrays;
import java.util.Collections;

public class Solution31 {
    public void nextPermutation(int[] nums) {
        int i=nums.length-1;
        for(;i>0;i--){
           if(nums[i]>nums[i-1]){
               break;
           }
        }
        if(i==0){
            Arrays.sort(nums);
            return;
        }
        for(int j= nums.length-1;j>=0;j--){
            if(nums[j]>nums[i-1]){
                int temp=nums[i-1];
                nums[i-1]=nums[j];
                nums[j]=temp;
                break;
            }
        }
//        Integer[] numsInt = Arrays.stream(nums).boxed().toArray(Integer[]::new);
//        Arrays.sort(numsInt,i-1,nums.length, Collections.reverseOrder());
//        nums=Arrays.stream(numsInt).mapToInt(Integer::intValue).toArray();
        Arrays.sort(nums,i,nums.length);
    }
}
