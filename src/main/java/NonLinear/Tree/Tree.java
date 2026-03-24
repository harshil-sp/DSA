package NonLinear.Tree;

import java.util.Scanner;

public class Tree {
    public static Node create() {
        Node temp = new Node();
        int number;
        System.out.println("Enter value(-1 for no node): ");
        number = new Scanner(System.in).nextInt();
        if (number == -1)
            return null;
        else {
            temp.vlaue = number;
            System.out.println("Enter left child of " + temp.vlaue + ": ");
            temp.left = create();
            System.out.println("Enter right child of " + temp.vlaue + ": ");
            temp.right = create();
            return temp;
        }
    }

    // pre order traversal
    public static void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.vlaue + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    // inorder traversal
    public static void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.vlaue + " ");
            inOrder(node.right);
        }
    }

    // post order traversal
    public static void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.vlaue + " ");
        }
    }

    // function that finds predecessor of a node
    public static Node predecessor(Node node) {
        if (node.left != null)
            return predecessor(node.left);
        else
            return node;
    }

    // function that finds successor of a node
    public static Node successor(Node node) {
        if (node.right != null)
            return successor(node.right);
        else
            return node;
    }

    // count the leaf nodes
    public static int countLeaf(Node node) {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null)
            return 1;
        else
            return countLeaf(node.left) + countLeaf(node.right);
    }
}
