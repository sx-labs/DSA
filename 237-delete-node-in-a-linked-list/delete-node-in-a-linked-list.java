/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//when we cannpt access the head of the linkedlist
class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;

        node.next = node.next.next;
    }
}

/*
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public void deleteNode(ListNode node) {

        node.val = node.next.val;

        node.next = node.next.next;
    }
}
*/
