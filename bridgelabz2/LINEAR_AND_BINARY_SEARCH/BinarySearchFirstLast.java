package STRING3;
public class BinarySearchFirstLast {
    public static int findFirst(int[] arr, int target) {
        int left=0,right=arr.length-1,result=-1;
        while(left<=right) {
            int mid = left + (right-left)/2;
            if(arr[mid]==target) { result=mid; right=mid-1; }
            else if(arr[mid]<target) left=mid+1;
            else right=mid-1;
        }
        return result;
    }

    public static int findLast(int[] arr, int target) {
        int left=0,right=arr.length-1,result=-1;
        while(left<=right) {
            int mid = left + (right-left)/2;
            if(arr[mid]==target) { result=mid; left=mid+1; }
            else if(arr[mid]<target) left=mid+1;
            else right=mid-1;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,2,2,3,4};
        System.out.println("First: "+findFirst(arr,2)+" Last: "+findLast(arr,2));
    }
}