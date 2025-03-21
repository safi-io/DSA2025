package Assignments.Lab_One;

import java.time.LocalDate;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {

        TaskScheduling ts = new TaskScheduling();

        ts.addTask("Test", LocalDate.parse("2030-08-17"), "low", "john-doe", "in progress");

        ts.addTask("Is it Working?", LocalDate.parse("2005-08-17"), "high", "john-doe", "in progress");

        ts.addTask("Let's See", LocalDate.parse("2005-08-17"), "medium", "john-doe", "pending");

        ts.addTask("Is it not working?", LocalDate.parse("2005-08-17"), "high", "john-doe", "in progress");


    }
}
