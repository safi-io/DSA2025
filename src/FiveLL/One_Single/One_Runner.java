package FiveLL.One_Single;

import com.sun.security.jgss.GSSUtil;

import static FiveLL.One_Single.One_CustomLL.sumLL;

public class One_Runner {
    public static void main(String[] args) {
        One_CustomLL LL1 = new One_CustomLL();
        One_CustomLL LL2 = new One_CustomLL();

        LL1.insertFirst(9);
        LL1.insertLast(1);
        LL1.insertLast(1);

        LL2.insertFirst(9);
        LL2.insertLast(1);
        LL2.insertLast(1);

        LL1.displayLL();
        LL2.displayLL();


        One_CustomLL.Node summed = sumLL(LL1, LL2);

        One_CustomLL.Node temp = summed;
        while(temp!=null) {
            System.out.print(temp.value + " ");
            temp= temp.next;
        }
    }
}
