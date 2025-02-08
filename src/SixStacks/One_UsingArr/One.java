package SixStacks.One_UsingArr;

public class One {
    public static void main(String[] args) {
        StackArr stack = new StackArr(1);

        stack.push(-1);
//        stack.pop();

        int ans = stack.peek();

        if (stack.flag) {
            System.out.println(ans);
        } else {
            System.out.println("Stack is Empty");
        }


    }
}
