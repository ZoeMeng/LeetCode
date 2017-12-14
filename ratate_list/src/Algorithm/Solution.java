package Algorithm;

public class Solution {

    public static void main(String[] args){
        int[] set = {1,2};
        int x = 2;
        ListNode test = new ListNode(set[0]);
        ListNode start = test;
        for(int i = 1; i < set.length; i++){
            ListNode newNode = new ListNode(set[i]);
            start.next = newNode;
            start = start.next;
        }
        ListNode newHead = rotateRight(test, x);
        while(newHead != null){
            System.out.println(newHead.val);
            newHead = newHead.next;
        }


    }

    public static ListNode rotateRight(ListNode head, int n){

        //考虑空指针，和n==0
        if(head == null || head.next == null || n == 0)
            return head;

        //首尾相接
        ListNode p1 = head;
        while(p1.next != null){
            p1 = p1.next;
        }
        p1.next = head;

        //指针右移n位，指向新头节点并断开环
        for(int i = 0; i < n-1; i++){
            head = head.next;
        }
        ListNode newHead = head.next;
        head.next = null;


        return newHead;
    }


}
