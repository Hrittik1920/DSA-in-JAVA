import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.xml.stream.events.Characters;

public class AssessmentTech {
    // // ********************************-> The Next Greater Integer of all elements : O(n) <-************************************************
    // public static int[] nextGreaterInteger(int[] nums) {
    //     Stack<Integer> s = new Stack<>();
    //     int[] ans = new int[nums.length];
    //     ans[nums.length-1] = -1;
    //     s.push(nums[nums.length-1]);
    //     for(int i=nums.length-2;i>=0;i--) {
    //         if(s.peek() > nums[i]) {
    //             ans[i] = s.peek();
    //         } else {
    //             while(!s.empty() && s.peek()<=nums[i]) {
    //                 s.pop();
    //             }
    //             ans[i] = s.empty() ? -1 : s.peek();
    //         }
    //         s.push(nums[i]);
    //     }
    //     return ans;
    // }
    // public static void main(String[] args) {
    //     // int[] nums = {4, 5, 2, 25};
    //     int[] nums = {5, 7, 1, 7, 6, 0};
    //     int[] ans = nextGreaterInteger(nums);
    //     for(int i=0;i<ans.length;i++) {
    //         System.out.print(ans[i] + " ");
    //     }
    // }

    // // **************************************-> Move all the Zeros to the end : O(n) <-***************************************************
    // public static void moveZerosToEnd(int[] nums) {
    //     int j=0;
    //     int count = 0;
    //     for(int i=0;i<nums.length;i++) {
    //         if(nums[i]!=0) {
    //             nums[j] = nums[i];
    //             j++;
    //         } else {
    //             count++;
    //         }
    //     }
    //     for(int i=0;i<count;i++) {
    //         nums[j++] = 0;
    //     }
    // }
    // public static void main(String[] args) {
    //     int[] nums = {1, 2, 0, 0, 0, 4, 5};
    //     moveZerosToEnd(nums);
    //     for(int i=0;i<nums.length;i++) {
    //         System.out.print(nums[i] + " ");
    //     }
    // }

    // // *****************************************-> Maximum sum of subarray : O(n) <-**************************************************
    // public static int maxSumSubarray(int[] nums) {
    //     if(nums.length == 0) return 0;
    //     int cn = nums[0];
    //     int mx = nums[0];
    //     for(int i=1;i<nums.length;i++) {
    //         cn += nums[i];
    //         mx = Math.max(cn, mx);
    //         if(cn < 0) cn=0;
    //     }
    //     return mx;
    // }
    // public static void main(String[] args) {
    //     int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    //     System.out.println(maxSumSubarray(nums));
    // }

    // // ********************************-> Nearest Integer to num which is divisible by m : O(1) <-**************************************************
    // public static int nearestInteger(int num, int m) {
    //     int r = num%m;
    //     if(r < (m+1)/2) {
    //         return num-r;
    //     }
    //     return num + m - r;
    // }
    // public static void main(String[] args) {
    //     int num = 68;
    //     int m = 8;
    //     System.out.println(nearestInteger(num, m));
    // }

    // // ********************************-> Unique Path to (0, 0) index to (n-1, m-1) index : O(n+m) <-**************************************************
    // public static int uniquePaths(int[][] grid, int i, int j, int n, int m) {
    //     if(n == 0 || m == 0) {
    //         return 0;
    //     }
    //     if(grid[n-1][m-1] == 1) {
    //         return 0;
    //     }
    //     if(i == n-1 && j == m-1) {
    //         return 1;
    //     }
    //     if(i == n || j == m) {
    //         return 0;
    //     }
    //     if(grid[i][j] == 1) {
    //         return 0;
    //     }
    //     int leftMove = uniquePaths(grid, i, j+1, n, m);
    //     int downMove = uniquePaths(grid, i+1, j, n, m);
    //     return leftMove + downMove;
    // }
    // public static int uniquePathsIteration(int[][] grid) {
    //     int n = grid.length;
    //     if(n == 0) return 0;

    //     int m = grid[0].length;
    //     if(m == 0) return 0;

    //     if(grid[n-1][m-1] == 1) {
    //         return 0;
    //     }

    //     int[][] dp = new int[n][m];
    //     for(int i=n-1;i>=0;i--) {
    //         for(int j=m-1;j>=0;j--) {
    //             if(grid[i][j] != 1) {
    //                 if(i+1<n && j+1<m) {
    //                     dp[i][j] = dp[i+1][j] + dp[i][j+1];
    //                 } else if(i+1<n && j+1==m) {
    //                     dp[i][j] = dp[i+1][j];
    //                 } else if(i+1==n && j+1<m) {
    //                     dp[i][j] = dp[i][j+1];
    //                 } else {
    //                     dp[i][j] = 1;
    //                 }
    //             }
    //         }
    //     }

    //     return dp[0][0];
    // }
    // public static void main(String[] args) {
    //     int[][] grid = {{0, 0, 0, 0},
    //                     {0, 0, 0, 0},
    //                     {0, 0, 0, 0},
    //                     {0, 0, 0, 0},
    //                     {0, 0, 0, 0},
    //                     {0, 0, 0, 0},
    //                     {0, 0, 0, 0},
    //                     {0, 0, 0, 0}};
    //     long start = System.nanoTime();
    //     System.out.println(uniquePaths(grid, 0, 0, grid.length, grid[0].length));
    //     long finish = System.nanoTime();
    //     System.out.println(finish-start);
    //     long start2 = System.nanoTime();
    //     System.out.println(uniquePathsIteration(grid));
    //     long finish2 = System.nanoTime();
    //     System.out.println(finish2-start2);
    // }

