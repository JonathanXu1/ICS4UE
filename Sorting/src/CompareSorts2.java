/* [CompareBubbleSelection.java]
 * This program is a template for a comparing sorting algorithms
 * Random numbers are generated and tested with various sorting algorithms
 */

import java.util.Random;
import java.util.Arrays;

public class CompareSorts2 {

  /** Main method *******************************************
   */
  public static void main(String[] args) {

    int data[] = generateNumberArray(10);
    int[] tempArray; // a temp holder for data as it is passed to methods
    long startTime, endTime;
    double elapsedTime;

    System.out.println("Array generated: ");
    displayArray(data);


    //Testing Selection Sort -----------------
    System.out.println("\nSorting with Selection sort:");
    tempArray = Arrays.copyOf(data,data.length); //to keep original arrays safe from modification
    startTime = System.nanoTime();     //start time

    tempArray = selectionSort(tempArray);

    endTime = System.nanoTime();  //end time
    elapsedTime = (endTime - startTime) / 1000000.0;

    displayArray(tempArray);
    System.out.println("The sort took: " + elapsedTime + "ms");


    //Testing Bubble Sort -----------------
    System.out.println("\nSorting with Bubble sort:");
    tempArray = Arrays.copyOf(data,data.length); //to keep original arrays safe from modification
    startTime = System.nanoTime();     //start time

    tempArray = bubbleSort(tempArray);

    endTime = System.nanoTime();  //end time
    elapsedTime = (endTime - startTime) / 1000000.0;

    displayArray(tempArray);
    System.out.println("The sort took: " + elapsedTime + "ms");

    //Testing Insertion Sort -----------------
    System.out.println("\nSorting with Insertion sort:");
    tempArray = Arrays.copyOf(data,data.length); //to keep original arrays safe from modification
    startTime = System.nanoTime();     //start time

    tempArray = insertionSort(tempArray);

    endTime = System.nanoTime();  //end time
    elapsedTime = (endTime - startTime) / 1000000.0;

    displayArray(tempArray);
    System.out.println("The sort took: " + elapsedTime + "ms");

    //Testing Merge Sort -----------------
    System.out.println("\nSorting with Merge sort:");
    tempArray = Arrays.copyOf(data,data.length); //to keep original arrays safe from modification
    startTime = System.nanoTime();     //start time

    tempArray = mergeSort(tempArray);

    endTime = System.nanoTime();  //end time
    elapsedTime = (endTime - startTime) / 1000000.0;

    displayArray(tempArray);
    System.out.println("The sort took: " + elapsedTime + "ms");

    //Testing Quick Sort -----------------
    System.out.println("\nSorting with Quick sort:");
    tempArray = Arrays.copyOf(data,data.length); //to keep original arrays safe from modification
    startTime = System.nanoTime();     //start time

    tempArray = quickSort(tempArray);

    endTime = System.nanoTime();  //end time
    elapsedTime = (endTime - startTime) / 1000000.0;

    displayArray(tempArray);
    System.out.println("The sort took: " + elapsedTime + "ms");


    //Testing Arrays.sort -----------------
    System.out.println("\nSorting with Arrays.sort sort:");
    tempArray = Arrays.copyOf(data,data.length);  //to keep original arrays safe from modification
    startTime = System.nanoTime();     //start time

    tempArray = javaBuiltInSort(tempArray);

    endTime = System.nanoTime();  //end time
    elapsedTime = (endTime - startTime) / 1000000.0;

    displayArray(tempArray);
    System.out.println("The sort took: " + elapsedTime + "ms");

  } //end of main method


  /** generateNumberArray *******************************************
   * Creates a random array on integers
   * @param size of array
   * @return the generated integer array
  */
  public static int[] generateNumberArray(int numOfElements) {

    int[] generated = new int[numOfElements];

    //add unique numbers into array in order
    for (int i = 0 ; i< generated.length;i++)
      generated[i]=i;

    //shuffle the numbers randomly
    Random randomNumber = new Random();
    for (int i = 0 ; i< generated.length;i++) {
      //swap to random positions
      int temp;
      int first = randomNumber.nextInt(generated.length);
      int second = randomNumber.nextInt(generated.length);
      temp = generated[first];
      generated[first]=generated[second];
      generated[second]=temp;
    }

    return generated;
  } //end of generateNumberArray


  /** displayArray *******************************************
   * Sorts a random array on integers using selection sort
   * @param the  integer array
   */
  public static void displayArray(int[] numbers) {
    for (int i = 0 ; i< numbers.length;i++) {
      System.out.print(numbers[i]+" ");
    }
    System.out.println("");
  }

