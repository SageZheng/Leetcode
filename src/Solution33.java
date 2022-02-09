public class Solution33 {
    public int search(int[] nums, int target) {
        if(nums[0]<target)
            return binarySearch(nums,0,nums.length/2,nums.length-1,target,true);
        else
            return binarySearch(nums,0,nums.length/2,nums.length-1,target,false);
    }
    public int binarySearch(int[] nums, int start,int index,int end,int target, boolean flag){
        System.out.println(start+" "+index+" "+end+" "+flag);
        if(nums[index]==target)
            return index;
        if(start>=index||index>end){
            return -1;
        }
        //flag=ture means in the left of the rotated point
        if(flag){
            if(nums[index]>target)
                return binarySearch(nums,start,(start+index)/2,index,target,flag);
            else{
                if(nums[(end+index)/2]>nums[index])
                return binarySearch(nums,index,(end+index)/2,end,target,flag);
                else
                {
                    int newIndex = findNewIndex(nums,start,end);
                    if(newIndex==-1)
                        return -1;
                    end=2*newIndex-index;
                    if(end>nums.length-1)
                        end=nums.length-1;
                    return binarySearch(nums,index,newIndex,end,target,flag);
                }
            }
        }
        else {
            if(nums[index]<target)
                return binarySearch(nums,index,(end+index)/2,end,target,flag);
            else {
                int newIndex =findNewIndex2(nums,start,end);
                if(newIndex==-1)
                    return -1;
                start=2*newIndex-end;
                if(start<0)
                    start=0;
                return binarySearch(nums,start,newIndex,end,target,flag);
            }
        }
    }
    public int findNewIndex(int[] nums,int start,int end){
        if(start>=end)
            return -1;
        int index=(start+end)/2;
        if(start==index){
            return start;
        }
        if(nums[index]>nums[start]){
            return index;
        }
        return findNewIndex(nums,start,index);
    }
    public int findNewIndex2(int[] nums,int start,int end){
        System.out.println(start+" "+end);
        if(start>=end){
            return -1;
        }
        int index=(start+end)/2;
        if(start==index){
            return start;
        }
        if(nums[index]<nums[end]){
            return index;
        }
        return findNewIndex2(nums,index,end);
    }
    public static void main(String[] args){
        Solution33 s = new Solution33();
        int[] nums = new int[]{4,5,6,7,0,1,2};
        int[] nums2 = new int[]{3,1};
        //System.out.println(s.search(nums,3));
        System.out.println(s.search(nums2,3));
    }
}