    // // ********************************-> Minimum number of steps to reach the top : O(1) <-**************************************************
    // public static int minimumSteps(int n, int m) {
    //     return (n/m) + (n%m);
    // }
    // public static void main(String[] args) {
    //     int n = 38;
    //     int m = 5;
    //     System.out.println(minimumSteps(n, m));
    // }

    // // ********************************->  No of Subarray which sum is equal to K : O(n) <-**************************************************
    // public static int noOfSubarrayEqualtoK(int[] arr, int k) {
    //     HashMap<Integer, Integer> map = new HashMap<>();
    //     map.put(0, 1);
    //     int sum = 0;
    //     int count = 0;
    //     for(int i=0;i<arr.length;i++) {
    //         sum += arr[i];
    //         if(map.containsKey(sum-k)) {
    //             count += map.get(sum-k);
    //         }
    //         map.put(sum, map.getOrDefault(sum, 0)+1);
    //     }
    //     return count;
    // }
    // public static void main(String[] args) {
    //     int[] arr = {10, 2, -2, -20, 10};
    //     int k = -10;
    //     System.out.println(noOfSubarrayEqualtoK(arr, k));
    // }

    // // ***************************-> Length of Maximum subarray contains equals 0 and 1 : O(n) <-*********8****************************
    // public static int maxLength(int[] arr, int n) {
    //     if(n == 0  ||  n == 1) return 0;
        
    //     HashMap<Integer, Integer> map = new HashMap<>();
    //     map.put(0, -1);
    //     int sum = 0;
    //     int max = 0;
    //     for(int i=0;i<n;i++) {
    //         sum += (arr[i] == 0) ? -1 : 1;
    //         if(map.containsKey(sum)) {
    //             max = Math.max(max, i-map.get(sum));
    //         } else {
    //             map.put(sum, i);
    //         }
    //     }
    //     return max;
    // }
    // public static void main(String[] args) {
    //     int[] arr = {0, 1, 1, 1, 0, 0};
    //     System.out.println(maxLength(arr, arr.length));
    // }
    
    // // ********************************-> Magical Number in Array : O(n*bitLength) <-**************************************************
    // public static void isMagical(int[] arr) {
    //     int n;
    //     int mag;
    //     for(int i=0;i<arr.length;i++) {
    //         n = arr[i];
    //         mag = 0;
    //         while(n != 0) {
    //             if((n & 1) == 0) {
    //                 mag += 1;
    //             } else {
    //                 mag += 2;
    //             }
    //             n = n >> 1;
    //         }
    //         if(mag%2 == 0) {
    //             System.out.println(arr[i]);
    //         }
    //     }
    // }
    // public static void main(String[] args) {
    //     int[] arr = {1, 2, 3, 4, 5, 7};
    //     isMagical(arr);
    // }

    // // *********************************-> Nth character in Decrypted String : O(n) <-**************************************************
    // public static String nthCharDecrypted(String str, int n) {
    //     int sum = 0;
    //     String ans = "";
    //     for(int i=1;i<str.length();i+=2) {
    //         sum += str.charAt(i) - '0';
    //         if(sum >= n) {
    //             ans += str.charAt(i-1);
    //             return ans;
    //         }
    //     }
    //     return "-1";
    // }
    // public static void main(String[] args) {
    //     String str = "a2b2c3d2";
    //     System.out.println(nthCharDecrypted(str, 1));
    // }
    
    // // *************************************-> String remainder mod 11 : O(n) <-*******************************************************
    // public static int mod11(String str) {
    //     int res = 0;

    //     for(int i=0;i<str.length();i++) {
    //         res = (res*10 + (str.charAt(i)-'0'))%11;
    //     }
    //     return res;
    // }
    // public static void main(String[] args) {
    //     String str = "1357";
    //     System.out.println(mod11(str));
    // }

    // // ********************************-> Number of Integer block by the Barriers : O(n) <-**************************************************
    // public static int maximumBlocked(int n, int[][] bar) {
    //     int[][] points = new int[n][2];
    //     for(int i=0;i<n;i++) {
    //         points[i][0] = bar[i][0];
    //         points[i][1] = bar[i][0]+bar[i][2];
    //     }

    //     int totalBlocked = 0;
    //     int sidx = points[0][0];
    //     int eidx = points[0][1];
    //     for(int i=1;i<n;i++) {
    //         if(points[i][0] <= points[i-1][1]) {
    //             eidx = points[i][1];
    //         } else {
    //             totalBlocked += eidx - sidx + 1;
    //             sidx = points[i][0];
    //             eidx = points[i][1];
    //         }
    //     }
    //     totalBlocked += eidx - sidx + 1;
    //     return totalBlocked;
    // }
    // public static void main(String[] args) {
    //     int n = 2;
    //     int[][] barrier = {{2, 3, 3},
    //                         {4, 6, 4}};
    //     // int[][] barrier = {{1, 2, 3},
    //     //                    {3, 4, 2},
    //     //                    {6, 3, 2},
    //     //                    {9, 3, 2},
    //     //                    {11, 3, 2}};
    //     System.out.println(maximumBlocked(n, barrier));
    //     // Scanner sc = new Scanner(System.in);
    //     // int n = sc.nextInt();
    //     // int[][] barriar = new int[n][3];
    //     // for(int i=0;i<n;i++) {
    //     //     barriar[i][0] = sc.nextInt();
    //     //     barriar[i][1] = sc.nextInt();
    //     //     barriar[i][2] = sc.nextInt();
    //     // }
    //     // sc.close();
    // }

