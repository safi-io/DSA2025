package TwoSeaching.Two_Binary.Questions;

public class findPeak {
    public static void main(String[] args) {
        int[] arr = {1,2};
        System.out.println(findPeakElement(arr));
    }

    public static int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        if (nums.length == 1) {
            return nums[0];
        }
        if(nums.length==2) {
            if(nums[0]>nums[1]) {
                return 0;
            }else {
                return 1;
            }
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // Hnadling Condition if array length is 1, and peak element is first element
            if (mid == 0) {
                if (nums[mid] > nums[mid + 1]) {
                    return mid;
                }
            }

            // Checking if peak  element is the last one
            if (mid == nums.length - 1) {
                if (nums[mid] > nums[mid - 1]) {
                    return mid;
                }
            }

            if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) {
                return mid;
            } else if (nums[mid] < nums[mid - 1]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }


        }

        return 0;
    }
}
