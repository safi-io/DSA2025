package OneArray;

import java.util.ArrayList;

public class Three_ArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<Integer>();

        // Adding
        nums.add(50);
        nums.add(20);
        nums.add(40);
        nums.add(50);
        System.out.println(nums);

        // Removing
        nums.remove(0);
        System.out.println(nums);

        // Checking
        System.out.println(nums.contains(50));

        // Updating
        nums.set(0,69);
        System.out.println(nums);

        // Getting/Accessing
        System.out.println(nums.get(0));

    }
}
