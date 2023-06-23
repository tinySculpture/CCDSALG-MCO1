public class Main {
    public static void main(String[] args) {
        Record records[];
        FileReader fr = new FileReader();
        SortingAlgorithms sa = new SortingAlgorithms();
        
        long[] results = new long[5];
        long average = 0;
        int num = 100000, nTimes = 5;
        
        System.out.println("");

        for (int i = 0; i < nTimes; i++) {
            // records = fr.readFile(".\\data\\random" + num + ".txt");
            // records = fr.readFile(".\\data\\totallyreversed.txt");
            records = fr.readFile(".\\data\\almostsorted.txt");

            // System.out.println("Heap Sort (Random " + num + "): ");
            // System.out.println("Heap Sort (Totally Reversed): ");
            System.out.println("Heap Sort (Almost Sorted): ");
            
            long startTime = System.currentTimeMillis();
            
            // sa.insertionSort(records, num);
            // sa.selectionSort(records, num);
            // sa.mergeSort(records, 0, num - 1);
            sa.heapSort(records, num);

            long endTime = System.currentTimeMillis();
            long executionTime = endTime - startTime;
            results[i] = executionTime;
    
            System.out.println("Time of test " + (i + 1) + ": " + executionTime + "ms \n");
        }

        for (long r : results) {
            average += r;
        }

        System.out.println("Average run time: " + (average / nTimes) + "ms");
    }
}
