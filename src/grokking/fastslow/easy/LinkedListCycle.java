package grokking.fastslow.easy;

public class LinkedListCycle {

    public static boolean hasCycle(ListNode head){
        ListNode sp = head;
        ListNode fp = head;
        while(fp!=null && fp.next!=null){
            fp = fp.next.next;
            sp = sp.next;
            if(fp==sp){
                return true;
            }

        }
        return false;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        System.out.println(hasCycle(head));
        head.next.next.next.next.next.next = head.next.next;
        System.out.println(hasCycle(head));

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println(hasCycle(head));

    }

    static class ListNode{
        int value;
        ListNode next;

        public ListNode(int value) {
            this.value = value;
        }
    }
}

