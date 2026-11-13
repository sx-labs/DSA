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
    public ListNode deleteMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        if (head == null || head.next == null) return null;
        fast = fast.next.next; //skip just one step of slow and move fast initially
        while(fast!= null && fast.next!= null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}

/* Bruteforce
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        int count = 0;
        ListNode temp = head;
        while(temp!= null) {
            count++;
            temp = temp.next;
        }
        int pos = count/2;
        temp = head;
        if(pos == 0) {
            return head.next;
        }
        for(int i = 0 ; i<pos-1 ; i++) {remember this rule:
- < means the loop stops before reaching the boundary value.
- <= means the boundary value is also included.
            temp = temp.next; 
        }
        temp.next = temp.next.next;
        return head;
    }
} */