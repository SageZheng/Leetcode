public class Solution423 {
    public String originalDigits(String s) {
        int[] hash = new int[26];
        int n = s.length();

        for(int i = 0; i < n; ++i){
            int d = s.charAt(i) - 'a';
            hash[d]++;
        }
        int[] res = new int[10];
        res[0] = hash['z' - 'a'];
        res[2] = hash['w' - 'a'];
        res[4] = hash['u' - 'a'];
        res[6] = hash['x' - 'a'];
        res[8] = hash['g' - 'a'];

        res[1] = hash['o' - 'a'] - res[0] - res[2] - res[4];
        res[3] = hash['h' - 'a'] - res[8];
        res[5] = hash['f' - 'a'] - res[4];
        res[7] = hash['s' - 'a'] - res[6];
        res[9] = hash['i' - 'a'] - res[5] - res[6] - res[8];


        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 10; ++i){
            for(int j = 0; j < res[i]; ++j){
                sb.append((char)('0' + i));
            }
        }
        return sb.toString();
    }
}