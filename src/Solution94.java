import java.util.ArrayList;
import java.util.List;

public class Solution94 {
    public static class TreeNode {
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
 public List<Integer> inorderTraversal(TreeNode root) {
  List<Integer> a = new ArrayList<>();
  inOrder(root,a);
  return a;

 }
 public void inOrder(TreeNode root, List<Integer> a){
        if(root ==null)
            return;
        inOrder(root.left,a);
        a.add(root.val);
        inOrder(root.right,a);
 }
}
