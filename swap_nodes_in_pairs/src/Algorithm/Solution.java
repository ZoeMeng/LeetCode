package Algorithm;

/*
 * Given a linked list, swap every two adjacent nodes and return its head.
 * For example,Given1->2->3->4, you should return the list as2->1->4->3.
 * Your algorithm should use only constant space.
 * You may not modify the values in the list, only nodes itself can be changed.
 */

public class Solution {
    public static void main(String[] args){
        int[] x = {1,2,3,4,5};
        ListNode test = new ListNode(x[0]);
        ListNode node1 = test;
        for(int i = 1; i < x.length; i++){
            ListNode newN = new ListNode(x[i]);
            node1.next = newN;
            node1 = node1.next;
        }
        ListNode result = swapPairs(test);
        node1 = result;
        while(node1 != null){
            System.out.println(node1.val);
            node1 = node1.next;
        }



    }

    public static ListNode swapPairs(ListNode head){
        if(head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, cur = head;
        while(cur != null && cur.next != null){
            ListNode nextcur = cur.next;
            cur.next = nextcur.next;
            nextcur.next = cur;
            pre.next = nextcur;
            pre = cur;
            cur = cur.next;
        }

        return dummy.next;
    }
}
