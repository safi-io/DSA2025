package EightTrees.BinaryTrees;


import java.util.LinkedList;
import java.util.Queue;
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

    // Traversals

    public void printLevelOrder() {
        printLevelOrder(root);
    }

    public void printInorder() {
        printInorder(root);
    }

    public void printPreOrder() {
        printPreOrder(root);
    }

    public void printPostOrder() {
        printPostOrder(root);
    }

    private void printLevelOrder(Node root) {
        Queue<Node> qe = new LinkedList<>();
        qe.add(root);
        while (!qe.isEmpty()) {
            Node temp = qe.remove();
            System.out.print(temp.value + " ");

            if (temp.left != null) {
                qe.add(temp.left);
            }

            if (temp.right != null) {
                qe.add(temp.right);
            }
        }
    }

    private void printInorder(Node node) {
        if (node == null) return;

        printInorder(node.left);
        System.out.print(node.value + "->");
        printInorder(node.right);
    }

    private void printPreOrder(Node node) {
        if (node == null) return;

        System.out.print(node.value + "->");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

    private void printPostOrder(Node node) {
        if (node == null) return;

        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.print(node.value + "->");
    }

    public int getSize(Node node) {
        if (node == null) return 0;
        return 1 + getSize(node.left) + getSize(node.right);
    }

    public Node getRoot() {
        return root;
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
        bt.printLevelOrder();
        System.out.println();
        bt.printInorder();
        System.out.println();
        bt.printPreOrder();
        System.out.println();
        bt.printPostOrder();
    }
}
