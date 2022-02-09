import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Solution22 {
//        public List<String> generateParenthesis(int n) {
//            List<String> ans = new ArrayList<>();
//            backtrack(ans, new StringBuilder(), 0, 0, n);
//            return ans;
//        }
//
//        public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max){
//            if (cur.length() == max * 2) {
//                ans.add(cur.toString());
//                return;
//            }
//
//            if (open < max) {
//                cur.append("(");
//                backtrack(ans, cur, open+1, close, max);
//                cur.deleteCharAt(cur.length() - 1);
//            }
//            if (close < open) {
//                cur.append(")");
//                backtrack(ans, cur, open, close+1, max);
//                cur.deleteCharAt(cur.length() - 1);
//            }
//        }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; ++c)
                for (String left: generateParenthesis(c))
                    for (String right: generateParenthesis(n-1-c))
                        ans.add("(" + left + ")" + right);
        }
        return ans;
    }

    public static void main(String[] args){
        Solution22 s = new Solution22();
        System.out.println(s.generateParenthesis(3));
    }
}
