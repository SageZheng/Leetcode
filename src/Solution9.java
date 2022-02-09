public class Solution9 {
    public boolean isPalindrome(int x) {
    Integer y = new Integer(x);
    String s = y.toString();
    for(int i=0;i<s.length();i++){
    if(s.charAt(i)!=s.charAt(s.length()-i-1))
        return false;
    }
    return true;
    }
}