    // // ******************************-> Number of Cards to built Pyramid : TC => O(n), SC => O(n) <-***********************************************
    // public static int cardPyramid(int n) {
    //     if(n == 0) return 0;
    //     if(n == 1) return 2;
    //     int[] arr = new int[n+1];
    //     arr[0] = 0;
    //     arr[1] = 2;
    //     for(int i=2;i<=n;i++) {
    //         arr[i] = (2*i + i-1 + arr[i-1])%100000007;
    //     }
    //     return arr[n];
    // }
    // public static void main(String[] args) {
    //     int n = 3;
    //     System.out.println(cardPyramid(n));
    // }

    // // *********************************-> Print a Inverted Right angel Triagle : O(n^2) <-**************************************************
    // public static void main(String[] args) {
    //     int n = 7;
    //     for(int i=0;i<n;i++) {
    //         for(int j=n-i;j<n;j++) System.out.print("  ");
    //         for(int j=0;j<n-i;j++) System.out.print("* ");
    //         System.out.println();
    //     }
    // }

    // // ********************************-> Segregate Odd and Even numbers in array : O(1) <-**************************************************
    // public static void printArray(int[] arr) {
    //     for(int i=0;i<arr.length;i++) {
    //         System.out.print(arr[i]+ " ");
    //     }
    //     System.out.println();
    // }
    // public static void segregateEvenOdd(int[] arr) {
    //     int f = 0;
    //     for(int i=0;i<arr.length;i++) {
    //         if(arr[i]%2 != 0) {
    //             int temp = arr[f];
    //             arr[f] = arr[i];
    //             arr[i] = temp;
    //             f++;
    //         }
    //     }
    // }
    // public static void segregateEvenOdd(int[] arr) {
    //     int oddIndex = 0;
    //     for(int i=0;i<arr.length;i++) {
    //         if(arr[i]%2 != 0) {
    //             int temp = arr[i];

    //             for(int j=i;j>oddIndex;j--) {
    //                 arr[j] = arr[j-1];
    //             }

    //             arr[oddIndex] = temp;
    //             oddIndex++;
    //         }
    //     }
    // }
    // public static void main(String[] args) {
    //     int[] arr = {12, 34, 45, 9, 8, 3, 4, 1, 33, 7, 23, 84, 9, 11, 90, 3};
    //     printArray(arr);
    //     segregateEvenOdd(arr);
    //     printArray(arr);
    // }

    // // **************************************-> Number to Binary : O(no.of bits) <-**************************************************
    // public static void main(String[] args) {
    //     int n = 10;
    //     String ans = "";
    //     while(n != 0) {
    //         int l = n & 1;
    //         if(l == 1) ans = "1" + ans;
    //         else ans = "0" + ans;
    //         n = n>>1;
    //     }
    //     System.out.println(ans);
    // }

    // // *****************************************-> The String Decoding : O(n) <-**************************************************
    // public static String stringDecoding(String s) {
    //     int count=0;
    //     String ans = "";
    //     for(int i=0;i<s.length();i++) {
    //         if(s.charAt(i) == '1') count++;
    //         else {
    //             if(count > 0) {
    //                 ans += (char)('A'+count-1);
    //                 count=0;
    //             }
    //         }
    //     }
    //     if(count > 0) {
    //         ans += (char)('A'+count-1);
    //     }
    //     return ans;
    // }
    // public static void main(String[] args) {
    //     String s = "101011111111011001111";
    //     System.out.println(stringDecoding(s));
    // }

    // // ***************************-> Googly Prime Number(Sum of digits is Prime) : O(no. of digits) <-**************************************************
    // public static String isGooglyPrimeNum(int n) {
    //     int p = 0;
    //     while(n != 0) {
    //         p += n%10;
    //         n = n/10;
    //     }
    //     for(int i=2;i<Math.sqrt(p);i++) {
    //         if(p%i == 0) return "No";
    //     }
    //     return "Yes";
    // }
    // public static void main(String[] args) {
    //     int n = 1235;
    //     System.out.println(isGooglyPrimeNum(n));
    // }

    // // *************************************-> No. of Permutation afte fixing Vowels : O(n) <-**************************************************
    // public static int countPermutations(String str) {
    //     HashSet<Character> set = new HashSet<>();
    //     set.add('A');
    //     set.add('E');
    //     set.add('I');
    //     set.add('O');
    //     set.add('U');
    //     set.add('a');
    //     set.add('e');
    //     set.add('i');
    //     set.add('o');
    //     set.add('u');
    //     int vcount = 0;
    //     for(int i=0;i<str.length();i++) {
    //         if(set.contains(str.charAt(i))) vcount++;
    //     }
    //     int fact = 1;
    //     for(int i=1;i<=str.length()-vcount;i++) {
    //         fact *= i;
    //     }
    //     return fact;
    // }
    // public static void main(String[] args) {
    //     // String str = "ABC";
    //     String str = "CBD";
    //     System.out.println(countPermutations(str));
    // }


