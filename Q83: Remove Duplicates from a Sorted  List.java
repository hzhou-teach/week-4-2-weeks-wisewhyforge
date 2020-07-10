/*
Runtime: 4 ms, faster than 33.56% of Java online submissions for Remove Duplicates from Sorted List.
Memory Usage: 41.8 MB, less than 5.06% of Java online submissions for Remove Duplicates from Sorted List.

Time: 5-10 minutes

Difficulty: 2

The only trick is to rectify the pointers in order to delete a node.
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
        HashSet<Integer> set = new HashSet<Integer>();
        ListNode previous = null;
        ListNode pointer = head;
        while(pointer != null){
            if(!set.add(pointer.val)){
                if(previous == null){
                    head = pointer.next;
                    pointer = head;
                }else{
                    previous.next = pointer.next;
                    pointer = pointer.next;
                }
            }else{
                previous = pointer;
                pointer = pointer.next;
            }
        }
        
        return head;
    }
}
