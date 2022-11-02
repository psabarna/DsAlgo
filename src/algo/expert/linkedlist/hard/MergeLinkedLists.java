package algo.expert.linkedlist.hard;

public class MergeLinkedLists {
    // This is an input class. Do not edit.
    public static class LinkedList {
        int value;
        LinkedList next;

        LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    //O(n+m) time | O(1) Space
    public static LinkedList mergeLinkedLists(LinkedList headOne, LinkedList headTwo) {

        LinkedList p1 = headOne;
        LinkedList p2 = headTwo;
        LinkedList merged = null;

        while(p1!=null && p2!=null){
            LinkedList small = null;
            if(p1.value<=p2.value){
                small = p1;
                p1= p1.next;
            }else{
                small = p2;
                p2 = p2.next;
            }
            if(merged!=null){
                merged.next = small;

            }
            merged=small;
        }
        if(p1!=null){
            merged.next= p1;
        }else if(p2!=null){
            merged.next= p2;
        }

        return headOne.value<= headTwo.value? headOne: headTwo;
    }

    public static LinkedList mergeLinkedLists2(LinkedList headOne, LinkedList headTwo) {

        recursiveMerge(headOne, headTwo, null);

        return headOne.value<= headTwo.value? headOne: headTwo;
    }

    public static void recursiveMerge(LinkedList headOne, LinkedList headTwo, LinkedList merged) {

        LinkedList p1 = headOne;
        LinkedList p2 = headTwo;

        if(p1!=null && p2!=null){
            LinkedList small = null;
            if(p1.value<=p2.value){
                small = p1;
                p1= p1.next;
            }else{
                small = p2;
                p2 = p2.next;
            }
            if(merged!=null){
                merged.next = small;

            }
            merged=small;
            recursiveMerge(p1, p2, merged);
        }else if(p1!=null){
            merged.next= p1;
        }else if(p2!=null){
            merged.next= p2;
        }


    }

    public static void main(String[] args) {
        LinkedList ll1 =  new LinkedList(2);
        ll1.next =  new LinkedList(6);
        ll1.next.next = new LinkedList(7);
        ll1.next.next.next = new LinkedList(8);

        LinkedList ll2 =  new LinkedList(1);
        ll2.next =  new LinkedList(3);
        ll2.next.next = new LinkedList(4);
        ll2.next.next.next = new LinkedList(5);
        ll2.next.next.next.next = new LinkedList(9);
        ll2.next.next.next.next.next = new LinkedList(10);
        LinkedList mergedHead = mergeLinkedLists2(ll1, ll2);
        while(mergedHead!=null){
            System.out.print(mergedHead.value +" ");
            mergedHead = mergedHead.next;
        }

    }
}
