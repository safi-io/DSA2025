package TwoSeaching.Two_Binary.Questions;

public class findFirstLast {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 9, 9, 9, 9, 10};
        int target = 9;

        System.out.println("THE FIRST INDEX OF " + target + " is: " + findFirst(arr, target, true));
        System.out.println("THE LAST INDEX OF " + target + " is: " + findFirst(arr, target, false));

    }

    static int findFirst(int[] arr, int target, boolean isFirst) {
        int start = 0;
        int end = arr.length - 1;
        int ans = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] < target) {
                start = mid + 1;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                ans = mid;
                if (isFirst) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }

        return ans;
    }
}
