package grokking.reverselinkedlist;

public class ReverseSubList {
    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    //If values are given
    public static ListNode reverse(ListNode head, int p, int q){
        ListNode origHead = head;
        ListNode prev = null;
        ListNode sortPrev = null;
        ListNode sortEnd = null;
        boolean startFound = false;
        while((prev==null || prev.val!=q) && head!=null){
            ListNode next = head.next;
            if(head.val==p){
                sortPrev = prev;
                sortEnd = head;
                startFound = true;
            }

            if(startFound) {
                head.next = prev;
            }
            prev = head;
            head = next;
        }

        if(sortPrev!=null) {
            sortPrev.next = prev;
        }
        if(sortEnd!=null) {
            sortEnd.next = head;
        }
        return sortPrev!=null? origHead : prev ;
    }

    //if indexes are given

    public static ListNode reverse1(ListNode head, int p, int q){
        ListNode current = head;
        for(int i =1; i< p; i++){
            current = current.next;
        }
        ListNode nodeBeforeSort = current;
        ListNode prev =null;
        ListNode next = null;
        for(int i =1; i< q-p+1; i++){
             next = current.next;
             current.next = prev;
             prev = current;
             current = next;
        }
        if(nodeBeforeSort!=null){
            nodeBeforeSort.next = prev;
        }

        return null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);

        ListNode revHead = reverse(head, 2,8);

        while(revHead!=null){
            System.out.print(revHead.val + "->");
            revHead = revHead.next;
        }
    }
}
