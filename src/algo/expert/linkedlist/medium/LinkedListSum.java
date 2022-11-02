package algo.expert.linkedlist.medium;

/**
 * Given two numbers in a linked list return a linked list representing their sum.
 * Ex: 2->4->7->1 (represents 1742) + 9->4->5(represents 549)
 * sums to 1->9->2->2(represents 2291)
 */
public class LinkedListSum {

    // This is an input class. Do not edit.
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static LinkedList sumOfLinkedLists1(LinkedList linkedListOne, LinkedList linkedListTwo) {
        // Write your code here.
        int residual = 0;
        LinkedList head = null;
        LinkedList tail = null;
        while (linkedListOne!=null && linkedListTwo!=null){
            int sum = residual + linkedListOne.value + linkedListTwo.value;
            residual = sum/10;
            LinkedList node = new LinkedList(sum%10);
            if(head ==null){
                head = node;
            }else{
                tail.next = node;
            }
            tail = node;

            linkedListOne = linkedListOne.next;
            linkedListTwo = linkedListTwo.next;
        }
        LinkedList listToIterate = null;
        if(linkedListOne!=null){
            listToIterate = linkedListOne;
        }else if(linkedListTwo!=null){
            listToIterate = linkedListTwo;
        }

        while(listToIterate!=null){
            int sum = residual + listToIterate.value ;
            residual = sum/10;
            LinkedList node = new LinkedList(sum%10);
            tail.next = node;
            listToIterate = listToIterate.next;
            tail = node;
        }
        if(residual>0){
            LinkedList node = new LinkedList(residual);
            tail.next = node;
        }

        return head;
    }

    public static LinkedList sumOfLinkedLists2(LinkedList linkedListOne, LinkedList linkedListTwo) {
        // Write your code here.
        int residual = 0;
        LinkedList head = null;
        LinkedList tail = null;
        while (linkedListOne!=null || linkedListTwo!=null){
            int sum = residual ;
            if(linkedListOne!=null){
                sum += linkedListOne.value;
                linkedListOne=linkedListOne.next;
            }
            if(linkedListTwo!=null){
               sum+=linkedListTwo.value;
               linkedListTwo = linkedListTwo.next;

            }

            residual = sum/10;
            LinkedList node = new LinkedList(sum%10);
            if(head ==null){
                head = node;
            }else{
                tail.next = node;
            }
            tail = node;

        }

        if(residual>0){
            LinkedList node = new LinkedList(residual);
            tail.next = node;
        }

        return head;
    }

    public static void main(String[] args) {
        LinkedList head1 = new LinkedList(0);
       head1.next = new LinkedList(0);
        head1.next.next = new LinkedList(0);
        head1.next.next.next = new LinkedList(5);

        LinkedList head2 = new LinkedList(9);
        /*head2.next = new LinkedList(4);
        head2.next.next = new LinkedList(5);*/

        LinkedList sum = sumOfLinkedLists2(head1, head2);
        while(sum!=null){
            System.out.print(sum.value+" ");
            sum = sum.next;
        }

    }


}
