package NineHash;

import java.util.ArrayList;
import java.util.LinkedList;

class HashMapCustom<K, V> {
    private int n; // Number of Nodes (Pairs)
    private final int N; // Array Size
    private LinkedList<Node>[] buckets;

    @SuppressWarnings("unchecked")
    public HashMapCustom(int initialCapacity) {
        this.N = initialCapacity;
        this.buckets = new LinkedList[4];

        for (int i = 0; i < 4; i++) {
            this.buckets[i] = new LinkedList<>();
        }
    }

    public void put(K key, V value) {
        int buckedIndex = hashFunction(key);
        int dataIndex = searchLL(key, buckedIndex);

        if (dataIndex == -1) {
            // key does not exist - we have to make a new one
            buckets[buckedIndex].add(new Node(key, value));
            this.n++;
        } else {
            // Key exist - just have to update the value
            Node toChange = buckets[buckedIndex].get(dataIndex);
            toChange.value = value;
        }

        // Check for rehashing
        double lambda = (double) n / N;
        if (lambda > 2.0) {
            // rehashing
            rehash();
        }
    }

    public V remove(K key) {
        int bucketIndex = hashFunction(key);
        LinkedList<Node> LL = buckets[bucketIndex];

        if (LL.isEmpty()) return null;
        int index = searchLL(key, bucketIndex);

        if (index == -1) {
            return null;
        } else {
            n--;
            return LL.remove(index).value;
        }

    }

    public V get(K key) {
        int bucketIndex = hashFunction(key);
        LinkedList<Node> LL = buckets[bucketIndex];

        if (LL.isEmpty()) return null;

        if (LL.size() == 1) {
            return LL.getFirst().value;
        }

        int index = searchLL(key, bucketIndex);
        return (index == -1) ? null : LL.get(index).value;
    }

    public ArrayList<K> keySet() {
        ArrayList<K> keySet = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            LinkedList<Node> LL = buckets[i];
            for (Node node : LL) {
                keySet.add(node.key);
            }
        }

        return keySet;
    }

    public boolean containsKey(K key) {
        int bucketIndex = hashFunction(key);
        LinkedList<Node> LL = buckets[bucketIndex];

        if (LL.isEmpty()) return false;

        return searchLL(key, bucketIndex) != -1;
    }

    public boolean isEmpty() {
        return this.n == 0;
    }

    public int getSize() {
        return this.n;
    }

    private int hashFunction(K key) {
        return Math.abs(key.hashCode()) % N;
    }

    private int searchLL(K key, int buckedIndex) {
        LinkedList<Node> LL = buckets[buckedIndex];

        for (int i = 0; i < LL.size(); i++) {
            if (LL.get(i).key == key) {
                return i;
            }
        }

        return -1;
    }

    @SuppressWarnings("unchecked")
    private void rehash() {
        LinkedList<Node>[] oldBucket = buckets;
        buckets = new LinkedList[N * 2];

        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }

        for (int i = 0; i < oldBucket.length; i++) {
            LinkedList<Node> LL = oldBucket[i];

            for (int j = 0; j < LL.size(); j++) {
                Node node = LL.get(j);
                put(node.key, node.value);
            }

        }
    }

    private class Node {
        K key;
        V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}

public class insideImplementation {
    public static void main(String[] args) {
        HashMapCustom<Integer, String> students = new HashMapCustom<>(4);

        students.put(101, "SAFI");
        students.put(102, "SAAD");
        students.put(103, "ASAD");

        // Getting all keys
        ArrayList<Integer> keySet = students.keySet();

        // Removal
        System.out.println(students.get(103));
        String data = students.remove(103);
        System.out.println(students.get(103));
    }
}

  /*
    Hashmap is Implemented by array of Linked Lists.

    n = Number of Nodes(Pairs)
    N = Size of Array

    Put Method Worst Case is O(n)

    Average Case:
        n/N = LAMBDA (IT MUST BE LESS THAN OR EQUAL TO CONSTANT K)

     Rehashing:
        -Increase bucket size

     */
