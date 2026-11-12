/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!= null && fast.next!= null) { //fast!= null for even length & fast.next!= null for odd length linkedlist
            slow = slow.next;
            fast = fast.next.next;           
        }
        return slow;
    }
}

/*
If we initialize:
ListNode slow = head;
ListNode fast = head.next;
We will get the first middle node for an even-length linked list, rather than the second middle.
*/

//bruteforce
/*
class Solution {
    public ListNode middleNode(ListNode head) {

        int count = 0;
        ListNode temp = head;

        // Step 1: Calculate length
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        // Step 2: Find middle position
        temp = head;
        int mid = count / 2;

        // Step 3: Traverse to middle
        while (mid > 0) {
            temp = temp.next;
            mid--;
        }

        // Step 4: Return middle node
        return temp;
    }
}
*/