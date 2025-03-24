import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Spliterator;
import java.util.Stack;
import java.util.stream.IntStream;

import org.w3c.dom.Node;

// class ListNode {
//     Node head;
//     private int size;
//     ListNode() {
//         head = null;
//         size = 0;
//     }

//     class Node {
//         int data;
//         Node next;
//         public Node(int data) {
//             this.data = data;
//             this.next = null;
//             size++;
//         }
//     }

//     // adding
//     public void addFirst(int data) {
//         Node newNode = new Node(data);
//         if(head == null) {
//             head = newNode;
//             return;
//         }
//         newNode.next = head;
//         head = newNode;
//     }

//     public void addLast(int data) {
//         Node newNode = new Node(data);
//         if(head == null) {
//             head = newNode;
//             return;
//         }
//         Node currNode = head;
//         while(currNode.next != null) {
//             currNode = currNode.next;
//         }
//         currNode.next = newNode;
//     }

//     public void add(int index, int data) {
//         if(index<0 && index>size) {
//             System.out.println("Invalid Index");
//             return;
//         }
//         if(index == 0) {
//             addFirst(data);
//             return;
//         }
//         Node newNode = new Node(data);
//         Node p = head;
//         Node q = head.next;
//         for(int i=1;i<index;i++) {
//             p = p.next;
//             q = q.next;
//         }
//         p.next = newNode;
//         newNode.next = q;
//     }

//     // Remove element from the linkedlist
//     public int removeFirst() {
//         if(head == null) {
//             System.out.println("List is Empty!");
//             return -1;
//         }
//         size--;
//         int val = head.data;
//         head = head.next;
//         return val;
//     }

//     public int removeLast() {
//         if(head == null) {
//             System.out.println("List is Empty!");
//             return -1;
//         }
//         size--;
//         int val;
//         if(head.next == null) {
//             val = head.data;
//             head = null;
//             return val;
//         }
//         Node currNode = head;
//         while(currNode.next.next != null) {
//             currNode = currNode.next;
//         }
//         val = currNode.next.data;
//         currNode.next = null;
//         return val;
//     }

//     public int remove(int index) {
//         if(index < 0 && index >= size) {
//             System.out.println("Index out of bound");
//             return -1;
//         }
//         if(index == 0) {
//             return removeFirst();
//         }
//         size--;
//         Node p = head;
//         Node q = head.next;
//         for(int i=1;i<index;i++) {
//             p = p.next;
//             q = q.next;
//         }
//         int val = p.next.data;
//         p.next = q.next;
//         return val;
//     }

//     public int size() {
//         return size;
//     }

//     public void printList() {
//         Node currNode = head;
//         while(currNode != null) {
//             System.out.print(currNode.data + " ");
//             currNode = currNode.next;
//         }
//         System.out.println();
//     }
//     private Node findMiddle(Node start) {
//         Node slow = start;
//         Node fast = start.next;
//         while(fast != null && fast.next != null) {
//             slow = slow.next;
//             fast = fast.next.next;
//         }
//         return slow;
//     }
//     private Node merge(Node left, Node right) {
//         if(left == null) {
//             return right;
//         }
//         if(right == null) {
//             return left;
//         }
//         Node ans = new Node(-1);
//         size--;
//         Node ptr = ans;
//         while(left != null && right != null) {
//             if(left.data < right.data) {
//                 ptr.next = left;
//                 ptr = left;
//                 left = left.next;
//             } else {
//                 ptr.next = right;
//                 ptr = right;
//                 right = right.next;
//             }
//         }
//         while(left != null) {
//             ptr.next = left;
//             ptr = left;
//             left = left.next;
//         }
//         while(right != null) {
//             ptr.next = right;
//             ptr = right;
//             right = right.next;
//         }
//         ans = ans.next;
//         return ans;
//     }
//     private Node mergeSort(Node start) {
//         if(start == null || start.next == null) {
//             return start;
//         }
//         Node middleNode = findMiddle(start);
//         Node middle = middleNode.next;
//         middleNode.next = null;
//         Node left = mergeSort(start);
//         Node right = mergeSort(middle);
//         return merge(left, right);
//     }
//     public void sort() {
//         head = mergeSort(head);
//     }

