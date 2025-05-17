package Assignments.Theory_Three;

/**
 * Basic array‑backed min‑heap for ints.
 * Grows automatically when capacity is exceeded.
 */

public class minHeap {

    private Driver[] heap;
    private int size;

    private static final int DEFAULT_CAPACITY = 16;

    /**
     * Constructors
     */

    public minHeap() {
        this(DEFAULT_CAPACITY);
    }

    private minHeap(int capacity) {
        heap = new Driver[capacity];
        size = 0;
    }

    /**
     * Insert a value into the heap.
     */

    public void addDriver(Driver driver) {
        ensureCapacity();
        heap[size] = driver;
        upHeap(size);
        size++;
        System.out.println("Added driver: " + driver.getDriverName() + " with arrival time " + driver.getDriverArrivalTime());
    }

    /**
     * Remove and return the smallest element.
     *
     * @return the driver with the shortest arrival time, or null if the heap is empty.
     */
    public Driver removeDriverShortestDistance() {
        if (isEmpty()) {
            System.out.println("No Drivers Found in System");
            return null;
        }

        Driver min = heap[0];
        size--;
        heap[0] = heap[size];
        downHeap(0);
        return min;
    }

    public Driver getDriverShortestDistance() {
        if (size == 0) return null;
        return heap[0];
    }

    /**
     * @return true if the heap has no elements.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Restore heap property going up from index.
     */
    private void upHeap(int index) {
        while (index > 0) {
            int parent = getParent(index);
            if (heap[index].getDriverArrivalTime() >= heap[parent].getDriverArrivalTime()) break;
            swap(index, parent);
            index = parent;
        }
    }

    /**
     * Restore heap property going down from index.
     */
    private void downHeap(int index) {
        while (true) {
            int left = getLeft(index);
            int right = getRight(index);
            int smallest = index;

            if (left < size && heap[left].getDriverArrivalTime() < heap[smallest].getDriverArrivalTime())
                smallest = left;
            if (right < size && heap[right].getDriverArrivalTime() < heap[smallest].getDriverArrivalTime())
                smallest = right;

            if (smallest == index) break;

            swap(index, smallest);
            index = smallest;
        }
    }

    /**
     * Double the array size when full.
     */
    private void ensureCapacity() {
        if (size < heap.length) return;
        Driver[] newHeap = new Driver[heap.length * 2];
        System.arraycopy(heap, 0, newHeap, 0, heap.length);
        heap = newHeap;
    }

    private void swap(int i, int j) {
        Driver temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private int getParent(int i) {
        return (i - 1) / 2;
    }

    private int getLeft(int i) {
        return 2 * i + 1;
    }

    private int getRight(int i) {
        return 2 * i + 2;
    }
}