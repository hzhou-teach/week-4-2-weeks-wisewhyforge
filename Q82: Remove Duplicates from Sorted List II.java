/*
Runtime: 2 ms, faster than 11.19% of Java online submissions for Remove Duplicates from Sorted List II.
Memory Usage: 41.6 MB, less than 5.17% of Java online submissions for Remove Duplicates from Sorted List II.

DISCLAIMER: Runtime and memory usage vary a lot(1-4ms, 38.8-41.6Mb)

Difficulty: 7

Time: 50 minutes

The trouble was getting the previous pointer to not increment when the next current is a duplicate in order to actually delete the ListNode.
*/

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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        HashSet<Integer> set = new HashSet<Integer>();
        while(current != null && head != null){
            if(!set.add(current.val)){
                ListNode deletePoint = current;
                while(deletePoint != null && deletePoint.val == current.val){
                    deletePoint = deletePoint.next; 
                }
                if(head.val == current.val){
                     head = deletePoint;
                }else{
                    previous.next = deletePoint;
                    current = deletePoint;
                }
            }else{
                if(previous == null){
                    previous = head;
                }else if (current.next != null && !set.contains(current.next.val)){
                    previous = previous.next;
                }
                current = current.next;
            }
            
        }
        
        return head;
    }
}
