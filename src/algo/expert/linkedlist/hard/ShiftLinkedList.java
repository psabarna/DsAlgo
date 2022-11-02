package algo.expert.linkedlist.hard;

public class ShiftLinkedList {

    //O(n)  time| O(1) space
    public static LinkedList shiftLinkedList(LinkedList head, int k) {
        // Write your code here.
        int l=1;
        LinkedList tail = head;
        while(tail.next!=null){
            tail = tail.next;
            l+=1;
        }
        k = k%l;
        if(k ==0){
            return head;
        } else if(k>0){
            k= l-k;
        }else{
            k = k*-1;
        }
        LinkedList newTail = head;
        int i =1;
        while(i<k){
            newTail = newTail.next;
            i+=1;
        }
        LinkedList newHead = newTail.next;
        newTail.next = null;
        tail.next = head;



        return newHead;
    }

    static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            next = null;
        }
    }

    public static void main(String[] args) {
        LinkedList head = new LinkedList(1);
        head.next = new LinkedList(2);
        head.next.next = new LinkedList(3);
        head.next.next.next = new LinkedList(4);
        head.next.next.next.next = new LinkedList(5);

        LinkedList newHead = shiftLinkedList(head, 0);
        while(newHead!=null){
            System.out.print(newHead.value+" ");
            newHead =  newHead.next;
        }
    }

}
