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
    public boolean isPalindrome(ListNode head) {
        //if single node then just return null
        if(head == null || head.next == null) return true;
    
        ListNode mid = findmid(head);

        //reverse the linkedlist
        ListNode prev = null;
        ListNode curr = mid;
        ListNode next = null;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        //two pointers to compare the linkedlist
        ListNode right = prev;
        ListNode left = head;
        while(right!= null) {
            if(left.val != right.val) return false;
            left = left.next;
            right = right.next;
        }
        
        return true;
    }

    public ListNode findmid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!= null && fast.next!= null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
/*
import java.util.Stack;

class Solution {
    public boolean isPalindrome(ListNode head) {

        Stack<Integer> st = new Stack<>();

        ListNode temp = head;

        // Step 1: Push all values into stack
        while (temp != null) {
            st.push(temp.val);
            temp = temp.next;
        }

        // Step 2: Traverse again and compare
        temp = head;

        while (temp != null) {

            if (temp.val != st.pop()) {
                return false;
            }

            temp = temp.next;
        }

        return true;
    }
}
*/