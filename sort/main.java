import QuickSort.QuickSort;

public class main {
    public static void main(String[] args) {
    	QuickSort demo = new QuickSort();
    	int[] test = {1,9,2,8,3,7,4,6,5};
    	demo.printArray(test);
    	demo.quickSort(test);
    	demo.printArray(test);
    }
}