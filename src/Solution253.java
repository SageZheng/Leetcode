import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Solution253 {
    public class Meet implements Comparable<Meet>{
        int start;
        int end;
        Meet(int start, int end){
            this.start=start;
            this.end=end;
        }
        @Override
        public int compareTo(Meet o) {
            return start-o.start;
        }
    }
    public int minMeetingRooms(int[][] intervals) {
        PriorityQueue<Meet> Meeting = new PriorityQueue<>();
        for (int[] interval : intervals) {
            Meeting.add(new Meet(interval[0], interval[1]));
        }
        PriorityQueue<Integer> endTime = new PriorityQueue<>();
        //房间1，结束时间
        //用贪婪算法，去最先开始的，然后放进房间，将房间的值给更新成结束时间
        //房间需要按照结束时间排序，优先结束的在前面，如果最先的也无法满足，那就新建一个房间
        endTime.add(0);
        while (Meeting.size() > 0) {
            if (Meeting.peek().start >= endTime.peek()) {
                endTime.poll();
                endTime.add(Meeting.poll().end);
            } else {
                endTime.add(Meeting.poll().end);
            }
        }
        return endTime.size();
    }
}
