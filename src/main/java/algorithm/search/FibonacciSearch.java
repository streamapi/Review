package algorithm.search;

import java.util.Arrays;

/**
 * @author ：stream
 * @date ：Created in 2019/7/25 13:57
 */
public class FibonacciSearch {
    public static int maxSize = 20;

    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};
        System.out.println(fibonacciSearch(arr, 1234));
    }

    public static int[] getFibonacciArray() {
        int[] fibonacciArray = new int[maxSize];
        fibonacciArray[0] = 1;
        fibonacciArray[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            fibonacciArray[i] = fibonacciArray[i - 1] + fibonacciArray[i - 2];
        }
        return fibonacciArray;
    }

    public static int fibonacciSearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int k = 0;
        int mid = 0;
        int fibonacci[] = getFibonacciArray();

        while (high > fibonacci[k] - 1) {
            k++;
        }
        int[] temp = Arrays.copyOf(arr, fibonacci[k]);
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = arr[high];
        }

        while (low <= high) {
            mid = low + fibonacci[k - 1] - 1;
            if (key < temp[mid]) {
                high = mid - 1;
                k--;
            } else if (key > temp[mid]) {
                low = mid + 1;
                k -= 2;
            } else {
                if (mid <= high) {
                    return mid;
                } else {
                    return high;
                }
            }
        }
        return -1;
    }
}
