import java.util.ArrayList;
import java.util.List;

public class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rowStart = 0;
        int rowEnd = matrix[0].length-1;
        int listStart=0;
        int listEnd=matrix.length-1;
        List<Integer> res = new ArrayList<>();
        rotate(matrix,res,0,0,rowStart,rowEnd,listStart,listEnd);
        return res;
    }
    public void rotate(int[][] matrix,List<Integer> res,int row,int list,int rowStart, int rowEnd, int listStart, int listEnd){
        System.out.println(row+" "+list+" "+rowStart+" "+rowEnd+" "+listStart+" "+listEnd);
        if(rowStart>rowEnd||listStart>listEnd)
            return;
        if(row==rowStart&&list==listStart){
            for(;row<=rowEnd;row++){
                res.add(matrix[list][row]);
            }
            row-=1;
            listStart+=1;
            list+=1;
            //System.out.println(row+" "+list+" "+rowStart+" "+rowEnd+" "+listStart+" "+listEnd);
            //res.add(matrix[list][row]);
        }
        else if(row==rowEnd&&list==listStart){
            for(;list<=listEnd;list++){
                res.add(matrix[list][row]);
            }
            list-=1;
            rowEnd-=1;
            row=row-1;
            //res.add(matrix[list][row]);
        }
        else if(row==rowEnd&&list==listEnd){
            for(row=rowEnd;row>=rowStart;row--){
                res.add(matrix[list][row]);
            }
            row+=1;
            list=list-1;
            listEnd-=1;
            //res.add(matrix[list][row]);
        }
        else if(row==rowStart&&list==listEnd){
            for(;list>=listStart;list--)
                res.add(matrix[list][row]);
            list+=1;
            rowStart+=1;
            row=row+1;
           // res.add(matrix[list][row]);
        }
        rotate(matrix,res,row,list,rowStart,rowEnd,listStart,listEnd);
    }
    public static void main(String[] args){
        Solution54 s = new Solution54();
        int[][] matrix= new int[][]{{1,2,3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(s.spiralOrder(matrix));
    }
}
