package Algorithm;
/*
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * For example,
 * Given1->1->2, return1->2.
 * Given1->1->2->3->3, return1->2->3.

 */

public class Solution {

    public static void main(String[] args){
        int[] sets = {1,1};

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
        if(head == null || head.next == null){
            return head;
        }

        //与deleted_duplicate不同，此不需要额外添加新节点指向头节点
        //因为没有删除头节点的情况

        ListNode Start = head;

        while( Start != null && Start.next != null){
            if(Start.val == Start.next.val){

                Start.next = Start.next.next;
            }
            Start = Start.next;

        }
        return  head;

    }
}
