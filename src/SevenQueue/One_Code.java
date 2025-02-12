package SevenQueue;

import java.util.LinkedList;
import java.util.Queue;

public class One_Code {
    public static void main(String[] args) {
        Queue<Integer> que = new LinkedList<>();
        // First in, First Out
        que.add(10);
        que.add(20);
        que.add(30);
        que.add(40);

        System.out.println(que.remove());
        System.out.println(que.remove());
        System.out.println(que.remove());

    }
}
