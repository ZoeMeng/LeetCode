package Algorithm;

/*
 *Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 *You should preserve the original relative order of the nodes in each of the two partitions.
 *For example,
 *Given1->4->3->2->5->2and x = 3,
 *return1->2->2->4->3->5.
 */


/*
 * 思路：新建两个节点preHead1与preHead2，分别为指向两个链表的头结点。
 * 把节点值小于x的节点链接到链表1上，节点值大等于x的节点链接到链表2上。
 * 最后把两个链表相连即可
 */

public class Solution {

    public static void main(String[] args){
        ListNode test = new ListNode(1);
        ListNode head = test;
        int[] xx = {4, 3, 2, 5, 2};
        for(int i = 0; i < xx.length; i++){
            ListNode newNode = new ListNode(xx[i]);
            head.next = newNode;
            head = head.next;
        }
        ListNode result = partition(test, 3);
        System.out.println(result.val);
    }

    public static ListNode partition(ListNode head, int x){
        //preHead1, preHead2分别表示两个链表的头节点的前移节点
        ListNode preHead1 = new ListNode(0),
                 preHead2 = new ListNode(0);
        ListNode cur1 = preHead1, cur2 = preHead2;
        while(head != null){
            if(head.val < x){
                cur1.next = head;
                cur1 = cur1.next;
            }else{
                cur2.next = head;
                cur2 = cur2.next;
            }
            head = head.next;
        }
        cur1.next = preHead2.next;
        cur2.next = null;
        return preHead1.next;
    }


}
