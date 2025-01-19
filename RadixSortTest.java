// Test class for Radix Sort

public class RadixSortTest {
    public static void main(String[] args) {

        int[] arr = {783, 99, 472, 182, 264, 543, 356, 295, 692, 491, 94};
        
        System.out.println("Original Array:");
        RadixSort.printArray(arr);

        RadixSort.radixSort(arr);

        System.out.println("Sorted Array:");
        RadixSort.printArray(arr);
    }
}
