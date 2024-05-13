public class selectionSort {
    public static void main(String[] args) {
        int arr[] = {4,5,3,2,8,9,1,2,4,3,1};
        for(int i=0;i<arr.length-1;i++) {
            int smallest=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[smallest]>arr[j])
                    smallest = j;
            }
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
        }
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i] + " ");
    }
}
