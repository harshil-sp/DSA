package NonLinear.Tree;

// Implementing Binary search Tree
public class BinarySearchTree {

    // root node for bst
    private Node root = null;

    // default constructor
    public BinarySearchTree() {
    }

    // constructor that sets root node value
    public BinarySearchTree(int rootNodeValue) {
        root = new Node(rootNodeValue);
    }

    // public function to insert a node
    public void insert(int value) {
        insertNode(root, value);
    }

    // insert function which inserts a node in bst
    private void insertNode(Node node, int key) {
        if (node == null) {
            System.out.println("---1");
            node = new Node(key);
        }
        else if (key < node.vlaue) {
            System.out.println("----2");
            insertNode(node.left, key);
        }
        else if (key > node.vlaue) {
            System.out.println("---3");
            insertNode(node.right, key);
        }
    }


    public void inorder() {
        printInorder(root);
    }

    private void printInorder(Node root) {
        if (root != null) {
            printInorder(root.left);
            System.out.println(root.vlaue + " ");
            printInorder(root.right);
        }
    }
}
