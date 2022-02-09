public class Solution60 {
    public String getPermutation(int n, int k) {
        StringBuilder res= new StringBuilder();
        boolean[] nums_unused=new boolean[n];
        //false是没用过
        Mutiple(n-1,k,res,nums_unused);
        return res.toString();
    }
    public void Mutiple(int n,int k, StringBuilder res,boolean[] nums_unused){
        if(n<0)
            return;
        int jiechen=1;
        for(int i=1;i<=n;i++)
            jiechen=jiechen*i;
        int num=findLeast(nums_unused);
        while(k>jiechen) {
            num= findnext(nums_unused, num);
            k -= jiechen;
        }
        res.append(num);
        nums_unused[num-1]=true;
        Mutiple(n-1,k,res,nums_unused);
    }
    public int findLeast(boolean[] nums_unsed)
    {
        for(int i=0;i<nums_unsed.length;i++){
            if(!nums_unsed[i])
                return i+1;
        }
        return 0;
    }
    public int findnext(boolean[] nums_unsed,int last){
        for(int i=last;i<nums_unsed.length;i++){
            if(!nums_unsed[i])
                return i+1;
        }
        return 0;
    }
    public static void main(String[] args){
        Solution60 s = new Solution60();
        System.out.println(s.getPermutation(4,9));
    }
}