    // // ***************************************-> The Peak Element of Array : O(n) <-**************************************************
    // public static int peakElement(int[] arr, int n) {
    //     if(n == 0) return 0;
    //     if(n == 1) return arr[0];
    //     if(arr[0] > arr[1]) return arr[0];
    //     if(arr[n-1] > arr[n-2]) return arr[n-1];
    //     for(int i=1;i<n-1;i++) {
    //         if(arr[i] > arr[i-1]  &&  arr[i] > arr[i+1]) return arr[i];
    //     }
    //     return -1;
    // }
    // public static void main(String[] args) {
    //     int[] arr = {1, 2, 1, 4, 3, 2, 1};
    //     // int[] arr = {5, 4};
    //     System.out.println(peakElement(arr, arr.length));
    // }


    // // **********************************-> Minumum Cost to Transform S1 string to S2 : O(n) <-****************************************
    // public static int minCostToTrasformS1ToS2(String s1, String s2) {
    //     HashMap<Character, Integer> map = new HashMap<>();
    //     for(int i=0;i<s2.length();i++) {
    //         char currChar = s2.charAt(i);
    //         if(map.containsKey(currChar)) map.put(currChar, map.get(currChar)+1);
    //         else map.put(currChar, 1);
    //     }
    //     for(int i=0;i<s1.length();i++) {
    //         char currChar = s1.charAt(i);
    //         if(map.containsKey(currChar) && map.get(currChar) > 0) map.put(currChar, map.get(currChar)-1);
    //     }
    //     int count = 0;
    //     for(char item : map.keySet()) {
    //         count += map.get(item);
    //     }
    //     return count;
    // }
    // public static void main(String[] args) {
    //     String s1 = "ABD";
    //     String s2 = "AABCCAD";
    //     System.out.println(minCostToTrasformS1ToS2(s1, s2));
    // }


    // // *****************************-> Maximum consecutive 'a' Songs in Playlist of k size : O(n) <-************************************
    // public static int maxPlaylistSong(String str, int k) {
    //     int n = str.length();
    //     if(n == 0) return 0;
    //     int count=0;
    //     if(n < k) {
    //         for(int i=0;i<n;i++) {
    //             if(str.charAt(i) == 'a') count++;
    //         }
    //         return count;
    //     }
    //     for(int i=0;i<k;i++) if(str.charAt(i) == 'a') count++;
    //     int max = count;
    //     for(int i=1;i<=n-k;i++) {
    //         if(str.charAt(i-1) == 'a') count--;
    //         if(str.charAt(i+k-1) == 'a') count++;
    //         max = Math.max(max, count);
    //     }
    //     return max;
    // }
    // public static void main(String[] args) {
    //     String str = "abcacaaa";
    //     int k = 5;
    //     System.out.println(maxPlaylistSong(str, k));
    // }


    // // ************************-> SIEVE OF ERATOSTHENES (to get PRIME value or FACTORIZATION) : O(n) <-********************************
    // public static List<Integer> primes(int n) {
    //     List<Integer> ans = new ArrayList<>();
    //     int[] prime = new int[n+1];
    //     for(int i=2;i<=n;i++) {
    //         if(prime[i] == 0) {
    //             ans.add(i);
    //             for(int j=i*i;j<=n;j+=i) {
    //                 prime[j] = 1;
    //             }
    //         }
    //     }
    //     // for(int i=2;i<=n;i++) {
    //     //     if(prime[i] == 0) {
    //     //         ans.add(i);
    //     //     }
    //     // }
    //     return ans;
    // }
    // public static List<Integer> primeFactors(int n) {
    //     List<Integer> ans = new ArrayList<>();
    //     int[] spf = new int[n+1];  // spf == smallest prime factor
    //     for(int i=2;i<=n;i++) {
    //         spf[i] = i;
    //     }
    //     for(int i=2;i<=n;i++) {
    //         if(spf[i] == i) {
    //             for(int j=i*i;j<=n;j+=i) {
    //                 if(spf[j] == j) {
    //                     spf[j] = i;
    //                 }
    //             }
    //         }
    //     }
    //     while(n != 1) {
    //         ans.add(spf[n]);
    //         n = n/spf[n];
    //     }
    //     return ans;
    // }
    // public static List<Integer> primeFactorsSimple(int n) {
    //     List<Integer> ans = new ArrayList<>();
    //     while(n % 2 == 0) {
    //         ans.add(2);
    //         n /= 2;
    //     }
    //     for(int i=3;i<=Math.sqrt(n);i+=2) {
    //         while(n % i == 0) {
    //             ans.add(i);
    //             n /= i;
    //         }
    //     }
    //     if(n > 2) {
    //         ans.add(n);
    //     }
    //     return ans;
    // }
    // public static List<Integer> factorsOfN(int n) {
    //     List<Integer> ans = new ArrayList<>();
    //     for(int i=1;i<=Math.sqrt(n);i++) {
    //         if(n%i == 0) {
    //             if(n/i == i) {
    //                 ans.add(i);
    //             } else {
    //                 ans.add(i);
    //                 ans.add((int)(n/i));
    //             }
    //         }
    //     }
    //     Collections.sort(ans);
    //     return ans;
    // }
    // public static void main(String[] args) {
    //     int n = 50;
    //     System.out.println(primes(n));
    //     System.out.println(primeFactors(n));
    //     System.out.println(primeFactorsSimple(n));
    //     System.out.println(factorsOfN(n));
    // }
    //___________________________________________________________________________________________________________________________________
    //___________________________________________________________________________________________________________________________________



