public class solution4 {
public double findMedianSortedArrays(int[] l1, int[] l2){
    int m=l1.length;
    int n=l2.length;
    int k=m+n;
    k=gethalf(k);

    double result = getk(l1,0,l2,0,k);
    return result;
}
public double getk(int[] l1, int i1, int[] l2, int i2, int k){
    double result=0;
    int j1,j2;
    System.out.println(gethalf(k));
    if((i1+gethalf(k))>l1.length)
        j1= l1.length-1;

    else
        j1=i1 + gethalf(k)-1;
    if((i2+gethalf(k))>l2.length)
        j2= l2.length-1;

    else
        j2=i2 + gethalf(k)-1;
    //System.out.println(j2);
   //System.out.println(gethalf(k));
    if(k==1) {
        System.out.println(j2);
        System.out.println(k);
        if ((l1.length + l2.length) % 2 == 1) {
            if ((j1+j2-i1-i2)==k){
                if (l1[j1] > l2[j2])
                    result = l2[j2] * 1.0;
                else
                    result = l1[j1] * 1.0;
            }
            else{
                if (l1[j1] > l2[j2])
                    result = l1[j1] * 1.0;
                else
                    result = l2[j2] * 1.0;
            }
        }
       /* else{
            //it's possible that the two median is in both array
        //my logic is still imperfect, need to be more specific
    System.out.println(l1[j1]);
            System.out.println(l2[j2]);
            if(j1>0&&j2>0){
            if (l1[j1]<l2[j2-1])
                result=(l2[j2-1]+l2[j2])/2.0;
            else if(l1[j1]>l2[j2-1])
            result=(l1[j1]+l2[j2])/2.0;
            else if(l1[j1-1]>l2[j2])
                result=(l1[j1-1]+l1[j1])/2.0;
            else if(l1[j1-1]<l2[j2])
                result=(l1[j1]+l2[j2])/2.0;
        }
            else
                result=(l1[j1]+l2[j2])/2.0;
        }

        */
        else{
            int num1,num2,num3,num4,res1,res2,res3;
            if(j1+1<l1.length-1)
                num1=l1[j1+1];
            else
                num1=100000000;
            if(j2+1<l2.length-1)
                num3=l2[j2+1];
            else
                num3=100000000;
            num2=l1[j1];
            num4=l2[j2];
            //get least two number from 4 number
            //the result have three cases so we just get the least combination
            res1=num1+num2;
            res2=num2+num4;
            res3=num3+num4;
            result=0.5*Math.min(Math.min(res1,res2),Math.min(res1,res3));
        }
        return result;
    }
    System.out.println(j2);
    if(l1[j1]>l2[j2])
        i2=i2+gethalf(k);
    else
        i1=i1+gethalf(k);
    //这边的k有问题
    k=k-gethalf(k);
    if(k<1)
        k++;
    return getk(l1,i1,l2,i2,k);
}
public int gethalf(int s) {
   if(s==1)
       return 1;
    if (s % 2 == 0)
        return s/2;
    else
        return (s+1)/2;
}
public static void main(String args[]){
    int[] l1={1};
    int[] l2={3,4,5,6,7,9};
    solution4 s =new solution4();
    //System.out.println(s.gethalf(5));
    System.out.println(s.findMedianSortedArrays(l1,l2));
}
}
