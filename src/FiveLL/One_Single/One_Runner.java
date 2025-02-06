package FiveLL.One_Single;

import static FiveLL.One_Single.One_CustomLL.sumLL;

public class One_Runner {
    public static void main(String[] args) {
        One_CustomLL LL1 = new One_CustomLL();
        LL1.insertFirst(1);
        LL1.insertLast(2);
        LL1.insertLast(3);
        LL1.insertLast(4);
        LL1.insertLast(5);

        LL1.displayLL();
        LL1.reverseBetween(2,4);
        LL1.displayLL();
    }
}
