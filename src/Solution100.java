import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Solution100 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public boolean isSameTree(TreeNode p, TreeNode q) {
            List<Integer> a = inorderTraversal(p);
            List<Integer> b = inorderTraversal(q);
            if (a.size() != b.size())
                return false;
            for (int i = 0; i < a.size(); i++) {
                if (!Objects.equals(a.get(i), b.get(i)))
                    return false;
            }
            return true;
        }

        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> a = new ArrayList<>();
            inOrder(root, a);
            return a;

        }

        public void inOrder(TreeNode root, List<Integer> a) {
            if (root == null) {
                a.add(10000);
                return;
            }
            inOrder(root.left, a);
            a.add(root.val);
            inOrder(root.right, a);
        }
    }
}
