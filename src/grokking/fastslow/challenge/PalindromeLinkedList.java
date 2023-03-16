package grokking.fastslow.challenge;

public class PalindromeLinkedList {

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

    public static boolean isPalindrome(ListNode head){
        ListNode middle = findMiddle(head);
        ListNode revHead = reverse(middle);

        while(revHead!=null){
            if(head.value!=revHead.value){
                return false;
            }
            revHead= revHead.next;
            head= head.next;
        }
        return true;
    }
    public static ListNode findMiddle(ListNode head){
        ListNode sp = head;
        ListNode fp = head;
        while(fp!=null && fp.next!=null){
            fp = fp.next.next;
            sp = sp.next;
        }
        //to get next of middle in case odd numbers
        if(fp!=null){
            sp=sp.next;
        }
        return sp;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        //System.out.println(isPalindrome(head));

        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);

        System.out.println(isPalindrome(head));
    }

    static class ListNode{
        int value;
        ListNode next;

        public ListNode(int value) {
            this.value = value;
        }
    }

}
