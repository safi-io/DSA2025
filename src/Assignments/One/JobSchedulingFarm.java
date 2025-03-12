package Assignments.One;

import java.util.Scanner;

public class JobSchedulingFarm {

    private Job HEAD;
    private int SIZE;

    // Add a Job
    public void addJob(int jobID, String jobName, int executionTime) {
        Job newJob = new Job(jobID, jobName, executionTime);
        SIZE++;

        if (HEAD == null) {
            HEAD = newJob;
            newJob.nextJob = newJob;
        } else {
            Job temp = HEAD;
            while (temp.nextJob != HEAD) {
                temp = temp.nextJob;
            }
            temp.nextJob = newJob;
            newJob.nextJob = HEAD;
        }

        System.out.println("Job added: ID = " + jobID + ", Name = " + jobName + ", Execution Time = " + executionTime);

    }

    // Delete a Job
    public void deleteJob(int jobId) {
        if (HEAD == null) {
            System.out.println("There are currently no JOBS in queue!");
            return;
        }

        // Case 1: Delete the Head Job
        if (HEAD.jobID == jobId) {

            // If there is only Job
            if (SIZE == 1) {
                HEAD = null;
                SIZE--;
                System.out.println("Deleted job with ID: " + jobId);
                return;
            }

            // First, Find the end of Linked List
            Job temp = HEAD;
            while (temp.nextJob != HEAD) {
                temp = temp.nextJob;
            }

            // Point that to the next of head
            temp.nextJob = HEAD.nextJob;

            // Move head ahead
            HEAD = HEAD.nextJob;
            System.out.println("Deleted job with ID: " + jobId);
            SIZE--;
            return;
        }

        // Case 2: Delete non-HEAD job
        Job temp = HEAD;
        while (temp.nextJob != HEAD && temp.nextJob.jobID != jobId) {
            temp = temp.nextJob;
        }

        // If the below condition works, it means we traverse the whole list, still haven't found the job
        if (temp.nextJob == HEAD) {
            System.out.println("NO Job found against given ID.");
            return;
        }

        // Finally, remove the job
        temp.nextJob = temp.nextJob.nextJob;
        SIZE--;
        System.out.println("Deleted job with ID: " + jobId);

    }

    // Executing Jobs (Round Robin)
    public void executeJobs(int timeQuantum) {
        if (HEAD == null) {
            System.out.println("No jobs to execute!");
            return;
        }

        boolean repeat;
        Scanner sc = new Scanner(System.in);
        do {

            System.out.println("Starting Executing Jobs::");
            Job temp = HEAD;

            do {
                Job next = temp.nextJob; // Save next job before deletion
                temp.executionTime -= timeQuantum;

                if (temp.executionTime <= 0) {
                    System.out.println("Job ID " + temp.jobID + " has finished executing and will be removed.");
                    deleteJob(temp.jobID);

                    // If HEAD becomes null after deletion, stop execution
                    if (HEAD == null) {
                        System.out.println("All jobs have been executed and removed!");
                        break;
                    }
                } else {
                    System.out.println("Executing Job ID: " + temp.jobID + " with Execution Time: " + temp.executionTime);
                }

                temp = next;  // Move to the next job (even if HEAD changed)
            } while (temp != HEAD); // Ensure list is not empty

            if (HEAD == null) {
                System.out.println("All jobs have been executed and removed!");
                break;
            }

            System.out.println("Do you want to repeat again?");
            repeat = sc.nextBoolean();

        } while (repeat);

        sc.close();
    }


    // Display Queue of Jobs
    public void display() {

        if (HEAD == null) {
            System.out.println("QUEUE IS EMPTY");
            return;
        }

        Job temp = HEAD;
        System.out.println("Current Jobs in Queue:");
        do {
            System.out.println("[ID: " + temp.jobID + ", Name: " + temp.jobName + ", Time: " + temp.executionTime + "]");
            temp = temp.nextJob;
        } while (temp != HEAD);
        System.out.println("(back to HEAD)");
    }


    public static class Job {
        int jobID;
        String jobName;
        int executionTime;
        Job nextJob;

        public Job(int jobID, String jobName, int executionTime) {
            this.jobID = jobID;
            this.jobName = jobName;
            this.executionTime = executionTime;
        }
    }
}
