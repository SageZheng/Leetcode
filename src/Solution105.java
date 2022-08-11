import java.util.HashMap;

public class Solution105 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    HashMap<Integer, Integer> inorderIndex =new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            inorderIndex.put(inorder[i],i);
        }
        return madeTree(preorder,0,inorder.length-1,0,inorder.length-1);
    }
    public TreeNode madeTree(int[] preorder, int left,int right,int leftInorder,int rightInorder){
        System.out.println(left+" "+right);
        if(left>right)
            return null;
        TreeNode root = new TreeNode(preorder[left]);
        int rootIndex=inorderIndex.get(preorder[left]);
        int leftsize= rootIndex-leftInorder;
        int rightsize =rightInorder -rootIndex;
        root.left=madeTree(preorder,left+1,leftsize+left,leftInorder,rootIndex-1);
        root.right=madeTree(preorder,leftsize+left+1,right,rootIndex+1,rightInorder);
        return root;
    }

    public static void main(String[] args) {
        Solution105 s = new Solution105();
        System.out.println(s.buildTree(new int[] {3,9,20,15,7},new int[]{9,3,15,20,7}));
    }
}
