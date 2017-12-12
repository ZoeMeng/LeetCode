package Algorithm;

public class Solution {
    public static void main(String[] args){
        int[] set1 = {1,2,3,4,5};
        int[] set2 = {99,98,97,96,95};

        ListNode List1 = new ListNode(set1[0]);
        ListNode List2 = new ListNode(set2[0]);
        ListNode p1 = List1, p2 = List2;

        for(int i = 1; i < set1.length; i++){
            ListNode newNode1 = new ListNode(set1[i]);
            p1.next = newNode1;
            p1 = p1.next;
            ListNode newNode2 = new ListNode(set2[i]);
            p2.next = newNode2;
            p2 = p2.next;
        }

        ListNode result = mergeTwoLists(List1, List2);
        ListNode pointer = result;
        while(pointer != null){
            System.out.println(pointer.val);
            pointer = pointer.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if(l1 == null)
            return l2;
        else if(l2 == null)
            return l1;

        ListNode head = new ListNode()

    }
}
