package EightTrees.BinarySearchTrees;

import java.util.Scanner;

class BinaryTree {

    private Node root;

    public Node insert(Node root, int data) {

        if (root == null) {
            return new Node(data);
        }

        if (root.data > data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }

        return root;
    }

    public void inOrderTraversal(Node root) {
        if (root == null) {
            return;
        }

        inOrderTraversal(root.left);
        System.out.print(root.data + "->");
        inOrderTraversal(root.right);
    }

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }


}

public class One_Binary_Search_Tree {
    // In-Order Traversal of BST gives a sorted sequence (Left, Root, Right)
    // Search is O(H)
    public static void main(String[] args) {

        int[] numbers = {9,10,4,6,90,34};
        BinaryTree tree = new BinaryTree();
        BinaryTree.Node root = null;

        for(int num : numbers) {
            root = tree.insert(root, num);
        }

        tree.inOrderTraversal(root);
        System.out.print("end");
    }
}
