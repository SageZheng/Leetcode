import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution55 {
    public int[][] merge(int[][] intervals) {
        if(intervals.length==0)
            return new int[0][2];
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        List<int[]> res = new ArrayList<>();
        for(int i=0;i<intervals.length;i++){
            int left=intervals[i][0];
            int right=intervals[i][1];
            while(i<intervals.length-1&&intervals[i+1][0]<=right){
                i++;
                right=Math.max(right,intervals[i][1]);
            }
            res.add(new int[]{left,right});
        }
        return res.toArray(new int[0][]);
    }
}
