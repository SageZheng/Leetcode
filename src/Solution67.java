public class Solution67 {
        public String addBinary(String a, String b) {
            StringBuilder ans = new StringBuilder();

            int n = Math.max(a.length(), b.length()), carry = 0;
            for (int i = 0; i < n; ++i) {
                carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
                carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
                ans.append((char) (carry % 2 + '0'));
                carry /= 2;
            }

            if (carry > 0) {
                ans.append('1');
            }
            ans.reverse();

            return ans.toString();
        }

    public static void main(String[] args){
        String a="10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
        String b ="110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";
        Solution67 s= new Solution67();
      //  System.out.println( s.getBinary(b)+s.getBinary(a));
       System.out.println( s.addBinary(a,b));
    }
}
