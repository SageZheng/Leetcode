import java.util.ArrayList;

public class Solution20 {
    public boolean isValid(String s) {
        int[] a=new int[s.length()];
        for(int i=0;i<s.length();i++){
           a[i]= find(s.charAt(i));
           //System.out.println(a[i]);
        }
        ArrayList<int[]> b= new ArrayList<int[]>();
        for(int i=s.length()-1;i>-1;i--){
            int[] x=new int [2];
            if(a[i]<4) {
                x[0]=i;
                //System.out.println(a[i]);
                int flag=0;
                for(int j=i;j<s.length();j++){
                    if (a[j] == a[i] + 3) {
                        x[1] = j;
                        a[j] = a[j] + 3;
                        a[i]=a[i]+6;
                        //System.out.println(a[j]);
                        flag=1;
                        b.add(x);
                        break;
                    }
                }
                if(flag==0)
                    return false;
            }
            //System.out.println(b.size());
        }
        for(int j=0;j<s.length();j++)
            if(a[j]<7)
                return false;
        for(int i=0;i<b.size()-1;i++){
            if(b.get(i)[0]>b.get(i)[1])
                return false;
            //System.out.println(b.get(i)[0]+" "+b.get(i)[1]);
            if(!judge(b.get(i),b.get(i+1)))
                return false;
        }
        return true;
    }
    public boolean judge(int[] a, int[] b){
        if(a[0]>b[0]&&a[1]<b[1])
                return true;
        if(a[0]<b[0]&&a[1]>b[1])
                return true;
        if(a[0]>b[0]&&a[0]>b[1])
            return true;
        if(a[0]<b[0]&&a[1]<b[0])
            return true;
        return false;
    }
    public int find(char a){
        if(a=='(')
            return 1;
        if(a=='{')
            return 2;
        if(a=='[')
            return 3;
        if(a==')')
            return 4;
        if(a=='}')
            return 5;
        if(a==']')
            return 6;
        return 0;
    }
    public static void main(String[] args){
        String s= "]";
        Solution20 s1= new Solution20();
        System.out.println(s1.isValid(s));
    }
}
