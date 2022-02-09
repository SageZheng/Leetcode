import java.util.Arrays;

public class Solution74 {
    public void sortColors(int[] nums) {
        int one = 0;
        int zero = 0;
        int two = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                zero += 1;
            else if (nums[i] == 1)
                one += 1;
        }
        two = one + zero;
        one = zero;
        int temp;
        if (one == 0) {
            for (int i = 0; i < two; i++) {
                if (nums[i] == 2) {
                    while (two < nums.length - 1 && nums[two] == 2) {
                        two += 1;
                    }
                    temp = nums[two];
                    nums[two] = nums[i];
                    nums[i] = temp;
                    i -= 1;
                }
            }
        }
        for (int i = 0; i < one; i++) {
            System.out.println(one + " " + two + " " + i);
            if (nums[i] == 0)
                continue;
            else if (nums[i] == 1) {
                while (one < two - 1 && nums[one] == 1) {
                    one += 1;
                }
                temp = nums[one];
                nums[one] = nums[i];
                nums[i] = temp;
                i -= 1;
            } else {
                while (two < nums.length - 1 && nums[two] == 2) {
                    two += 1;
                }
                temp = nums[two];
                nums[two] = nums[i];
                nums[i] = temp;
                i -= 1;
            }
        }
    }

    public static void main(String[] args) {
        Solution74 s = new Solution74();
        int[] color = new int[]{2, 0, 2, 1, 1, 0};
        s.sortColors(color);
        System.out.println(Arrays.toString(color));
    }
}