    // public static int twoSumEqualsToTarget(int[] arr, int target) {
    //     Map<Integer, Integer> map = new HashMap<>();
    //     int count = 0;
    //     for(int i=0;i<arr.length;i++) {
    //         int comp = target - arr[i];
    //         if(map.containsKey(comp)) {
    //             count += map.get(comp);
    //         }
    //         map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
    //     }
    //     return count;
    // }
    // public static ArrayList<ArrayList<Integer>> getPairs(int[] arr) {
    //     // code here
    //     Arrays.sort(arr);
    //     ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    //     HashSet<Integer> set = new HashSet<>();
    //     for(int i=0;i<arr.length;i++) {
    //         if(arr[i] == 0) continue;
    //         if(i>0 && arr[i] == arr[i-1]) continue;
    //         int comb = 0 - arr[i];
    //         if(set.contains(comb)) {
    //             ArrayList<Integer> list = new ArrayList<>();
    //             list.add(comb);
    //             list.add(arr[i]);
    //             ans.add(list);
    //         }
    //         set.add(arr[i]);
    //     }
    //     Collections.sort(ans, new Comparator<List<Integer>>() {
    //         @Override
    //         public int compare(List<Integer> l1, List<Integer> l2) {
    //             return l1.get(0).compareTo(l2.get(0));
    //         }
    //     });
    //     if(ans.get(ans.size()-1).get(0) == 0) {
    //         ans.remove(ans.size()-1);
    //     }
    //     return ans;
    // }
    // public static void main(String[] args) {
    //     // int[] arr = {1, 5, 7, -1, 5};
    //     int[] arr = {6, -1, 8, 0, 4, -9, -1, -10, -6, -5, 0, 1, -4, 6, -6, 4, -4, -3, 3};
    //     System.out.println(getPairs(arr));
    //     System.out.println(Math.sqrt(9));
    //     TreeSet<Integer> set = new TreeSet<>((key1, key2) -> {return key1.compareTo(key2);});
    //     set.add(4);
    //     set.add(2);
    //     set.add(9);
    //     set.add(1);
    //     System.out.println(set);
    // }



    // public static List<Integer> find3Numbers(int[] arr) {
    //     // code here
    //     // if(arr.length < 3) return new ArrayList<>(Arrays.asList(-1));
    //     int min = Integer.MAX_VALUE;
    //     for(int i=0;i<arr.length;i++) {
    //         if(arr[i] < min) {
    //             min = arr[i];
    //         }
    //     }
    //     List<Integer> list = new ArrayList<>();
    //     list.add(min);
    //     int c = 0;
    //     for(int i=0;i<arr.length;i++) {
    //         if(arr[i] > min) {
    //             min = arr[i];
    //             list.add(min);
    //             c++;
    //             if(c == 2) {
    //                 return list;
    //             }
    //         }
    //     }
    //     return new ArrayList<>();
    // }
    // public static void main(String[] args) {
    //     int[] arr = {8, 7, 5, 4, 3, 2, 3, 6};
    //     System.out.println(find3Numbers(arr));
    // }


    

    // public static boolean checkAlmostEquivalent(String word1, String word2) {
    //     int[] ch = new int[26];
    //     for(int i=0;i<word1.length();i++) ch[word1.charAt(i)-'a']++;
    //     for(int i=0;i<word2.length();i++) {
    //         int idx = word2.charAt(i) - 'a';
    //         if(ch[idx] > 0) {
    //             ch[idx]--;
    //         } else {
    //             System.out.println("Enter");
    //             ch[idx]++;
    //         }
    //     };
    //     for(int i=0;i<26;i++) {
    //         if(ch[i] > 3) return false;
    //     }
    //     return true;
    // }
    // public static void main(String[] args) {
    //     String w1 = "zzzyyy";
    //     String w2 = "iiiiii";
    //     System.out.println(checkAlmostEquivalent(w1, w2));
    //     int num = -22;
    //     System.out.println(num >>> 29);
    //     String row1 = "qwertyuiop";
    //     char[] arr = row1.toCharArray();
    //     System.out.println((Math.log10(8)/Math.log10(1))%1 == 0);
    //     System.out.println('A' - 'a');    
    // }



