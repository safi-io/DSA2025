package Assignments.Lab_Two;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CallCenterManagementAdditionalTests {
    private callCenterManagement callCenter;

    @BeforeEach
    void setUp() {
        callCenter = new callCenterManagement();
    }

    @Test
    void testEnqueueMultipleCalls() {
        callCenter.addCall(1, "Call One");
        callCenter.addCall(2, "Call Two");
        callCenter.addCall(3, "Call Three");
        assertEquals(1, callCenter.getCalls().peek().getCallID());
    }

    @Test
    void testDequeueUntilEmpty() {
        callCenter.addCall(4, "Call Four");
        callCenter.addCall(5, "Call Five");
        callCenter.processCall();
        callCenter.processCall();
        assertNull(callCenter.getCalls().peek());
    }

    @Test
    void testPopHistoryAfterMultipleProcesses() {
        callCenter.addCall(6, "Call Six");
        callCenter.addCall(7, "Call Seven");
        callCenter.processCall();
        callCenter.processCall();
        callCenter.popHistory();
        assertNotNull(callCenter.getHistory().peek());
    }

    @Test
    void testEmptyQueueDequeue() {
        assertNull(callCenter.getCalls().dequeue());
    }

    @Test
    void testEmptyStackPop() {
        assertNull(callCenter.getHistory().pop());
    }

    @Test
    void testOrderPreservationInQueue() {
        callCenter.addCall(8, "First Call");
        callCenter.addCall(9, "Second Call");
        assertEquals(8, callCenter.getCalls().peek().getCallID());
    }

    @Test
    void testStackLastInFirstOut() {
        callCenter.addCall(10, "Old Call");
        callCenter.addCall(11, "New Call");
        callCenter.processCall();
        callCenter.processCall();
        assertEquals(11, callCenter.getHistory().peek().getCallID());
    }

    @Test
    void testProcessingEmptyQueue() {
        callCenter.processCall();
        assertNull(callCenter.getHistory().peek());
    }

    @Test
    void testMultipleHistoryPops() {
        callCenter.addCall(12, "Call A");
        callCenter.addCall(13, "Call B");
        callCenter.processCall();
        callCenter.processCall();
        callCenter.popHistory();
        callCenter.popHistory();
        assertNull(callCenter.getHistory().peek());
    }
}
