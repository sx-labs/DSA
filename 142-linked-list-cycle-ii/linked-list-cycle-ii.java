/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 //bruteforce
/*
public class Solution {
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode temp = head;
        while(temp != null) {
            if(set.contains(temp)){
                return temp; //this is the first where it is already in set so return it it is first starting point
            }
            set.add(temp) ;
            temp = temp.next;
        }
        return null; // since temp!= null is executed which occurs in linear linkedList that means no loop is there in it
*/
    public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!= null && fast.next!= null) {
            slow= slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                slow = head;
                {
                    while(slow!= fast) {
                        slow = slow.next;
                        fast = fast.next;
                    }
                    return slow;
                }
            }
        }
        return null;
    }
}