package EightTrees.BinaryTrees;


import java.util.Scanner;

class BinaryTree {
    private Node root;

    public void populate(Scanner sc) {
        System.out.println("Enter the root Node: ");
        int value = sc.nextInt();
        root = new Node(value);
        populate(sc, root);
    }

    private void populate(Scanner sc, Node node) {
        System.out.println("Do you want to enter left of " + node.value);

        boolean isLeft = sc.nextBoolean();
        if (isLeft) {
            System.out.println("Enter the value of the left of " + node.value);
            int value = sc.nextInt();
            node.left = new Node(value);
            populate(sc, node.left);
        }

        System.out.println("Do you want to enter right of " + node.value);

        boolean isRight = sc.nextBoolean();
        if (isRight) {
            System.out.println("Enter the value of the right of " + node.value);
            int value = sc.nextInt();
            node.right = new Node(value);
            populate(sc, node.right);
        }

    }

    public void display() {
        display(root, "");
    }

    private void display(Node node, String indent) {
        if (node == null) return;
        System.out.println(indent + node.value);

        display(node.left, indent + "\t");
        display(node.right, indent + "\t");
    }

    private static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }
}

public class One_Simple_Binary {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.populate(new Scanner(System.in));
        bt.display();

    }
}
