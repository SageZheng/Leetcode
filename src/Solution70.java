public class Solution70 {
    public int climbStairs(int n) {
        if(n==1)
            return 1;
        if(n==2)
            return 2;
        return climb(n,1,2,3);
    }
    public int climb(int n, int x, int y,int i){
        if(n==i)
            return x+y;
        i++;
        return climb(n,y,x+y,i);
    }
}
