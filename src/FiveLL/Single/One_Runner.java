package FiveLL.Single;

public class One_Runner {
    public static void main(String[] args) {
        One_CustomLL LL = new One_CustomLL();
        LL.insertFirst(10);
        LL.insertFirst(40);
        LL.insertFirst(50);
        LL.insertFirst(20);
        LL.insertLast(100);
        LL.insert(1,1);

        LL.displayLL();
        LL.deleteFirst();
        LL.displayLL();
        LL.deleteLast();
        LL.displayLL();

        LL.delete(0);
        LL.displayLL();

        System.out.println("Size of Linked List is:" + One_CustomLL.size);
    }
}
