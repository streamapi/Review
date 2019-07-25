package algorithm.search;

import algorithm.sort.RadixSort;

/**
 * @author ：stream
 * @date ：Created in 2019/7/25 10:44
 */
public class BinarySearchRecursiveImp {
    public static void main(String[] args) {
        int arr[] = new int[100];
        int goal = 100;
        for (int i = 1; i <= goal; i++) {
            arr[i - 1] = i;
        }
        System.out.println(binarySearch(arr, 0, arr.length - 1, 10));
    }

    public static int binarySearch(int[] arr, int left, int right, int goal) {
        if (left > right) {
            return -1;
        }
        System.out.println("hi---------");
        int mid = (left + right) / 2;
        int midValue = arr[mid];
        if (goal > midValue) {
            return binarySearch(arr, mid + 1, right, goal);
        } else if (goal < midValue) {
            return binarySearch(arr, left, mid - 1, goal);
        } else {
            return mid;
        }
    }
}
