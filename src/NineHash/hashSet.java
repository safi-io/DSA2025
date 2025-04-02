package NineHash;

import java.util.HashSet;
import java.util.Iterator;

public class hashSet {
    public static void main(String[] args) {

        // Creation
        HashSet<Integer> numbers = new HashSet<>();

        // Insertion
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);

        // Size
        System.out.println(numbers.size());

        // Printing
        System.out.println(numbers);

        // Iterator
        Iterator it = numbers.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
