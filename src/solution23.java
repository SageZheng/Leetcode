import java.util.PriorityQueue;

public class solution23 {
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
        //用最小堆做就可以
        class Status implements Comparable<Status> {
            int val;
            ListNode ptr;

            Status(int val, ListNode ptr) {
                this.val = val;
                this.ptr = ptr;
            }

            public int compareTo(Status status2) {
                return this.val - status2.val;
            }
        }

    PriorityQueue<Status> queue = new PriorityQueue<Status>();

    public ListNode mergeKLists(ListNode[] lists) {
        for (ListNode node: lists) {
            if (node != null) {
                queue.offer(new Status(node.val, node));
            }
        }
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while (!queue.isEmpty()) {
            Status f = queue.poll();
            tail.next = f.ptr;
            tail = tail.next;
            if (f.ptr.next != null) {
                queue.offer(new Status(f.ptr.next.val, f.ptr.next));
            }
        }
        return head.next;
    }
        public static void main(String args[]){
            solution23 s2=new solution23();
            ListNode l1=new ListNode(5);
            l1=new ListNode(4,l1);
            l1=new ListNode(1,l1);
            ListNode l2=new ListNode(4);
            l2=new ListNode(3,l2);
            l2=new ListNode(1,l2);
            ListNode l3=new ListNode(6);
            l3=new ListNode(1,l3);
            ListNode[] lists= new ListNode[3];
            lists[0]=l1;
            lists[1]=l2;
            lists[2]=l3;
           ListNode res=s2.mergeKLists(lists);
           // res=s2.mergeTwoLists(l1,l2);
            while(res!=null)
            {
                System.out.println(res.val);
                res=res.next;
            }
        }
    }

