import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Solution1249_2 {
    public String minRemoveToMakeValid(String s) {
        int parenLeft = 0;
        ArrayList<Integer> indexRemove = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                parenLeft++;
            else if (s.charAt(i) == ')') {
                if (parenLeft == 0)
                    indexRemove.add(i);//not matched
                else parenLeft--;//match
            }
        }
        //parenLeft might larger than 0, means that their
        //has some open parentheses left in the right part
        //which need to remove
        for (int i = s.length() - 1; i >= 0; i--) {
            if (parenLeft == 0)
                break;
            if (s.charAt(i) == '(') {
                indexRemove.add(i);
                parenLeft--;
            }
        }
        //remove
        Collections.sort(indexRemove);
        indexRemove.add(-1);
        StringBuilder result = new StringBuilder();
        int flag = 0;
        for (int i = 0; i < s.length(); i++) {
            if (flag< indexRemove.size()&& i != indexRemove.get(flag)) {
                result.append(s.charAt(i));
            } else flag++;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Solution1249_2 main= new Solution1249_2();
        System.out.println(main.minRemoveToMakeValid("a)b(c)d"));
    }
}
