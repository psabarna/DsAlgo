package algo.expert.linkedlist.hard;

public class ReverseLinkedList {


    public static LinkedList reverseLinkedList(LinkedList head) {
        LinkedList prev = null;
        LinkedList current = head;
        while(current!=null){
            LinkedList temp = current;
            current = current.next;
            temp.next = prev;
            prev = temp;
        }

        return prev;
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LinkedList head = new LinkedList(1);
        head.next = new LinkedList(2);
        head.next.next =  new LinkedList(3);
        head.next.next.next = new LinkedList(4);


        LinkedList reverse = reverseLinkedList(head);
        while(reverse!=null) {
            System.out.print(reverse.value+" ");
            reverse = reverse.next;
        }
    }
}
