import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Solution347 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> sum = new HashMap<>();
        ArrayList<Integer> numSum = new ArrayList<>();
        for(int i=0;i<20001;i++){
            numSum.add(i);
            sum.put(i,0);
        }
        for(int i =0 ;i<nums.length;i++){
            sum.put((nums[i]+10000),sum.get(nums[i]+10000)+1);
        }
        numSum.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -sum.get(o1)+sum.get(o2);
            }
        });
        int[] returnValue= new int[k];
        for(int i=0;i<k;i++){
            returnValue[i]=numSum.get(i)-10000;
        }
        return returnValue;
    }
}