//     public void reverse() {
//         if(head == null || head.next == null) {
//             return;
//         }
//         Node prev = null;
//         Node nex = null;
//         while(head!=null) {
//             nex = head.next;
//             head.next = prev;
//             prev = head;
//             head = nex;
//         }
//         head = prev;
//     }

//     public Node reverseRecursive(Node head) {
//         if(head == null || head.next == null) {
//             return head;
//         }
//         Node newNode = reverseRecursive(head.next);
//         head.next.next = head;
//         head.next = null;
//         return newNode;
//     }

//     public int nthNodeFromTheLastAndDeleteIt(int pos) {
//         if(pos <= 0 || pos > size) {
//             System.out.println("Invalid Position! Position start from 1 to list.size()");
//             return -1;
//         }
//         if(head == null) {
//             System.out.println("List is Empty!");
//             return -1;
//         }
//         size--;
//         int val;
//         if(head.next == null) {
//             val = head.data;
//             head = null;
//             return val;
//         }
//         if(pos == size+1) {
//             val = head.data;
//             head = head.next;
//             return val;
//         }
//         Node currNode = head;
//         for(int i=0;i<size-pos;i++) {
//             currNode = currNode.next;
//         }
//         val = currNode.next.data;
//         currNode.next = currNode.next.next;
//         return val;
//     }
//     public boolean isPalindrom() {
//         if(head == null || head.next == null) {
//             return true;
//         }
//         Node middleNode = findMiddle(head);
//         Node middle = middleNode.next;
//         middleNode.next = null;
//         Node prev = null;
//         Node nex = null;
//         while(middle!=null) {
//             nex = middle.next;
//             middle.next = prev;
//             prev = middle;
//             middle = nex;
//         }
//         middle = prev;
//         Node first = head;
//         Node last = middle;
//         while(last!=null) {
//             if(last.data != first.data) {
//                 return false;
//             }
//             last = last.next;
//             first = first.next;
//         }
//         return true;
//     }

//     public void createLoop(int val) {
//         if(head == null) {
//             System.out.println("List is empty!");
//             return;
//         }
//         Node lastNode = head;
//         while(lastNode.next != null) {
//             lastNode = lastNode.next;
//         }
//         Node connector = head;
//         while(connector != null) {
//             if(connector.data == val) {
//                 lastNode.next = connector;
//                 return;
//             }
//             connector = connector.next;
//         }
//         System.out.println("Value doen't find in the linkedlist!");
//     }
//     public boolean hasCycle() {
//         if(head == null || head.next == null) {
//             return false;
//         }
//         Node slow = head;
//         Node fast = head;
//         while(fast != null && fast.next != null) {
//             slow = slow.next;
//             fast = fast.next.next;
//             if(slow == fast) {
//                 return true;
//             }
//         }
//         return false;
//     }
//     public Node meetLoop() {
//         if(!hasCycle()) {
//             return null;
//         }
//         Node slow = head;
//         Node fast = head;
//         while(fast != null && fast.next != null) {
//             slow = slow.next;
//             fast = fast.next.next;
//             if(slow == fast) {
//                 return slow;
//             }
//         }
//         return null;
//     }
//     public Node startLoop() {
//         if(!hasCycle()) {
//             return null;
//         }
//         Node startNode = head;
//         Node meetNode = meetLoop();
//         while(startNode != meetNode) {
//             startNode = startNode.next;
//             meetNode = meetNode.next;
//         }
//         return startNode;
//     }
//     public void removeLoop() {
//         if(!hasCycle()) {
//             System.out.println("Loop has no cycle");
//             return;
//         }
//         Node startNode = startLoop();
//         System.out.println("__--> " + startNode.data);
//         Node ptr = startNode;
//         while(ptr.next != startNode) {
//             ptr = ptr.next;
//             System.out.println("--> " + ptr.data);
//         }
//         System.out.println("__--> " + ptr.next.data);
//         ptr.next = null;
//     }
// }



