package SixStacks.One_UsingArr;

public class StackArr {
    private int size;
    private int[] arr;
    private int top;
    public boolean flag;

    public StackArr(int size) {
        this.size = size;
        this.arr = new int[size];
        this.top = -1;
        this.flag = false;
    }

    // Stack is Basically Last IN, First OUT

    public void push(int elem) {
        if (isSize()) {
            System.out.println("Stack Overflow!");
            return;
        }
        top++;
        arr[top] = elem;
        flag = true;
    }

    public void pop() {
        if (isEmpty()) {
            System.out.println("Stack UnderFlow!");
            return;
        }
        top--;
        if (top == -1) {
            flag = false;
        }
    }

    public int peek() {
        if (top != -1) {
            return arr[top];
        }

        return -1;
    }

    private boolean isSize() {
        return top == this.size - 1;
    }

    private boolean isEmpty() {
        return top == -1;
    }
}
