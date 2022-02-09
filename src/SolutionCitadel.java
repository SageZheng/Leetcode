import java.util.Arrays;
import java.util.List;

public class SolutionCitadel {
//   public static long maxValue(int n, List<List<Integer>> rounds) {
//        // Write your code here
//        long[] res= new long[n];
//        for(int i=0;i<n;i++){
//            res[i]=0;
//        }
//        for(int i=0;i<rounds.size();i++){
//            int left=rounds.get(i).get(0);
//            int right=rounds.get(i).get(1);
//            int add=rounds.get(i).get(2);
//            for(int j=left-1;j<right;j++){
//                res[j]+=add;
//            }
//        }
//        long max=res[0];
//        for(int i=1;i<n;i++){
//            max=Math.max(max, res[i]);
//        }
//        return max;
//    }
//    public static long maxValue(int n, List<List<Integer>> rounds) {
//        // Write your code here
//        int[] res = new int[n];
//        for(int i=0;i<rounds.size();i++){
//            res[rounds.get(i).get(0)-1]+=rounds.get(i).get(2);
//            if(rounds.get(i).get(1)<n){
//                res[rounds.get(i).get(1)]-=rounds.get(i).get(2);
//            }
//        }
//        int cur=0;
//        int max=0;
//        for(int value:res)
//        {
//            cur+=value;
//            max=Math.max(cur, max);
//        }
//        return max;
//    }
//    public static int stockPairs(List<Integer> stocksProfit, long target) {
//        // Write your code here
//        int[] profit= stocksProfit.stream().mapToInt(Integer::intValue).toArray();
//        Arrays.sort(profit);
//        int left=0;
//        int sum=0;
//        int right=stocksProfit.size()-1;
//        while(left<right){
//            //边界存在问题
//            if(profit[left]==profit[left+1]&&left+1!=right)
//                left+=1;
//            if(profit[right]==profit[right-1]&&left+1!=right)
//                right-=1;
//            long res=profit[left]+profit[right];
//            if(res==target){
//                sum+=1;
//                left+=1;
//            }
//            else if(res<target)
//                left+=1;
//            else
//                right-=1;
//        }
//        return sum;
//    }
}
