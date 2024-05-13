import java.util.Arrays;

public class _977_Squares_of_Sorted_Array {
    public static int[] sortedSquares(int[] nums) {
        for(int i=0;i<nums.length;i++) {
            nums[i] *= nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
    public static void main(String[] args) {
        int[] nums = {-4,-1,0,3,10};
        for(int x : sortedSquares(nums)) {
            System.out.print(x + " ");
        }
    }
}