public class Practice {
//     static class Node {
//         int data;
//         Node left;
//         Node right;
        
//         Node(int data) {
//             this.data = data;
//             this.left = null;
//             this.right = null;
//         }
//     }

//     public static Node insert(Node root, int data) {
//         if(root == null) {
//             return new Node(data);
//         }
//         if(root.data > data) {
//             root.left = insert(root.left, data);
//         } else {
//             root.right = insert(root.right, data);
//         }
//         return root;
//     }

//     public static void inOrder(Node root) {
//         if(root == null) {
//             return;
//         }
//         inOrder(root.left);
//         System.out.print(root.data + " ");
//         inOrder(root.right);
//     }

//     public static boolean searchValue(Node root, int val) {
//         if(root == null) {
//             return false;
//         }
//         if(root.data > val) {
//             return searchValue(root.left, val);
//         } else if(root.data < val) {
//             return searchValue(root.right, val);
//         } else {
//             return true;
//         }
//     }

//     public static void helper(int[] nums, int idx, ArrayList<Integer> list, ArrayList<Integer> sum) {
//         if(idx == nums.length) {
//             if(list.size() > 0) {
//                 int val = 0;
//                 for(int i=0;i<list.size();i++) {
//                     val += list.get(i);
//                 }
//                 sum.add(val);
//             }
//             return;
//         }
//         list.add(nums[idx]);
//         helper(nums, idx+1, list, sum);

//         list.remove(list.size()-1);
//         helper(nums, idx+1, list, sum);
//     }

//     public static int rangeSum(int[] nums, int n, int left, int right) {
//         ArrayList<Integer> list = new ArrayList<>();
//         ArrayList<Integer> sum = new ArrayList<>();
//         helper(nums, 0, list, sum);
//         Collections.sort(sum);
//         System.out.println(sum);
//         int ans = 0;
//         for(int i=left-1;i<right;i++) {
//             ans += sum.get(i);
//         }
//         return ans;
//     }

//     public static boolean isValidIP(String str) {
//         int i=0;
//         int j=0;
//         int count = 0;
//         String val;
//         int valInt;
//         while(i<str.length()) {
//             if(str.charAt(i) == '.') {
//                 val = str.substring(j, i);
//                 valInt = Integer.parseInt(val);
//                 if(valInt > 255 || valInt < 0) {
//                     return false;
//                 }
//                 count++;
//                 j=i+1;
//                 if(count >= 4) {
//                     return false;
//                 }
//             }
//             i++;
//         }
//         if(count < 3) {
//             return false;
//         }
//         val = str.substring(j, i);
//         valInt = Integer.parseInt(val);
//         if(valInt > 255 || valInt < 0) {
//             return false;
//         }
//         return true;
//     }

    // public static void main(String[] args) {
        // int[] values = {5, 1, 3, 4, 2, 7};
        // Node root = null;

        // for(int i=0;i<values.length;i++) {
        //     root = insert(root, values[i]);
        // }
        // inOrder(root);
        // System.out.println();

        // System.out.println(searchValue(root, 6));

        // int[] nums = {1,2,3,4}; 
        // int n = 4, left = 1, right = 5;

        // ArrayList<Long> list = new ArrayList<>();
        // long sum;
        // for(int i=0;i<nums.length;i++) {
        //     for(int j=nums.length-1;j>=i;j--) {
        //         sum = 0;
        //         for(int k=i;k<=j;k++) {
        //             sum += nums[k];
        //         }
        //         list.add(sum);
        //     }
        // }
        // Collections.sort(list);
        // System.out.println(list);

        // System.out.println(Long.MAX_VALUE);
        // System.out.println(716699888);

        // int[] arr = {5, 2, 8, 1, 2, 0};
        // Arrays.sort(arr, 0, arr.length-1);
        // for(int i=0;i<arr.length;i++) {
        //     System.out.print(arr[i] + " ");
        // }

