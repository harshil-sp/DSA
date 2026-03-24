package Linear.DoublyLinkedList;

public class DoublyNode {
    // value which we want to store in node
    int value;

    // refernece variables wchich refers to the next and previous node
    DoublyNode previous, next;

    // Constructor to create node with specifies value and null reference nodes
    DoublyNode(int value) {
        this(value, null, null);
    }

    // Constructor to create node with specifies value and specified reference node
    DoublyNode(int value, DoublyNode previous, DoublyNode next) {
        this.value = value;
        this.previous = previous;
        this.next = next;
    }

}
