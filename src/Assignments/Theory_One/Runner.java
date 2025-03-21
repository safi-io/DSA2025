package Assignments.Theory_One;

public class Runner {
    public static void main(String[] args) {
        JobSchedulingFarm JSF = new JobSchedulingFarm();

        //  Current Update
        // Add Job Working Good
        // Delete Job Working Good
        // Display Jobs Working Good
        // Execution of Jobs Working Good

        JSF.addJob(1, "Task 1", 20);
        JSF.addJob(2, "Task 2", 70);
        JSF.addJob(3, "Task 3", 40);
        JSF.addJob(40, "Task 4", 50);
        JSF.addJob(50, "Task 5", 60);
        JSF.addJob(60, "Task 6", 70);


        // Implemented Round Robin here
        JSF.executeJobs(12);


    }
}
