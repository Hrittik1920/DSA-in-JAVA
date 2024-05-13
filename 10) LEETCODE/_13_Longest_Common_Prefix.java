public class _13_Longest_Common_Prefix {
    public static String longestCommonPrefix(String[] strs) {
        StringBuilder ans = new StringBuilder();
        int minLength = Integer.MAX_VALUE;
        for(int i=0;i<strs.length;i++) {
            int l = strs[i].length();
            if(l < minLength) {
                minLength = l;
            }
        }
        boolean match=true;
        char curr;
        for(int i=0;i<minLength;i++) {
            curr = strs[0].charAt(i);
            for(int j=1;j<strs.length;j++) {
                if(strs[j].charAt(i) != curr) {
                    match = false;
                    break;
                }
                match = true;
            }
            if(match == true) {
                ans.append(curr);
            } else {
                break;
            }
        }
        return ans.toString();
    }
    public static void main(String[] args) {
        String[] strs = {"dog","racecar","car"};
        System.out.println(longestCommonPrefix(strs));
    }
}
