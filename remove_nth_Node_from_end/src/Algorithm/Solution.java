package Algorithm;

/*
 * Given a linked list, remove the nth node from the end of the list,
 * and return its head.
 * For example,
 * list : 1 -> 2 -> 3 -> 4 -> 5 -> 6, n = 2
 * return 1 -> 2 -> 3 -> 4 -> 6
 * Note: Given n will always be valid.

 */

public class Solution {

    public static void main(String[] args){

        ListNode test = new ListNode(1);
        int n = 2;
        ListNode start = test;
        int[] a = {2,3,4,5,6};
        for (int i = 0; i < a.length; i++){
            ListNode newnode = new ListNode(a[i]);
            start.next = newnode;
            start = start.next;
        }

        ListNode newList = removeNthFromEnd(test, n);
        start = newList;
        while (start != null){
            System.out.println(start.val);
            start = start.next;
        }
    }

    /*
     * 思路：1.扫描，求链表长度hLen；
     * 2.hLen除以n取余，加头节点
     * 3.移动指针，删除，返回
     */
    public static ListNode removeNthFromEnd(ListNode head, int n){
        if(head == null)
            return head;

        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        ListNode start = preHead.next;
        int hLen = 0;
        while(start != null){
            hLen += 1;
            start = start.next;
        }
        start = preHead;
        int xx = hLen - n;
        for(int i = 0; i < xx; i++){
            start = start.next;
        }
        start.next = start.next.next;
        return preHead.next;




    }


}
