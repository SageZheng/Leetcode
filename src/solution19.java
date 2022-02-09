import java.util.Deque;
import java.util.LinkedList;

public class solution19 {
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
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(0, head);
            ListNode first = head;
            ListNode second = dummy;
            for (int i = 0; i < n; ++i) {
                first = first.next;
                System.out.println("delete once");
            }
            while (first != null) {
                first = first.next;
                second = second.next;
            }
            second.next = second.next.next;
            head=dummy.next;
            System.out.println(second.next.val);
            System.out.println("dummy.next.val"+dummy.next.val);
            System.out.println("print head");
            while(head!=null){
                System.out.print(head.val);
                head=head.next;
            }
            System.out.println("");
            return dummy.next;
        }
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        Deque<ListNode> stack = new LinkedList<ListNode>();
        ListNode cur = dummy;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        for (int i = 0; i < n; ++i) {
            stack.pop();
        }
        ListNode prev = stack.peek();
        prev.next = prev.next.next;
        ListNode ans = dummy.next;
        return ans;
    }

        public  static void main(String args[]){
            solution19 s= new solution19();
        ListNode l =new ListNode(5);
        l=new ListNode(4,l);
            l=new ListNode(3,l);
            l=new ListNode(2,l);
            l=new ListNode(1,l);
            s.removeNthFromEnd2(l,5);
            System.out.println("print head");
            while(l!=null){
                System.out.print(l.val);
                l=l.next;
            }
        }
}
