public class _5_Longest_Palindromic_Substring {
    public static boolean isPalindrome(String str,int i,int j) {
        for(int k=i,l=j;k<=(j+i)/2;k++,l--) {
            if(str.charAt(k) != str.charAt(l)) {
                return false;
            }
        }
        // for(int k=0;k<(j-i)/2;k++) {
        //     if(str.charAt(i) != str.charAt(j)) {
        //         return false;
        //     }
        //     i++;j++;
        // }
        return true;
    }
    public static String longestPalindrome(String s) {
        String ans = "";
        int n = s.length();
        for(int i=0;i<n;i++)  {
            for(int j=i;j<n;j++) {
                if(isPalindrome(s, i, j)) {
                    if((j-i+1) > ans.length()) {
                        ans = s.substring(i, j+1);
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String str = "a";
        
        System.out.println(longestPalindrome(str));
        
    }
}
