public class Solution50 {
    public double myPow(double x, int n) {
        //快速幂+转换成二进制+迭代
        if(n<0) {
            n=-n;
            x = 1 / x;
        }
        String s = Integer.toBinaryString(n);
        char[] num = s.toCharArray();
        double res=1;
        double temp=x;
        for (int i=num.length-1;i>=0;i--) {
            if(i!=num.length-1)
                temp=temp*temp;
            if (num[i] == '1')
                res = res*temp;
            //System.out.println(num[i]);
        }
        return res;
    }
    public static void main(String[] args){
        Solution50 s = new Solution50();
        double x=2.0;
        int n=-4;
        System.out.println(s.myPow(x,n));
    }
}
