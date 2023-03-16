package grokking.fastslow.easy;

public class MiddleOfLinkedList {

    public static ListNode findMiddle(ListNode head){
        ListNode sp = head;
        ListNode fp = head;
        while(fp!=null && fp.next!=null){
            fp = fp.next.next;
            sp = sp.next;
        }
        return sp;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(findMiddle(head).value);

        head.next.next.next.next.next = new ListNode(6);
        System.out.println(findMiddle(head).value);

        head.next.next.next.next.next.next = new ListNode(7);
        System.out.println(findMiddle(head).value);

    }

    static class ListNode{
        int value;
        ListNode next;

        public ListNode(int value) {
            this.value = value;
        }
    }
}
