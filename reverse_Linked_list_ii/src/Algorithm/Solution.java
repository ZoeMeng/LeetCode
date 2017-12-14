package Algorithm;

/*
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * For example:
 * Given1->2->3->4->5->NULL, m = 2 and n = 4,
 *
 * return1->4->3->2->5->NULL.
 *
 * Note:
 * Given m, n satisfy the following condition:
 * 1 ≤ m ≤ n ≤ length of list.
 */

public class Solution {
    public static void main(String[] args){
        ListNode test = new ListNode(1);
        ListNode head = test;
        for(int x = 2; x<8; x++){
            ListNode newNode = new ListNode(x);
            head.next = newNode;
            head = head.next;
        }

        int m = 3, n = 5;
        ListNode result = reverseBetween(test, m, n);

    }

    public static ListNode reverseBetween(ListNode head, int m, int n){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode preStart = dummy;
        ListNode start = head;
        for(int i = 1; i < m; i++){
            preStart = start;
            start = start.next;
        }

        for(int i = 0; i < n - m; i++){
            ListNode temp = start.next;
            start.next = temp.next;
            temp.next = preStart.next;
            preStart.next = temp;

        }
        return dummy.next;

    }
}
