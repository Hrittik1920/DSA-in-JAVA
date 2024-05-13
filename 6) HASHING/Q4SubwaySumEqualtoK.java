import java.util.HashMap;

public class Q4SubwaySumEqualtoK {
    public static void main(String[] args) {
        int arr[] = {10,2,-2,-20,10};
        int k = -10;
        int sum=0,ans=0;

        // for(int i=0;i<arr.length;i++) {
        //     sum = 0;
        //     for(int j=i;j<arr.length;j++) {
        //         sum += arr[j];
        //         if(sum == k) {
        //             ans++;
                    
        //             for(int n=i;n<=j;n++) {
        //                 System.out.print(arr[n] + " ");
        //             }
        //             System.out.println();
        //         }
        //     }
        // }
        // System.out.println(ans);

        HashMap<Integer,Integer> map = new HashMap<>(); // <sum, freq>
        
        map.put(0,1); // empty subarray
        
        for(int j=0;j<arr.length;j++) {
            sum += arr[j];
            if(map.containsKey(sum-k)) {
                ans += map.get(sum-k);
            }

            if(map.containsKey(sum)) {
                map.put(sum,map.get(sum) + 1);
            } else {
                map.put(sum,1);
            }
        }

        System.out.println(ans);
    }
}
