public class Solution61 {
    public static class ListNode {
        int val;
       ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val,ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null)
            return head;
        int length=1;
        ListNode ret=head;
        while(head.next!=null)
        {
            length+=1;
            head=head.next;
        }
        int add=length-k%length;
        if(add==length)
            return ret;
        head.next=ret;
        while (add-->0){
            head=head.next;
        }
        ret=head.next;
        head.next=null;
        return ret;

    }
}
