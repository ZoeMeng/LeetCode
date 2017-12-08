package Algorithm;

/*
 *Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 *You should preserve the original relative order of the nodes in each of the two partitions.
 *For example,
 *Given1->4->3->2->5->2and x = 3,
 *return1->2->2->4->3->5.
 */


/*
 * 注意：两部分都要保持原始相对位置
 * 思路：确定要移动得节点个数；循环将大于x元素移到队尾
 * 对比答案发现，思路过于复杂，移到队尾不可取。。
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
        if(head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode Start = head, preStart = dummy;

        //统计需要移动的次数


        //移动
        while(Start.next != null){
            if(Start.val < x){
                preStart = Start;
                Start = Start.next;
            }else{
                //Start节点移动到队尾
                Start = toListEnd(preStart,Start);

            }
        }
        return dummy.next;

    }

    private static ListNode toListEnd(ListNode preS, ListNode S){

        ListNode head = preS;
        while(S.next != null){
            ListNode temp = S.next;
            S.next = temp.next;
            temp.next = preS.next;
            preS.next = temp;
            preS = preS.next;

        }
        return head.next;

    }


}
