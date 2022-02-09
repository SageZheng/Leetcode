public class Solution69 {
    //感觉就是求2进制的过程吧，二分法一步一步往下走
    public int mySqrt(int x) {
        if (x == 0)
            return 0;
        if (x == 1)
            return 1;
        int res=0;
        for (int i = 15; i >= 0; i--) {
            long temp= (long) res *res;
            if((long)(res+two_Index(i))*(res+two_Index(i))<=x){
                res+=two_Index(i);
            }
        }
        return res;
    }
    public int two_Index(int i){
        if(i==0) return 1;
        if(i==1) return 2;
        if(i==2) return 4;
        if(i==3) return 8;
        if(i==4) return 16;
        if(i==5) return 32;
        if(i==6) return 64;
        if(i==7) return 128;
        if(i==8) return 256;
        if(i==9) return 512;
        if(i==10) return 1024;
        if(i==11) return 2048;
        if(i==12) return 4096;
        if(i==13) return 8192;
        if(i==14) return 16384;
        if(i==15) return 32768;
        else
            return 0;
    }
    public static void main(String[] args){
        int x=2147395599;
        Solution69 s =new Solution69();
        System.out.println(s.mySqrt(x));
    }
}