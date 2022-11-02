package algo.expert.linkedlist.easy;

/**
 * Create various methods to construct a doubly linked list
 */
public class ConstructLinkedList {

    static class DoublyLinkedList {
        public Node head;
        public Node tail;

        public void setHead(Node node) {
            // Write your code here.
            if(head!=null){
                insertBefore(head, node);
            }else{
                head = node;
                tail = node;
            }
        }

        public void setTail(Node node) {
            // Write your code here.

            if(tail!=null){
                insertAfter(tail, node);
            }else{
                head = node;
                tail = node;
            }
        }

        public void insertBefore(Node node, Node nodeToInsert) {
            // Write your code here.
            if(head == nodeToInsert && nodeToInsert ==tail){
                return;
            }
            if(node.prev!=null){
                nodeToInsert.prev = node.prev;
                node.prev.next = nodeToInsert;
            }
            node.prev = nodeToInsert;
            nodeToInsert.next = node;


        }

        public void insertAfter(Node node, Node nodeToInsert) {
            // Write your code here.
            if(head == nodeToInsert && nodeToInsert ==tail){
                return;
            }
            if(node.next!=null){
                nodeToInsert.next = node.next;
                node.next.prev = nodeToInsert;
            }
            nodeToInsert.prev = node;
            node.next = nodeToInsert;

        }

        public void insertAtPosition(int position, Node nodeToInsert) {

            if(head ==null){
                setHead(nodeToInsert);
            }

            int pos =1;
            Node current = head;
            while(pos++==position && current!=null){
                current=current.next;
            }
            if(current==null){
                setTail(nodeToInsert);
            }else{
                insertBefore(current, nodeToInsert );
            }

        }

        public void removeNodesWithValue(int value) {
            // Write your code here.
            Node current = head;
            while(current!=null && current.value !=value){
                current= current.next;
            }
            remove(current);
        }

        public void remove(Node node) {
            // Write your code here.
            if(node!=null){
                if(node==tail){
                    tail = node.prev;
                }
                if(node == head){
                    head = node.next;
                }

                if(node.prev!=null){
                    node.prev.next = node.next;
                }
                if(node.next!=null){
                    node.next.prev = node.prev;
                }

                node.prev=null;
                node.next = null;

            }

        }

        public boolean containsNodeWithValue(int value) {
            // Write your code here.
            Node current = head;
            while(current!=null){
                if(current.value == value){
                    return true;
                }
                current = current.next;
            }
            return false;
        }
    }

    // Do not edit the class below.
    static class Node {
        public int value;
        public Node prev;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}
