package grokking.fastslow.challenge;

public class ReArrangeLinkedList {
    public static ListNode reverse(ListNode head){
        ListNode prev = null;
        while(head!=null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static void refactor(ListNode head){
        ListNode middle = findMiddle(head);
        ListNode revHead = reverse(middle);

        while(revHead!=null && head!=null){
            ListNode newRevHead = revHead.next;
            ListNode newHead = head.next;

            head.next = revHead;
            revHead.next= newHead;

            revHead = newRevHead;
            head= newHead;
        }

    }
    public static ListNode findMiddle(ListNode head){
        ListNode sp = head;
        ListNode fp = head;
        ListNode spPrev = null;
        while(fp!=null && fp.next!=null){
            fp = fp.next.next;
            spPrev = sp;
            sp = sp.next;
        }
        //to get next of middle in case odd numbers
        if(fp!=null){
            spPrev = sp;
            sp=sp.next;
        }
        if(spPrev!=null){
            spPrev.next=null;
        }
        return sp;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        //System.out.println(isPalindrome(head));

        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        refactor(head);
        while(head!=null) {
            System.out.print(head.value + "->");
            head = head.next;
        }
    }
    static class ListNode{
        int value;
        ListNode next;

        public ListNode(int value) {
            this.value = value;
        }
    }

}
