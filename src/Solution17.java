import java.util.ArrayList;
import java.util.List;

public class Solution17 {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length()==0)
            return res;
        String[] a = new String[digits.length()];
        int sum=1;
        for(int i =0;i<digits.length();i++){
            a[i]=ReturnLetter(digits.charAt(i));
            sum=sum*a[i].length();
        }
        int repeat=1;
        int sum_use=sum;
        List<StringBuffer> out = new ArrayList<>();
        for(int i=0;i<sum_use;i++){
            out.add( new StringBuffer());
        }
        for(int i =0;i<digits.length();i++){
             int index=0;
            sum=sum/a[i].length();
            if(i>0)
                repeat=repeat*a[i-1].length();
            for(int k=0;k<repeat;k++) {
                for (int j = 0; j < a[i].length(); j++) {
                    int count = 0;
                    while (count < sum) {
                        out.get(index).append(a[i].charAt(j));
                        count++;
                        index++;
                    }
                }
            }
        }
        for(int i=0;i<sum_use;i++){
            res.add(out.get(i).toString());
        }
        return res;
    }
    public String ReturnLetter(char i){
        if(i=='2')
            return "abc";
        else if(i=='3')
            return "def";
        else if(i=='4')
            return "ghi";
        else if(i=='5')
            return "jkl";
        else if(i=='6')
            return "mno";
        else if(i=='7')
            return "pqrs";
        else if(i=='8')
            return "tuv";
        else
            return "wxyz";
    }
    public static void main(String[] args){
        Solution17 s = new Solution17();
        System.out.println(s.letterCombinations("23"));
    }
}
