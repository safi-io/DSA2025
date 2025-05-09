package TenHeaps.One;

import java.util.ArrayList;

// MAX HEAP
// and HEAP SORT (DESCENDING ORDER)
// and PRIORITY QUEUE (HIGH VALUE IS ON TOP)

// Same Dataset, can have more than one heap

class MaxHeapImplementation<T extends Comparable<T>> {
    public ArrayList<T> list;

    public MaxHeapImplementation() {
        list = new ArrayList<>();
    }

    public void insert(T value) {
        list.add(value);
        upHeap(list.size() - 1);
    }

    public T remove() throws Exception {
        if (list.isEmpty()) {
            throw new Exception("Removing from Empty List");
        }
        swap(0, list.size() - 1);
        T toRemoved = list.removeLast();

        downHeap(0);
        return toRemoved;
    }

    private void upHeap(int index) {
        if (index == 0) return;

        int parentIndex = getParent(index);

        if (list.get(index).compareTo(list.get(parentIndex)) > 0) {
            swap(index, parentIndex);
            upHeap(parentIndex);
        }


    }

    private void downHeap(int index) {
        int max = index;
        int left = getLeft(index);
        int right = getRight(index);

        if (left < list.size() && list.get(max).compareTo(list.get(left)) < 0) {
            max = left;
        }

        if (right < list.size() && list.get(max).compareTo(list.get(right)) < 0) {
            max = right;
        }

        if (max != index) {
            swap(max, index);
            downHeap(max);
        }
    }

    public ArrayList<T> heapSort() throws Exception {
        ArrayList<T> toReturn = new ArrayList<>();
        while (!list.isEmpty()) {
            toReturn.add(this.remove());
        }
        return toReturn;
    }

    private void swap(int first, int second) {
        T temp = list.get(first);
        list.set(first, list.get(second));
        list.set(second, temp);
    }

    private int getParent(int index) {
        return (index - 1) / 2;
    }

    private int getLeft(int index) {
        return (index * 2) + 1;
    }

    private int getRight(int index) {
        return (index * 2) + 2;
    }
}

public class MaxHeap {
    public static void main(String[] args) throws Exception {
        MaxHeapImplementation<Integer> one = new MaxHeapImplementation<>();
        one.insert(12);
        one.insert(3);
        one.insert(17);
        one.insert(8);
        one.insert(34);
        one.insert(25);
        one.insert(1);
        one.insert(45);
        one.insert(10);
        one.insert(2);
        one.insert(19);
        System.out.println(one.list);
        System.out.println(one.heapSort());
    }
}
