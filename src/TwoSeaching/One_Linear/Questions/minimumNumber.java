package TwoSeaching.One_Linear.Questions;

public class minimumNumber {
    public static void main(String[] args) {
        int[] arr = {1,2,3,-65,24,1000,-99,-101,9000};
        System.out.println(findMinimum(arr));
    }

    static int findMinimum(int[] arr) {
        int min = Integer.MAX_VALUE;
        for(int number: arr) {
            if(number<min) min = number;
        }
        return min;
    }
}
