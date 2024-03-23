import java.util.Arrays;
import java.util.Random;

public class SortingAlgorithms {
  private int[] array;

  public SortingAlgorithms(int size){
    this.array = new int[size];
  }
  public static void main(String[] args) {
    SortingAlgorithms alg = new SortingAlgorithms(22);
    alg.populateBoard();
    quickSort(alg.array,0, alg.array.length - 1);
    System.out.println(Arrays.toString(alg.array));

  }

  public void populateBoard(){
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
  }


  public void bubbleSort(){
    for (int i = 0; i < array.length; i++){
      for (int j = 0; j < array.length - i - 1; j++){
        if (array[j] > array[j+1]){
          int temp = array[j+1];
          array[j + 1] = array[j];
          array[j] = temp;
        }
      }
    }
    System.out.println(Arrays.toString(array));
  }

  public void insertionSort(){
    for (int i = 0; i < array.length; i++){
      int index = i;
      while(index > 0 && array[index - 1] > array[index]){
        int temp = array[index - 1];
        array[index-1] = array[index];
        array[index] = temp;
        index--;
      }
    }
    System.out.println(Arrays.toString(array));
  }

  public void selectionSort(){
    for (int i = 0; i < array.length; i++){
      int minIndex = i;
      for (int j = i; j < array.length; j++){
        if (array[j] < array[minIndex]){
          minIndex = j;
        }
      }
      int temp = array[i];
      array[i] = array[minIndex];
      array[minIndex] = temp;
    }
    System.out.println(Arrays.toString(array));
  }

  public int[] mergeSort(int[] tempArray){
    int length = tempArray.length;
    if (length <= 1){return tempArray;}

    int mid = length / 2;
    int[] leftArray = Arrays.copyOfRange(tempArray, 0, mid);
    int[] rightArray = Arrays.copyOfRange(tempArray, mid, length);


    rightArray = mergeSort(rightArray);
    leftArray = mergeSort(leftArray);
    tempArray = mergeAssistant(rightArray,leftArray);

    return tempArray;
  }
  public int[] mergeAssistant(int[] rightArray, int[] leftArray){
    int r = 0;
    int l = 0;
    int i = 0;

    int[] mergedArray = new int[leftArray.length + rightArray.length];

    int leftLength = mergedArray.length / 2;
    int rightLength = mergedArray.length - leftLength;

    while(l < leftLength && r < rightLength){
      if (leftArray[l] < rightArray[r]){
        mergedArray[i] = leftArray[l];
        l++;
        i++;
      }
      else {
        mergedArray[i] = rightArray[r];
        r++;
        i++;
      }
    }
    while (l < leftLength){
      mergedArray[i] = leftArray[l];
      l++;
      i++;
    }
    while(r< rightLength){
      mergedArray[i] = rightArray[r];
      r++;
      i++;
    }
    return mergedArray;
  }
  public static void quickSort(int[] tempArray, int start , int end){
    if (start >= end || tempArray.length <= 1){
      return;
    }
    int pivot = tempArray[end];
    int leftPointer = start;
    int rightPointer = end;

    while(leftPointer < rightPointer){
      while(leftPointer < rightPointer && tempArray[leftPointer] <= pivot){
        leftPointer++;
      }
      while(leftPointer < rightPointer && tempArray[rightPointer] >= pivot){
        rightPointer--;
      }
      int temp = tempArray[rightPointer];
      tempArray[rightPointer] = tempArray[leftPointer];
      tempArray[leftPointer] = temp;
    }

    int temp = tempArray[end];
    tempArray[end] = tempArray[leftPointer];
    tempArray[leftPointer] = temp;
    quickSort(tempArray,start,leftPointer - 1);
    quickSort(tempArray,leftPointer+1, end);
  }


  
}
