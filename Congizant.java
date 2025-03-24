import java.util.HashMap;
import java.util.Stack;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Map;

public class Congizant {
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int j = low - 1;
        for(int i=low;i<high;i++) {
            if(arr[i] < pivot) {
                j++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        j++;
        int temp = arr[j];
        arr[j] = pivot;
        arr[high] = temp;
        return j;
    }
    public static void quickSort(int[] arr, int low, int high) {
        if(low < high) {
            int part = partition(arr, low, high);

            quickSort(arr, low, part-1);
            quickSort(arr, part+1, high);
        }
    }
    public static int partitionDesc(int[] arr, int low, int high) {
        int pivot = arr[high];
        int j = low - 1;
        for(int i=low;i<high;i++) {
            if(arr[i] > pivot) {
                j++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        j++;
        int temp = arr[j];
        arr[j] = pivot;
        arr[high] = temp;
        return j;
    }
    public static void quickSortDesc(int[] arr, int low, int high) {
        if(low < high) {
            int part = partitionDesc(arr, low, high);

            quickSortDesc(arr, low, part-1);
            quickSortDesc(arr, part+1, high);
        }
    }
    public static void main(String[] args) {
        // int[] arr = {1, 5, 7, -1, 5};
        int[] arr = {6, -1, 8, 0, 4, -9, -1, -10, -6, -5, 0, 1, -4, 6, -6, 4, -4, -3, 3};
        int k = 8;
        quickSort(arr, 0, k-1);
        quickSortDesc(arr, k, arr.length-1);
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i] + " ");
        }
    }
}






































// public static void main(String[] args) {
// String sen = "Hey my name is hrittik";
// StringBuilder sb = new StringBuilder("");
// StringBuilder sec;
// for(int i=0;i<sen.length();i++) {
// int ascii = (int)sen.charAt(i);
// int c = 1;
// sec = new StringBuilder("");
// while(ascii != 0) {
// c++;
// sec.insert(0, (int)(ascii%2)+"");
// ascii = ascii >> 1;
// }
// for(int j = c;j<=8;j++) {
// sec.insert(0, "0");
// }
// sb.append(sec);
// sb.append(" ");
// }
// System.out.println(sb);
// }
