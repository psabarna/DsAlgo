package algo.expert.linkedlist.veryhard;

public class Pallindrome {
    // This is an input class. Do not edit.
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static LinkedList findMiddle(LinkedList head){
        if(head==null || head.next==null){
            return  head;
        }

        LinkedList sp = head;
        LinkedList fp = head;
        while(fp!=null && fp.next!=null){
            fp = fp.next.next;
            sp = sp.next;
        }
        //this will give next of middle node in case of odd number of nodes
        if(fp!=null){
            sp = sp.next;
        }
        return sp;
    }
    public static LinkedList reverse(LinkedList head){
        LinkedList prev = null;
        LinkedList current = head;
        while(current!=null){
            LinkedList newCurr = current.next;
            current.next = prev;
            prev = current;
            current = newCurr;
        }
        return prev;
    }

    public static boolean linkedListPalindrome(LinkedList head) {
        LinkedList mid = findMiddle(head);
        LinkedList revHead = reverse(mid);
        while(head!=null && revHead!=null){
            if(head.value!=revHead.value){
                return false;
            }
            head = head.next;
            revHead =  revHead.next;
        }
        return true;
    }

    //using recursion
    public static boolean linkedListPalindrome1(LinkedList head) {
        LinkedList mid = findMiddle(head);
        LinkedList revHead = reverse(mid);
       return isValueEqual(head, revHead);
    }

    public static boolean isValueEqual(LinkedList head1, LinkedList head2) {
        if(head1==null || head2==null){
            return true;
        }

        if(head1.value!=head2.value){
            return false;
        }

       return isValueEqual(head1.next, head2.next);
    }

    public static void main(String[] args) {
        LinkedList head = new LinkedList(1);
        head.next = new LinkedList(2);
        head.next.next = new LinkedList(2);
        head.next.next.next = new LinkedList(1);
       // head.next.next.next.next = new LinkedList(1);
        /*System.out.println(findMiddle(head).value);
        LinkedList reverse = reverse(head);
        while(reverse!=null){
            System.out.println(reverse.value);
            reverse =  reverse.next;
        }
        */
        System.out.println(linkedListPalindrome1(head));
    }
}
