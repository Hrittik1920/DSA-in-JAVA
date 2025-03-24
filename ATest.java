import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class ATest {
    static class Job {
        int id, deadline, profit;
        public Job(int id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }
    public static int[] jobScheduling(Job[] arr) {
        Arrays.sort(arr, (a1, a2) -> Integer.compare(a2.profit, a1.profit));
        int maxDeadline = 0;
        for(Job job : arr) 
            maxDeadline = Math.max(maxDeadline, job.deadline);
        int[] slots = new int[maxDeadline+1];
        Map<Integer, Integer> map = new TreeMap<>();
        int count = 0, sum = 0;
        for(int i=0;i<arr.length;i++) {
            for(int j=arr[i].deadline;j>=1;j--) {
                if(slots[j] == 0) {
                    count++;
                    slots[j] = 1;
                    sum += arr[i].profit;
                    map.put(arr[i].id, arr[i].profit);
                    break;
                }
            }
        }
        for(int num : map.keySet()) {
            System.out.println("id: " + num + "  profit: " + map.get(num));
        }
        return new int[] {count, sum};
    }
    public static void main(String[] args) {
        int[] id = {1, 2, 3, 4, 5};
        int[] deadline = {2, 1, 2, 1, 1};
        int[] profit = {100, 19, 27, 25, 15};
        Job[] arr = new Job[id.length];
        for(int i=0;i<id.length;i++) {
            arr[i] = new Job(id[i], deadline[i], profit[i]);
        }
        int[] ans = jobScheduling(arr);
        System.out.println("id_Count: " + ans[0] + "  Total_profit: " + ans[1]);
    }
}