        // int num = 8;
        // double squareRoot = num/2;
        // double t;
        // do {
        //     System.out.println("call");
        //     t = squareRoot;
        //     squareRoot = (t + num/t)/2;
        // } while(t-squareRoot!=0);
        // System.out.println((int)squareRoot);
        // System.out.println(Math.sqrt(num));

        // String str = "ABCDE";
        // System.out.println(str.);

        // int[] nums = {3,3,4,3,0};
        // int k = 3;
        // double maxAvg = 0;
        // double avg = 0;
        // for(int i=0;i<k;i++) {
        //     avg += nums[i]; 
        // }
        // avg = avg/k;
        // maxAvg = avg;
        // System.out.println(maxAvg);
        // for(int i=1;i<=nums.length-k;i++) {
        //     System.out.println(avg*4 + "   " + nums[i+k-1] + "   " + nums[i-1]);
        //     avg = ((avg*4)+nums[i+k-1]-nums[i-1])/k;
        //     maxAvg = Math.max(maxAvg, avg);
        //     System.out.println(maxAvg);
        // }
        // System.out.println(maxAvg);
        // System.out.println(Math.pow(13, 31)%1000000007);

        // StringBuilder sb = new StringBuilder("");
        // int n = 4834834;
        // while(n != 0) {
        //     int rem = n % 16;
        //     if(rem == 15) sb.append("F");
        //     else if(rem == 14) sb.append("E");
        //     else if(rem == 13) sb.append("D");
        //     else if(rem == 12) sb.append("C");
        //     else if(rem == 11) sb.append("B");
        //     else if(rem == 10) sb.append("A");
        //     else sb.append(rem + "");
        //     n /= 16; 
        // }
        // sb.reverse();
        // System.out.println(sb);

        
        //------------------------------------------------------------------------------------------------------------------------------------
        // // Subarray Sum equal to k
        // int arr[] = {10, 2, -2, -20, 10};
        // // int k = -10;
        // int k = 0;
        // // int arr[] = {1, 2, 3};
        // // int k = 2;
        // int sum = 0;

        // HashMap<Integer, List<Integer>> map = new HashMap<>();
        // map.put(0, new ArrayList<>(Arrays.asList(-1)));

        // for(int i=0;i<arr.length;i++) {
        //     sum += arr[i];
        //     if(map.containsKey(sum-k)) {
        //         List<Integer> list = map.get(sum-k);
        //         for(int index : list) {
        //             System.out.println("Subarray : " + Arrays.toString(Arrays.copyOfRange(arr, index+1, i+1)));
        //         }
        //     }
        //     map.putIfAbsent(sum, new ArrayList<>());
        //     map.get(sum).add(i);
        // }
        

        // //-------------------------------------------------------------------------------------------------------------------------------------
        // // SEIVE OF EROTOSTHENES(PRIME UPTO N)
        // int n = 50;
        // int[] prime = new int[n+1];
        // for(int i=2;i<=n;i++) {
        //     if(prime[i] == 0) {
        //         for(int j=i*i;j<=n;j+=i) {
        //             prime[j] = 1;
        //         }
        //     }
        // }
        // for(int i=2;i<=n;i++) {
        //     if(prime[i] == 0) {
        //         System.out.print(i + " ");
        //     }
        // }
        // SEIVE OF EROTOSTHENES VARIATION -> PRIME FACTORIZATION OF A NUMBER
        
        // System.out.println(6^0);

        // StringBuilder sb  = new StringBuilder();

        
        // int[] id = {1, 2, 3, 4, 5, 6, 7};
        // int[] profit = {10, 5, 15, 7, 6, 18, 3};
        // int[] weight = {2, 3, 5, 7, 1, 4, 1};
        
        


        
    
