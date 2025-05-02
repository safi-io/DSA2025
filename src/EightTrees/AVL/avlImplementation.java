package EightTrees.AVL;

// Time Complexity is O(log n)

class AVL {

    public Node insert(Node root, int value) {
        // Root Doesn't Exist
        if (root == null) {
            return new Node(value);
        }
        // Root Exists
        if (value < root.data) {
            root.left = insert(root.left, value);
        } else if (value > root.data) {
            root.right = insert(root.right, value);
        } else {
            return root; // No Duplicate Values
        }

        // Update Height
        root.height = 1 + Math.max(getHeight(root.left), getHeight(root.right));

        // Balancing Check
        int balance = getBalance(root);

        // LEFT
        if (balance > 1) {
            // If LL, then value must be smaller than root.left.data
            if (value < root.left.data) {
                // Left, Left Case
                return rightRotation(root);
            } else {
                // Left Right Case
                root.left = leftRotation(root.left);
                return rightRotation(root);
            }
        }
        // RIGHT
        else if (balance < -1) {
            // If RR, value must be greater than root.right.data
            if (value > root.right.data) {
                // Right, Right Case
                return leftRotation(root);
            } else {
                // Right Left Case
                root.right = rightRotation(root.right);
                return leftRotation(root);
            }
        }
        // NO UNBALANCE
        else {
            return root;
        }

    }

    private Node rightRotation(Node root) {
        Node child = root.left;
        Node childRight = child.right;

        child.right = root;
        root.left = childRight;

        // Update Heights
        root.height = 1 + Math.max(getHeight(root.left), getHeight(root.right));
        child.height = 1 + Math.max(getHeight(child.left), getHeight(child.right));

        return child;
    }

    private Node leftRotation(Node root) {
        Node child = root.right;
        Node childLeft = child.left;

        child.left = root;
        root.right = childLeft;

        // Update Heights
        root.height = 1 + Math.max(getHeight(root.left), getHeight(root.right));
        child.height = 1 + Math.max(getHeight(child.left), getHeight(child.right));

        return child;
    }

    private int getHeight(Node root) {
        if (root == null) return 0;
        return root.height;
    }

    private int getBalance(Node root) {
        return getHeight(root.left) - getHeight(root.right);
    }

    public void printTree(Node root) {
        printTreeHelper(root, 0);
    }

    private void printTreeHelper(Node node, int level) {
        if (node == null) return;

        // Print right subtree first (it goes on top visually)
        printTreeHelper(node.right, level + 1);

        // Print current node with tabs for indentation
        System.out.println("\t".repeat(level) + node.data);

        // Print left subtree
        printTreeHelper(node.left, level + 1);
    }
}

class Node {
    int data;
    int height;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        this.height = 1;
        left = right = null;
    }
}

public class avlImplementation {
    public static void main(String[] args) {
        AVL avlTree = new AVL();

        Node root = new Node(30);
        root = avlTree.insert(root, 35);
        root = avlTree.insert(root, 38);
        root = avlTree.insert(root, 9);
        root = avlTree.insert(root, 11);
        root = avlTree.insert(root, 12);
        root = avlTree.insert(root, 14);
        root = avlTree.insert(root, 15);
        root = avlTree.insert(root, 40);
        root = avlTree.insert(root, 43);
        avlTree.printTree(root);
    }
}
