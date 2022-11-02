package algo.expert.linkedlist.veryhard;

public class ZipList {
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static LinkedList zipLinkedList(LinkedList linkedList) {
        // Write your code here.
        LinkedList linkedList1 = splitFromMiddle(linkedList);
        linkedList1 = reverse(linkedList1);
        merge(linkedList, linkedList1);
        return linkedList;
    }
    public static void merge(LinkedList ll1, LinkedList ll2) {
        if(ll2==null) {
            return;
        }
        LinkedList ll2Next = ll2.next;
        ll2.next= ll1.next;
        ll1.next= ll2;
        merge(ll2.next, ll2Next);
    }

    public static LinkedList splitFromMiddle(LinkedList head) {
        if(head==null || head.next==null) {
            return head;
        }
        LinkedList prev = null;
        LinkedList fp = head;
        LinkedList sp = head;
        while(fp!=null && fp.next!=null) {
            fp= fp.next.next;
            prev = sp;
            sp = sp.next;
        }
        if(fp!=null) {
            prev = sp;
            sp = sp.next;
        }
        prev.next = null;
        return sp;
    }

    public static LinkedList reverse(LinkedList head) {
        LinkedList prev = head;
        LinkedList curr = head;
        while(curr!=null) {
            LinkedList newCurr = curr.next;
            curr.next = prev;
            prev = curr;
            curr = newCurr;
        }
        return prev;
    }



    public static void main(String[] args) {
        LinkedList head = new LinkedList(1);
        head.next = new LinkedList(2);
        head.next.next = new LinkedList(3);
        head.next.next.next = new LinkedList(4);
        head.next.next.next.next = new LinkedList(5);
        LinkedList zipHead = zipLinkedList(head);
        while(zipHead!=null){
            System.out.println(zipHead.value);
            zipHead =  zipHead.next;
        }
    }

}
