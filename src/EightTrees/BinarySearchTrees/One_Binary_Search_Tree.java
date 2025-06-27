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

    public boolean searchTree(Node root, int data) {
        if (root == null) {
            return false;
        }
        if (root.data == data) {
            return true;
        }
        if (root.data > data) {
            return searchTree(root.left, data);
        } else {
            return searchTree(root.right, data);
        }
    }

    public Node delete(Node root, int key) {
        if (root == null) {
            return root;
        }

        if (root.data < key) {
            root.right = delete(root.right, key);
        } else if (root.data > key) {
            root.left = delete(root.left, key);
        } else {
            // Root data matches with key

            // Case 1: If there is no leaf node
            if (root.left == null && root.right == null) {
                return null;
            }

            // Case 2: If there is a single node
            // Left
            if (root.right == null) {
                return root.left;
            }
            // Right
            if (root.left == null) {
                return root.right;
            }

            // Case 3: If there are two child
            // get the in order successor

            Node successor = getSuccessor(root);
            root.data = successor.data;
            root.right = delete(root.right, root.data);

        }

        return root;
    }

    private Node getSuccessor(Node root) { // Smallest Node in Right Sub-Tree
        Node current = root.right;

        while (current != null && current.left != null) {
            current = current.left;
        }

        return current;
    }

    public void printInRange(Node root, int X, int Y) {
        if(root==null) return;
        if (root.data >= X && root.data <= Y) {
            printInRange(root.left, X, Y);
            System.out.print(root.data + " ");
            printInRange(root.right, X, Y);
        }
        else if(root.data >= Y) {
            printInRange(root.left, X, Y);
        }else {
            printInRange(root.right, X, Y);
        }
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

        int[] numbers = {9, 10, 4, 6, 90, 34};
        BinaryTree tree = new BinaryTree();
        BinaryTree.Node root = null;

        for (int num : numbers) {
            root = tree.insert(root, num);
        }

        tree.inOrderTraversal(root);
        System.out.println("end");

//        tree.delete(root, 9);
//        tree.inOrderTraversal(root);
//        System.out.println("end");
//

//        System.out.println("Enter to Search Something: ");
//        Scanner sc = new Scanner(System.in);
//
//        if(tree.searchTree(root, sc.nextInt())) {
//            System.out.print("DATA FOUND IN BST");
//        }else {
//            System.out.print("DATA NOT FOUND IN BST");
//        }


    }
}
