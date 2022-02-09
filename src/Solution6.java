public class Solution6 {
    //构建转换关系就可以了
    public String convert(String s, int numRows) {
        if(numRows==1)
            return s;
        //每一块的数量
        int nums_part=2*numRows-2;
        StringBuilder[] res = new StringBuilder[numRows];
        for(int j=0;j<numRows;j++) {
            res[j]= new StringBuilder("");
            for (int i = j; i < s.length(); i = i + nums_part) {
                res[j].append(s.charAt(i));
                if(j!=0&&j!=numRows-1)
                    if(i+nums_part-2*j<s.length())
                        res[j].append(s.charAt(i+nums_part-2*j));
            }
        }
        StringBuilder out= new StringBuilder();
        for(int i=0;i<numRows;i++){
            out.append(res[i]);
        }
        return out.toString();
    }

    public static void main(String[] args){
        Solution6 s =new Solution6();

    }
}
