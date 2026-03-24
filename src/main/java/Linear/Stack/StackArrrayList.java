// Java program to implement Linear.Stack using ArrayList
package Linear.Stack;

import java.util.ArrayList;

// class that implements stack using ArrayList
public class StackArrrayList {
    // Declaring empty arrayList
    private ArrayList<Integer> stack;

    // Variable to store size of Linear.Stack
    int size;

    // Variable to store the top value of Linear.Stack (if Linear.Stack is empty then default value is -1)
    int top = -1;

    // Constructure to intilize size of Linear.Stack
    StackArrrayList(int size) {
        // Store the value of stack
        this.size = size;

        // Creating Linear.Stack(ArrayList) of Size = size
        this.stack = new ArrayList<>(size);
    }

    // method for checking stack is full or not
    public boolean isFull() {
        return stack.size() == size;
    }

    // method for checking stack is empty or not
    public boolean isEmpty() {
        return top == -1;
    }


    // method push an element in Linear.Stack
    public void push(int value) {
        // checking stack is full or not
        if (!isFull()) {
            stack.add(value);
        }
        else { // if stack is full
            System.out.println("Oops...Linear.Stack is full...");
        }
    }


    public int pop() {
        // checking stack isEmpty or not
        if (!isEmpty()) {

            return top;
        }
        else {
            System.out.println("Oops...Linear.Stack is empty");
            return -1;
        }
    }
}
