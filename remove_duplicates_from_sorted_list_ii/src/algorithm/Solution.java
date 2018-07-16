package algorithm;
/*
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given1->2->3->3->4->4->5, return1->2->5.
Given1->1->1->2->3, return2->3.


 */

public class Solution {
    public static ListNode deleteDuplicates(ListNode head){
        if(head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = head, slow = dummy;
        while(fast != null && fast.next != null){
            if(slow.next.val != fast.next.val){
                fast = fast.next;
                slow = slow.next;
            }
            else{
                while(fast.next != null && fast.val == fast.next.val){
                    fast = fast.next;
                }
                slow.next = fast.next;
                fast = slow.next;
            }


        }
        return dummy.next;
    }
    public static void main(String[] args){
        ListNode test = new ListNode(1);
        ListNode head = test;
        int[] xx = {1,1,1};
        for(int i = 0; i < xx.length; i++){
            ListNode newNode = new ListNode(xx[i]);
            head.next = newNode;
            head = head.next;
        }
        ListNode result = deleteDuplicates(test);
    }
}
