public class Solution24 {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int n){
            this.val=n;
        }
        ListNode(int val,ListNode next){
            this.val=val;
            this.next=next;
        }
    }
        public ListNode swapPairs(ListNode head) {
        if(head==null)
            return null;
            ListNode cur = new ListNode(-1,head);
            ListNode out = cur;
            ListNode temp = new ListNode();
            while(cur.next.next!=null){
                temp=cur.next;
                cur.next=cur.next.next;
                cur=cur.next;
                temp.next=cur.next;
                cur.next=temp;
                cur=cur.next;
                if(cur.next==null)
                    break;
            }
            return out.next;
        }
        public static void main(String[] args){
        Solution24 s = new Solution24();
        ListNode head= new ListNode(4);
        head=new ListNode(3,head);
        head = new ListNode(2,head);
        //head=new ListNode(1,head);
        System.out.println(s.swapPairs(head).val);
        }
}
