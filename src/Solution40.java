import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        for (int i = 0; i < candidates.length; i++) {
            if(i>0&&candidates[i]==candidates[i-1])
                continue;
            if (candidates[i] <= target) {
                target=target-candidates[i];
                path.add(candidates[i]);
                back(candidates, target, i, path,res);
                path.remove(0);
                target=target+candidates[i];
            }
        }
        return res;
    }

    public void back(int[] candodates, int target, int lastIndex, List<Integer> path,List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            //这边！！！
            return;
        }
        int lasttemp = lastIndex;
        for (int i = lastIndex + 1; i < candodates.length; i++) {
            if (i>lastIndex+1&&candodates[i] == candodates[i - 1])
                continue;
            if (candodates[i] <= target) {
                path.add(candodates[i]);
                lastIndex = i;
                target = target - candodates[i];
                back(candodates, target, lastIndex, path,res);
                path.remove(path.size() - 1);
                lastIndex = lasttemp;
                target = target + candodates[i];
            }
            if (candodates[i] > target)
                break;
        }
    }
    public static void main(String[] args){
        Solution40 s = new Solution40();
        int [] a = new int[]{10,1,2,7,6,1,5};
        System.out.println(s.combinationSum2(a,8));
    }
}
