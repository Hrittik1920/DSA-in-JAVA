import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void combinationSum(int[] arr, int i, List<Integer> comb, List<List<Integer>> ans, int target) {
        if(target == 0) {
            ans.add(new ArrayList<>(comb));
            return;
        }
        if(i == arr.length || target < 0) return;
        comb.add(arr[i]);
        // combinationSum(arr, i+1, comb, ans, target-arr[i]);
        combinationSum(arr, i, comb, ans, target-arr[i]);
        comb.remove(comb.size()-1);
        combinationSum(arr, i+1, comb, ans, target);
    }
    public static void main(String[] args) {
        int[] arr = {2, 3, 5};
        int target = 8;
        List<List<Integer>> ans = new ArrayList<>();
        combinationSum(arr, 0, new ArrayList<>(), ans, target); 
        System.out.println(ans);
    }
}
