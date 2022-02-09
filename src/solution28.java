public class solution28 {
    public int strStr(String haystack, String needle) {
        if(needle==null)
            return 0;
        int k=-1;
        String c;
        if(haystack.length()-needle.length()<0)
            return -1;
        for(int i=0;i<haystack.length()-needle.length()+1;i++){
            c=haystack.substring(i,i+needle.length());
            if(needle.equals(c))
                return i;
        }
        return k;
    }
    public static void main(String[] args){
        String haystack="";
        String needle="";
        solution28 s = new solution28();
       //System.out.println(haystack.substring(0,0+needle.length()));
       //System.out.println(needle.equals(haystack.substring(0,0+needle.length())));
        System.out.println(s.strStr(haystack,needle));
    }
}
