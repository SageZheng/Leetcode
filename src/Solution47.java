import java.util.*;

public class Solution47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path =new ArrayDeque<>();
        boolean[] index= new boolean[nums.length];
        recursion(nums,res,path,index);
        return res;
    }
    public void recursion(int[] nums,List<List<Integer>> res,Deque<Integer> path,boolean[] index){
        //System.out.println(path);
        if(path.size()==nums.length)
            res.add(new ArrayList<Integer>(path));
        for(int i=0;i<nums.length;i++) {
            if(index[i]) continue;
            if (i>0&&!index[i-1]&&nums[i]==nums[i-1]) {
                continue;
            }
                index[i] = true;
                path.addLast(nums[i]);
                recursion(nums, res, path, index);
                path.removeLast();
                index[i] = false;
        }
    }
    public static void main(String[] args){
        Solution47 s = new Solution47();
        int[] nums = new int[]{1,1,2};
        System.out.println(s.permuteUnique(nums));
    }
}
