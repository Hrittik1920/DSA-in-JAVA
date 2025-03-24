public class HeapSort {
    // RECURSIVE HEAPSORT (Time Complexity : O(nlogn), Space Complexity : O(logn))
    public static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }

        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }

    public static void heapSort(int[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    // ITERATIVE HEAPSORT (Time Complexity : O(nlogn), Space Complexity : O(1))
    static void buildMaxHeap(int arr[], int n) {
        for (int i = 1; i < n; i++) {
            // if child is bigger than parent
            if (arr[i] > arr[(i - 1) / 2]) {
                int j = i;

                // swap child and parent until
                // parent is smaller
                while (arr[j] > arr[(j - 1) / 2]) {
                    swap(arr, j, (j - 1) / 2);
                    j = (j - 1) / 2;
                }     
            }
        }
    }

    static void heapSortIterative(int arr[], int n) {
        buildMaxHeap(arr, n);

        for (int i = n - 1; i > 0; i--) {
            // swap value of first indexed
            // with last indexed
            swap(arr, 0, i);

            // maintaining heap property
            // after each swapping
            int j = 0, index;

            do {
                index = (2 * j + 1);

                // if left child is smaller than
                // right child point index variable
                // to right child
                if (index < (i - 1) && arr[index] < arr[index + 1])
                    index++;

                // if parent is smaller than child
                // then swapping parent with child
                // having higher value
                if (index < i && arr[j] < arr[index])
                    swap(arr, j, index);

                j = index;

            } while (index < i);
        }
    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = { 6, 8, 2, 1, 4, 9, 7, 3, -1, 0, -1, -2, 55 };
        printArray(arr);
        // heapSort(arr);
        heapSortIterative(arr, arr.length);
        System.out.print("Sorted list by HeapSort : ");
        printArray(arr);
    }
}
