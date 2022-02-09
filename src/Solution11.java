public class Solution11 {
    int right=0;
    int left=0;
    public int maxArea(int[] height) {
        left=height.length-1;
        int right_h=height[0];
        int left_h=height[left];
        int res=Math.min(right_h,left_h)*(height.length-1);
        while(right<left&&right_h>=0&&left_h>=0){
        if(right_h<left_h){
            right_h=findLarge(right,true,height);
        }
        else{
            left_h=findLarge(left,false,height);
        }
        if(res<Math.min(right_h,left_h)*(left-right)) {
            res = Math.min(right_h, left_h) * (left - right);
        }
        }
        return res;
    }
    public int findLarge(int index,boolean a,int[] height){
        //true is right
        if(a){
            for(int i=index;i<height.length;i++){
                if(height[i]>height[index]){
                    right=i;
                    return height[i];
                }
            }
        }
        else {
           for(int i=index;i>=0;i--){
               if(height[i]>height[index]){
                   left=i;
                   return height[i];
               }
           }
        }
        return -1;
    }
    public static void main(String[] args){
        Solution11 s= new Solution11();
        int[] a = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(s.maxArea(a));
    }
}
