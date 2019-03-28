/* [CompareBubbleSelection.java]
 * This program is a template for a comparing sorting algorithms
 * Random numbers are generated and tested with various sorting algorithms
 */

import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;

class CompareSorts {
  
   /** Main method *******************************************
     * @param arguements
     */ 
   public static void main(String[] args) {     
     
     int data[] = generateNumberArray(20);
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
     int lowest;
     for(int i = 0; i < numbers.length-1; i++){
        lowest= numbers[i];
       int lowestIndex = i;

       for(int j = i+1; j < numbers.length; j++ ){
         if(numbers[j] < lowest){
           lowest = numbers[j];
           lowestIndex = j;
         }
       }
       // Swap
       int temp = numbers[i];
       numbers[i] = numbers[lowestIndex];
       numbers[lowestIndex] = temp;
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
     for(int i = 1; i < numbers.length; i++){
       for(int j = 0; j < numbers.length-i; j++){
         //Swap
         if(numbers[j+1] < numbers[j]){
           int temp = numbers[j];
           numbers[j] = numbers[j+1];
           numbers[j+1] = temp;
         }
       }
     }
     return numbers;     
   }

   /** insertionSort *******************************************
     * Sorts a random array on integers using insertion sort
     * @param the unsorted integer array
     * @return the sorted integer array
     */
   // Can I use breaks???
   public static int[] insertionSort(int[] numbers) {    
     //******* Your code here *************
     for(int i = 1; i < numbers.length; i++){ // Item to move
       for(int j = i; j > 0; j--){ // Look backwards
          if(numbers[j] < numbers[j-1]){
            int temp = numbers [j];
            numbers[j] = numbers[j-1];
            numbers[j-1] = temp;
          } else {
            j = 0;
          }

       }
     }
     return numbers;     
   }
   
   /** mergeSort *******************************************
     * Sorts a random array on integers using merge sort
     * @param the unsorted integer array
     * @return the sorted integer array
     */
   public static int[] mergeSort(int[] numbers) {    
     //******* Your code here *************
     numbers = mergeSort(numbers, 0, numbers.length-1);
     return numbers;     
   }
   public static int[] mergeSort(int [] numbers, int start, int end){
     if(end-start <=1){
       int[] result = {numbers[start]};
       return result;
     }
     // Split
     int mid = (start+end)/2;
     int[] set1 = mergeSort(numbers, start, mid);
     int[] set2 = mergeSort(numbers, mid, end);

     //Combine
     int[] combined = new int[end-start];
     int set1Index = 0;
     int set2Index = 0;
     int combinedIndex = 0;
     for(int i = 0; i < end-start; i++){
       // If at the end of both sets
       if(set1Index == set1.length){ // If at the end of either set1 or set2
           for(int j = set2Index; j < set2.length; j++){
             combined[combinedIndex] = set2[j];
             combinedIndex ++;
           }
           i = end;
       } else if(set2Index == set2.length) {
         for (int j = set1Index; j < set1.length; j++) {
           combined[combinedIndex] = set1[j];
           combinedIndex++;
         }
         i = end;
       }
       else { // Normal comparison
         if(set1[set1Index] <= set2[set2Index]){
           combined[combinedIndex] = set1[set1Index];
           set1Index ++;
         } else {
           combined[combinedIndex] = set2[set2Index];
           set2Index ++;
         }
         combinedIndex ++;
       }
     }

     return combined;
   }
   
   /** quickSort *******************************************
     * Sorts a random array on integers using quick sort
     * @param the unsorted integer array
     * @return the sorted integer array
     */
   public static int[] quickSort(int[] snumbers) {
     if(numbers.length <= 1){
       return  numbers;
     }

     int pivot = numbers.length/2;
     int swapLeft = 0;
     int swapRight = numbers.length-1;

     while(swapLeft< swapRight){
       while(swapLeft < pivot && numbers[swapLeft] < numbers[pivot]){
         swapLeft ++;
       }
       while(swapRight > pivot && numbers[swapRight] > numbers[pivot]){
         swapRight --;
       }

       if(numbers[swapLeft] > numbers[pivot] && numbers[swapRight] < numbers[pivot]){
         int temp = numbers[swapLeft];
         numbers[swapLeft] = numbers[swapRight];
         numbers[swapRight] = temp;
         swapLeft ++;
         swapRight --;
       } else if(numbers[swapLeft] > numbers[pivot]){
         int temp = numbers[swapLeft];
         numbers[swapLeft] = numbers[pivot];
         numbers[pivot] = temp;
         pivot = swapLeft;
       } else if(numbers[swapRight] < numbers[pivot]){
         int temp = numbers[swapRight];
         numbers[swapRight] = numbers[pivot];
         numbers[pivot] = temp;
         pivot = swapRight;
       }

     }
     int[] leftList = Arrays.copyOfRange(numbers, 0, swapRight);
     int[] rightList = Arrays.copyOfRange(numbers, swapRight+1, numbers.length);

     leftList = quickSort(leftList);
     rightList = quickSort(rightList);


     int[] output = new int[numbers.length];
     for(int i = 0; i < swapRight; i++){
       output[i] = leftList[i];
     }
     output[swapRight] = numbers[swapRight];
     for(int i = swapRight + 1; i < numbers.length; i++){
       output[i] = rightList[i-swapRight-1];
     }

     return output;
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