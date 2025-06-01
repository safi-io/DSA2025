package Assignments.Theory_Four;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {


        Transaction t1 = new Transaction(101, "Safi", 987.68F);
        Transaction t2 = new Transaction(102, "Ali", 600.34F);
        Transaction t3 = new Transaction(103, "Ahmed", 2.44F);
        Transaction t4 = new Transaction(104, "Aleen", 400.12F);
        Transaction t5 = new Transaction(105, "Ilhan", Float.MIN_VALUE);
        Transaction t6 = new Transaction(106, "Ameen", Float.MAX_VALUE);

        Transaction[] transactions = new Transaction[6];
        transactions[0] = t1;
        transactions[1] = t2;
        transactions[2] = t3;
        transactions[5] = t4;
        transactions[3] = t5;
        transactions[4] = t6;

        System.out.println("Raw Data:\n" + Arrays.toString(transactions));
        MergeSortTransaction.merge(transactions, 0, transactions.length - 1);
        System.out.println("Sorted Raw Data:\n" + Arrays.toString(transactions));
    }
}
