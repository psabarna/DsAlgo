package algo.expert.linkedlist.veryhard;

import java.util.HashMap;
import java.util.Map;

/**
 * Implement LRU
 */
public class LRUImplementation {

    static class LRUCache {
        int maxSize;
        Map<String, DoublyLinkedListNode> map = new HashMap<>();
        DoublyLinkedList lru = new DoublyLinkedList();

        public LRUCache(int maxSize) {
            this.maxSize = maxSize > 1 ? maxSize : 1;
        }

        public void insertKeyValuePair(String key, int value) {
            // Write your code here.
            if (map.size() >= maxSize) {
                //remove tail
                String tailKey = lru.tail.key;
                lru.removeTail();
                map.remove(tailKey);
            }
            //add to head
            DoublyLinkedListNode node =new DoublyLinkedListNode(key, value);
            lru.setHead(node);
            map.put(key, node);
        }

        //This does not update lru
        public LRUResult getValueFromKey(String key) {
            // Write your code here.
            if (map.containsKey(key)) {
                //update Head
                lru.updateHead(map.get(key));
                return new LRUResult(true, map.get(key).value);
            }
            return new LRUResult(false, 0);
        }

        public String getMostRecentKey() {
            if (lru.head != null) {
                return lru.head.key;
            }
            return "";
        }
    }

    static class DoublyLinkedList {
        DoublyLinkedListNode head;
        DoublyLinkedListNode tail;

        public void removeTail() {
            if (tail != null) {
                if (tail == head) {
                    head = null;
                    tail = null;
                } else {
                    DoublyLinkedListNode currTail = tail;
                    tail = currTail.prev;
                    tail.next = null;
                    currTail.prev = null;
                }
            }
        }

        public void setHead(DoublyLinkedListNode head) {
            if(head==this.head){
                return;
            }
            if (this.head == null) {
                this.head = head;
                this.tail = head;
            } else {
                head.next = this.head;
                this.head.prev = head;
                this.head = head;

            }

        }
        public void updateHead(DoublyLinkedListNode newHead){
            if(newHead== head){
                return;
            }
            if(newHead==tail){
                removeTail();
                setHead(newHead);
            }else {
                newHead.prev.next = newHead.next;
                newHead.next.prev = newHead.prev;
                newHead.prev = null;
                newHead.next = head;
                head.prev = newHead;
                head = newHead;
            }

        }

    }

    static class DoublyLinkedListNode {
        String key;
        int value;
        DoublyLinkedListNode prev = null;
        DoublyLinkedListNode next = null;

        public DoublyLinkedListNode(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    static class LRUResult {
        boolean found;
        int value;

        public LRUResult(boolean found, int value) {
            this.found = found;
            this.value = value;
        }
    }

    public static void main(String[] args) {

        LRUCache lruCache = new LRUCache(3);
        lruCache.insertKeyValuePair("b", 2);
        lruCache.insertKeyValuePair("a", 1);
        lruCache.insertKeyValuePair("c", 3);
        System.out.println(lruCache.getMostRecentKey() == "c");
        System.out.println(lruCache.getValueFromKey("a").value == 1);
        System.out.println(lruCache.getMostRecentKey() == "a");
        lruCache.insertKeyValuePair("d", 4);
        var evictedValue = lruCache.getValueFromKey("b");
        System.out.println(evictedValue == null || evictedValue.found == false);
        lruCache.insertKeyValuePair("a", 5);
        System.out.println(lruCache.getValueFromKey("a").value == 5);


    }
}
