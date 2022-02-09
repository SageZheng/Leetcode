import java.util.ArrayList;
import java.util.List;

public class Solution57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res= new ArrayList<>();
        if(intervals.length==0){
            res.add(newInterval);
            return res.toArray(new int[0][]);
        }
        boolean flag=false;
        int index=-1;
        for(int i=0;i<intervals.length;i++) {
            if (intervals[i][1] >= newInterval[0]) {
                index = i;
                i=i+1;
                for (int j = i; j < intervals.length; j++) {
                    if (intervals[j][0] > newInterval[1]) {
                        res.add(new int[]{intervals[i-1][0], newInterval[1]});
                        i = j;
                        flag = true;
                        break;
                    }
                    if (intervals[j][0] == newInterval[1]) {
                        res.add(new int[]{intervals[i-1][0], intervals[j][1]});
                        i = j + 1;
                        flag = true;
                        break;
                    }
                }
            }
            if(i<intervals.length)
                res.add(intervals[i]);
        }
            if(!flag&&index>-1) {
                res.add(new int[]{intervals[index][0], Math.max(newInterval[1],intervals[intervals.length-1][1])});
            }
            if(index==-1)
                res.add(newInterval);
        return res.toArray(new int[0][]);
    }
}
