package Linear.SinglyLinkedList;

import java.util.ArrayList;

public class SinglyLinkedList {

    //    reference the first node of LinkedList
    private SinglyNode head;

    //    reference the last node of LinkedList
    private SinglyNode tail;

    //    Create an empty LinkedList
    public SinglyLinkedList() {
        head = tail = null;
    }

    //    returns reference of first node
    public SinglyNode getHead() {
        return head;
    }

    //    set first node reference as head
    public void setHead(SinglyNode head) {
        this.head = head;
    }

    //    returns reference of last node
    public SinglyNode getTail() {
        return tail;
    }

    //    set last node reference as tail
    public void setTail(SinglyNode tail) {
        this.tail = tail;
    }

    //    return's the element at provided index
    public int getValue(int index) {
        SinglyNode temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.value;
    }

    //    returns true if LinkedList is empty
    public boolean isEmpty() {
        return head != null;
    }

    //    adds a node at the fornt of the LnkedList
    public void addToHead(int value) {
//        creates a new node set it as a head, and set previous head as a next node
        head = new SinglyNode(value, head);
        if (tail == null) {
            tail = head;
        }
    }

    //    adds a node at last of Linkedlist
    public void addToTail(int value) {
//        if LinkedList is not empty
        if (isEmpty()) {
//            creates a new Node and set it to tail's next
            tail.next = new SinglyNode(value);
//            now set newly created node as a tail
            tail = tail.next;
        }
//        if linkedList is empty then head and tail is same
        else head = tail = new SinglyNode(value);
    }

    //    adds a node in middle of the LinkedList (at specified location)
    public void addAt(int value, int index) {
//        if we want to add a node at head
        if (index == 0) {
            this.addToHead(value);
        } else {
//        creating a new node which we want to add
            SinglyNode newNode = new SinglyNode(value);
//        create a copy of head and interate overa linkedList to rich that postion where we want to add a node
            SinglyNode position = head;
            for (int i = 0; i < index - 1; i++) {
                position = position.next;
            }
//        set the newNode in middle of LinkedList
            newNode.next = position.next;
            position.next = newNode;
        }
    }

    //    adds a node in middle of the LinkedList after specified location
    public void addAfter(int value, int index) {
        this.addAt(value, index + 1);
    }


    //    Displying the LinkedList
    public void displayLinkedList() {
        if (isEmpty()) {   // if list is not empty then and then this operation performed
            System.out.print("[");
            SinglyNode i;
            for (i = this.head; i.next != null; i = i.next) {
                System.out.print(i.value + " , ");
            }
            System.out.print(i.value);
            System.out.println("]");
        } else {  // if list is empty
            System.out.println("List is Empty. You can't perform this operation...");
        }

    }

    //    checks the particular element is in LinkedList or not
    public boolean isInList(int value) {
        SinglyNode i;
        for (i = head; i.next != null; i = i.next) {
            if (i.value == value) return true;
        }
        return i.value == value;
    }

    //    delete the node which is at i'th position
    public void delete(int index) {
        SinglyNode node = this.head;
        if (isEmpty()) {   // if list is not empty then and then this operation performed
            if (index == 0) {
                head = head.next;
            } else {
                for (int i = 0; i < index - 1; i++) {
                    node = node.next;
                }
                node.next = node.next.next;
            }
        } else {  // if list is empty
            System.out.println("List is Empty. You can't perform this operation...");
        }
    }

    //    delete the first node of LinkedList
    public void deleteAtFront() {
        if (isEmpty()) { // if list is not empty then and then this operation performed
            // if only one node is present in LinkedList
            if (head == tail) head = tail = null;
                // chnge the reference of head and the first node will be deleted
            else head = head.next;
        } else    // if list is empty
            System.out.println("List is Empty. You can't perform this operation...");
    }

    //    delete the last node of LinkedList
    public void deleteAtLast() {
        if (isEmpty()) {   // if list is not empty then and then this operation performed
            // if only one node is present in LinkedList
            if (head == tail) head = tail = null;
            else {
                SinglyNode i;
                for (i = this.head; i.next != tail; i = i.next) ;
                tail = i;
                tail.next = null;
            }
        } else    // if list is empty
            System.out.println("List is Empty. You can't perform this operation...");
    }

    // to search element in LinkedList
    public int search(int value) {
        int index = 0;
        for (SinglyNode i = this.head; i.value != value; i = i.next) {
            index++;
        }
//        rerturn's the index of that elelment
        return index + 1;
    }

    //    move an element at head
    public void moveToHead(int value) {
        if (isInList(value)) {
            SinglyNode i, j = null;
            for (i = this.head; i.value != value; i = i.next) {
                j = i;
            }
            if (j == null) System.out.println("element is already at first position");
            else {
                j.next = i.next;
                i.next = head;
                head = i;
            }
        } else {
            System.out.println("element is not in the list...");
        }
    }

