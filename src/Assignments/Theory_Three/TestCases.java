package Assignments.Theory_Three;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestCases {

    @Test
    public void testInsertAndPeek() {
        minHeap heap = new minHeap();
        Driver d1 = new Driver(201, "A", 12);
        Driver d2 = new Driver(202, "B", 5);
        Driver d3 = new Driver(203, "C", 8);

        heap.addDriver(d1);
        heap.addDriver(d2);
        heap.addDriver(d3);

        Driver shortest = heap.getDriverShortestDistance();
        assertEquals("B", shortest.getDriverName());
        assertEquals(5, shortest.getDriverArrivalTime());
    }

    @Test
    public void testRemoveOrder() {
        minHeap heap = new minHeap();
        heap.addDriver(new Driver(301, "X", 15));
        heap.addDriver(new Driver(302, "Y", 10));
        heap.addDriver(new Driver(303, "Z", 20));

        Driver first = heap.removeDriverShortestDistance();
        assertEquals("Y", first.getDriverName());

        Driver second = heap.removeDriverShortestDistance();
        assertEquals("X", second.getDriverName());

        Driver third = heap.removeDriverShortestDistance();
        assertEquals("Z", third.getDriverName());
    }

    @Test
    public void testRemoveFromEmptyHeap() {
        minHeap heap = new minHeap();
        Driver result = heap.removeDriverShortestDistance();
        assertNull(result);
    }

    @Test
    public void testPeekDoesNotRemove() {
        minHeap heap = new minHeap();
        Driver d = new Driver(401, "PeekTest", 7);
        heap.addDriver(d);

        Driver peek1 = heap.getDriverShortestDistance();
        Driver peek2 = heap.getDriverShortestDistance();

        assertEquals(peek1, peek2);
        assertEquals("PeekTest", peek1.getDriverName());

        Driver removed = heap.removeDriverShortestDistance();
        assertEquals("PeekTest", removed.getDriverName());
    }

    @Test
    public void testToStringOfDriver() {
        Driver d = new Driver(501, "TestName", 9);
        String expected = "Driver{ID=501, Name='TestName', ArrivalTime=9}";
        assertEquals(expected, d.toString());
    }

    @Test
    public void testHeapWithSingleElement() {
        minHeap heap = new minHeap();
        Driver d = new Driver(601, "Solo", 3);
        heap.addDriver(d);

        assertEquals("Solo", heap.getDriverShortestDistance().getDriverName());
        assertEquals("Solo", heap.removeDriverShortestDistance().getDriverName());
        assertNull(heap.getDriverShortestDistance());
    }
}
