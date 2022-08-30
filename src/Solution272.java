import javafx.util.Pair;

import java.util.*;

public class Solution272 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    ArrayList<Pair<Integer,Double>> nums = new ArrayList<>();
    double target;
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        this.target=target;
        DFS(root);
        List<Integer> res = new ArrayList<>();
        nums.sort(new Comparator<Pair<Integer, Double>>() {
            @Override
            public int compare(Pair<Integer, Double> o1, Pair<Integer, Double> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        for(int i=0;i<k;i++){
            res.add(nums.get(i).getKey());
        }
        return  res;
    }
    public void DFS(TreeNode root){
        if(root.left!=null)
            DFS(root.left);
        nums.add(new Pair<>(root.val,Math.abs(root.val-target)));
        if(root.right!=null)
            DFS(root.right);
    }
}
