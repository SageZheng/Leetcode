import com.sun.deploy.security.SelectableSecurityManager;
import javafx.scene.chart.ScatterChart;

import javax.imageio.stream.ImageInputStream;
import java.lang.reflect.Array;
import java.nio.channels.ScatteringByteChannel;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class Solution76 {
    public String minWindow(String s, String t) {
        int[] letter = new int[58];
        int[] letterAll = new int[58];
        int start = 0;
        int end = s.length() - 1;
        int length = end - start;
        //initialize
        //哈希表的确有优势，也不需要初始化
        if(s.length()<t.length())
            return "";
        for (int i = 0; i < 58; i++) {
            letter[i] = 0;
            letterAll[i] = 0;
        }
        for (int i = 0; i < s.length(); i++) {
            letterAll[s.charAt(i) - 'A'] += 1;
        }
        for (int i = 0; i < t.length(); i++) {
            letter[t.charAt(i) - 'A'] += 1;
            if(letter[t.charAt(i) - 'A']>letterAll[t.charAt(i) - 'A'])
                return "";
        }
        for (int i = 0; i <= s.length() - t.length(); i++) {
            int index = s.charAt(i) - 'A';
            System.out.println(s.charAt(i)+" "+i+" "+letterAll[index]+" "+letter[index]+" "+index);
            if (letter[index] == 0) {
                continue;
            }
            if (letterAll[index] < letter[index])
                return "";
            else {
                int[] letterCur = Arrays.copyOf(letterAll, 58);
                for (int j = s.length() - 1; j >= i + t.length() - 1; j--) {
                    int indexright = s.charAt(j) - 'A';
                    System.out.println(s.charAt(j)+" "+j+" "+letterCur[indexright]+" "+letter[indexright]+" "+indexright);
                    if (letter[indexright] == 0) {
                        continue;
                    }
                    if (letterCur[indexright] < letter[indexright])
                        return "";
                    else if (letterCur[indexright] == letter[indexright]) {
                        if (length > j - i) {
                            start = i;
                            end = j;
                            length = j - i;
                        }
                        break;
                    } else  if (letterCur[indexright] > letter[indexright]){
                        letterCur[indexright] -= 1;
                    }
                }
                if (letterAll[index] == letter[index]) {
                    break;
                } else
                    letterAll[index] -= 1;
            }
        }
        return s.substring(start, end + 1);
    }
public String minWindows2(String s, String t){
        if(s==null||s.length()==0||t==null||t.length()==0){
            return "";
        }
        int[] need=new int[58];
    for (int i = 0; i < t.length(); i++) {
        need[t.charAt(i)]++;
    }
    //l是当前左边界，r是当前右边界，size记录窗口大小，count是需求的字符个数，start是最小覆盖串开始的index
    int l = 0, r = 0, size = Integer.MAX_VALUE, count = t.length(), start = 0;
    //遍历所有字符
    while (r < s.length()) {
        char c = s.charAt(r);
        if (need[c] > 0) {//需要字符c
            count--;
        }
        need[c]--;//把右边的字符加入窗口
        if (count == 0) {//窗口中已经包含所有字符
            while (l < r && need[s.charAt(l)] < 0) {
                need[s.charAt(l)]++;//释放右边移动出窗口的字符
                l++;//指针右移
            }
            if (r - l + 1 < size) {//不能右移时候挑战最小窗口大小，更新最小窗口开始的start
                size = r - l + 1;
                start = l;//记录下最小值时候的开始位置，最后返回覆盖串时候会用到
            }
            //l向右移动后窗口肯定不能满足了 重新开始循环
            need[s.charAt(l)]++;
            l++;
            count++;
        }
        r++;
    }
    return size == Integer.MAX_VALUE ? "" : s.substring(start, start + size);
}

    public static void main(String[] args) {
        Solution76 s = new Solution76();
        System.out.println(s.minWindow("ABCDD", "AD"));
    }
}
