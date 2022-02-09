public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
    int a= nums.length;
    int[] num =nums.clone();
    int[] index=new int[a-1];
    quickSort(nums,0,a-1);
        int[] result = new int[2];
        int l = 0, r = nums.length - 1;
        int i=0;
        while (l < r) {
            if (nums[l] + nums[r] == target) {
                if(nums[l]==nums[r]) {
                    result[0] = findIndex(num, nums[l], 0);
                    result[1] = findIndex(num, nums[r], 1);
                }
                else {
                    result[0] = findIndex(num, nums[l], 0);
                    result[1] = findIndex(num, nums[r], 0);
                }
                return result;
            } else if (nums[l] + nums[r] < target) {
                l++;
            } else {
                r--;
            }
        }

        return result;

    }
    public int findIndex(int[] num,int a,int x){
        int b=num.length;
        int result =0;
        for(int i=0;i<b;i++){
            if(num[i]==a)
                if(x==0)
                return i;
                else{
                    x--;
                    continue;
                }
        }
        return result;
    }
    public static void quickSort(int[] arr,int low,int high) {
        int p,i,j,temp;

        if(low >= high) {
            return;
        }
        //p就是基准数,这里就是每个数组的第一个
        p = arr[low];
        i = low;
        j = high;
        while(i < j) {
            //右边当发现小于p的值时停止循环
            while(arr[j] >= p && i < j) {
                j--;
            }

            //这里一定是右边开始，上下这两个循环不能调换（下面有解析，可以先想想）

            //左边当发现大于p的值时停止循环
            while(arr[i] <= p && i < j) {
                i++;
            }

            temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
        arr[low] = arr[i];//这里的arr[i]一定是停小于p的，经过i、j交换后i处的值一定是小于p的(j先走)
        arr[i] = p;
        quickSort(arr,low,j-1);  //对左边快排
        quickSort(arr,j+1,high); //对右边快排

    }

    public static void main(String[] args){
        int[] nums =new int[]{3,2,3};
        int[] num;
        int target = 6;
        Solution1 a = new Solution1();
        num=a.twoSum(nums,target);
        System.out.println(num[0]+" "+num[1]);
    }
}
