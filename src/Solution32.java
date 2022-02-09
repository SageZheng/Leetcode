public class Solution32 {
    public int longestValidParentheses(String s) {
        int res=0;
        int res2=0;
        int open=0;
        int close=0;
        int temp=0;
        for(int i =0;i<s.length();i++){
            if(s.charAt(i)=='(')
                open+=1;
            if(open==0){
                temp=0;
            }
            if(s.charAt(i)==')'&&open>0){
                temp+=1;
                open-=1;
                if(temp>res) {
                    res = temp;
                    temp=0;
                }
            }
        }
        temp=0;
        for(int i =s.length()-1;i>=0;i--){
            if(s.charAt(i)==')')
                close+=1;
            if(close==0){
                temp=0;
            }
            if(s.charAt(i)=='('&&close>0){
                temp+=1;
                close-=1;
                if(temp>res2) {
                    res2 = temp;
                    temp=0;
                }
            }
        }
        System.out.println(res2);
        return 2*Math.min(res,res2);
    }
    public static void main(String[] args){
        Solution32 s = new Solution32();
        System.out.println(s.longestValidParentheses("(()"));
    }
}
