package NonLinear.Tree;

public class Node {
    int vlaue;
    Node left, right;

    public Node() {
    }

    public Node(int value) {
        this.vlaue = value;
    }

    public int getValue() {
        return this.vlaue;
    }
}
