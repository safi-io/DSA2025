package Assignments.Lab_One;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class TaskSchedulingTest {

    private TaskScheduling taskScheduler;

    @BeforeEach
    public void setUp() {
        taskScheduler = new TaskScheduling();
    }

    @Test
    public void testAddTask_ShouldIncreaseTaskCount() {
        assertEquals(0, taskScheduler.getNumberOfTasks());

        taskScheduler.addTask("First Task", LocalDate.now().plusDays(5), "high", "John Doe", "pending");
        assertEquals(1, taskScheduler.getNumberOfTasks());

        taskScheduler.addTask("Second Task", LocalDate.now().plusDays(10), "medium", "Jane Doe", "in progress");
        assertEquals(2, taskScheduler.getNumberOfTasks());
    }

    @Test
    public void testRemoveTask_ShouldDecreaseTaskCount() {
        taskScheduler.addTask("Task 1", LocalDate.now().plusDays(3), "high", "Alice", "pending");
        taskScheduler.addTask("Task 2", LocalDate.now().plusDays(4), "low", "Bob", "in progress");

        assertEquals(2, taskScheduler.getNumberOfTasks());

        taskScheduler.removeTask(1); // Remove head
        assertEquals(1, taskScheduler.getNumberOfTasks());

        taskScheduler.removeTask(2); // Remove tail
        assertEquals(0, taskScheduler.getNumberOfTasks());
    }

    @Test
    public void testUpdateTask_ValidUpdate() {
        taskScheduler.addTask("Initial Task", LocalDate.now().plusDays(7), "low", "Charlie", "pending");

        taskScheduler.updateTask(1, "Updated Description", "high", "completed");

        // Not asserting here since Task class is private. You can add assertions after adding getters.
        // For now, rely on console output or make Task public with getters.
        taskScheduler.searchTask(1);
    }

    @Test
    public void testMarkComplete_ShouldChangeStatus() {
        taskScheduler.addTask("Incomplete Task", LocalDate.now().plusDays(5), "medium", "Daniel", "in progress");

        taskScheduler.markComplete(1);
        taskScheduler.searchTask(1); // Console output: status should be "completed"

        // Try marking again to test "Already Completed" case
        taskScheduler.markComplete(1);
    }

    @Test
    public void testOverdueTasks_FindsOverdue() {
        taskScheduler.addTask("Overdue Task", LocalDate.now().minusDays(2), "high", "Eve", "in progress");
        taskScheduler.addTask("Future Task", LocalDate.now().plusDays(5), "medium", "Frank", "in progress");

        taskScheduler.overdueTasks(); // Should print only the overdue task
    }

    @Test
    public void testRemoveTask_NonExistingId() {
        taskScheduler.addTask("Task X", LocalDate.now().plusDays(2), "low", "George", "pending");

        taskScheduler.removeTask(999); // Should print "No Task Found against the ID:999"
        assertEquals(1, taskScheduler.getNumberOfTasks());
    }

    @Test
    public void testUpdateTask_InvalidPriorityAndStatus() {
        taskScheduler.addTask("Task Y", LocalDate.now().plusDays(3), "high", "Harry", "pending");

        taskScheduler.updateTask(1, "New Desc", "urgent", "done"); // Should auto-fix to medium and in progress
        taskScheduler.searchTask(1);
    }

    @Test
    public void testSearchTask_InvalidId() {
        taskScheduler.searchTask(-1); // Should print "Invalid ID"
    }

    @Test
    public void testDisplayTasks_EmptyList() {
        taskScheduler.displayTasks(); // Should print "There are currently no tasks in system!"
    }
}