    // public static int minReplacement(String str) {
    //     int n = str.length();
    //     int i = 0;
    //     int j = n-1;
    //     boolean found = false;
    //     while(i<n) {
    //         if(str.charAt(i) == 'I') {
    //             if(found) {
    //                 break;
    //             } else {
    //                 found = true;
    //             }
    //         }
    //         i++;
    //     }
    //     if(i == n) return 0;
    //     while(j>=i) {
    //         if(str.charAt(j) == 'I') {
    //             break;
    //         }
    //         j--;
    //     }
    //     int ans = j-i+1;
    //     i=0;
    //     j=n-1;
    //     found = false;
    //     while(j>=i) {
    //         if(str.charAt(j) == 'I') {
    //             if(found) {
    //                 break;
    //             } else {
    //                 found = true;
    //             }
    //         }
    //         j--;
    //     }
    //     while(i<=j) {
    //         if(str.charAt(i) == 'I') break;
    //         i++;
    //     }
    //     ans = Math.min(ans, j-i+1);
    //     return ans;
    // }
    // public static void main(String[] args) {
    //     String str = "FIFFIIFFFI";
    //     System.out.println(minReplacement(str));
    // }



    // public static int totalCount(int[] arr, int x, int n) {
    //     int count = 0;
    //     int i = 0;
    //     int j = n-1;
    //     while(i <= j) {
    //         if(arr[i] + arr[j] <= x) {
    //             count += j-i+1;
    //             i++;
    //         } else {
    //             j--;
    //         }
    //     }
    //     return count;
    // }
    // public static void main(String[] args) {
    //     int[] arr = {1, 3, 5, 8};
    //     System.out.println(totalCount(arr, 5, arr.length));
    // }

    // **********************************************************************************************************************************
    // ******************************************** BASIC FUCTIONS THAT WE SHOULD KNOW **************************************************
    // public static boolean isInteger(double a) {
    //     return a % 1 == 0;
    // }
    // public static boolean isArmstrongNumber(int a) {
    //     int temp = a;
    //     int sum = 0;
    //     while(temp != 0) {
    //         int val = temp%10;
    //         sum += (val*val*val);
    //         temp /= 10;
    //     }
    //     return sum == a;
    // }
    // public static int reverseNumber(int a) {
    //     int reverse = 0;
    //     while(a != 0) {
    //         int val = a%10;
    //         reverse = (reverse*10) + val;
    //         a /= 10;
    //     }
    //     return reverse;
    // }
    // public static boolean isPalindromNumber(int a) {
    //     int rev = reverseNumber(a);
    //     return rev == a;
    // }
    // // ####*** MOST IMPORTANT FUNCTION (GCD & LCM) -> EUCLID'S ALGORITHM
    // public static int gcd(int a, int b) {  // O(log(min(a, b))), O(1)
    //     while(a > 0 && b > 0) {
    //         if(a > b) {
    //             a = a % b;
    //         } else {
    //             b = b % a;
    //         }
    //     }
    //     return a == 0 ? b : a;
    // }
    // public static int gcdRec(int a, int b) {  // O(log(min(a, b))), O(log(min(a, b))) for recursive stack
    //     if(b == 0) return a;
    //     return gcdRec(b, a % b);
    // }
    // public static int gcdRec2(int a, int b) {  // O(log(n)), O(log(min(a, b))) for recursive Stack
    //     if(a == 0) return b;
    //     return gcdRec2(b % a, a);
    // }
    // public static int gcdOfArray(int[] arr) {  // O(N*log(X)) where X is the largest element, O(N)
    //     if(arr.length == 0) return -1;
    //     int result = arr[0];
    //     for(int i=1;i<arr.length;i++) {
    //         result = gcdRec2(result, arr[i]);
    //         if(result == 1) return 1;
    //     }
    //     return result;
    // }
    // public static int lcm(int a, int b) {  // O(log(min(a, b))), O(1)
    //     int gcd = gcd(a, b);
    //     return (a * b) / gcd;
    // }
    // public static int lcmOfArray(int[] arr) {  // O(N*log(n)), O(1)
    //     int lcm = arr[0], gcd;
    //     for(int i=1;i<arr.length;i++) {
    //         gcd = gcd(lcm, arr[i]);
    //         lcm = (lcm * arr[i]) / gcd;
    //     }
    //     return lcm;
    // }
    // /*
    //  *   ## MODULO ARITHMATICS
    //  *    X % N  ->  [0, N-1]       e.g,  10 % 3  ->  [0, 1, 2]
    //  *   
    //  *   *Rules*
    //  *   1) (X + Y) % M = X % M  +  Y % M
    //  *   2) (X - Y) % M = X % M  -  Y % M
    //  *   3) (X . Y) % M = x % M  . Y % M
    //  *  *4) (((X % M) % M) % M) % M  <==>  x % M 
    //  */
    // public static void main(String[] args) {
    //     // System.out.println(153 + (isArmstrongNumber(153) ? " is" : " is not") + " Armstrong Number");
    //     // System.out.println(111 + (isArmstrongNumber(111) ? " is" : " is not") + " Armstrong Number");
    //     // System.out.println(reverseNumber(78562));
    //     // System.out.println(isPalindromNumber(12452421));
    //     // System.out.println(gcdRec(24, 18));
    //     // int[] arr = {4, 28, 36, 64, 72};
    //     // System.out.println(gcdOfArray(arr));
    //     // System.out.println(lcm(24, 18));
    //     // System.out.println(lcmOfArray(arr));
    // }
    // __________________________________________________________________________________________________________________________________
    // __________________________________________________________________________________________________________________________________
    

