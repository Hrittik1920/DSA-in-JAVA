import java.util.Scanner;

public class _1_Interview_Easy_Que {
    public static void main(String[] args) {
    
        final int DEFAULT_LENGTH = 5;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the Element:");
        int l = sc.nextInt();
        if(l > DEFAULT_LENGTH) {
            System.out.println("Excide Length!");
            sc.close();
            return;
        } else if(l<0) {
            System.out.println("Invalid Length!");
            sc.close();
            return;
        }
        int[] arr = new int[l];
        System.out.println("Enter Elements");
        int sum = 0;
        for(int i=0;i<l;i++) {
            System.out.printf("Element[%d]:",i);
            arr[i] = sc.nextInt();
        }
        for(int i=0;i<l;i++) {
            System.out.print(arr[i] + " ");
            if(arr[i]%2 == 0) {
                sum += arr[i];
            }
        }
        System.out.println();
        System.out.println("Sum: " + sum);
        sc.close();
    }
    
}