        // ListNode list = new ListNode();
        // list.addFirst(1);
        // list.addFirst(5);
        // list.addFirst(3);
        // list.addLast(2);
        // list.addFirst(9);
        // list.addLast(4);
        // list.add(0, 11);
        // list.add(4, 23);
        // list.add(list.size(), 7);
        // list.printList();
        // System.out.println(list.size());
        // list.sort();
        // list.printList();
        // list.removeFirst();
        // list.removeLast();
        // list.remove(list.size()-1);
        // list.remove(3);
        // list.printList();
        // System.out.println(list.size());
        // list.reverse();
        // list.printList();
        // System.out.println(list.head.data + " " + list.size());
        // list.head = list.reverseRecursive(list.head);
        // list.printList();
        // System.out.println(list.head.data);
        // System.out.println(list.nthNodeFromTheLastAndDeleteIt(list.size()-5));
        // list.printList();
        // list.addLast(7);
        // list.addLast(4);
        // list.addLast(3);
        // list.addLast(2);
        // list.printList();
        // System.out.println(list.isPalindrom());
        // list.createLoop(3);
        // System.out.println(list.hasCycle());
        // System.out.println(list.meetLoop().data);
        // System.out.println(list.startLoop().data);
        // list.removeLoop();
        // System.out.println(list.hasCycle());
        // list.printList();
    // }
    // public static ArrayList<Integer> subArraySum(int[] arr, int s) {
    //     ArrayList<Integer> ans = new ArrayList<>();
    //     int sum = 0;
    //     int i = 0;
    //     int j = 0;
    //     while (i <= j && j < arr.length) {
    //         sum += arr[j];
    //         if (sum < s) {
    //             j++;
    //         } else if (sum > s) {
    //             sum -= arr[i];
    //             i++;
    //             if (sum == s) {
    //                 ans.add(i + 1);
    //                 ans.add(j + 1);
    //                 return ans;
    //             }
    //             j++;
    //         } else {
    //             ans.add(i + 1);
    //             ans.add(j + 1);
    //             return ans;
    //         }
    //     }
    //     ans.add(-1);
    //     return ans;
    // }

    // public static ArrayList<String> findPath(int[][] mat) {
    // ArrayList<String> ans = new ArrayList<>();
    // if(mat.length == 0) {
    // ans.add("-1");
    // return ans;
    // }
    // helper(mat, ans, "", 0, 0, mat.length, mat[0].length);
    // return ans;
    // }
    public static class Edge {
        int src, desc, wt;
        public Edge(int src, int desc, int wt) {
            this.src = src;
            this.desc = desc;
            this.wt = wt;
        }
        public Edge(int src, int desc) {
            this.src = src;
            this.desc = desc;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]) {
        for(int i=0;i<graph.length;i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0,2,4));

        graph[1].add(new Edge(1,2,1));
        graph[1].add(new Edge(1,3,7));

        graph[2].add(new Edge(2,4,3));

        graph[3].add(new Edge(3,5,1));

        graph[4].add(new Edge(4,3,2));
        graph[4].add(new Edge(4,5,5));
    }
    public static class Pair implements Comparable<Pair> {
        int node, cost, par;
        public Pair(int node, int cost, int par) {
            this.node = node;
            this.cost = cost;
            this.par = par;
        }
        @Override
        public int compareTo(Pair p2) {
            return this.cost - p2.cost;
        }
    }
    public static void primsAlgorithm(ArrayList<Edge> graph[], int v) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean[] vis = new boolean[v];
        ArrayList<Edge> arr = new ArrayList<>();
        pq.add(new Pair(0, 0, -1));
        int mstCost = 0;
        while(!pq.isEmpty()) {
            Pair curr = pq.remove();
            if(!vis[curr.node]) {
                vis[curr.node] = true;
                mstCost += curr.cost;
                if(curr.node != 0) {
                    arr.add(new Edge(curr.par, curr.node));
                }
                for(int i=0;i<graph[curr.node].size();i++) {
                    Edge e = graph[curr.node].get(i);
                    if(!vis[e.desc]) {
                        pq.add(new Pair(e.desc, e.wt, curr.node));
                    }
                }
            }
        }
        for(int i=0;i<arr.size();i++) {
            System.out.println((i+1) + " Edge : " + arr.get(i).src + " " + arr.get(i).desc);
        }
        System.out.println("Mst Cost : " + mstCost);
    }
    @SuppressWarnings("unchecked")
    public static void main(String args[]) {
        int v = 6;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);

        primsAlgorithm(graph, v);
    }
}