  /** selectionSort *******************************************
   * Sorts a random array on integers using selection sort
   * @param the unsorted integer array
   * @return the sorted integer array
   */
  public static int[] selectionSort(int[] numbers) {
    //******* Your code here *************
    if(numbers.length <= 1){
      return numbers;
    }

    for(int i = 0; i < numbers.length - 1; i++){
      int smallestIndex = i+1;
      for(int j = i + 1; j < numbers.length; j++){
        if(numbers[j] < numbers[smallestIndex]){
          smallestIndex = j;
        }
      }
      if(numbers[smallestIndex] < numbers[i]){
        int temp = numbers[i];
        numbers[i] = numbers[smallestIndex];
        numbers[smallestIndex] = temp;
      }
    }

    return numbers;

  }

  /** bubbleSort *******************************************
   * Sorts a random array on integers using bubble sort
   * @param the unsorted integer array
   * @return the sorted integer array
   */
  public static int[] bubbleSort(int[] numbers) {
    //******* Your code here *************
    if(numbers.length <= 1){
      return numbers;
    }

    int i = 1;
    boolean swapped;
    do{
      swapped = false;
      for(int j = 0; j < numbers.length - i; j++){
        if(numbers[j] > numbers[j+1]){
          int temp = numbers[j];
          numbers[j] = numbers[j+1];
          numbers[j+1] = temp;
          swapped = true;
        }
      }
      i++;
    } while(i < numbers.length && swapped);

    return numbers;
  }

  /** insertionSort *******************************************
   * Sorts a random array on integers using bubble sort
   * @param the unsorted integer array
   * @return the sorted integer array
   */
  public static int[] insertionSort(int[] numbers) {
    //******* Your code here *************
    if(numbers.length <= 1){
      return numbers;
    }

    for(int i = 1; i < numbers.length; i ++){
      int j = i-1;
      while(j >= 0 && numbers[j] > numbers[j+1]){
        int temp = numbers[j];
        numbers[j] = numbers[j+1];
        numbers[j+1] = temp;
        j--;
      }
    }
    return numbers;
  }

  /** mergeSort *******************************************
   * Sorts a random array on integers using bubble sort
   * @param the unsorted integer array
   * @return the sorted integer array
   */
  public static int[] mergeSort(int[] numbers) {
    //******* Your code here *************
    numbers = mergeSort(numbers, 0, numbers.length);
    return numbers;
  }

  public static int[] mergeSort(int[] numbers, int start, int end){

    if(end - start == 0){
      int[] output = {};
      return output;
    } else if(end - start == 1){
      int[] output = {numbers[start]};
      return output;
    }

    int mid = (start+end)/2;
    int[] left = mergeSort(numbers, start, mid);
    int[] right = mergeSort(numbers, mid, end);

    int leftIndex = 0;
    int rightIndex = 0;
    int[] merged = new int[end-start];
    int mergedIndex = 0;

    while(leftIndex < left.length && rightIndex < right.length){
      if(left[leftIndex] <= right[rightIndex]){
        merged[mergedIndex] = left[leftIndex];
        leftIndex ++;
      } else {
        merged[mergedIndex] = right[rightIndex];
        rightIndex ++;
      }
      mergedIndex ++;
    }
    while(leftIndex < left.length){
      merged[mergedIndex] = left[leftIndex];
      leftIndex ++;
      mergedIndex ++;
    }
    while(rightIndex < right.length){
      merged[mergedIndex] = right[rightIndex];
      rightIndex ++;
      mergedIndex ++;
    }
    return merged;

  }

  /** quickSort *******************************************
   * Sorts a random array on integers using bubble sort
   * @param the unsorted integer array
   * @return the sorted integer array
   */
  public static int[] quickSort(int[] numbers) {
    //******* Your code here *************
    quickSort(numbers, 0, numbers.length);
    return numbers;
  }

  public static void quickSort(int[] numbers, int start, int end){

    if(end-start <= 1){
      return;
    }

    int pivot = (end+start)/2;
    int i = start;
    int j = end-1;
    while(i < j){
      System.out.println(i + " " + j);
      if (numbers[i] < numbers[pivot]){
        i++;
      }
      if (numbers[j] > numbers[pivot]){
        j--;
      }
      int temp = numbers[i];
      numbers[i] = numbers[j];
      numbers[j] = temp;
      i++;
      j--;
    }

    if(start < j){
       quickSort(numbers, start, j);
       quickSort(numbers, j, end);
    } else {
       quickSort(numbers, start, i);
       quickSort(numbers, i, end);
    }
  }

  /** javaBuiltInSort *******************************************
   * Sorts a random array on integers using Arrays.sort
   * @param the unsorted integer array
   * @return the sorted integer array
   */
  public static int[] javaBuiltInSort( int[] numbers) {
    Arrays.sort(numbers);  //sort
    return numbers;
  }

}