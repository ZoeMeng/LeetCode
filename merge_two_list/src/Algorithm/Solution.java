package Algorithm;

public class Solution {
    public static void main(String[] args){
        int[] set1 = {1,2,12,32,35};
        int[] set2 = {3,10,11,16};

        ListNode List1 = new ListNode(set1[0]);
        ListNode List2 = new ListNode(set2[0]);
        ListNode p1 = List1, p2 = List2;

        for(int i = 1; i < set1.length; i++){
            ListNode newNode1 = new ListNode(set1[i]);
            p1.next = newNode1;
            p1 = p1.next;

        }
        for(int i = 1; i < set2.length; i++){
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

        //空指针判断
        if(l1 == null)
            return l2;
        else if(l2 == null)
            return l1;

        //头节点
        ListNode head = new ListNode(0);
        ListNode start = head;

        while(l1 != null || l2 != null){

            if(l1 != null && l2 != null && l1.val < l2.val){
                ListNode newNode = new ListNode(l1.val);
                start.next = newNode;
                start = start.next;
                l1 = l1.next;
            }else if(l1 != null && l2 != null && l1.val >= l2.val){
                ListNode newNode = new ListNode(l2.val);
                start.next = newNode;
                start = start.next;
                l2 = l2.next;
            }else if(l1 == null ){
                start.next = l2;
                l2 = null;
            }else if(l2 == null){
                start.next = l1;
                l1 = null;
            }

        }
        return head.next;

    }
}
