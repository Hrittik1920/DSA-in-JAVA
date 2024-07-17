public class QuickSort {
    public static void dualPivotQuickSort(int[] arr, int low, int high) {
        if (low < high) {
            // p1 is the first pivot, p2 is the second pivot
            int[] pivots = partitionDual(arr, low, high);
            int p1 = pivots[0];
            int p2 = pivots[1];

            // Recursively sort the three sub-arrays
            dualPivotQuickSort(arr, low, p1 - 1);
            dualPivotQuickSort(arr, p1 + 1, p2 - 1);
            dualPivotQuickSort(arr, p2 + 1, high);
        }
    }

    private static int[] partitionDual(int[] arr, int low, int high) {
        if (arr[low] > arr[high]) {
            swap(arr, low, high);
        }
        int p1 = arr[low];
        int p2 = arr[high];

        int less = low + 1;
        int great = high - 1;
        int i = low + 1;

        while (i <= great) {
            if (arr[i] < p1) {
                swap(arr, i, less++);
            } else if (arr[i] > p2) {
                while (i < great && arr[great] > p2) {
                    great--;
                }
                swap(arr, i, great--);    
                if (arr[i] < p1) {
                    swap(arr, i, less++);
                }
            }
            i++;
        }
        less--;
        great++;

        // Place pivots in their correct positions
        swap(arr, low, less);
        swap(arr, high, great);
        return new int[]{less, great};
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static int partition(int[]arr,int low,int high) {
        int pivot = arr[high];
        int i = low - 1;

        for(int j=low;j<high;j++) {
            if(arr[j] < pivot) {
                i++;
                //swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        int temp = arr[i];
        arr[i] = pivot;
        arr[high] = temp;
        return i;
    }
    public static void quickSort(int[]arr,int low,int high) {
        if(low < high) {
            int pidx = partition(arr,low,high);

            quickSort(arr, low, pidx-1);
            quickSort(arr, pidx+1, high);
        }
    }
    public static void main(String[] args) {
        int[] arr = {5,8,1,9,11,2,5,7,2,3};
        quickSort(arr, 0, arr.length-1);
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i] + " ");
    }
}
