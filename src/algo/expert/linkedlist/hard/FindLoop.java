package algo.expert.linkedlist.hard;

import java.util.HashSet;
import java.util.Set;

public class FindLoop {
    //O(n) time || O(n) space
    public static LinkedList findLoop1(LinkedList head) {
        // Write your code here.

        Set<LinkedList> visited = new HashSet<>();
        while (head!=null ){
            if(visited.contains(head)){
                return head;
            }
            visited.add(head);
            head= head.next;

        }

        return null;
    }

    //O(n ) time | O(1) space
    public static LinkedList findLoop2(LinkedList head) {
        // Write your code here.

        LinkedList sp = head;
        LinkedList fp = head;
        LinkedList meetingPoint = null;
        while (fp!=null && fp.next!=null ){
            fp = fp.next.next;
            sp = sp.next;
           if(fp == sp){
               meetingPoint = sp;
               break;
           }

        }

        if(meetingPoint==null){
            return null;
        }
        while(meetingPoint!=head){
            meetingPoint= meetingPoint.next;
            head = head.next;
        }
        return  meetingPoint;
    }

    public static void main(String[] args) {
        LinkedList head = new LinkedList(0);
        head.next = new LinkedList(1);
        head.next.next = new LinkedList(2);
        head.next.next.next = new LinkedList(3);
        LinkedList loopNode = new LinkedList(4);
        head.next.next.next.next = loopNode;
        loopNode.next = new LinkedList(5);
        loopNode.next.next = new LinkedList(6);
        loopNode.next.next.next = new LinkedList(7);
        loopNode.next.next.next.next = new LinkedList(8);
        loopNode.next.next.next.next.next = new LinkedList(9);
        loopNode.next.next.next.next.next.next = loopNode;

        LinkedList loop = findLoop2(head);
        if(loop!=null) {
            System.out.println(loop.value);
        }

    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }
}
