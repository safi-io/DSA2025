package TwoSeaching.One_Linear.Questions;

public class searchRange {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(range(arr,3, 2, arr.length-1));
    }

    static boolean range(int[] arr,int target, int start, int end)  {
        for(int i=start; i<=end; i++) {
            if(arr[i]==target) {
                return true;
            }
        }
        return false;
    }
}
