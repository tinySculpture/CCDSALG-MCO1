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

        for (int i = 0; i < 100; i++) {
            System.out.println(arr[i].getName() + ": " + arr[i].getIdNumber());
        }
    }

    public void selectionSort(Record[] arr, int n) {
        // TODO: Implement this sorting algorithm here.

    }

    public void mergeSort(Record[] arr, int p, int r) {
        // TODO: Implement this sorting algorithm here.

    }

    /*
     * Define AT LEAST ONE more sorting algorithm here, apart from the
     * ones given above. Make sure that the method accepts an array of
     * records
     */

    private void heapify(Record[] arr, int n, int i) {
        int largestIndex = i;
        int leftIndex = 2 * i + 1;
        int rightIndex = 2 * i + 2;

        if (leftIndex < n && arr[leftIndex].getIdNumber() > arr[largestIndex].getIdNumber()) {
            largestIndex = leftIndex;
        }

        if (rightIndex < n && arr[rightIndex].getIdNumber() > arr[largestIndex].getIdNumber()) {
            largestIndex = rightIndex;
        }

        if (largestIndex != i) {
            // swap
            Record temp = arr[i];
            arr[i] = arr[largestIndex];
            arr[largestIndex] = temp;

            heapify(arr, n, largestIndex);
        }
    }

    public void heapSort(Record[] arr, int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        /*
         * Actual heap sort
         */
        for (int i = n - 1; i >= 0; i--) {
            // swap
            Record temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // System.out.println("0: " + arr[0].getIdNumber() + " i " + i + ": " + arr[i].getIdNumber());

            heapify(arr, i, 0);
        }
    }

    public void printArray(Record[] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i].getName() + ": " + arr[i].getIdNumber());
        }
    }

}