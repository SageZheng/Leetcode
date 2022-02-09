public class Solution44 {
    public boolean isMatch(String s, String p) {
        int row = s.length();
        int list = p.length();
        if (row == 0) {
            for (int i = 0; i < list; i++) {
                if (p.charAt(i) != '*')
                    return false;
            }
            return true;
        }
        boolean[][] dp = new boolean[list + 1][row + 1];
        dp[0][0] = true;
        for (int i = 1; i < list + 1; i++) {
            for (int j = 1; j < row + 1; j++) {
                if ((dp[i - 1][j])) {
                    if (p.charAt(i - 1) == '*') {
                        for (int k = j; k < row + 1; k++)
                            dp[i][k] = true;
                    }
                }
                if (dp[i - 1][j - 1]) {
                    if (p.charAt(i - 1) == '*') {
                        for (int k = j - 1; k < row + 1; k++)
                            dp[i][k] = true;
                    }
                    if (p.charAt(i - 1) == '?' || p.charAt(i - 1) == s.charAt(j - 1)) {
                        dp[i][j] = true;
                    }
                }
            }

        }
        return dp[list][row];
    }

    public static void main(String[] args) {
        Solution44 ss = new Solution44();
        String s = "abcabczzzde";
        String p = "*abc???de*";
        System.out.println(ss.isMatch(s, p));
    }
}