    // ******************************************************************************************************************************* 
    // ********************************************* BINARY SEARCH RELATED PROBLEMS **************************************************
    // // **************************** P1 : BOOK ALLOCATION PROBLEM (Minimum Possible Maximum Pages) *********************************
    // // You have to allocate books to M number of students so that the maximum number of pages allocated to a student is minimum.
    // // *Constraints : 1) Each book should be allocated to a student.
    // //                2) Each student has to be allocated at least one book.
    // //                3) Allotment shuld be in contiguous order.
    // public static boolean isValid(int[] arr, int n, int m, int maxAllowedPages) {
    //     int students = 1, pages = 0;
    //     for(int i=0;i<arr.length;i++) {
    //         if(arr[i] > maxAllowedPages) {
    //             return false;
    //         }
    //         if(pages + arr[i] <= maxAllowedPages) {
    //             pages += arr[i];
    //         } else {
    //             students++;
    //             pages = arr[i];
    //             if(students > m) return false;
    //         }
    //     }
    //     return students > m ? false : true;
    // }
    // public static int maximumAllocatedBook(int[] arr, int n, int m) {
    //     if(m > n) {
    //         return -1;
    //     }
    //     int sum = 0;
    //     for(int i=0;i<n;i++) sum += arr[i];

    //     int ans = -1;
    //     int st = 0, end = sum; // range of possible answers
    //     while(st <= end) {
    //         int mid = st + (end - st)/2;
    //         if(isValid(arr, n, m, mid)) {
    //             end = mid-1;
    //             ans = mid;
    //         } else {
    //             st = mid+1;
    //         }
    //     }
    //     return ans;
    // } 
    // public static void main(String args[]) {
    //     int m = 2; // No of students
    //     int[] arr = {2, 1, 3, 4}; // N numbers of book with arr[i] pages
    //     System.out.println(maximumAllocatedBook(arr, arr.length, m));
    // }

    // // **************************** P2 : PAINTER'S PARTITION PROBLEM (Minumum Possible Maximum Time) ********************************
    // // Given an N boards of length of each given in the form of array, and M painters, such that each painter takes 1 unit of time 
    // // to paint 1 unit of the board.
    // // The task if to find the minimum time to paint all boards under the constaints that any painter will only paint continuos
    // // sections of boards.
    // public static boolean isPossible(int[] arr, int n, int m, int maxAllowedTime) {
    //     int painter = 1, time = 0;
    //     for(int i=0;i<n;i++) {
    //         if(arr[i] > maxAllowedTime) return false;
    //         if(time + arr[i] <= maxAllowedTime) {
    //             time += arr[i];
    //         } else {
    //             painter++;
    //             time = arr[i];
    //         }
    //     }
    //     return painter <= m ? true : false;
    // }
    // public static int minimumTimeToPaintAllBoards(int[] arr, int n, int M) {
    //     int totalTime = 0;
    //     for(int i=0;i<n;i++) totalTime += arr[i];

    //     int ans = -1;
    //     int st=0, end=totalTime;
    //     while(st <= end) {
    //         int mid = st + (end - st)/2;
    //         if(isPossible(arr, n, M, mid)) {
    //             ans = mid;
    //             end = mid - 1;
    //         } else {
    //             st = mid + 1;
    //         }
    //     }
    //     return ans;
    // }
    // public static void main(String args[]) {
    //     int[] arr = {40, 30, 10, 20};
    //     int M = 2;
    //     System.out.println("Minimum time to paint all boards : " + minimumTimeToPaintAllBoards(arr, arr.length, M));
    // }

    // // *************************** P3 : AGGRESIVE COW PROBLEM (Maximum Possible Minimum Distance) ***********************************
    // // Assign C cows to N stalls such that min distance between them is largest possible.
    // // Return largest minumum distance.
    // public static boolean isPossible(int[] arr, int n, int M, int minDis) {
    //     int cows = 1, lastStallPos = arr[0];
    //     for(int i=0;i<n;i++) {
    //         if(arr[i] - lastStallPos >= minDis) {
    //             cows++;
    //             lastStallPos = arr[i];
    //         }
    //         if(cows == M) return true;
    //     }
    //     return false;
    // }
    // public static int largestMinimumDistanceBetweenCows(int[] arr, int n, int M) {
    //     Arrays.sort(arr);

    //     int ans = -1;
    //     int st=1, end=arr[n-1]-arr[0];
    //     while(st <= end)  {
    //         int mid = st + (end - st)/2;
    //         if(isPossible(arr, n, M, mid)) {
    //             ans = mid;
    //             st = mid + 1;
    //         } else {
    //             end = mid - 1;
    //         }
    //     }
    //     return ans;
    // }
    // public static void main(String args[]) {
    //     int C = 3;
    //     int[] arr = {1, 2, 8, 4, 9};
    //     System.out.println(largestMinimumDistanceBetweenCows(arr, arr.length, C));
    // }
    // ########################################-> SIMPLE BINARY SEARCH ALGORITHM FOR 2D MATRIX <-###############################################
    // public static boolean searchInRowAndColumnWiseSortedMatrix(int[][] mat, int target) {  // Expected Time Complexity :- O(n + m)
    //     int row = 0, col = mat[0].length-1;
    //     while(row < mat.length  &&  col >= 0) {
    //         if(mat[row][col] == target) return true;
    //         else if(mat[row][col] > target) col--;
    //         else row++; 
    //     }
    //     return false;
    // }
    // public static void main(String args[]) {
    //     int[][] mat = {{1, 4, 7, 9}, 
    //                    {3, 6, 8, 11},
    //                    {5, 9, 10, 22}};
    //     System.out.println(searchInRowAndColumnWiseSortedMatrix(mat, 2));
    // } 


