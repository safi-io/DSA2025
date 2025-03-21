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

    public void delete(Node root, int key) {
        if (root == null) {
            return;
        }

        if ((root.left != null) && root.left.data == key) {
            root.left = null;
            return;
        }

        if ((root.right != null) && root.right.data == key) {
            root.right = null;
            return;
        }

        if (key > root.data) {
            delete(root.right, key);
        } else {
            delete(root.left, key);
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

        tree.delete(root, 6);

        tree.inOrderTraversal(root);
        System.out.println("end");


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
