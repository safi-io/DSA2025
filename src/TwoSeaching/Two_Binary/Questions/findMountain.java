package TwoSeaching.Two_Binary.Questions;

public class findMountain {

    public static void main(String[] args) {
        // Sample array and target
        int[] arr = {0,5,3,1};
        int target = 1;

        // Simulating MountainArray interface
        MountainArray mountainArr = new MountainArray(arr);

        // Calling the function and printing the result
        int result = findInMountainArray(target, mountainArr);
        System.out.println("Index of target: " + result);
    }

    public static int findInMountainArray(int target, MountainArray mountainArr) {
        // Finding Peak Element
        int peakIndex = 0;
        int start = 1;
        int end = mountainArr.length() - 2;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mountainArr.get(mid) > mountainArr.get(mid - 1) && mountainArr.get(mid) > mountainArr.get(mid + 1)) {
                peakIndex = mid;
                break;
            } else if (mountainArr.get(mid) > mountainArr.get(mid - 1)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        // Done finding peak

        // Binary Search in Ascend
        start = 0;
        end = peakIndex;

        while (start <= end) {
            int mid = start + ((end - start) / 2);

            if (mountainArr.get(mid) == target) {
                return mid;
            } else if (mountainArr.get(mid) > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        // Binary Search in Descend
        start = peakIndex + 1;
        end = mountainArr.length() - 1;

        while (start <= end) {
            int mid = start + ((end - start) / 2);

            if (mountainArr.get(mid) == target) {
                return mid;
            } else if (mountainArr.get(mid) > target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    // Simulated MountainArray class
    static class MountainArray {
        private int[] array;

        public MountainArray(int[] array) {
            this.array = array;
        }

        public int get(int index) {
            return array[index];
        }

        public int length() {
            return array.length;
        }
    }
}

