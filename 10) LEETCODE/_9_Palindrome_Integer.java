public class _9_Palindrome_Integer {
    public static boolean isPalindrome(int x) {
        Integer ix = x;
        String s = ix.toString();
        int l = s.length();
        for(int i=0,j=l-1;i<l/2;i++,j--) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int x = 123421;
        System.out.println(isPalindrome(x));
    }

    // *********BEST TIME*****************
    // public boolean isPalindrome(int x) {
    //     int n=x;
    //     int sum =0;
    //     int r;
    //     while(n>0){
    //         r=n%10;
    //         sum=sum*10+r;
    //         n/=10;
    //     }
    //     if(sum==x){
    //         return true;
    //     }
    //     else
    //     return false;
    // }

    
}
