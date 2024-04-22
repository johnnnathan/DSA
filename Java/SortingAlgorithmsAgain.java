import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class SortingAlgorithmsAgain {

    public static void main(String[] args) {
        int[] arr = new int[22];
        populateBoard(arr);
        System.out.println(Arrays.toString(arr));
        arr = quickSort(arr, 0 ,arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }
    public static int[] populateBoard(int[] array){
        Random rand = new Random();

        boolean[] used = new boolean[array.length]; // Keeps track of used numbers
        int count = 0;

        while (count < array.length) {
            int randomNumber = rand.nextInt(array.length);
            if (!used[randomNumber]) {
                array[count] = randomNumber;
                used[randomNumber] = true;
                count++;
            }
        }
        return array;
    }
    //bubble sort, runs in n^2 with n space complexity
    public static int[] bubbleSort(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n - 1; j++){
                if (arr[j] >= arr[j+1]){
                    arr = swap(arr, j , j + 1);
                }
            }
        }
        return arr;
    }
    //swap to elements
    public static int[] swap(int[] arr, int k , int l){
        int temp = arr[k];
        arr[k] = arr[l];
        arr[l] = temp;
        return arr;
    }
    //find the biggest element and add it to the end of the array runs in n^2 with n space complexity
    public static int[] selectionSort(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n; i++){
            int max = 0;
            for (int j = 0; j < n - i ; j++){
                if (arr[j] > arr[max]){
                    max = j;
                }
            }
            swap(arr,max,n - i - 1);
        }
        return arr;
    }

    public static int[] insertionSort(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n - 1 ; i++){
            int j = i + 1;
            while (j > 0 && arr[j] <= arr[j-1]){
                swap(arr, j, j-1);
                j--;
            }

        }
        return arr;
    }

    public static int[] mergeSort(int[] arr){
        int n = arr.length;
        if (n <= 1){
            return arr;
        }
        int half = (n)/2;
        int[] left = Arrays.copyOfRange(arr, 0, half);
        int[] right = Arrays.copyOfRange(arr, half , n);

        left = mergeSort(left);
        right = mergeSort(right);

        return mergeSortHelper(left,right);
    }
    public static int[] mergeSortHelper(int[] left, int[] right){
        int l = 0,r = 0, i = 0;
        int rend = right.length;
        int lend = left.length;
        int[] merged = new int[rend + lend];

        while (l < lend && r < rend) {
            if (left[l] < right[r]){
                merged[i] = left[l];
                l++;
                i++;
            }
            else{
                merged[i] = right[r];
                r++;
                i++;
            }
        }
        while (l < lend){
            merged[i] = left[l];
            l++;
            i++;
        }
        while (r < rend){
            merged[i] = right[r];
            r++;
            i++;
        }
        return merged;


    }

    public static int[] quickSort(int[] arr, int low, int high){
        int n = arr.length;
        if (n == 1){
            return arr;
        }
        if (low < high) {
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
        return arr;



    }
    public static int partition(int[] arr, int low, int high){
        int left = low;
        int right = high -1;
        int pivot = arr[high];
        while(true){
            while(left <= right && arr[left] <= pivot){
                left++;
            }
            while(left <= right && arr[right] >= pivot){
                right--;
            }
            if (left >= right){break;}
            swap(arr, left, right);
            left++;
            right--;
        }
        swap(arr, left,high);
        return left;
    }


}
