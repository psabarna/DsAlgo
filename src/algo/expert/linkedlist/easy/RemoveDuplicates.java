package algo.expert.linkedlist.easy;

/**
 * Given the head of a sorted single linked list
 * Remove duplicates
 * Ex: input 1->2->2->3->4->4->5
 * output 1->2->3->4->5
 */
public class RemoveDuplicates {
    // This is an input class. Do not edit.
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
        // Write your code here.
        if(linkedList== null){
            return linkedList;
        }
        LinkedList prev = linkedList;
        LinkedList current = linkedList.next;
        while(current!=null){
            if(current.value == prev.value){
                prev.next = current.next;
            }else{
                prev = current ;
            }
            current = current.next;
        }
        return linkedList;
    }

    public static void main(String[] args) {

    }

}
