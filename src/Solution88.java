public class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int m1=0;
        int n1=0;
        int[] res=new int[m+n];
        int i=0;
        while(m1<m&&n1<n)
        {
            if(nums1[m1]<nums2[n1])
            {
                res[i]=nums1[m1];
                m1++;
            }
        else {
            res[i]=nums2[n1];
            n1++;
        }
        i++;
        }
        if(m1==m){
            for(int j=n1;j<n;j++,i++){
                res[i]=nums2[j];
            }
        }
        else{
            for(int j=m1;j<m;j++,i++){
                res[i]=nums1[j];
            }
        }
        if (m + n >= 0) System.arraycopy(res, 0, nums1, 0, m + n);
    }
}
