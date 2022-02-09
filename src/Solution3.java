public class Solution3 {
    public static int lengthOfLongestSubstring(String s) {
        boolean[] a=new boolean[200];
        for(int j=0;j<200;j++){
            a[j]=false;
        }
        if(s.length()==0)
            return 0;
        int i=0;
        int res=0;
        char cha = s.charAt(i);
        a[index(cha)]=true;

        if(s.length()==1)
            return 1;
        for(int j=1;j<s.length();j++){
            cha = s.charAt(j);
            if(a[index(cha)]=false)
                a[index(cha)]=true;
            else{
                for(int x=i;x<j;x++){
                    if(s.charAt(x)==s.charAt(j))
                    {i=x+1;
                    break;}
                    a[index(s.charAt(x))]=false;
                }
            }
            int num=j-i+1;
            if(num>res)
                res=num;
        }
        return res;
    }
    public static int index(char a){
       int num= a;
       return num;
    }
    public static void main(String[] args){
        String a ="au";
        Solution3 s = new Solution3();
        int res= lengthOfLongestSubstring(a);
        System.out.println(res);

    }
}
