package Linear.DoublyLinkedList;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList dl = new DoublyLinkedList();
        int i = 0;
        dl.add(++i);
        dl.add(++i);
        dl.add(++i);
        dl.add(++i);
//        System.out.println(dl.getHead().value);
        dl.addAtTail(++i);
//        System.out.println(dl.getHead().value);
        dl.add(++i);
        dl.add(++i);
        dl.add(++i);
        dl.add(++i);

        DoublyNode node = dl.getHead();
        for (int j = 0; j < 5; j++) {
            System.out.println(node.value);
            node = node.next;
        }
        for (int j = 0; j < 5; j++) {
            node = node.previous;
            System.out.println(node.value);
        }
    }
}
