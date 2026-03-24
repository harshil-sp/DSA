package Linear.DoublyLinkedList;

public class DoublyLinkedList {

    // node that refers to the head node of the list
    private DoublyNode head;

    // node that refers to the last node of the list
    private DoublyNode tail;

    // creates an empty DoublyLinkedList
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    // creates an DoublyLinkedList with specified node
    public DoublyLinkedList(DoublyNode node) {
        if (this.head == null) {
            this.head = this.tail = node;
        } else {
            node.next = this.head;
            this.head = node;
        }
    }

    // to get the head node of the linst
    public DoublyNode getHead() {
        return this.head;
    }

    // add node at the end of the list
    public void add(int value) {
        if (this.head == null) {
            this.head = new DoublyNode(value);
            this.tail = this.head;
        } else {
            DoublyNode newNode = new DoublyNode(value);
            this.tail.next = newNode;
            newNode.previous = this.tail;
            this.tail = newNode;
        }
    }

    // add a head node at head
    public void addAtHead(int value) {
        if (this.head == null) {
            this.head = new DoublyNode(value);
            this.tail = this.head;
        } else {
            DoublyNode newNode = new DoublyNode(value);
            newNode.next = this.head;
            this.head.previous = newNode;
            this.head = newNode;
        }
    }

    // add a head node at head
    public void addAtTail(int value) {
        // add function already adds the elemnt at last of list
        this.add(value);
    }

    // print the doublyLinkedList
    public void printDoublyLinkedList() {
        DoublyNode newNode = this.head;
        System.out.print("[");
        while (newNode.next != null) {
            System.out.print(newNode.value + ", ");
            newNode = newNode.next;
        }
        System.out.println(newNode.value + "]");
    }


}
