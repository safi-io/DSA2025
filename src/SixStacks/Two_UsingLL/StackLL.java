package SixStacks.Two_UsingLL;

public class StackLL {

    Node top;
    int size;


    public StackLL() {
        top = null;
        size = 0;
    }

    // Last In, First out

    public void push(int data) {
        Node temp = new Node(data);
        if (temp == null) {
            System.out.println("Stack Overflow");
            return;
        }
        System.out.println(temp.data + " Pushed!");
        temp.next = top;
        top = temp;
        size += 1;
    }

    public void pop() {
        if (size <= 0) {
            System.out.println("Stack Underflow");
            return;
        }
        System.out.println(top.data + " Popped!");
        top = top.next;
        size -= 1;
    }

    public int peek() {
        if (top == null) {
            System.out.println("Stack is Empty");
            return -1;
        }

        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int isSize() {
        return size;
    }

    public class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
        }
    }
}
