package Linear.CircularLinkedList;//package Linear.CircularLinkedList;
//
//public class CircularLinkedList {
//
//    //    reference the first node of LinkedList
//    private CircularLinkedListNode head;
//
//    //    reference the last node of LinkedList
//    private CircularLinkedListNode tail;
//
//    // Create an empty List
//    public CircularLinkedList() {
//        head = tail = null;
//    }
//
//    //  returns reference of first node
//    public CircularLinkedListNode getHead() {
//        return this.head;
//    }
//
//    // set first node reference as head
//    public void setHead(CircularLinkedListNode head) {
//        this.head = head;
//    }
//
//    //  returns reference of last node
//    public CircularLinkedListNode getTail() {
//        return this.head;
//    }
//
//    // set first node reference as head
//    public void setTail(CircularLinkedListNode head) {
//        this.head = head;
//    }
//
//    // Displayinf CircularLinkedList
//    public void display() {
//        // Reference of head node
//        CircularLinkedListNode i;
//        i = this.head;
//        System.out.println("[");
//        do {
//            if (i.next != null)
//                System.out.println(i.value + ", ");
//            else
//                System.out.println(i.value + "]");
//        } while (i != this.head);
//    }
//}
