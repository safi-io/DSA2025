package FiveLL.One_Single;

public class One_Runner {
    public static void main(String[] args) {
        One_CustomLL LL = new One_CustomLL();

        LL.insertFirst(1);
        LL.insertLast(0);
        LL.insertLast(1);

//        LL.displayLL();

        LL.binaryToDecimal();
    }
}
