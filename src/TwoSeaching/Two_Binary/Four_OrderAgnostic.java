package TwoSeaching.Two_Binary;

public class Four_OrderAgnostic {
    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 4, 5, 6, 7};
     int[] arr = {90,80,70,60,50,40,30,20};
        int target = 50;

        if (arr[0] < arr[arr.length - 1]) {
            System.out.println(binarySearch(arr, target, true) + " index.");
        } else {
            System.out.println(binarySearch(arr, target, false) + " index.");
        }
    }

    static int binarySearch(int[] arr, int target, boolean isAscend) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + ((end - start) / 2);

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                if (isAscend) {
                    end = mid - 1;
                }else {
                    start = mid+1;
                }
            } else {
                if (isAscend) {
                    start = mid + 1;
                }else {
                    end = mid-1;
                }
            }
        }

        return -1;
    }
}
