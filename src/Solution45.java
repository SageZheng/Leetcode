public class Solution45 {
    int res=1;
    public int jump(int[] nums) {
//贪心算法吗
        //应该就是贪心，每次都选择最后索引的那个数字
        if(nums.length==1)
            return 0;
        for(int i=0;i<nums.length-1;i++){
            nums[i]=i+nums[i];
        }
        if(nums[0]>=nums.length-1)
            return 1;
        res=res+1;
        back(nums,0);
        return res;
    }
    public void back(int[] nums, int index){
        int farthest=nums[index+1];
        int nextindex=index+1;
        for(int i=index+1;i<=nums[index];i++){
            if(farthest<nums[i]){
                farthest=nums[i];
                nextindex=i;
            }
            if(farthest>=nums.length-1)
                return;
        }
        res=res+1;
        back(nums,nextindex);
    }
    public static void main(String[] args){
        int[] nums=new int[]{2,3,0,1,4};
        Solution45 s = new Solution45();
        System.out.println(s.jump(nums));
    }
}
