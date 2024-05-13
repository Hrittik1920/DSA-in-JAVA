import java.util.Arrays;

public class _16_three_Sum_Closest  {
    public static int threeSumClosest(int[] nums,int target) {
        int n = nums.length;
        int ans = nums[0] + nums[1] + nums[2];

        Arrays.sort(nums);

        for(int i=0;i+2<n;i++) {
            if(i>0 && nums[i] == nums[i-1]) {
                continue;
            }

            int l = i+1;
            int r = n-1;
            
            while(l<r) {
                final int sum = nums[i] + nums[l] + nums[r];
                if(sum == target) {
                    return sum;
                }
                if(Math.abs(sum - target) < Math.abs(ans - target)){
                    ans = sum;
                }
                if(sum < target) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSumClosest(nums, 0));
    }
}
