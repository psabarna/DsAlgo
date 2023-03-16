package grokking.fastslow.easy;

public class LinkedListCycleLength {

    public static int getCycleLength(ListNode head){
        ListNode sp = head;
        ListNode fp = head;

        while(fp!=null && fp.next!=null){
            fp = fp.next.next;
            sp = sp.next;
            if(fp==sp){
                return calculateCycleLength(sp);
            }

        }
        return 0;
    }

    public static int calculateCycleLength(ListNode meet){
        ListNode current = meet;
        int length = 0;
        do{
            current = current.next;
            length+=1;
        }while(current!=meet);
        return length;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        System.out.println(getCycleLength(head));

        head.next.next.next.next.next.next = head.next.next;
        System.out.println(getCycleLength(head));

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println(getCycleLength(head));

    }

    static class ListNode{
        int value;
        ListNode next;

        public ListNode(int value) {
            this.value = value;
        }
    }
}
