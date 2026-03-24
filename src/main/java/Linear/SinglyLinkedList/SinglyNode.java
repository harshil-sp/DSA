package Linear.SinglyLinkedList;

public class SinglyNode {
    //    Value which we want to store in a Node
    int value;
    //    Reference variable which referes to the next Node
    SinglyNode next;

    //    Constructor to create node with specifies value and null reference node
    SinglyNode(int value) {
        this(value, null);
    }

    //    Constructor to create node with specifies value and specified reference node
    SinglyNode(int value, SinglyNode next) {
        this.value = value;
        this.next = next;
    }
}