    //    return's the length of LinkedList
    public int length() {
        int length = 0;
        for (SinglyNode i = head; i != null; i = i.next) {
            length++;
        }
        return length;
    }

    //    return's the sum of all element in a linkedList
    public int sum() {
        int sum = 0;
        for (SinglyNode i = head; i != null; i = i.next) {
            sum += i.value;
        }
        return sum;
    }

    //    return's the maximum element in a LinkedList
    public int maximum() {
        int max = Integer.MIN_VALUE;
        for (SinglyNode i = head; i != null; i = i.next) {
            max = Math.max(max, i.value);
        }
        return max;
    }

    //    return's the maximum element in a LinkedList
    public int minimum() {
        int min = Integer.MAX_VALUE;
        for (SinglyNode i = head; i != null; i = i.next) {
            min = Math.min(min, i.value);
        }
        return min;
    }

    //    reverse the LinkedList
    public void reverse() {
//        creating Node's for iteraring
        SinglyNode p = this.head, q = null, r = null;
        tail = this.head; // because after reverse LinkedList head become tail
//        iterating over a linkedlist
        while (p != null) {
//            Sliding nodes to next node
            r = q;
            q = p;
            p = p.next;
            q.next = r; // chnage the links of node
        }
//        after reverse q node becomwe head
        head = q;
    }


    //    merge two sorted linkedlist in sorted linkedlist
    public SinglyNode merge(SinglyNode head1, SinglyNode head2) {

        SinglyNode newMergeListHead, newMergeListTail;
        int i = 0;
        if (head1.value <= head2.value) {
            newMergeListHead = newMergeListTail = head1;
            // System.out.println("head1 added head1.val = "+ head1.val+ "  newMergeListTail.val = " + newMergeListTail.val + "\t head1.next.val = " + head1.next.val);
            head1 = head1.next;
            newMergeListTail.next = null;
        } else {
            newMergeListHead = newMergeListTail = head2;
            // System.out.println("head2 added head1.val = "+ head2.val+ "  newMergeListTail.val = " + newMergeListTail.val + "\t head2.next.val = " + head2.next.val);
            head2 = head2.next;
            newMergeListTail.next = null;
        }
        while (head1 != null && head2 != null) {
            if (head1.value <= head2.value) {
                newMergeListTail.next = head1;
                // System.out.println("head1 added head1.val = "+ head1.val+ "  newMergeListTail.val = " + newMergeListTail.val + "\t head1.next.val = " + head1.next.val);
                newMergeListTail = head1;
                head1 = head1.next;
                newMergeListTail.next = null;
            } else {
                newMergeListTail.next = head2;
                // System.out.println("head2 added head1.val = "+ head2.val+ "  newMergeListTail.val = " + newMergeListTail.val + "\t head2.next.val = " + head2.next.val);
                newMergeListTail = head2;
                head2 = head2.next;
                newMergeListTail.next = null;
            }
        }
        if (head1 != null) {
            newMergeListTail.next = head1;
        } else {
            newMergeListTail.next = head2;
        }
        return newMergeListHead;
    }

    // remove the nth node from the end of the list and return its head.
    public static SinglyNode removeNthFromEnd(SinglyNode head, int n) {
        SinglyNode mainHead = new SinglyNode(0);
        mainHead.next = head;
        SinglyNode nthNode = mainHead;

        if (head.next == null) {
            head = null;
            return head;
        }

        for (int i = 1; i < n; i++)
            head = head.next;

        while (head.next != null) {
            head = head.next;
            nthNode = nthNode.next;
        }
        nthNode.next = nthNode.next.next;
        return mainHead.next;
    }

    public SinglyNode mergeKLists(SinglyNode[] lists) {
        SinglyNode newList = new SinglyNode(0);
        ArrayList<Integer> list = new ArrayList<>();

        for (SinglyNode singlyNode : lists) {
            while (singlyNode != null) {
                list.add(singlyNode.value);
                singlyNode = singlyNode.next;
            }
        }

//        Collections.sort(list);

        // insertion sort
        for (int i = 1; i < list.size(); i++) {
            int key = list.get(i);
            int j = i - 1;
            while (j >= 0 && (list.get(j) > key)) {
                list.set(j + 1, list.get(j));
                j = j - 1;
            }
            list.set(j + 1, key);
        }

        for (Integer integer : list) {
            SinglyNode newNode = new SinglyNode(integer);
            newList.next = newNode;
            newNode.next = null;
        }

        return newList.next;
    }

    public static SinglyNode deleteDuplicates(SinglyNode head) {
        SinglyNode newHead = head;

        if (head == null || head.next == null)
            return head;

        while (head.next != null) {
            if (head.value == head.next.value) {
                head.next = head.next.next;
            }
            head = head.next;
        }

        return newHead;
    }
}
