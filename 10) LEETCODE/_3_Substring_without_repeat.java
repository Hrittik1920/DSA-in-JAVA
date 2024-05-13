import java.util.Arrays;

public class _3_Substring_without_repeat {

    // public int lengthOfLongestSubstring(String s) {
    //     Set<Character> set = new HashSet();
    //     int max = 0;
    //     int left = 0;
    //     for (int right = 0; right < s.length(); right++) {
    //         while (!set.add(s.charAt(right))) {
    //             set.remove(s.charAt(left++));
    //         }
    //         max = Math.max(max, right - left + 1);
    //     }
    //     return max;
    // }

    public static int lengthOfLongestSubstring(String s) {
        boolean[] vis = new boolean[256];
        char curr;
        int len = 0;
        int length = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                curr = s.charAt(j);
                if (vis[curr] == false) {
                    vis[curr] = true;
                    len++;
                } else {
                    if (len > length) {
                        length = len;
                    }
                    Arrays.fill(vis, false);
                    // vis[curr] = true;
                    len = 0;
                    break;
                }
            }
        }
        if (len > length) {
            length = len;
        }
        return length;
    }

    public static void main(String arg[]) {
        String str = "dvdf";
        System.out.println(lengthOfLongestSubstring(str));

    }

    // public int lengthOfLongestSubstring(String s) {
    // int n = s.length();
    // int maxLength = 0;
    // int[] charIndex = new int[128]; // Assuming ASCII characters

    // for (int start = 0, end = 0; end < n; end++) {
    // char currentChar = s.charAt(end);

    // // Move the starting pointer to the next character of the repeated character
    // start = Math.max(charIndex[currentChar], start);

    // // Update the maximum length
    // maxLength = Math.max(maxLength, end - start + 1);

    // // Store the index of the next character
    // charIndex[currentChar] = end + 1;
    // }

    // return maxLength;
    // }

    // public static void main(String[] args) {
    // Solution solution = new Solution();
    // String s = "abcabcbb";
    // int result = solution.lengthOfLongestSubstring(s);
    // System.out.println(result); // Output: 3
    // }

}
