import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res=new ArrayList<>();
        String path="";
        //按行找皇，每个皇的列坐标放到Path里面
        back(n,path,0,res);
        return res;
    }
    public ArrayList<Integer> findnext(int n,String path){
        ArrayList<Integer> res = new ArrayList<>();
        int index = path.length();
        Boolean[] Notavailable = new Boolean[n];
        Arrays.fill(Notavailable, Boolean.FALSE);
        int gap=0;
        for(int i=0;i<path.length();i++){
            int num=path.charAt(i)-'0';
            Notavailable[num]=true;
            gap=index-i;
            if(num+gap<n){
                Notavailable[num+gap]=true;
            }
            if(num-gap>=0)
                Notavailable[num-gap]=true;
        }
        //判断还剩下的available的，添加到arraylist
        for(int i=0;i<n;i++){
            if(!Notavailable[i])
                res.add(i);
        }
        return res;
    }
    public void back(int n, String path,int row,List<List<String>> res){
        ArrayList<Integer> possibleNum=findnext(n,path);
        if(path.length()==n){
            Build(path,res);
            return;
        }
        if(possibleNum.size()==0)
            return;
        for(int i=0;i<possibleNum.size();i++){
            row=row+1;
            int num=possibleNum.get(i);
            path=path+String.valueOf(num);
           // System.out.println(path+"??"+row);
            back(n,path,row,res);
            path=path.substring(0,path.length()-1);
            row=row-1;
        }
    }
    public void Build(String path, List<List<String>> res){
        List<String> add= new ArrayList<>();
        for(int i=0;i<path.length();i++){
            int index=0;
            StringBuilder temp = new StringBuilder();
            for(int j=0;j<path.length();j++,index++){
                if(index==path.charAt(i)-'0'){
                    temp.append('Q');
                }
                else
                    temp.append('.');
            }
            add.add(temp.toString());
        }
        res.add(add);
    }
    public static void main(String[] args){
        Solution51 s = new Solution51();
        List<List<String>> res=new ArrayList<>();
//        s.Build("1302",res);
//        System.out.println(res);
        ArrayList<Integer> test= s.findnext(4,"");
        System.out.println(test);
       // System.out.println(s.solveNQueens(4));
        s.back(10,"",0,res);
        System.out.println(res.size());
    }
}
