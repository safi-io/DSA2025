package OneArray.Questions;

import java.util.ArrayList;
import java.util.Arrays;

public class plusOne {
    public static void main(String[] args) {
        int[] digits = {1, 2, 3, 4, 5,9};

        ArrayList<Integer> result = new ArrayList<>();
        for (int digit : digits) {
            result.add(digit);
        }

        result.set(result.size()-1, result.getLast()+1 );

        if(result.getLast()==10) {
            result.remove(result.getLast());
            result.add(0);
            result.add(1);
        }

//        result.to

        System.out.println(result);
    }
}
