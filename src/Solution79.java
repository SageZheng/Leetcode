import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution79 {
    Integer flag=0;
    //这边参数传不回来
    public boolean exist(char[][] board, String word) {
        int row=board.length;
        int list=board[0].length;
        Integer[][] path=new Integer[row][list];
        //path 0 为没有用过，1为用过，我不知道Boolean和boolean能不能传，试着写了一下，都无法传值
        for(int i=0;i<row;i++){
            for(int j=0;j<list;j++){
                path[i][j]=0;
            }
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<list;j++){
                if(board[i][j]==word.charAt(0)) {
                    path[i][j]=1;
                    back(board, word, 1, i, j, path);
                    path[i][j]=0;
                }
            }
        }
        if(flag==1)
            return true;
        return false;
    }
    public ArrayList<Integer> getNearby(char[][] borad,char next,int row,int list,Integer[][] path){
        // return value
        // 0 means up, 1 means right, 2 means down, 3 means left
        ArrayList<Integer> res= new ArrayList<>();
        if(row-1>=0&&borad[row-1][list]==next&&path[row-1][list]==0)
            res.add(3);
        if(list-1>=0&&borad[row][list-1]==next&&path[row][list-1]==0)
            res.add(0);
        if(list+1<borad[0].length&&borad[row][list+1]==next&&path[row][list+1]==0)
            res.add(2);
        if(row+1<borad.length&&borad[row+1][list]==next&&path[row+1][list]==0)
            res.add(1);
        return res;
    }
    public void back(char[][] board,String word, int length, int row, int list,Integer[][] path){

        if(flag==1)
            return;
        //System.out.println(row+" "+list+" "+length+" "+path[0][3]);
        //下面这个就是防止总长度为1的情况
        if(length==word.length()){
            flag=1;
            return;
        }
        ArrayList<Integer> neaby = getNearby(board,word.charAt(length),row,list,path);
       //System.out.println(neaby.size()+" "+word.charAt(length));
        if(length==word.length()-1&&neaby.size()>0){
            flag=1;
            return;
        }
        if(neaby.size()==0)
            return;
        for(int i=0;i<neaby.size();i++){
            if(neaby.get(i)==3){
                row=row-1;
                length=length+1;
                path[row][list]=1;
                back(board,word,length,row,list,path);
                length=length-1;
                path[row][list]=0;
                row=row+1;
                //这里要反向
            }
            else if(neaby.get(i)==0){
                list=list-1;
                length=length+1;
                path[row][list]=1;
                back(board,word,length,row,list,path);
                length=length-1;
                path[row][list]=0;
                list=list+1;
            }
            else if(neaby.get(i)==2){
                list=list+1;
                length=length+1;
                path[row][list]=1;
                back(board,word,length,row,list,path);
                length=length-1;
                path[row][list]=0;
                list=list-1;
            }
            else{
                row=row+1;
                length=length+1;
                path[row][list]=1;
                back(board,word,length,row,list,path);
                length=length-1;
                path[row][list]=0;
                row=row-1;
            }
        }
    }
    public static void test1(boolean i){
        i=true;
    }
    public static void test2(Boolean i){
        i=true;
    }
    public static void test3(int i){
        i=1;
    }
    public static void test5(Integer i){
        i=1;
    }
    public static void test4(List<Integer> i){
        i.add(1);
    }
    public static void test6(StringBuffer i){
        i=i.append("new");
    }
    public static void test7(String i){
        i=i+"new";
    }
    public static void main(String[] args){
        boolean i = false;
        Boolean j = false;
        int k=0;
        Integer x= 0;
       List<Integer> l = new ArrayList<>();
       StringBuffer ss =new StringBuffer("old");
       String sss = "old";
        test1(i);
        test2(j);
        test3(k);
        test4(l);
        test5(x);
        test6(ss);
        test7(sss);
        System.out.println(i+" "+j+" "+k+' '+x+" "+l+" "+ss+" "+sss);
        char[][] board= new char[][]{{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
        char[][] board2= new char[][]{{'a'}};
        char[][] board3 = new char[][]{{'a','b'}};
        char[][] board4= new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        Solution79 s = new Solution79();
       //System.out.println(s.exist(board3,"ba"));
        System.out.println(s.exist(board4,"ABCB"));
        //System.out.println(s.exist(board,"ABCEFSADEESE"));
        //System.out.println(s.exist(board2,"a"));
    }
}
