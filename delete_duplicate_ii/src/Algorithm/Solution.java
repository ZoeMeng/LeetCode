package Algorithm;
/*
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * For example,
 * Given1->1->2, return1->2.
 * Given1->1->2->3->3, return1->2->3.

 */

public class Solution {

    public static void main(String[] args){
        int[] sets = {1,2,2,2,3,4,4};

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

    }
}
