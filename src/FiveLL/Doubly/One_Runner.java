package FiveLL.Doubly;

public class One_Runner {
    public static void main(String[] args) {

        // TODO: Deletion Pending
        One_DoublyLL DLL = new One_DoublyLL();
        DLL.insertFirst(10);
        DLL.insertFirst(20);
        DLL.insertFirst(30);
        DLL.insertFirst(40);

        DLL.insert(35, 2);


        DLL.displayLL();
    }
}
