public class Solution14 {
    public String longestCommonPrefix(String[] strs) {
    String result="";
    int i =strs.length;
    if(i==1)
        return strs[0];
    int x=strs[0].length();
    for(int j=1;j<i;j++){
        if(x>strs[j].length())
            x=strs[j].length();
    }
    //System.out.println(x);
    int flag=1;
    for(int j=1;j<x+1;j++){
        String a = strs[0].substring(0,j);
        for(int k=1;k<i;k++){
            if(!a.equals(strs[k].substring(0, j)))
            { flag=0;
               // System.out.println(strs[k]);
                break;}
        }
        if(flag==0)
            return result;
        result=a;
       // System.out.println(strs[0].substring(0,2));
    }
    return result;
    }
    public static void main(String args[]){
        String[] strs = new String[1];
        strs[0]="abac";
        Solution14 s1= new Solution14();
        System.out.println(s1.longestCommonPrefix(strs));
    }
}