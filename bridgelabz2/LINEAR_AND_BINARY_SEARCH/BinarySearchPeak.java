package STRING3;
public class BinarySearchPeak {
    public static int findPeak(int[] arr) {
        int left=0, right=arr.length-1;
        while(left<right) {
            int mid = left + (right-left)/2;
            if(arr[mid] < arr[mid+1]) left = mid+1;
            else right = mid;
        }
        return left;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,5,4,2};
        System.out.println("Peak element index: " + findPeak(arr));
    }
}