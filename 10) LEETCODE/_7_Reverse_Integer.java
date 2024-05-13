public class _7_Reverse_Integer {
    public static int reverse(int x) {
        long ans = 0;
        while(x!=0) {
            int rem = x%10;
            ans = ans*10 + rem;
            x /= 10;
        }
        System.out.println(ans);
        if(!(ans < Integer.MAX_VALUE  && ans >= Integer.MIN_VALUE)) {
            return 0;
        }
        
        return (int)ans;
    }
    public static void main(String[] args) {
        System.out.println(reverse(Integer.MAX_VALUE));
    }

    // class Solution {
    //     public int reverse(int x) {
    //         boolean isNeg = x < 0;
           
    //         long xl = Math.abs((long)(x));
    //         long r = xl%10;
    //         xl = xl/10;
    //         while(xl >= 1){
    //            long l = xl%10;
    //             r=r*10+l;
    //             xl=xl/10;
    //         }
    //         if(r > Integer.MAX_VALUE){
    //             return 0;
    //         }
    
    //         return (int)(isNeg?r*-1: r);
            
    //     }
    // }
}
