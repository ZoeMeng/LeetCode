package Algorithm;

import java.util.ArrayList;


/*
 * Merge k sorted linked lists and return it as one sorted list.
 * Analyze and describe its complexity.
 */

public class Solution {

    public static void main(String[] args){
        ListNode test = new ListNode(1);
        ListNode head = test;
        int[] xx = {4,5};
        for(int i = 0; i < xx.length; i++){
            ListNode newNode = new ListNode(xx[i]);
            head.next = newNode;
            head = head.next;
        }

        ListNode test2 = new ListNode(2);
        head = test2;
        int[] xx2 = {3, 6};
        for(int i = 0; i < xx2.length; i++){
            ListNode newNode = new ListNode(xx2[i]);
            head.next = newNode;
            head = head.next;
        }

        ListNode test3 = new ListNode(7);
        head = test3;
        int[] xx3 = {8,9};
        for(int i = 0; i < xx3.length; i++){
            ListNode newNode = new ListNode(xx3[i]);
            head.next = newNode;
            head = head.next;
        }
        ArrayList<ListNode> Xlist = new ArrayList<ListNode>();
        Xlist.add(test);
        Xlist.add(test2);
        Xlist.add(test3);

        ListNode result = mergeKLists(Xlist);
        head = result;
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }




    }

    public static ListNode mergeKLists(ArrayList<ListNode> lists){
        if(lists == null || lists.size() == 0)
            return null;
        return mergeKList(lists, 0 , lists.size() - 1);
    }

    public static ListNode mergeKList(ArrayList<ListNode> lists, int lo, int hi ){
        if(hi <= lo)
            return lists.get(lo);
        int mid = lo + (hi - lo) / 2;
        ListNode left = mergeKList(lists, lo, mid);
        ListNode right = mergeKList(lists, mid + 1, hi);
        return merge(left, right);
    }

    public static ListNode merge(ListNode left, ListNode right){
        ListNode h = new ListNode(-1);
        ListNode tmp = h;
        while (left != null && right != null){
            if(left.val < right.val){
                tmp.next = left;
                left = left.next;
            }else{
                tmp.next = right;
                right = right.next;
            }
            tmp = tmp.next;
        }
        if(left != null)
            tmp.next = left;
        if(right != null)
            tmp.next = right;
        return h.next;
    }



}
