import java.util.Arrays;

public class solution26 {
    public int removeDuplicates1(int[] nums){
        int k=nums.length;
        if(k==0)
            return k;
        int i=nums[0];
        for(int j=1;j<k;j++){
            if(i==nums[j]) {
                move(nums, j);
                k--;
                j--;
            }
                i=nums[j];
        }
        return k;
    }
    public void move(int[] nums, int j){
        for(int i=j;i<nums.length-1;i++){
            nums[i]=nums[i+1];
        }
    }
    public int removeDuplicates2(int[] nums){
        if(nums.length==0)
            return 0;
        int p=0;
        int q=1;
        for(;q<nums.length;){
            if(nums[p]==nums[q]){
                q++;
            }
            else{
                if(p+1!=q)
                    nums[p+1]=nums[q];
                p++;
                q++;
            }
        }
        return p+1;
    }
    public int removeDuplicates(int[] nums) {
        int i = 1, j = 1;
        while(i < nums.length){
            if(nums[i] != nums[i-1])
                nums[j++] = nums[i++];
            else
                i++;
        }
        return j;
    }
    public static void main(String[] args){
        solution26 s = new solution26();
        int[] nums= {0,0,1,1,1,2,2,3,3,4};
        int k = s.removeDuplicates(nums);
        System.out.println(k);
        System.out.println(Arrays.toString(nums));
    }
}
