import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        boolean[] index= new boolean[nums.length];
        recursion(nums,res,path,index);
        return res;
    }
    public void recursion(int[]nums, List<List<Integer>> res, Deque<Integer> path, boolean[] index){
        if(path.size()==nums.length)
            res.add(new ArrayList<Integer>(path));
        for(int i=0;i<nums.length;i++){
            if(!index[i]){
                index[i]=true;
                path.addLast(nums[i]);
                recursion(nums,res,path,index);
                path.removeLast();
                index[i]=false;
            }
        }
    }
}
