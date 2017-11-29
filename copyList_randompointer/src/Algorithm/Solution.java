package Algorithm;
/*
 * A linked list is given such that each node contains an additional random pointer
 * which could point to any node in the list or null.
 * Return a deep copy of the list.


 */

public class Solution {

    public static void main(String[] args){
        RandomListNode test = new RandomListNode(0);
        for(int i =0; i< 9;i++){
            RandomListNode newNode = new RandomListNode(i+1);
            test.next = newNode;
        }
        while(test.next.next != null){
            test.random = test.next.next;
        }

        RandomListNode copytest = copyRandomList(test);
    }



    public static RandomListNode copyRandomList(RandomListNode head){
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
