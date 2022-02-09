import java.math.BigInteger;

public class Solution43 {
    public String multiply(String num1, String num2) {
        BigInteger N1= new BigInteger(num1);
        BigInteger N2= new BigInteger(num2);
        BigInteger N3=N1.multiply(N2);
        String res = new String(String.valueOf(N3));
        System.out.println(N1);
        return res;
    }
    public static void main(String[] args){
        Solution43 s = new Solution43();
        System.out.println(s.multiply("111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111","0"));
    }
}
