package test;

import java.util.Arrays;

/**
 * 注释:
 *
 * @Author moinros
 * @Date 2020/2/16 1:08
 * @Verison 1.0
 */
public class DemoTest {

    public static void main(String[] args) {
        // int[] arr = {151, 22, 46, 1, 58991, 0, 5, 9, 99, 55, 616, 11, 3, 88, 77, 114, 119, 110, 808080, 4, 66, 123, 321, 4484, 10, 41, 4};
        // [0, 1, 1, 1, 2, 3, 4, 5, 5, 6, 7, 8, 9, 9]
        // [0, 1, 1, 1, 2, 3, 4, 5, 5, 6, 7, 8, 9, 9]
        // [0, 1, 1, 1, 2, 3, 4, 5, 5, 6, 7, 8, 9, 9]
        int[] arr = {5, 5, 6, 7, 8, 9, 9, 0, 1, 1, 1, 2, 3, 4};
        System.out.println(Arrays.toString(arr));
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int index = getIndex(arr, left, right);
            quickSort(arr, left, index - 1);
            quickSort(arr, index + 1, right);
        }
    }

    public static int getIndex(int[] arr, int left, int right) {
        int pivot = arr[left];
        while (left < right) {
            while (arr[right] >= pivot && left < right) right--;
            arr[left] = arr[right];
            while (arr[left] < pivot && left < right) left++;
            arr[right] = arr[left];
        }
        arr[left] = pivot;
        return left;
    }

    //希尔排序
    public static void shell(int[] array) {
        // int[] array = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1};
        int gap = array.length;
        while (true) {
            gap /= 2;   //增量每次减半
            for (int i = 0; i < gap; i++) {
                for (int j = i + gap; j < array.length; j += gap) {//这个循环里其实就是一个插入排序
                    int temp = array[j];
                    int k = j - gap;
                    while (k >= 0 && array[k] > temp) {
                        array[k + gap] = array[k];
                        k -= gap;
                    }
                    array[k + gap] = temp;
                }
            }
            if (gap == 1)
                break;
        }
    }

    // 插入排序
    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = i;
            int value = array[i];
            while (key > 0 && array[key - 1] > value) {
                array[key] = array[key - 1];
                key--;
            }
            array[key] = value;
        }
    }

    // 二分插入排序
    public static void BinInsertSort(int[] a, int n) {
        int key, left, right, middle;
        for (int i = 1; i < n; i++) {
            key = a[i];
            left = 0;
            right = i - 1;
            while (left <= right) {
                middle = (left + right) / 2;
                if (a[middle] > key)
                    right = middle - 1;
                else
                    left = middle + 1;
            }

            for (int j = i - 1; j >= left; j--) {
                a[j + 1] = a[j];
            }

            a[left] = key;
        }
    }

    // 归并排序
    public static int[] mergeSort(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    // 归并排序
    public static int[] mergeSort(int[] nums, int l, int h) {
        if (l == h) return new int[]{nums[l]};
        int mid = l + (h - l) / 2;
        int[] leftArr = mergeSort(nums, l, mid); //左有序数组
        int[] rightArr = mergeSort(nums, mid + 1, h); //右有序数组
        int[] newNum = new int[leftArr.length + rightArr.length]; //新有序数组
        int m = 0, i = 0, j = 0;
        while (i < leftArr.length && j < rightArr.length)
            newNum[m++] = leftArr[i] < rightArr[j] ? leftArr[i++] : rightArr[j++];
        while (i < leftArr.length) newNum[m++] = leftArr[i++];
        while (j < rightArr.length) newNum[m++] = rightArr[j++];
        return newNum;
    }

    // 选择排序
    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            if (i != min) {
                int tmp = array[min];
                array[min] = array[i];
                array[i] = tmp;
            }
        }
    }
}
