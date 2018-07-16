package algorithm;
/*
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 *
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 *
 * You may not alter the values in the nodes, only nodes itself may be changed.
 *
 * Only constant memory is allowed.
 *
 * For example,
 * Given this linked list:1->2->3->4->5
 *
 * For k = 2, you should return:2->1->4->3->5
 *
 * For k = 3, you should return:3->2->1->4->5
 *
 * 思路：1. 循环一次统计链表长度n, n/k作为循环次数；2.
 */

public class solution {
    public static ListNode reverseKGroup(ListNode head, int k){
        if(head == null || head.next == null || k == 1)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;

        int num = 1;
        while(cur.next != null){
            cur = cur.next;
            num += 1;
        }

        int y = num/k;
        while(--y > 0){
            int kk = k-1;
            cur = pre.next;
            while(kk-- >0) {

                ListNode curNext = cur.next;
                cur.next = curNext.next;
                curNext.next = pre.next;
                pre.next = curNext;
            }
            pre = cur;
        }
        return dummy.next;
    }

    public static void main(String[] args){
        ListNode test = new ListNode(1);
        ListNode head = test;
        for(int x = 2; x<3; x++){
            ListNode newNode = new ListNode(x);
            head.next = newNode;
            head = head.next;
        }

        int m = 2;
        ListNode result = reverseKGroup(test, m);

    }
}
