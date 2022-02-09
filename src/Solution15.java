import java.util.*;

public class Solution15 {
//    public List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> res = new ArrayList<>();
//        Arrays.sort(nums);
//        int end=nums.length-2;
//        //这个end是可以优化的
//        for(int i=0;i<end;i++){
//            if(i>=1&&nums[i]==nums[i-1])
//                continue;
//           int left=i+1;
//           int right=nums.length-1;
//            while(left<right){
//                //如何去掉重复元素呢？哈希表？
//                if(nums[i]+nums[left]+nums[right]==0) {
//                    if(nums[left]!=nums[left+1]&&nums[right]!=nums[right-1]||right-left==1){
//                        List<Integer> temp = new ArrayList<>();
//                        temp.add(nums[i]);
//                        temp.add(nums[left]);
//                        temp.add(nums[right]);
//                        res.add(temp);
//                    }
//                    if(nums[left]==nums[left+1])
//                        left++;
//                    else
//                        right--;
//                }
//                if(nums[i]+nums[left]+nums[right]<0){
//                    left++;
//                }
//                if(nums[i]+nums[left]+nums[right]>0){
//                    right--;
//                }
//            }
//        }
//        return res;
//    }
public List<List<Integer>> threeSum(int[] nums) {
    int n = nums.length;
    Arrays.sort(nums);
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    // 枚举 a
    for (int first = 0; first < n; ++first) {
        // 需要和上一次枚举的数不相同
        if (first > 0 && nums[first] == nums[first - 1]) {
            continue;
        }
        // c 对应的指针初始指向数组的最右端
        int third = n - 1;
        int target = -nums[first];
        // 枚举 b
        for (int second = first + 1; second < n; ++second) {
            // 需要和上一次枚举的数不相同
            if (second > first + 1 && nums[second] == nums[second - 1]) {
                continue;
            }
            // 需要保证 b 的指针在 c 的指针的左侧
            while (second < third && nums[second] + nums[third] > target) {
                --third;
            }
            // 如果指针重合，随着 b 后续的增加
            // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
            if (second == third) {
                break;
            }
            if (nums[second] + nums[third] == target) {
                List<Integer> list = new ArrayList<Integer>();
                list.add(nums[first]);
                list.add(nums[second]);
                list.add(nums[third]);
                ans.add(list);
            }
        }
    }
    return ans;
}
    public static void main(String[] args){
        int[] a = new int[]{-2,0,0,2,2};
        Solution15 s = new Solution15();
        System.out.println(s.threeSum(a));
    }
}
