import java.util.Arrays;

public class KnapsackProblem {
    static class Materials {
        int id, profit, weight;
        public Materials(int id, int profit, int weight) {
            this.id = id;
            this.profit = profit;
            this.weight = weight;
        }
    }
    public static double maximumProfit(Materials[] arr, int maxCapacity, int n) {
        Arrays.sort(arr, (a1, a2) -> { return (a2.profit/a2.weight) - (a1.profit/a1.weight);});
        double maxProfit = 0;
        for(int i=0;i<arr.length;i++) {
            int newCap = maxCapacity - arr[i].weight;
            if(newCap > 0) {
                maxProfit += arr[i].profit;
                maxCapacity = newCap;
            } else if(newCap == 0) {
                maxProfit += arr[i].profit;
                break;
            } else {
                maxProfit += (((double)maxCapacity/arr[i].weight)*arr[i].profit);
                break;
            }
        }
        return maxProfit;    
    }
    public static void main(String[] args) {
        Materials[] arr = {new Materials(1, 10, 2), new Materials(2, 5, 3), new Materials(3, 15, 5), new Materials(4, 7, 7), 
                            new Materials(5, 6, 1), new Materials(6, 18, 4), new Materials(7, 3, 1)};
        int maxCapacity = 15;
        System.out.println(maximumProfit(arr, maxCapacity, arr.length));
    }
}
