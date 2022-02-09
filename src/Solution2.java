public class Solution2 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }
 /*   public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode result = new ListNode();
    int l1num= 0;
    int i=1;
        while (l1.next!=null) {
            l1num=l1.val*i+l1num;
            i=i*10;
            l1=l1.next;
        }
        i=1;
    int l2num= 0;
        while (l2.next!=null) {
            l2num=l2.val*i+l1num;
            i=i*10;
            l2=l2.next;
        }
    int sum=l1num+l2num;
    int length=(int)Math.log10(sum);
    int num=0;
    for(int j=length;j>0;j--){
        int number= (int)Math.pow(10,length);
        result.val=sum%number;
        result=result.next;
    }
        return result;
    }
*/
    public ListNode delete(ListNode first){
        ListNode temp=first;
        first=first.next;
        return temp;
    }
/*
 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
     ListNode dummyHead = new ListNode(0);
     ListNode p = l1, q = l2, curr = dummyHead;
     int carry = 0;
     while (p != null || q != null) {
         int x = (p != null) ? p.val : 0;
         int y = (q != null) ? q.val : 0;
         int sum = carry + x + y;
         carry = sum / 10;
         curr.next = new ListNode(sum % 10);
         curr = curr.next;
         //System.out.println(p.val);
         if (p != null) p = p.next;
         if (q != null) q = q.next;
        // System.out.println(l1.val);
     }
     if (carry > 0) {
         curr.next = new ListNode(carry);
     }
     return dummyHead.next;
     //这边就跳过第一个初始化的点了
 }

 */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode result = new ListNode();

        ListNode x=l1;
        ListNode y=l2;
        ListNode out=result;
        int carry=0;
        while(x!=null||y!=null){
            int p = (x != null) ? x.val : 0;
            int q = (y != null) ? y.val : 0;
            int sum=p+q+carry;
            int num=sum%10;
            carry=sum/10;
          //  \u000d System.out.println("Note:");
            //  out= new ListNode(num,out);
           // System.out.println(out.val);
           out.next=new ListNode(num);
            out=out.next;
            if(x!=null)x=x.next;
            if(y!=null)y=y.next;
        }
        if (carry > 0) {
            out.next = new ListNode(carry);
        }
        return result.next;
    }


    public static void main(String[] args){
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(4);
        l1=new ListNode(4,l1);
        l1=new ListNode(5,l1);
        l2 =new ListNode(6,l2);
        l2=new ListNode(5,l2);
        Solution2 s1= new Solution2();
        ListNode l5= s1.addTwoNumbers(l1,l2);
        while (l5!=null){
        System.out.println(l5.val);
        l5=l5.next;}
        ListNode l6=s1.delete(l1);
       // System.out.println(l6.val);
    }
}
