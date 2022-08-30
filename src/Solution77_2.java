import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution77_2 {
    public List<List<Integer>> combine(int n, int k) {
        Queue<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            int size = res.size();
            if (size == 0) {
                for (int j = 1; j <= n; j++) {
                    ArrayList<Integer> addIn = new ArrayList<>();
                    addIn.add(j);
                    res.add(addIn);
                }
            } else {
                for (int j = 0; j < size; j++) {
                    List<Integer> start = res.poll();
                    for (int x = start.get(start.size() - 1) + 1; x <= n; x++) {
                        start.add(x);
                        res.add(new ArrayList<>(start));
                        start.remove(start.size()-1);
                    }
                }
            }
        }
        List<List<Integer>> returnValue = new ArrayList<>();
        int size=res.size();
        for (int j = 0; j < size; j++) {
            returnValue.add(res.poll());
        }
        return returnValue;
    }

    public static void main(String[] args) {
        Solution77_2 s = new Solution77_2();
        s.combine(4,2);
        //System.out.println(new ArrayList<Integer>(1).get(0));
    }
}
