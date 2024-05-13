public class insertionSort {
    public static void main(String[] args) {
        int arr[] = {4,6,9,2,3,5,1,6,2,4,3,7,4,7};
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
        for(int i=1;i<arr.length;i++) {
            int key = arr[i];
            int j = i - 1;
            while(j >= 0  &&  key > arr[j]) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
    }
}
