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
        for (int aXx : xx) {
            head.next = new ListNode(aXx);
            head = head.next;
        }

        ListNode test2 = new ListNode(2);
        head = test2;
        int[] xx2 = {3, 6};
        for (int aXx2 : xx2) {
            head.next = new ListNode(aXx2);
            head = head.next;
        }

        ListNode test3 = new ListNode(7);
        head = test3;
        int[] xx3 = {8,9};
        for (int aXx3 : xx3) {
            head.next = new ListNode(aXx3);
            head = head.next;
        }
        ArrayList<ListNode> Xlist = new ArrayList<ListNode>();
        Xlist.add(test);
        Xlist.add(test2);
        Xlist.add(test3);

        head = mergeKLists(Xlist);
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }

    }

    /*
    思路1：并归排序，也称为分治思想
     */
    private static ListNode mergeKLists(ArrayList<ListNode> lists){
        if(lists == null || lists.size() == 0)
            return null;
        return mergeKList(lists, 0 , lists.size() - 1);
    }

    private static ListNode mergeKList(ArrayList<ListNode> lists, int lo, int hi){
        if(hi <= lo)  //这句很重要！！！
            return lists.get(lo);
        int mid = lo + (hi - lo) / 2;
        ListNode left = mergeKList(lists, lo, mid);
        ListNode right = mergeKList(lists, mid + 1, hi);
        return merge(left, right);
    }

    private static ListNode merge(ListNode left, ListNode right){
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
