/* This file contains implementations of sorting algorithms.
 * You are NOT allowed to modify any of the given method headers.
 */

public class SortingAlgorithms {

    /*
     * You may define additional helper functions here if you need to.
     * Make sure the helper functions have the private access modifier, as
     * they will only be used in this class.
     */

    public void insertionSort(Record[] arr, int n) { // i assume n = length of array
        for (int i = 1; i < n; i++) {
            Record key = arr[i]; // take second item on first iteration
            int j = i - 1; // get elements from before ith item

            /*
             * loop while j is in array
             * and id is still less than the id of key
             * basically move the key to the left until it's less than the key
            */
            while (j >= 0 && key.getIdNumber() < arr[j].getIdNumber()) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    public void selectionSort(Record[] arr, int n) {
        for(int index = 0; index < n - 1; index++) {
            int lowest = index;
            for(int compare = index + 1; compare < n; compare++) {
                if(arr[compare].getIdNumber() < arr[lowest].getIdNumber()) {
                    lowest = compare;
                }
            }
            Record temp = arr[lowest];
            arr[lowest] = arr[index];
            arr[index] = temp;
        }
    }

    private void merge(Record[] array, int start, int mid, int end) {
        // Calculates the lengths of the two subarrays
        int length1 = mid - start + 1;
        int length2 = end - mid;

        // Creates temporary subarrays
        Record[] leftSubarray = new Record[length1];
        Record[] rightSubarray = new Record[length2];

        // Copies elements from the original array to the temporary subarrays
        for (int i = 0; i < length1; i++) {
            leftSubarray[i] = array[start + i];
        }
        for (int j = 0; j < length2; j++) {
            rightSubarray[j] = array[mid + j + 1];
        }

        // Merges the two subarrays back into the original array
        int i = 0, j = 0, k = start;

        while (i < length1 && j < length2) {
            if (leftSubarray[i].getIdNumber() <= rightSubarray[j].getIdNumber()) {
                array[k] = leftSubarray[i];
                i++;
            } else {
                array[k] = rightSubarray[j];
                j++;
            }
            k++;
        }

        // Copies any remaining elements from the left subarray
        while (i < length1) {
            array[k] = leftSubarray[i];
            i++;
            k++;
        }

        // Copies any remaining elements from the right subarray
        while (j < length2) {
            array[k] = rightSubarray[j];
            j++;
            k++;
        }
    }

    public void mergeSort(Record[] array, int start, int end) {
        if (start < end) {
            // Finds the middle index
            int mid = (start + end) / 2;

            // Recursively sorts the two halves
            mergeSort(array, start, mid);
            mergeSort(array, mid + 1, end);

            // Merges the sorted halves
            merge(array, start, mid, end);
        }
    }

    /*
     * Define AT LEAST ONE more sorting algorithm here, apart from the
     * ones given above. Make sure that the method accepts an array of
     * records
     */

    private void heapify(Record[] arr, int n, int i) {
        int largestIndex = i;
        int leftIndex = 2 * i + 1; // left node: 2 * i + 1
        int rightIndex = 2 * i + 2; // right node: 2 * i + 2

        // compare with left node
        if (leftIndex < n && arr[leftIndex].getIdNumber() > arr[largestIndex].getIdNumber()) {
            largestIndex = leftIndex;
        }

        // compare if right node
        if (rightIndex < n && arr[rightIndex].getIdNumber() > arr[largestIndex].getIdNumber()) {
            largestIndex = rightIndex;
        }

        // check if left or right node is largest
        if (largestIndex != i) {
            // swap
            Record temp = arr[i];
            arr[i] = arr[largestIndex];
            arr[largestIndex] = temp;

            heapify(arr, n, largestIndex);
        }
    }

    public void heapSort(Record[] arr, int n) {
        // turn array into a heap structure
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // sort the heap
        for (int i = n - 1; i >= 0; i--) {
            /*
             * swap root node with last node,
             * reheapify until last node - 1 (this is implied
             * since n in heapify function is the number of items not index)
             */
            Record temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }
}