    // public static boolean searchInRowWiseIncresingSortedMatrix(int[][] mat, int target) {  // Expected Time Complexity :- O(log(n + m))
    //     int n = mat.length, m = mat[0].length;
    //     int srow = 0, erow = n-1;
    //     while(srow <= erow) {
    //         int rmid = srow + (erow - srow)/2;
    //         if(mat[rmid][0] <= target  &&  mat[rmid][m-1] >= target) {
    //             int scol = 0, ecol = m-1;
    //             while(scol <= ecol) {
    //                 int cmid = scol + (ecol - scol)/2;
    //                 if(mat[rmid][cmid] == target) return true;
    //                 else if(mat[rmid][cmid] < target) scol = cmid+1;
    //                 else ecol = cmid-1;
    //             } 
    //             break;
    //         } else if(mat[rmid][m-1] < target) {
    //             srow = rmid+1;
    //         } else {
    //             erow = rmid-1;
    //         }
    //     }
    //     return false;
    // }
    // public static void main(String arg[]) {
    //     int[][] mat = {{1, 4, 6, 7},
    //                    {8, 9, 12, 23},
    //                    {25, 27, 31, 33}, 
    //                    {39, 81, 234, 289}};
    //     System.out.println(searchInRowWiseIncresingSortedMatrix(mat, 28));
    // }
    // _______________________________________________________________________________________________________________________________
    // _______________________________________________________________________________________________________________________________

    // public static List<Integer> findSplit(int[] arr) {
    //     // code here
    //     int total = 0;
    //     for(int i=0;i<arr.length;i++) total += arr[i];
    //     int i=0, j=arr.length-1, first = arr[i], second = arr[j], third;
    //     while(i < j) {
    //         third = total - first - second;
    //         System.out.println(third);
    //         if(third == first && first == second) {
    //             return new ArrayList<>(Arrays.asList(i, j-1));
    //         } else if(third >= first && third >= second) {
    //             if(first >= second && j > i+1) {
    //                 second += arr[--j];
    //             } else if(second > first && i < j-1) {
    //                 first += arr[++i];
    //             } else {
    //                 System.out.println("break");
    //                 break;
    //             }
    //         } else {
    //             break;
    //         }
    //     }
    //     return new ArrayList<>(Arrays.asList(-1, -1));
    // }
    // public static void main(String args[]) {
    //     // int[] arr = {0, 0, 0, 4, 0, 0, 4, 0, 0, 0, 0, 2, 0, 2};
    //     // System.out.println(findSplit(arr));
    //     // int[] arr = {40, 20, 10, 30};
    //     // int[] newArr = arr.clone(); // **AFTER CLONING an ARRAY WE CAN REARRANGE IT, IT WILL NOT EFFECT THE CLONE ONE.
    //     // Arrays.sort(newArr);
    //     // newArr[2] = 50;
    //     // for(int i=0;i<arr.length;i++) System.out.print(arr[i]+" ");
    //     // System.out.println();
    //     // for(int i=0;i<arr.length;i++) System.out.print(newArr[i]+" ");
    //     // System.out.println();
    //     // System.out.println(Math.floor(Math.log10(89))+1);
    //     // char a = (char)('0' + 9);
    //     // System.out.println(a);
    //     // System.out.println((int)Character.MAX_VALUE);
    //     // int[][] mat = new int[3][4];
    //     // System.out.println(mat.length);
    //     // Long[] array = {5L, 7L, 1L, 3L, 4L};
    //     // Long[] clone = array.clone();
    //     // Arrays.sort(clone);
    //     // int n = clone.length;
    //     // int j=n-1, k=0;
    //     // for(int i=0;i<n;i++) {
    //     //     if(i%2 == 0) {
    //     //         array[i] = clone[k++];
    //     //     } else {
    //     //         array[i] = clone[j--];
    //     //     }
    //     // }
    //     // for(int i=0;i<clone.length;i++) {
    //     //     System.out.print(array[i] + " ");
    //     // }
    // }

    // Write a whole program to find the gcd of a number 
    // public static void main(String[] args) {
    //     int n = 3;
    //     Scanner sc = new Scanner(System.in);
    //     String[] arr = new String[n];
    //     String longest = "";
    //     String shortest = "lfslfsdlfjsdlfdslfjdslfjdslfjdslfjdslfjdslfjsdfldjsfldjslfsdjflsdjlfdsfdsfdslfdslfsd";
    //     for(int i=0;i<arr.length;i++) {
    //         arr[i] = sc.nextLine();
    //         if(longest.length() < arr[i].length()) {
    //             longest = arr[i];
    //         }
    //         if(shortest.length() > arr[i].length()) {
    //             shortest = arr[i];
    //         }
    //     }
    //     System.out.println(longest);
    //     System.out.println(shortest);
    // }
    public static void main(String[] args) {
        System.out.println(4.56%1);
        
    }
}
