import java.util.HashMap;

public class Solution437 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
    }
    int sum=0;//中间一段和为targetSum的情况
    int target=0;//总根节点开始的路径和为targetSum的情况
    int nodeSum=0;//总的节点数
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long,Integer> rootSum= new HashMap<>();
        if(root==null)
            return 0;
        pathValue(root,targetSum,0,rootSum);
        //因为targetSum等于0的时候，会把每一个空的范围给额外加一遍，所以需要删掉，就是【1】 0 的这种情况
        if(targetSum==0)
            return sum+target-nodeSum;
        return sum+target;
    }
    public void pathValue(TreeNode root, int targetSum, long pathSum, HashMap<Long,Integer> rootSum){
        nodeSum+=1;
        if(root.val+pathSum==targetSum)
            target+=1;
        rootSum.put((long)pathSum+root.val,rootSum.getOrDefault((long)pathSum+root.val,0)+1);//根节点到这里的路径和
        sum+=rootSum.getOrDefault((long)pathSum+root.val-targetSum,0);//查看是否存在，targetSum=两端路径和之间的情况，以及这种情况出现的次数
        if(root.left!=null)
            pathValue(root.left,targetSum,pathSum+root.val,rootSum);
        if(root.right!=null)
            pathValue(root.right,targetSum,pathSum+root.val,rootSum);
        rootSum.put(pathSum+root.val,rootSum.getOrDefault(pathSum+root.val,0)-1);//回溯的思路，这一段的和已经用过了，不适用于另一侧子树，需要删掉
    }
}
