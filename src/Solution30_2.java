import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution30_2 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        int wordNum= words.length;
        if(wordNum==0){
            return res;
        }
        int wordLen = words[0].length();
        HashMap<String, Integer> allwords = new HashMap<>();
        for(String w : words){
            int value= allwords.getOrDefault(w,0);
            allwords.put(w,value+1);
        }
        for(int i = 0; i < s.length() - wordNum * wordLen + 1; i++) {
            HashMap<String, Integer> hasWords = new HashMap<String, Integer>();
            int num = 0;
            while (num < wordNum) {
                String word = s.substring(i + num * wordLen, i + (num + 1) * wordLen);
                if (allwords.containsKey(word)) {
                    int value = hasWords.getOrDefault(word, 0);
                    hasWords.put(word, value + 1);
                    //判断当前单词的 value 和 HashMap1 中该单词的 value
                    if (hasWords.get(word) > allwords.get(word)) {
                        break;
                    }
                } else {
                    break;
                }
                num++;
            }
            if (num == wordNum) {
                res.add(i);
            }
        }
        return res;
    }

    public static void main(String[] args){
        Solution30_2 s = new Solution30_2();
        String[] word = new String[]{"word","good","best","good"};
        System.out.println(s.findSubstring("wordgoodgoodgoodbestword",word));
    }
}