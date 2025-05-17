package Assignments.Lab_Three.Airport;

public class minHeapAirport {

    private Plane[] heap;
    private int size;
    private static final int DEFAULT_CAPACITY = 16;

    public minHeapAirport() {
        this(DEFAULT_CAPACITY);
    }

    private minHeapAirport(int capacity) {
        heap = new Plane[capacity];
        size = 0;
    }

    public void addPlane(Plane plane) {
        ensureCapacity();
        heap[size] = plane;
        upHeap(size);
        size++;
        System.out.println("Added Plane: " + plane.getPlaneId() + " with priority " + plane.getPriority());
    }

    public Plane removeHighestPriorityPlane() {
        if (isEmpty()) {
            System.out.println("No planes in queue.");
            return null;
        }

        Plane highestPriority = heap[0];
        size--;
        heap[0] = heap[size];
        downHeap(0);
        return highestPriority;
    }

    public Plane peekHighestPriorityPlane() {
        if (size == 0) return null;
        return heap[0];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void upHeap(int index) {
        while (index > 0) {
            int parent = getParent(index);
            if (heap[index].getPriority() >= heap[parent].getPriority()) break;
            swap(index, parent);
            index = parent;
        }
    }

    private void downHeap(int index) {
        while (true) {
            int left = getLeft(index);
            int right = getRight(index);
            int smallest = index;

            if (left < size && heap[left].getPriority() < heap[smallest].getPriority()) smallest = left;
            if (right < size && heap[right].getPriority() < heap[smallest].getPriority()) smallest = right;

            if (smallest == index) break;

            swap(index, smallest);
            index = smallest;
        }
    }

    private void ensureCapacity() {
        if (size < heap.length) return;
        Plane[] newHeap = new Plane[heap.length * 2];
        System.arraycopy(heap, 0, newHeap, 0, heap.length);
        heap = newHeap;
    }

    private void swap(int i, int j) {
        Plane temp = heap[i];
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
