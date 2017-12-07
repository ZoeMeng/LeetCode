package Algorithm;



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
