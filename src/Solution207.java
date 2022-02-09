public class Solution207 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int n) {
            this.val = n;
        }

        ListNode(int val,ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
//    public ListNode reverseList(ListNode head) {
//        ListNode prev =null;
//        ListNode curr=head;
//        while(curr!=null){
//            ListNode next = curr.next;
//            curr.next=prev;
//            prev=curr;
//            curr=next;
//        }
//        return prev;
//    }
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode newHead= reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return newHead;
    }
}
