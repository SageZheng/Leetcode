public class Solution42 {
    int num = 0;
    public int trap(int[] height) {
        int largest = height[0];
        int index = 0;
        for (int i = 1; i < height.length; i++)
            if (largest < height[i]) {
                index = i;
                largest = height[i];
            }
        findheight(0, index, height);
        findheight(index, height.length - 1, height);
        return num;
    }

    public void findheight(int start, int end, int[] height) {
        //System.out.println(start+" "+end);
        if(end-start<2){
            return;
        }
//        int largest;
//        int largestIndex;
        int secondIndex;
        int secondLarge;
        if (height[start] < height[end]) {
//            largest = height[end];
//            largestIndex = end;
            secondIndex = start;
            secondLarge = height[start];
            for (int i = start + 1; i < end; i++)
                if (secondLarge < height[i]) {
                    secondIndex = i;
                    secondLarge = height[i];
                }
            rain(height, secondIndex, end);
            findheight(start, secondIndex, height);
        } else {
//            largest = height[start];
//            largestIndex = start;
            secondLarge = height[end];
            secondIndex = end;
            for (int i = start + 1; i < end; i++)
                if (secondLarge < height[i]) {
                    secondIndex = i;
                    secondLarge = height[i];
                }
            rain(height, start, secondIndex);
            findheight(secondIndex, end, height);
        }
    }

    public void rain(int[] height, int start, int end) {
        //两个高度之间的水量的计算
        int max = Math.min(height[start], height[end]);
        for (int i = start + 1; i < end; i++)
            num = num + max - height[i];
    }
    public static void main(String[] args){
        Solution42 s = new Solution42();
        int[] nums = new int[]{4,2,0,3,2,5};
        System.out.println(s.trap(nums));
    }
}
