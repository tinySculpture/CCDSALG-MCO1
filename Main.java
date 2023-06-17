public class Main {
    public static void main(String[] args) {
        Record records[];
        FileReader fr100 = new FileReader();
        SortingAlgorithms sa = new SortingAlgorithms();

        records = fr100.readFile(".\\data\\random100.txt");
        
        long startTime = System.currentTimeMillis();

        sa.heapSort(records, 100);

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.println("Start: " + startTime);
        System.out.println("End: " + endTime);
        System.out.println("Time: " + executionTime);

        // sa.printArray(records, 100);
    }
}
