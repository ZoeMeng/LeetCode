package Algorithm;

/*
 *Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * For example,
 * Given1->2->3->3->4->4->5, return1->2->5.
 * Given1->1->1->2->3, return2->3.
 */

public class Solution {

    public static void main(String[] args){

        int[] sets = {1,2,2,2,3,4,4,5};

        ListNode test = new ListNode(sets[0]);
        ListNode start = test;
        for(int i = 1; i < sets.length; i++){
            ListNode newNode = new ListNode(sets[i]);
            start.next = newNode;
            start = start.next;
        }
        ListNode result = deleteDuplicates(test);
        ListNode tryNode = result;
        while(tryNode != null){
            System.out.println(tryNode.val);
            tryNode = tryNode.next;
        }

    }


    public static ListNode deleteDuplicates(ListNode head){
        if(head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(head.val-1);
        dummy.next = head;
        ListNode preStart = dummy;
        ListNode Start = head;

        while(Start != null && Start.next != null){
            if(Start.val != Start.next.val){
                preStart = Start;

            } else{

                while(Start.next != null && Start.val == Start.next.val){
                    Start = Start.next;
                }
                preStart.next = Start.next;
                Start = preStart.next;
            }
            Start = Start.next;

        }
        return dummy.next;

    }

}
