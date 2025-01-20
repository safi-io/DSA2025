package TwoSeaching.One_Linear;

public class One_Code {
    public static void main(String[] args) {
        int[] arr ={1,2,3,4,5,6,7,8,9,10};
        System.out.println(linearSearch(arr, 9));
    }

    static int linearSearch(int[] arr, int element) {
        int toReturn = -1;

        for(int i=0; i<arr.length; i++) {
            if(arr[i]==element) {
                toReturn = i;
                break;
            }
        }

        return toReturn;
    }
}
