package algorithm;
/*
 * 自己的答案不好，不够简明，这个是参考牛客网的版本
 */

import java.util.List;

public class Solution2 {
    public static ListNode deleteDuplicated(ListNode head){
        if(head == null && head.next == null)
            return head;
        ListNode dummy = new ListNode(head.val - 1);
        dummy.next = head;
        ListNode cur = head, last = dummy;
        while(cur != null && cur.next != null){
            if(cur.val!=cur.next.val){
                last = cur;
            }else{
                while(cur.next != null && cur.val == cur.next.val)
                    cur = cur.next;
                last.next = cur.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode test = new ListNode(1);
        ListNode head = test;
        int[] xx = {1, 1, 1};
        for (int i = 0; i < xx.length; i++) {
            ListNode newNode = new ListNode(xx[i]);
            head.next = newNode;
            head = head.next;
        }
        ListNode result = deleteDuplicated(test);
    }
}

