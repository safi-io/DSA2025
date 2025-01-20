package OneArray;

import java.util.ArrayList;
import java.util.Scanner;

public class Four_2DArrayLists {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> nums = new ArrayList<>();

        // Adding Array List, otherwise it would be empty
        for(int i=0; i<2; i++)  {
            nums.add(new ArrayList<>());
        }

        // Adding Elements
        for(int i=0; i<2; i++) {
            for(int j=0;j<2;j++) {
                nums.get(i).add(sc.nextInt());
            }
        }

        // Printing Elements
        System.out.println(nums);


    }
}
