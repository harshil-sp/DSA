package Linear.CircularQueue;

import java.util.ArrayList;

public class CircularQueue {
    private int size, front, rear;
    private ArrayList<Integer> queue = new ArrayList<>();

    // initialize the size of array and make front and rear to -1
    CircularQueue(int size) {
        this.size = size;
        this.front = this.rear = -1;
    }

    // function to number in Linear.CircularQueue
    public void enQueue(int number) {
        if ((front == 0 && rear == size - 1) || (front == rear + 1)) {
            System.out.println("Queue is full. You can't perform this operarion.");
        } else if (front == -1) {
            front = 0;
            rear = 0;
            queue.add(rear, number);
        } else if (rear == size - 1 && front != 0) {
            rear = 0;
            queue.set(rear, number);
        } else {
            rear += 1;
            if (front <= rear) {
                queue.add(rear, number);
            } else {
                queue.set(rear, number);
            }
        }
    }

    // function to delete from Queue
    public int deQueue() {
        int temp;
        if (front == -1) {
            System.out.print("Queue is Empty");
            return -1;
        }
        temp = queue.get(front);
        // for only one element
        if (front == rear) {
            front = -1;
            rear = -1;
        } else if (front == size - 1) {
            front = 0;
        } else {
            front = front + 1;
        }
        return temp;
    }

    // displaying queue
    public void displayQueue() {
        if (front == -1) {
            System.out.print("Queue is Empty");
        } else {
            if (rear >= front) {
                for (int i = front; i <= rear; i++) {
                    System.out.print(queue.get(i));
                    System.out.print(" ");
                }
                System.out.println();
            } else {
                for (int i = front; i < size; i++) {
                    System.out.print(queue.get(i));
                    System.out.print(" ");
                }
                for (int i = 0; i <= rear; i++) {
                    System.out.print(queue.get(i));
                    System.out.print(" ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        CircularQueue cq = new CircularQueue(5);
        cq.enQueue(2);
        cq.enQueue(3);
        cq.enQueue(4);
        cq.enQueue(5);
        cq.enQueue(6);
//        cq.enQueue(9);
        System.out.println("Queue Elements are below:");
        cq.displayQueue();
        System.out.println();
        System.out.println("Deleted Element : " + cq.deQueue());
        System.out.println("Deleted Element : " + cq.deQueue());
        System.out.println("Queue Elements are below:");
        cq.displayQueue();
        System.out.println();
        cq.enQueue(7);
        cq.enQueue(8);
        System.out.println("Queue Elements are below:");
        cq.displayQueue();
    }
}
