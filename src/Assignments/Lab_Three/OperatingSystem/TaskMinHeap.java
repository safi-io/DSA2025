package Assignments.Lab_Three.OperatingSystem;

public class TaskMinHeap {
    private Task[] heap;
    private int size;
    private static final int DEFAULT_CAPACITY = 16;

    public TaskMinHeap() {
        heap = new Task[DEFAULT_CAPACITY];
        size = 0;
    }

    public void enqueue(Task task) {
        ensureCapacity();
        heap[size] = task;
        upHeap(size);
        size++;
        System.out.println("Enqueued Task: " + task.getName() + " (Priority: " + task.getPriority() + ")");
    }

    public Task dequeue() {
        if (isEmpty()) {
            System.out.println("No tasks in queue.");
            return null;
        }

        Task min = heap[0];
        size--;
        heap[0] = heap[size];
        downHeap(0);
        return min;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void upHeap(int index) {
        while (index > 0) {
            int parent = getParent(index);
            if (!isHigherPriority(heap[index], heap[parent])) break;
            swap(index, parent);
            index = parent;
        }
    }

    private void downHeap(int index) {
        while (true) {
            int left = getLeft(index);
            int right = getRight(index);
            int smallest = index;

            if (left < size && isHigherPriority(heap[left], heap[smallest])) smallest = left;
            if (right < size && isHigherPriority(heap[right], heap[smallest])) smallest = right;

            if (smallest == index) break;

            swap(index, smallest);
            index = smallest;
        }
    }

    private boolean isHigherPriority(Task t1, Task t2) {
        if (t1.getPriority() != t2.getPriority()) {
            return t1.getPriority() < t2.getPriority();
        }
        return t1.getTimestamp() < t2.getTimestamp(); // earlier timestamp = higher priority
    }

    private void swap(int i, int j) {
        Task temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private void ensureCapacity() {
        if (size < heap.length) return;
        Task[] newHeap = new Task[heap.length * 2];
        System.arraycopy(heap, 0, newHeap, 0, heap.length);
        heap = newHeap;
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
