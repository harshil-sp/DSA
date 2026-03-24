package Linear.SinglyLinkedList;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        SinglyLinkedList list1 = new SinglyLinkedList();

        list1.addToTail(1);
        list1.addToTail(1);
        list1.addToTail(2);
        list1.addToTail(3);
        list1.addToTail(3);

        SinglyLinkedList.deleteDuplicates(list1.getHead());
        list1.displayLinkedList();


    }
}
