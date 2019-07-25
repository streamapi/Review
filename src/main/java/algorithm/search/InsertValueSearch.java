package algorithm.search;

/**
 * @author ：stream
 * @date ：Created in 2019/7/25 11:33
 */
public class InsertValueSearch {
    public static void main(String[] args) {
        int arr[] = new int[100];
        int goal = 100;
        for (int i = 1; i <= goal; i++) {
            arr[i - 1] = i;
        }
        System.out.println(insertValutSearch(arr, 0, arr.length - 1, 10));
    }

    private static int insertValutSearch(int arr[], int left, int right, int goal) {
        if (left > right || goal < arr[0] || goal > arr[arr.length - 1]) {
            return -1;
        }
        System.out.println("hi---------");
        int mid = left + (right - left) * (goal - arr[left]) / (arr[right] - arr[left]);
        int midValue = arr[mid];
        if (goal > midValue) {
            return insertValutSearch(arr, mid + 1, right, goal);
        } else if (goal < midValue) {
            return insertValutSearch(arr, left, mid - 1, goal);
        } else {
            return mid;
        }
    }
}
