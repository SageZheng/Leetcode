public class Solution7 {
    public int reverse(int x) {
        try{
            if(x>=0)
                return Integer.parseInt(new StringBuffer(Integer.valueOf(x).toString()).reverse().toString());
            else
                x=-x;
            return -Integer.parseInt(new StringBuffer(Integer.valueOf(x).toString()).reverse().toString());}
        catch (NumberFormatException e){
            return 0;
        }
    }
}
