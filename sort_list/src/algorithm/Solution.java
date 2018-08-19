package algorithm;

public class Solution {
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        ListNode c = head;
        int[] x = {9,2,5,3};
        for (int i = 0; i<4;i++){
            c.next = new ListNode(x[i]);
            c = c.next;
        }
        Solution s = new Solution();
        ListNode res = s.sortList(head);
        ListNode r = res;
        while(r != null){
            System.out.print(r.val);
            r = r.next;
        }
    }

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode middle = getMiddle(head);
        ListNode midNext = middle.next;
        middle.next = null;
        return mergesort(sortList(head), sortList(midNext));

    }
    private ListNode mergesort(ListNode l1, ListNode l2){
        ListNode first=l1, second=l2;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(first != null && second != null){
            if(first.val > second.val){
                cur.next = second;
                second = second.next;
            }
            else{
                cur.next = first;
                first = first.next;
            }
            cur = cur.next;
        }
        if(first == null)
            cur.next = second;
        else
            cur.next = first;
        return dummy.next;

    }

    private ListNode getMiddle(ListNode a){
        if(a == null || a.next == null)
            return a;
        ListNode fast = a, slow = a;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
