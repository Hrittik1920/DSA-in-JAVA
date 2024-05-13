import java.util.List;

public class _23_Merge_k_Sorted_Lists {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; };
        ListNode(int val,ListNode next) { this.val = val; this.next = next;};
    }
    public ListNode merge(ListNode l1,ListNode l2) {
        ListNode ans = new ListNode(-1);
        ListNode node = ans;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                node.next = new ListNode(l1.val);
                node = node.next;
                l1 = l1.next;
            } else {
                node.next = new ListNode(l2.val);
                node = node.next;
                l2 = l2.next;
            }
        }
        while(l1 != null) {
            node.next = new ListNode(l1.val);
            node = node.next;
            l1 = l1.next;
        }
        while(l2 != null) {
            node.next = new ListNode(l2.val);
            node = node.next;
            l2 = l2.next;
        }
        ans = ans.next;
        return ans;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = null;
        for(int i=0;i<lists.length;i++) {
            ans = merge(ans,lists[i]);
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE + " " + Integer.MIN_VALUE);
    }
}