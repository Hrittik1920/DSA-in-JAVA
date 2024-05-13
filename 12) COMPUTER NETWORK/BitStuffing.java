public class BitStuffing {
    public static int[] bitStuffing(int[] arr) {
        int l = arr.length;
        int inc = l/5;
        int[] ans = new int[l+inc];
        int check = 0;
        int i=0;
        int k=0;
        while(i<l) {
            if(check == 5) {
                ans[k] = 0;
                k++;
                check=0;
                continue;
            }
            if(arr[i] == 1) {
                check++;
                ans[k] = arr[i];
                i++;k++;
            } else {
                check = 0;
                ans[k] = arr[i];
                k++;i++;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {0,1,1,1,1,1,1,0,0,0,1,1,1,1,1,0,1,0,1,1,1,1,1};
        int[] ans = bitStuffing(arr);
        for(int i=0;i<ans.length-6;i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
