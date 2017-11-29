package Algorithm;

public class Solution {
    public RandomListNode copyRandomList(RandomListNode head){
        if(head == null) return null;

        //first scan, copy the list, inserting the new node under the old
        RandomListNode node = head;
        while(node != null){
            RandomListNode newnode = new RandomListNode(node.label);
            newnode.next = node.next;
            node = newnode.next;
        }

        //second scan
        node = head;
        while(node != null){
            if(node.random != null)
                node.next.random = node.random.next; //
            node  = node.next.next;
        }
        RandomListNode newhead = head.next;

        //third scan
        node = head;
        while (node != null){
            RandomListNode newnode = node.next;
            node.next = newnode.next;
            if(newnode.next !=null)
                newnode.next = newnode.next.next;
            node = node.next;
        }

        return newhead;
    }
}
