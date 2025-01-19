
class RadixSort {
	
	// Main radix sort function
    public static void radixSort(int[] arr) {
        // Find the maximum number to determine the number of digits
        int max = arr[0]; // Initialize max with the first element of the array
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i]; // Update max if a larger number is found
            }
        }
        
        // Apply counting sort for every digit in base 10 (1's, 10's, 100's, etc.)
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortByDigit(arr, exp);
        }
    }

    // A function to perform counting sort of arr[] according to the digit represented by exp
    private static void countingSortByDigit(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n]; // Output array to store sorted numbers
        int[] count = new int[10]; // Count array to store frequency of digits (0-9)

        // Store count of occurrences of digit in current position on exp
        for (int i = 0; i < n; i++) {
            ++count[(arr[i] / exp) % 10];
        }

        // Update count[i] to contain the actual positions of this digit in output[]
        // cumulative sum of current index count and the count of previous index
        // the number represents the last position of this digit in the output[]
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array, by iterating from the end of the input array
        // and placing the value in output[] at the index (position - 1) 
        // indicated in the count array
        for (int i = n - 1; i >= 0; i--) {
            output[--count[(arr[i] / exp) % 10]] = arr[i];
        }

        // Copy output[] to arr[], so the original array now contains the sorted numbers
        for (int i = 0; i < n; i++) {
        	arr[i] = output[i];
        }
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

}
