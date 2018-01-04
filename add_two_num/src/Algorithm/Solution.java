package Algorithm;
/*
 * Given twp linked lists representing two non-negative numbers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */
public class Solution {

    public static void main(String[] args){
        ListNode test1 = new ListNode(0);
        ListNode test2 = new ListNode(0);
        ListNode start = test1;
        int[] a1 = {0,8,6,5,6,8,3,5,7}; //375
        int[] a2 = {6,7,8,0,8,5,8,9,7}; //828
        for (int i = 0; i < a1.length; i++){
            ListNode newnode = new ListNode(a1[i]);
            start.next = newnode;
            start = start.next;
        }
        start = test2;
        for (int i = 0; i < a2.length; i++){
            ListNode newnode = new ListNode(a2[i]);
            start.next = newnode;
            start = start.next;
        }
        ListNode newHead = addTwoNumbers(test1.next, test2.next);
        start = newHead;
        while (start != null){
            System.out.println(start.val);
            start = start.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;

        int over = 0 ;
        ListNode newHead = new ListNode(-1);
        ListNode start = newHead;
        while(l1 != null || l2 != null || over != 0){

            int x1, x2;
            if(l1 == null && l2 == null ){
                ListNode newNode = new ListNode(over);
                start.next = newNode;
                return newHead.next;
            }

            if(l1 == null)
                x1 = 0;
            else {
                x1 = l1.val;
                l1 = l1.next;
            }
            if(l2 == null)
                x2 = 0;
            else {
                x2 = l2.val;
                l2 = l2.next;
            }
            ListNode newNode = new ListNode((x1 + x2 + over)%10);
            over = (x1 + x2 + over) / 10;
            start.next = newNode;
            start = start.next;



        }
        return newHead.next;


    }

}
