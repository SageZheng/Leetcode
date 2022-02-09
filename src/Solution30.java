import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution30 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        int num=words.length;
        int[] nums=new int[num];
        int length=words[0].length();
        for(int i=0;i<s.length()-num*length+1;i++){
            Arrays.fill(nums, 0);
            if(judge(s.substring(i,i+num*length), words,nums)&&allOne(nums))
               res.add(i);
        }
        return res;
    }
    public boolean judge(String s, String[] word, int[] nums){
        int length=word[0].length();
        for(int i=0;i<length*(nums.length);i=i+length) {
                for (int j = 0; j < nums.length; j = j + 1) {
                    if (nums[j] == 1&&j!=nums.length-1) {
                        continue;
                    }
                    if (s.startsWith(word[j], i)) {
                        nums[j] = 1;
                        break;
                    }
                    if(j==nums.length-1){
                        return false;
                    }
                }
        }
        return true;
    }
    public boolean allOne(int[] nums){
        for (int num : nums) {
            if (num != 1)
                return false;
        }
        return true;
    }
    public static void main(String[] args){
        Solution30 s = new Solution30();
        String[] word = new String[]{"word","good","best","good"};
        System.out.println(s.findSubstring("wordgoodgoodgoodbestword",word));
    }
}
