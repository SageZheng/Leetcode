public class Solution83 {
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

//public ListNode deleteDuplicates(ListNode head) {
//    if (head == null) {
//        return head;
//    }
//
//    ListNode cur = head;
//    while (cur.next != null) {
//        if (cur.val == cur.next.val) {
//            cur.next = cur.next.next;
//        } else {
//            cur = cur.next;
//        }
//    }
//
//    return head;
//}
    public ListNode deleteDuplicate(ListNode head){
        if(head==null)
            return null;
        ListNode out=head;
        while(out.next!=null)
        {
            if(out.val==out.next.val){
                out.next=out.next.next;
            }
            else
                out=out.next;
        }
        return head;
    }
}
