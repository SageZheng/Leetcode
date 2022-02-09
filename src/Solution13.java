public class Solution13 {
    public int romanToInt(String s) {
    int x=s.length();
    int result=judge(s.charAt(0));
    for(int i=1;i<x;i++)
    {
        result=result+judge(s.charAt(i));
        if(judge(s.charAt(i-1))<judge(s.charAt(i)))
        {
            result=result-2*judge(s.charAt(i-1));
        }
    }
    return result;
    }
    public int judge(char a){
        if(a=='I')
            return 1;
        else if(a=='V')
            return 5;
        else if (a=='X')
            return 10;
        else if (a=='L')
            return 50;
        else if (a=='C')
            return 100;
        else if (a=='D')
            return 500;
        else
            return 1000;
    }
    public static void main(String[] args){
        String s= "MCMXCIV";
        Solution13 s1 = new Solution13();
        System.out.println(s1.romanToInt(s));
    }
}
