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

    private void merge(Record[] arr, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;

        Record[] leftArr = new Record[n1];
        Record[] rightArr = new Record[n2];

        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[p + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArr[j] = arr[q + j + 1];
        }

        int i = 0, j = 0, k = p;

        while (i < n1 && j < n2) {
            if (leftArr[i].getIdNumber() <= rightArr[j].getIdNumber()) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }

    public void mergeSort(Record[] arr, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(arr, p, q);
            mergeSort(arr, q + 1, r);
            merge(arr, p, q, r);
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

            heapify(arr, i, 0);
        }
    }
}