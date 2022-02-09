public class solution21 {
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
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode prehead = new ListNode(-1);

            ListNode prev = prehead;
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    prev.next = l1;
                    l1 = l1.next;
                } else {
                    prev.next = l2;
                    l2 = l2.next;
                }
                prev = prev.next;
            }

            // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
            prev.next = l1 == null ? l2 : l1;

            return prehead.next;
        }
    // write it myself,next指针用的还是有问题
    public ListNode merge(ListNode l1, ListNode l2){
        ListNode result = new ListNode(-1);
        ListNode out = result;
        while(l1!=null&&l2!=null){
            if(l1.val>l2.val){
                out.val=l2.val;
                l2=l2.next;
            }
            else {
                out.val=l1.val;
                l1=l1.next;
            }
            out=out.next;
        }
        out=l1!=null? l1:l2;
        return result.next;
    }
        // this is wrong, and have huge errors
    public ListNode TwoLists(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode();
        while (l1 != null || l2 != null) {
            if(l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    prev = new ListNode(l1.val, prev);
                    l1 = l1.next;
                } else {
                    prev = new ListNode(l2.val, prev);
                    l2 = l2.next;
                }
            }
            else {
                if(l1==null){
                    prev = new ListNode(l2.val, prev);
                    l2 = l2.next;
                }
                else{
                    prev = new ListNode(l1.val, prev);
                    l1 = l1.next;
                }
            }
        }

        return prev;
    }
public void printList(ListNode l1){
        ListNode l2=l1;
        while(l2!=null){
            System.out.print(l2.val+"+");
            l2=l2.next;
        }
}
    public static void main(String[] args){
        solution21 s = new solution21();
        ListNode l1 = new ListNode(4);
        l1 = new ListNode(2,l1);
        l1 = new ListNode(1,l1);
        ListNode l2 = new ListNode(4);
        l2 = new ListNode(3,l2);
        l2 = new ListNode(2,l2);
      s.printList(s.mergeTwoLists(l1,l2));
        System.out.println("Next Algorithm:");
        s.printList(s.merge(l1,l2));
    }
}
